package es.ull.relearn;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.relearn.analysis.CustomErrorListener;
import es.ull.relearn.dbitems.Database;
import es.ull.relearn.dsl.DatabaseEvalVisitor;
import es.ull.relearn.dsl.DatabaseLexer;
import es.ull.relearn.dsl.DatabaseParser;

public class SchemaDSLChecker {

	private Database database;
	private String errorMessages;
	
	public void SchemaDSLChecker() {
		database = null;
		errorMessages = "";
	}
	
	public boolean schemaDefinitionIsCorrect(String schemaDefinition) {
		CustomErrorListener errorListener = new CustomErrorListener();
		ANTLRInputStream input = new ANTLRInputStream(schemaDefinition);
	    
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
	    	// Save errors
	    	for (int i = 0; i < errorListener.getSyntaxErrorsList().size(); i++) {
	    		errorMessages += errorListener.getSyntaxErrorsList().get(i) + "\n";
	    	}
	    	
	    	return false;
	    }
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public String getErrorMessages() {
		return errorMessages;
	}
}
