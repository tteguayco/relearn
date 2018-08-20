package es.ull.relearn.relearn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.relearn.analysis.CustomErrorListener;
import es.ull.relearn.analysis.dbschema.DatabaseEvalVisitor;
import es.ull.relearn.analysis.dbschema.DatabaseLexer;
import es.ull.relearn.analysis.dbschema.DatabaseParser;
import es.ull.relearn.dbitems.Database;

public class SchemaDSLAnalysisTest {

	private static final String GRAMMAR_PATH = "C:/development/relearn/grammars/Database.g4";
	private static final String DATABASE_SAMPLE_PATH = "C:/development/relearn/examples/r1r2r3r4.db";
	
	private Database database;
	private String filePath;
	private ArrayList<String> syntaxErrors;
	
	public SchemaDSLAnalysisTest(String aFilePath) {
		filePath = aFilePath;
	}
	
	private String readFile() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String(encoded);
	}
	
	/**
	 * Returns true if the file was read correctly.
	 * False otherwise.
	 * Returns true if there were not errors.
	 */
	public boolean readDatabaseFromFile() {
		try {
			String inputString = readFile();
			
			CustomErrorListener errorListener = new CustomErrorListener();
			ANTLRInputStream input = new ANTLRInputStream(inputString);
		    
			// Lexer
			DatabaseLexer lexer = new DatabaseLexer(input);
		    lexer.removeErrorListeners();
		    lexer.addErrorListener(errorListener);
		    
		    // Parser from tokens from the lexer
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    DatabaseParser parser = new DatabaseParser(tokens);
		    parser.removeErrorListeners();
		    parser.addErrorListener(errorListener);
		    
		    // Syntax analysis
		    ParseTree tree = parser.start();
		    
		    // Semantic analysis if syntax analysis was successful
		    if (errorListener.getSyntaxErrorsList().size() == 0) {	
		    	DatabaseEvalVisitor eval = new DatabaseEvalVisitor();
				database = (Database) eval.visit(tree);
				
				return true;
		    }
		    
		    else {
		    	// Window showing the errors for the user
		    	syntaxErrors = errorListener.getSyntaxErrorsList();
		    	return false;
		    }
		}
		
		catch (Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public ArrayList<String> getSyntaxErrors() {
		return syntaxErrors;
	}
	
	public static void main(String[] args) {
		SchemaDSLAnalysisTest schemaDSLAnalysisTest = new SchemaDSLAnalysisTest(DATABASE_SAMPLE_PATH);
		boolean result = false;
		
		result = schemaDSLAnalysisTest.readDatabaseFromFile();
		System.out.println(result);
		System.out.println(schemaDSLAnalysisTest.getSyntaxErrors());
	}
}
