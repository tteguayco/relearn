package es.ull.relearn;
import static spark.Spark.*;

import java.io.IOException;

import spark.Spark;
import spark.utils.IOUtils;

public class MainApp {

	private static final int DEFAULT_PORT = 8080;
	private static final String HOME_PAGE_PATH = "/views/home.html";
	private static final String SCHEMA_PAGE_PATH = "/views/schema.html";
	
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
		Spark.staticFiles.location("/public");
		Spark.init();
		
		Spark.get("/", (req, res) -> renderContent(HOME_PAGE_PATH));
		Spark.get("/schema", (req, res) -> renderContent(SCHEMA_PAGE_PATH));
	}
}
