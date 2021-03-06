package es.ull.relearn;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.relearn.analysis.CustomErrorListener;
import es.ull.relearn.analysis.dbschema.DatabaseEvalVisitor;
import es.ull.relearn.analysis.dbschema.DatabaseLexer;
import es.ull.relearn.analysis.dbschema.DatabaseParser;
import es.ull.relearn.dbitems.Database;

public class SchemaDSLAnalyzer {

	private Database database;
	private String errorMessages;
	
	public SchemaDSLAnalyzer() {
		database = null;
		errorMessages = "";
	}
	
	/**
	 * Returns a database object which represents the schema defined through the DSL.
	 * If an error occurs, null is returned.
	 * @param schemaDefinition
	 * @return
	 */

	public Database getDatabaseObjectFromDefinition(String schemaDefinition) {
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
			
			return database;
	    }
	    
	    else {
	    	// Save errors
	    	for (int i = 0; i < errorListener.getSyntaxErrorsList().size(); i++) {
    			errorMessages += errorListener.getSyntaxErrorsList().get(i) + "\n";
	    	}
	    	
	    	return null;
	    }
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public String getErrorMessages() {
		return errorMessages;
	}
}
