package es.ull.relearn;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Date;

import org.json.JSONObject;

import es.ull.relearn.dbitems.Database;
import es.ull.relearn.RelationalAlgebraInterpreter;
import es.ull.relearn.DatabaseManager;
import es.ull.relearn.SchemaDSLAnalyzer;
import es.ull.relearn.ScheduledDatabaseDropper;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.pp.para.GFmtOpt;
import gudusoft.gsqlparser.pp.para.GFmtOptFactory;
import gudusoft.gsqlparser.pp.stmtformattor.FormattorFactory;
import spark.ModelAndView;
import spark.Spark;
import spark.utils.IOUtils;
import spark.template.velocity.*;

import static es.ull.relearn.utils.JsonUtils.*;

public class MainApp {

	private static final int DEFAULT_PORT = 8080;
	private static final String STATIC_FILES_LOCATION = "/public";
	private static final String HOME_PAGE_PATH = "/views/home.html";
	private static final String SCHEMA_PAGE_PATH = "/views/schema.html";
	private static final String MAIN_PAGE_PATH = "/templates/app.vm";
	private static final String ABOUT_PAGE_PATH = "/views/about.html";
	private static final String STATISTICS_PAGE_PATH = "/views/statistics.html";
	
	public static DatabaseManager databaseManager = new DatabaseManager();
	public static HashMap<String, Timestamp> definedDatabases = new HashMap<String, Timestamp>();
	public static ScheduledDatabaseDropper databaseDropper = new ScheduledDatabaseDropper(definedDatabases, databaseManager);
	
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
		Spark.get("/about", (req, res) -> renderContent(ABOUT_PAGE_PATH));
		Spark.get("/statistics", (req, res) -> renderContent(STATISTICS_PAGE_PATH));
		
		Spark.get("/", (req, res) -> {
			String routeToRedirect = "/main";
			res.redirect(routeToRedirect);
			return null;
		});
		
		Spark.get("/schema", (req, res) -> {
			Database definedDatabase = req.session().attribute("definedDatabase");
			String routeToRedirect = "/main";
			
			if (definedDatabase != null) {
				res.redirect(routeToRedirect);
				return null;
			}
			
			return renderContent(SCHEMA_PAGE_PATH);
		});
		
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
				Date date = new Date();
				long time = date.getTime();
				
				databaseManager.createDatabaseOnDbms(definedDatabase, userSessionID);
				definedDatabases.put(userSessionID, new Timestamp(time));
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
				sqlTranslation = formatSqlQuery(sqlTranslation);
				
				// Execute the SQL translation on PostgreSQL and get the result table
				String databaseName = req.session().id();
				String schemaName = selectedDatabaseName;
				
				databaseManager.switchToDatabase(databaseName);
				databaseManager.switchToSchema(schemaName);
				databaseManager.executeQuery(sqlTranslation);
				
				String queryExecutionErrors = databaseManager.getErrors();
				
				if (queryExecutionErrors.length() > 0) {
					translationErrors += queryExecutionErrors;
				} else {
					resultTable = databaseManager.getResultSetAsJson();
				}
			}
		
			translationErrors = prepareErrorsMessages(translationErrors);
			
			responseForClient.put("SQLTranslation", sqlTranslation);
			responseForClient.put("TranslationExecutionResult", resultTable);
			responseForClient.put("RelationalAlgebraTranslationErrors", translationErrors);
			
			System.out.println("SQL Translation: " + sqlTranslation);
			System.out.println("Translation errors: " + translationErrors);
			
			return responseForClient;
			
		}, json());
		
		databaseDropper.start();
	}
	
	private static String prepareErrorsMessages(String errorsMessage) {
		return errorsMessage.replaceAll("\n", "<br>");
	}
	
	private static String formatSqlQuery(String sqlQuery) {
		TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvoracle);
		sqlparser.sqltext = sqlQuery;
        int ret = sqlparser.parse();
        
        if (ret == 0) {
            GFmtOpt option = GFmtOptFactory.newInstance();
            return FormattorFactory.pp(sqlparser, option);
        }
        
        return sqlQuery;
	}
}
