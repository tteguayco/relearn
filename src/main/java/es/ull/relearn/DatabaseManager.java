package es.ull.relearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	private static final String CREDENTIALS_FILE_PATH = "C:/Users/Teguayco/Desktop/postgresql_credentials.txt";
	private static final String TEST_SCHEMA_DEFINITION_FILE_PATH = "C:/Users/Teguayco/Desktop/r1r2r3r4.db";
	private static final String DEFAULT_DBMS_PREFIX = "jdbc:postgresql://";
	private static final String DEFAULT_HOSTNAME = "localhost";
	private static final String DEFAULT_PORT = "5432";
	
	private String dbmsPrefix;
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String connectionURL;
	private String databaseName;
	private String databaseSchemaName;
	
	private Connection connection;
	private ResultSet queryResultSet;
	
	private Database databaseToCreate;
	private ArrayList<String> errors;
	
	public DatabaseManager() {
		String[] credentials = readCredentialsFromFile();
		username = credentials[0];
		password = credentials[1];
		dbmsPrefix = DEFAULT_DBMS_PREFIX;
		hostname = DEFAULT_HOSTNAME;
		port = DEFAULT_PORT;
		databaseName = "";
		databaseSchemaName = "";
		connectionURL = DEFAULT_DBMS_PREFIX + hostname + ":" + port + "/" + databaseName;
		errors = new ArrayList<String>();
		
		createConnectionToDbms(connectionURL);
	}
	
	private void createConnectionToDbms(String aConnectionURL) {		
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		
		try {
			connection = DriverManager.getConnection(aConnectionURL, props);
			queryResultSet = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getDefaultConnectionURL() {
		return DEFAULT_DBMS_PREFIX + hostname + ":" + port + "/" + databaseName;
	}
	
	/**
	 * The file which contains the credentials should have the username
	 * in its first line and the password in the second one.
	 * @return
	 */
	private String[] readCredentialsFromFile() {
		String readUsername = "";
		String readPassword = "";
		String[] credentials = new String[2];
		
		try {
			File credentialsFile = new File(CREDENTIALS_FILE_PATH);
			Scanner in = new Scanner(credentialsFile);
			
			readUsername = in.nextLine();
			readPassword = in.nextLine();
            in.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		credentials[0] = readUsername;
		credentials[1] = readPassword;
		
		return credentials;
	}
	
	public void switchToDatabase(String aDatabaseName) {
		databaseName = aDatabaseName;
		connectionURL = getDefaultConnectionURL();
		
		createConnectionToDbms(connectionURL);
	}
	
	public void switchToSchema(String aDatabaseSchemaName) {
		databaseSchemaName = aDatabaseSchemaName;
		connectionURL = getDefaultConnectionURL() + "?currentSchema=" + databaseSchemaName;
		
		createConnectionToDbms(connectionURL);
	}
	
	private void executeCreateDatabaseStatement(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP DATABASE IF EXISTS " + databaseName);
		statement.executeUpdate("CREATE DATABASE " + databaseName);
		
		// Reconnect to the database which has just been created
		switchToDatabase(databaseName);
	}
	
	public void dropDatabase(String databaseName) {
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("DROP DATABASE IF EXISTS " + databaseName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void executeCreateSchemaStatement(String schemaName) throws SQLException {
		schemaName = schemaName.toLowerCase();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP SCHEMA IF EXISTS " + schemaName + " CASCADE");
		statement.executeUpdate("CREATE SCHEMA " + schemaName);
	}
	
	private void executeCreateTableStatement(Table table, String schemaName) throws SQLException {
		Attribute auxAttr;
		String createTableStatement = "CREATE TABLE ";
		
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
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(createTableStatement);
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
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(insertRowStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				executeCreateDatabaseStatement(userSessionID);
				
				// SCHEMA
				String databaseName = aDatabaseToCreate.getName();
				executeCreateSchemaStatement(databaseName);
				
				// TABLES
				for (int i = 0; i < aDatabaseToCreate.getNumOfTables(); i++) {
					Table auxTable = aDatabaseToCreate.getTables().get(i);
					executeCreateTableStatement(auxTable, databaseName);
					
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
		// The created statement must return a scrollable Result Set;
		// that is, it must be iterable more than once (ResultSet.TYPE_SCROLL_SENSITIVE).
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			queryResultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			errors.add(e.getMessage());
		}
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
		} catch (SQLException e) {
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
			    	String valueFromDatabase = (String) queryResultSet.getObject(i);
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
	
	public String getErrors() {
		String result = "";
		
		for (int i = 0; i < errors.size(); i++) {
			result += errors.get(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		SchemaDSLAnalyzer schemaDSLAnalyzer = new SchemaDSLAnalyzer();
		
		String schemaDefinition = DatabaseManager.getSchemaDefinitionFromFile(TEST_SCHEMA_DEFINITION_FILE_PATH);
		
		System.out.println(schemaDefinition);
		System.out.println(databaseManager);
		
		Database databaseToCreateOnPostgre = schemaDSLAnalyzer.getDatabaseObjectFromDefinition(schemaDefinition);
		
		databaseManager.createDatabaseOnDbms(databaseToCreateOnPostgre, "dssdfewr322423v");
		
		// Try SELECT * statement
		String selectStatement = "SELECT * FROM " + databaseToCreateOnPostgre.getTables().get(0).getName();
		try {
			databaseManager.executeQuery(selectStatement);
			//System.out.println(selectStatement);
			//System.out.println(databaseManager.getQueryResultSetAsString());
		}
		
		catch (/*SQL*/Exception e) {
			e.printStackTrace();
		}
	}
}
