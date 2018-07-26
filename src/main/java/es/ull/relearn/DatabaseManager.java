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
	
	private Connection connection;
	private ResultSet queryResultSet;
	
	private Database databaseToCreate;
	private boolean errors;
	
	public DatabaseManager() {
		String[] credentials = readCredentialsFromFile();
		username = credentials[0];
		password = credentials[1];
		dbmsPrefix = DEFAULT_DBMS_PREFIX;
		hostname = DEFAULT_HOSTNAME;
		port = DEFAULT_PORT;
		connectionURL = DEFAULT_DBMS_PREFIX + hostname + ":" + port + "/";
		
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		
		try {
			connection = DriverManager.getConnection(connectionURL, props);
			queryResultSet = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	private void executeCreateDatabaseStatement(String databaseName) throws SQLException {
		databaseName = databaseName.toLowerCase();
		Statement statement = connection.createStatement();
		statement.executeUpdate("CREATE DATABASE " + databaseName);
	}
	
	private void executeCreateTableStatement(Table table) throws SQLException {
		Attribute auxAttr;
		String createTableStatement = "CREATE TABLE ";
		
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
	 * Normally, the "schemaIdName" will be the user session id so that users use
	 * only their own databases.
	 * @param aDatabaseToCreate
	 * @param schemaName
	 */
	public void createDatabaseOnDbms(Database aDatabaseToCreate, String schemaIdName) {
		try {
			if (databaseToCreate != null && connection != null) {
				
				// DATABASE
				String databaseName = aDatabaseToCreate.getName();
				executeCreateDatabaseStatement(databaseName);
				
				// TABLES
				for (int i = 0; i < aDatabaseToCreate.getNumOfTables(); i++) {
					Table auxTable = aDatabaseToCreate.getTables().get(i);
					executeCreateTableStatement(auxTable);
					
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
	
	public void executeQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		queryResultSet = statement.executeQuery(query);
	}
	
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		SchemaDSLAnalyzer schemaDSLAnalyzer = new SchemaDSLAnalyzer();
		
		String schemaDefinition = DatabaseManager.getSchemaDefinitionFromFile(TEST_SCHEMA_DEFINITION_FILE_PATH);
		
		System.out.println(schemaDefinition);
		System.out.println(databaseManager);
		
		Database databaseToCreateOnPostgre = schemaDSLAnalyzer.getDatabaseObjectFromDefinition(schemaDefinition);
		databaseManager.createDatabaseOnDbms(databaseToCreateOnPostgre, "123456");
	}
}
