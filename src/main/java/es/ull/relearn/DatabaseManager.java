package es.ull.relearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import es.ull.relearn.dbitems.Attribute;
import es.ull.relearn.dbitems.DataType;
import es.ull.relearn.dbitems.Database;
import es.ull.relearn.dbitems.Datum;
import es.ull.relearn.dbitems.Row;
import es.ull.relearn.dbitems.Table;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Creates the specified database on PostgreSQL.
 * @author Teguayco
 *
 */
public class DatabaseManager {
	
	private static final String CREDENTIALS_FILE_PATH = "../postgresql_credentials.txt";
	private static final String TEST_SCHEMA_DEFINITION_FILE_PATH = "./examples/r1r2r3r4.db";
	private static final String DEFAULT_SCHEMA_NAME = "public";
	private static final String DEFAULT_DBMS_PREFIX = "jdbc:postgresql://";
	private static final String DEFAULT_HOSTNAME = "localhost";
	private static final String DEFAULT_PORT = "5433";
	private static final String DEFAULT_DATABASE = "postgres";
	private static final String DEFAULT_USERNAME = "postgres";
	private static final String DEFAULT_PASSWORD = "postgres";
	private static final char SCHEMA_NAME_SEPARATOR_CHAR = '_';
	
	private String dbmsPrefix;
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String connectionURL;
	private String databaseName;
	private String databaseSchemaName;
	
	private boolean connectedToHeroku;
	
	private Connection connection;
	private ResultSet queryResultSet;
	
	private ArrayList<String> executionErrors;
	
	public DatabaseManager(boolean isConnectedToHeroku) {
		connectedToHeroku = isConnectedToHeroku;
		username = DEFAULT_USERNAME;
		password = DEFAULT_PASSWORD;
		dbmsPrefix = DEFAULT_DBMS_PREFIX;
		hostname = DEFAULT_HOSTNAME;
		port = DEFAULT_PORT;
		databaseName = DEFAULT_DATABASE;
		databaseSchemaName = "";
		connectionURL = DEFAULT_DBMS_PREFIX + hostname + ":" + port + "/" + databaseName;
		executionErrors = new ArrayList<String>();
		
		createConnectionToDbms(connectionURL);
		createDefaultSchema();
	}
	
	private void createConnectionToDbms(String aConnectionURL) {
		
		try {
			if (connection != null) connection.close();
			
			if (connectedToHeroku) {
				URI dbUri = new URI(System.getenv("DATABASE_URL"));
		
			    String username = dbUri.getUserInfo().split(":")[0];
			    String password = dbUri.getUserInfo().split(":")[1];
			    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
		
			    connection =  DriverManager.getConnection(dbUrl, username, password);
			    queryResultSet = null;
			}
			
			// Working locally
			else {
				System.out.println("Connection URL = " + aConnectionURL);
				System.out.println("Username = " + username);
				Properties props = new Properties();
				
				props.setProperty("user", username);
				props.setProperty("password", password);
				
				connection = DriverManager.getConnection(aConnectionURL, props);
				queryResultSet = null;
			}
		} 
		
		catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	private String getDefaultConnectionURL() {
		
		try {
			if (connectedToHeroku) {
				URI dbUri = new URI(System.getenv("DATABASE_URL"));
			    return "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			} 
			
			else {
				return DEFAULT_DBMS_PREFIX + hostname + ":" + port + "/" + databaseName;
			}
		}
		
		catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	private void executeStatement(String SqlStatement) {
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(SqlStatement);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropDatabase(String databaseName) {
		executeStatement("DROP DATABASE IF EXISTS " + databaseName);
	}
	
	public void dropDatabaseCascade() {
		executeStatement("DROP DATABASE IF EXISTS " + databaseName + " CASCADE");
	}
	
	public void dropSchema(String schemaName) {
		executeStatement("DROP SCHEMA IF EXISTS " + schemaName);
	}

	public void dropSchemaCascade(String schemaName) {
		executeStatement("DROP SCHEMA IF EXISTS " + schemaName + " CASCADE");
	}
	
	private void createSchema(String schemaName) {
		dropSchemaCascade(schemaName);
		executeStatement("CREATE SCHEMA IF NOT EXISTS " + schemaName);
	}
	
	private void createDefaultSchema() {
		createSchema(DEFAULT_SCHEMA_NAME);
	}
	
	public void switchToDatabase(String aDatabaseName) throws SQLException {
		connection.close();
		
		databaseName = aDatabaseName;
		connectionURL = getDefaultConnectionURL();
		
		createConnectionToDbms(connectionURL);
	}
	
	public void switchToSchema(String aDatabaseSchemaName) {
		databaseSchemaName = aDatabaseSchemaName;
		connectionURL = getDefaultConnectionURL() + "?currentSchema=" + databaseSchemaName;
		
		System.out.println("URL to connect to schema: " + connectionURL);
		
		createConnectionToDbms(connectionURL);
		
		try {
			
			if (connectedToHeroku) {
				URI dbUri = new URI(System.getenv("DATABASE_URL"));
				databaseName = dbUri.getPath().substring(1);
			}
		
			System.out.println("Setting default schema of database '" + databaseName + "' to '" + databaseSchemaName + "'");
			
			// Set the schema as default
			String defaultSchemaStatement = "ALTER database \"" + databaseName + "\" SET search_path TO " + databaseSchemaName + ";";
			Statement statement = connection.createStatement();
			statement.executeUpdate(defaultSchemaStatement);
		}
		
		catch (URISyntaxException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToDefaultSchema() {
		createSchema(DEFAULT_SCHEMA_NAME);
		switchToSchema(DEFAULT_SCHEMA_NAME);
	}
	
	private void executeCreateDatabaseStatement(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP DATABASE IF EXISTS " + databaseName);
		statement.executeUpdate("CREATE DATABASE " + databaseName);
		
		// Reconnect to the database which has just been created
		switchToDatabase(databaseName);
		
		System.out.println(">> Database '" + databaseName + "' was created on PostgreSQL.");
	}
	
	private void executeCreateTableStatement(Table table, String schemaName) throws SQLException {
		Attribute auxAttr;
		String createTableStatement = "CREATE TABLE IF NOT EXISTS ";
		
		// Rename the table to create it with the notation: "schemaName"."tableName"
		table.setName(schemaName + "." + table.getName());
		
		createTableStatement += table.getName();
		createTableStatement += "(";
		
		// ATTRIBUTES
		for (int i = 0; i < table.getNumOfColumns(); i++) {
			auxAttr = table.getAttributes().get(i);
			createTableStatement += auxAttr.getName();
			createTableStatement += " ";
			
			switch (auxAttr.getDataType()) {
				case STRING: createTableStatement += "varchar(255)"; 	break;
				case CHAR: createTableStatement += "char"; 				break;
				case INT: createTableStatement += "int"; 			 	break;
				case FLOAT: createTableStatement += "float"; 		 	break;
				case DATE: createTableStatement += "date"; 				break;
			}
			
			// Add comma
			if (i < table.getNumOfColumns() - 1) {
				createTableStatement += ",";
			} else {
				createTableStatement += ")";
			}
		}
		
		executeStatement(createTableStatement);
	}
	
	private void executeInsertIntoStatement(Row row, Table table) {
		Datum auxDatum;
		String insertRowStatement = "INSERT INTO " + table.getName() + " VALUES(";
		
		for (int i = 0; i < row.getData().size(); i++) {
			auxDatum = row.getData().get(i);
			insertRowStatement += auxDatum.getStringValue();
			
			// Add comma
			if (i < row.getData().size() - 1) {
				insertRowStatement += ",";
			} else {
				insertRowStatement += ")";
			}
		}
		
		executeStatement(insertRowStatement);
	}
	
	/**
	 * TODO complete
	 * 
	 * The REAL database will be the USER SESSION ID (CREATE DATABASE userSessionID).
	 * 
	 * The name of the database defined by the user in the app will be actually the name of the schema.
	 * 
	 * @param aDatabaseToCreate
	 * @param schemaName
	 */
	public void createDatabaseOnDbms(Database aDatabaseToCreate, String userSessionID) {
		try {
			if (aDatabaseToCreate != null && connection != null) {
				
				// DATABASE
				//executeCreateDatabaseStatement(userSessionID);
				
				// SCHEMA
				String databaseName = aDatabaseToCreate.getName();
				String schemaName = getCleanSchemaName(userSessionID, databaseName);
				createSchema(schemaName);
				
				// TABLES
				for (int i = 0; i < aDatabaseToCreate.getNumOfTables(); i++) {
					Table auxTable = aDatabaseToCreate.getTables().get(i);
					executeCreateTableStatement(auxTable, schemaName);
					
					// ROWS
					for (int j = 0; j < auxTable.getNumOfRows(); j++) {
						Row auxRow = auxTable.getRowAt(j);
						executeInsertIntoStatement(auxRow, auxTable);
					}
				}
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String toString = "";
		
		if (connection != null) {
			toString += "DatabaseManager object. Connection established with DBMS.\n";
			toString += "DBMS prefix: " + dbmsPrefix + "\n";
			toString += "Hostname: " + hostname + "\n";
			toString += "Port: " + port + "\n";
			toString += "Username: " + username + "\n";
			toString += "Password: ******\n";
		}
		
		else {
			toString += "DatabaseManager object. There is no connection established with a DBMS.";
		}
		
		return toString;
	}
	
	public static String getSchemaDefinitionFromFile(String aFilePath) {
		byte[] fileBytes = null;
		
		try {
			fileBytes = Files.readAllBytes(Paths.get(aFilePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new String(fileBytes, StandardCharsets.UTF_8);
	}
	
	public void executeQuery(String query) {

		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			queryResultSet = statement.executeQuery(query);
			executionErrors = new ArrayList<String>();
		}
		
		catch (SQLException e) {
			executionErrors.add(e.getMessage());
		}
	}
	
	public String getCleanSchemaName(String userSessionID, String appDatabaseName) {
		return userSessionID + SCHEMA_NAME_SEPARATOR_CHAR + appDatabaseName;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public ResultSet getQueryResultSet() {
		return queryResultSet;
	}
	
	public String getQueryResultSetAsString() {
		String result = "";
		
		try {
			queryResultSet.first();
			while (queryResultSet.next()) {
			    int numColumns = queryResultSet.getMetaData().getColumnCount();
			    
			    for (int i = 1; i <= numColumns; i++) {
			        result += "COLUMN " + i + " = " + queryResultSet.getObject(i) + "\n";
			    }
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public JSONObject getResultSetAsJson() {
		JSONObject result = new JSONObject();
		String[] columnNames = null;
		String[] rowValues = null;
		int numColumns = 0;
		int row = 0;
		
		try {
			queryResultSet.first();
			numColumns = queryResultSet.getMetaData().getColumnCount();
			columnNames = new String[numColumns];
			
			do {
			    rowValues = new String[numColumns];
			    for (int i = 1; i <= numColumns; i++) {
			    	String valueFromDatabase = queryResultSet.getObject(i).toString();
			    	rowValues[i - 1] = valueFromDatabase;
			    	columnNames[i - 1] = queryResultSet.getMetaData().getColumnName(i);
			    }
			    
			    result.put(Integer.toString(row), rowValues);
			    row++;
			    
			} while (queryResultSet.next());
			
			result.put("columnNames", columnNames);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String getExecutionErrors() {
		String result = "";
		
		for (int i = 0; i < executionErrors.size(); i++) {
			result += executionErrors.get(i);
		}
		
		return result;
	}
}
