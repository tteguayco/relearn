package es.ull.relearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import es.ull.relearn.dbitems.Database;

/**
 * Creates the specified database on PostgreSQL.
 * @author Teguayco
 *
 */
public class DatabaseManager {
	
	private static final String CREDENTIALS_FILE_PATH = "C:/Users/Teguayco/Desktop/postgresql_credentials.txt";
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
	
	/**
	 * TODO complete
	 * Normally, the "schemaName" will be the user session id so that a user uses
	 * only its databases.
	 * @param aDatabaseToCreate
	 * @param schemaName
	 */
	public void createDatabase(Database aDatabaseToCreate, String schemaName) {
		if (databaseToCreate != null) {
			
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
	
	public static void main(String[] args) {
		DatabaseManager databaseManager = new DatabaseManager();
		System.out.println(databaseManager);
	}
}
