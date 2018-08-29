package es.ull.relearn;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import es.ull.relearn.dbitems.Database;
import spark.ModelAndView;
import spark.Spark;
import spark.utils.IOUtils;
import spark.template.velocity.*;

import static es.ull.relearn.utils.JsonUtils.*;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

public class MainApp {

	private static final int DEFAULT_PORT = 8080;
	private static final String STATIC_FILES_LOCATION = "/public";
	private static final String HOME_PAGE_PATH = "/views/home.html";
	private static final String SCHEMA_PAGE_PATH = "/views/schema.html";
	private static final String MAIN_PAGE_PATH = "/templates/app.vm";
	private static final String ABOUT_PAGE_PATH = "/views/about.html";
	private static final String STATISTICS_PAGE_PATH = "/views/statistics.html";
	
	public static DatabaseManager databaseManager = new DatabaseManager();
	public static ArrayList<Database> definedDatabases = new ArrayList<Database>();
	
	private static String renderContent(String htmlFilePath) {
		String htmlPageAsString = "";
		
		try {
			htmlPageAsString = IOUtils.toString(Spark.class.getResourceAsStream(htmlFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return htmlPageAsString;
	}
	
	public static void main(String[] args) {
		
		// Server initialization
		Spark.port(DEFAULT_PORT);
		
		// Automatic refresh of static files
		// COMMENT THESE LINES DURING DEVELOPMENT
		String projectDir = System.getProperty("user.dir");
	    String staticDir = "/src/main/resources/public";
	    Spark.staticFiles.externalLocation(projectDir + staticDir);
		
	    // Uncomment the following line when deploying the app
		//Spark.staticFiles.location(STATIC_FILES_LOCATION);
		
	    Spark.init();
		System.out.println("Server listening on port " + Spark.port());
		
		// ROUTES
		Spark.get("/", (req, res) -> renderContent(HOME_PAGE_PATH));
		Spark.get("/about", (req, res) -> renderContent(ABOUT_PAGE_PATH));
		Spark.get("/schema", (req, res) -> renderContent(SCHEMA_PAGE_PATH));
		Spark.get("/statistics", (req, res) -> renderContent(STATISTICS_PAGE_PATH));
		
		Spark.get("/checkSchemaDefinitionFromFile", (req, res) -> {
			SchemaDSLAnalyzer schemaDSLAnalyzer = new SchemaDSLAnalyzer();
			Database definedDatabase = null;
			String schemaDefinitionDSL = req.queryParams("DatabaseSchemaDefinition");
			
			definedDatabase = schemaDSLAnalyzer.getDatabaseObjectFromDefinition(schemaDefinitionDSL);
			req.session().attribute("definedDatabase", definedDatabase);
			
			if (definedDatabase == null) {
				System.out.println(">> The creation of the specified database on PostgreSQL raised errors.");
				return schemaDSLAnalyzer.getErrorMessages();
			}
			
			else {
				String userSessionID = req.session().id();
				String definedDatabaseName = definedDatabase.getName();
				databaseManager.createDatabaseOnDbms(definedDatabase, userSessionID);
				definedDatabases.add(definedDatabase);
				System.out.println(">> Database '" + definedDatabaseName + "' was created on PostgreSQL.");
			}
			
			return "";
		});
		
		Spark.get("/main", (req, res) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			Database definedDatabase = req.session().attribute("definedDatabase");
			
			if (definedDatabase != null) {
				model.put("database", definedDatabase);
				return new ModelAndView(model, MAIN_PAGE_PATH);
			}
			
			else {
				String routeToRedirect = "/schema";
				res.redirect(routeToRedirect);
				return null;
			}
			
		}, new VelocityTemplateEngine());
	
		Spark.get("/executeQuery", "application/json", (req, res) -> {
			String relationalAlgebraQuery = "";
			String sqlTranslation = "";
			String translationErrors = "";
			String selectedDatabaseName = "";
			Database definedDatabase = null;
			RelationalAlgebraInterpreter relalgInterpreter = null;
			JSONObject responseForClient = new JSONObject();
			JSONObject resultTable = null;
			
			// Collect data sent from the client
			relationalAlgebraQuery = req.queryParams("RelationalAlgebraQuery");
			selectedDatabaseName = req.queryParams("SelectedDatabaseName");
			
			// Translation Relational Algebra into SQL
			relalgInterpreter = new RelationalAlgebraInterpreter(definedDatabase);
			sqlTranslation = relalgInterpreter.translate(relationalAlgebraQuery);
			translationErrors = relalgInterpreter.getErrors();
			
			if (translationErrors.length() <= 0) {
				// Format SQL output
				BasicFormatterImpl sqlFormatter = new BasicFormatterImpl();
				sqlTranslation = sqlFormatter.format(sqlTranslation);
				
				// Execute the SQL translation on PostgreSQL and get the result table
				String databaseName = req.session().id();
				String schemaName = selectedDatabaseName;
				
				databaseManager.switchToDatabase(databaseName);
				databaseManager.switchToSchema(schemaName);
				databaseManager.executeQuery(sqlTranslation);
				resultTable = databaseManager.getResultSetAsJson();
			}
		
			translationErrors = prepareErrorsMessages(translationErrors);
			
			responseForClient.put("SQLTranslation", sqlTranslation);
			responseForClient.put("TranslationExecutionResult", resultTable);
			responseForClient.put("RelationalAlgebraTranslationErrors", translationErrors);
			
			return responseForClient;
			
		}, json());
		
		// Drop all defined databases on program exit
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		    	System.out.println("Dropping databases...");
		        deleteAllDefinedDatabases();
		    }
		}));
	}
	
	private static String prepareErrorsMessages(String errorsMessage) {
		return errorsMessage.replaceAll("\n", "<br>");
	}
	
	private static void deleteAllDefinedDatabases() {
		String databaseName = "";
		
		for (int i = 0; i < definedDatabases.size(); i++) {
			databaseName = definedDatabases.get(i).getName();
			databaseManager.dropDatabase(databaseName);
		}
	}
}
