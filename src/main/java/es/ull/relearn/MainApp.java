package es.ull.relearn;
import static spark.Spark.*;

public class MainApp {

	private static final int DEFAULT_PORT = 8080;
	
	public static void main(String[] args) {
		
		// Server initialization
		port(DEFAULT_PORT);
		init();
		
		get("/", (req, res) -> "Showing home page");
		get("/schema", (req, res) -> "Schema page!");
	}
}
