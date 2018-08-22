package es.ull.relearn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import es.ull.relearn.dbitems.Database;
import spark.ModelAndView;
import spark.Spark;
import spark.utils.IOUtils;
import spark.template.velocity.*;

public class MainApp {

	private static final int DEFAULT_PORT = 8080;
	private static final String STATIC_FILES_LOCATION = "/public";
	private static final String HOME_PAGE_PATH = "/views/home.html";
	private static final String SCHEMA_PAGE_PATH = "/views/schema.html";
	private static final String MAIN_PAGE_PATH = "/views/app.html";
	
	//private Database definedDatabase = null;
	
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
		
		Spark.get("/schema", (req, res) -> renderContent(SCHEMA_PAGE_PATH));
		
		Spark.get("/checkSchemaDefinitionFromFile", (req, res) -> {
			SchemaDSLAnalyzer schemaDSLAnalyzer = new SchemaDSLAnalyzer();
			DatabaseManager databaseManager = new DatabaseManager();
			Database definedDatabase = null;
			
			System.out.println("The following definition schema was received from the client:\n\"");
			String schemaDefinitionDSL = req.queryParams("DatabaseSchemaDefinition");
			System.out.println(schemaDefinitionDSL + "\n\"");
			
			definedDatabase = schemaDSLAnalyzer.getDatabaseObjectFromDefinition(schemaDefinitionDSL);
			req.session().attribute("definedDatabase", definedDatabase);
			
			// If there are errors, send them to the client
			if (definedDatabase == null) {
				System.out.println("The following errors were encountered:");
				System.out.println(schemaDSLAnalyzer.getErrorMessages());
				return schemaDSLAnalyzer.getErrorMessages();
			}
			
			// Create database on PostgreSQL
			else {
				String userSessionID = req.session().id();
				System.out.println("Creating database for the session ID: " + userSessionID);
				//System.out.println(databaseManager);
				databaseManager.createDatabaseOnDbms(definedDatabase, userSessionID);
			}
			
			System.out.println("Database created on PostgreSQL with no errors.");
			return "";
		});
		
		Spark.get("/main", (req, res) -> {
			System.out.println("\n/main visited. Session ID: " + req.session().id());
			
			Map<String, Object> model = new HashMap<String, Object>();
			Database definedDatabase = req.session().attribute("definedDatabase");
			
			if (definedDatabase != null) {
				model.put("database", definedDatabase);
				System.out.println("Serving main app page...");
				return new ModelAndView(model, "/templates/app.vm");
			}
			
			// If the user visits /main and there are no databases defined, 
			// redirect him/her to the schema page
			else {
				res.redirect("/schema");
				return null;
			}
			
		}, new VelocityTemplateEngine());
	}
}
