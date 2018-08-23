package es.ull.relearn;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import es.ull.relearn.analysis.CustomErrorListener;
import es.ull.relearn.analysis.relalg.RelationalAlgebraEvalVisitor;
import es.ull.relearn.analysis.relalg.RelationalAlgebraLexer;
import es.ull.relearn.analysis.relalg.RelationalAlgebraParser;
import es.ull.relearn.dbitems.Database;
import es.ull.relearn.utils.FileUtils;

public class RelationalAlgebraInterpreter {

	private static final String DATABASE_FILE_DEFINITION_PATH = "C:/Users/Teguayco/Desktop/r1r2r3r4.db";
	
	private ANTLRInputStream input;
	private ParseTree tree;
	
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private RelationalAlgebraEvalVisitor eval;
	private CustomErrorListener errorListener;
	
	private Database database;
	private String sqlTranslation;
	
	public RelationalAlgebraInterpreter(Database aDatabase) {
		database = aDatabase;
		errorListener = new CustomErrorListener();	
		sqlTranslation = null;
	}
	
	private void runSyntaxAnalysis(String relationalAlgebraInput) {
		input = new ANTLRInputStream(relationalAlgebraInput);
		
		lexer = new RelationalAlgebraLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListener);
		
		tokens = new CommonTokenStream(lexer);
		parser = new RelationalAlgebraParser(tokens);
		parser.removeErrorListeners();
	    parser.addErrorListener(errorListener);
	}
	
	private void runSemanticAnalysis() {
		eval = new RelationalAlgebraEvalVisitor(database);
		sqlTranslation = eval.visit(tree);
		
		// Semantic errors?
		if (eval.getErrorsList().size() > 0) {
			for (int i = 0; i < eval.getErrorsList().size(); i++) {
				System.out.println(" - " + eval.getErrorsList().get(i));
			}
		}
	}
	
	public String translate(String relationalAlgebraInput) {
		errorListener = new CustomErrorListener();
	    runSyntaxAnalysis(relationalAlgebraInput);
		tree = parser.start();
		
	    // Semantic analysis if syntax analysis was successful
	    if (errorListener.getSyntaxErrorsList().size() == 0) {	
	    	runSemanticAnalysis();
	    }
	    
	    else {
	    	errorListener.printErrors();
	    }
		
		return sqlTranslation;
	}
	
	public static void main(String args[]) {
		String databaseDefinition = FileUtils.readFileContentToString(DATABASE_FILE_DEFINITION_PATH);
		SchemaDSLAnalyzer schemaAnalyzer = new SchemaDSLAnalyzer();
		Database databaseToExecuteQueriesOn = schemaAnalyzer.getDatabaseObjectFromDefinition(databaseDefinition);
		RelationalAlgebraInterpreter relalgInterpreter = new RelationalAlgebraInterpreter(databaseToExecuteQueriesOn);
		String sqlQuery = "";
		
		//sqlQuery = relalgInterpreter.translate("PROJECT (A, B, C) (R1 natural join R2);");
		//sqlQuery = relalgInterpreter.translate("RENAME (D, E, F) (PROJECT (A, B, C) (R1 NATURAL JOIN R2));");
		//sqlQuery = relalgInterpreter.translate("PROJECT (A, B) (REL1) RIGHT OUTER JOIN PROJECT (C, D) (REL2) (rel1.A = rel2.C);");
		System.out.println("SQL Translation:");
		System.out.println(sqlQuery);
	}
}
