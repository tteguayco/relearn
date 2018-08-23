package es.ull.relearn;

import es.ull.relearn.dbitems.Database;
import es.ull.relearn.utils.FileUtils;

public class RelationalAlgebraInterpreter {

	private static final String DATABASE_FILE_DEFINITION_PATH = "C:/Users/Teguayco/Desktop/r1r2r3r4.db";
	
	/*
	private ANTLRInputStream input;
	private ParseTree tree;
	
	private RelationalAlgebraLexer lexer;
	private CommonTokenStream tokens;
	private RelationalAlgebraParser parser;
	private RelationalAlgebraEvalVisitor eval;
	private CustomErrorListener errorListener;
	*/
	private Database database;
	private String sqlTranslation;
	
	public static void main(String args[]) {
		String databaseDefinition = FileUtils.readFileContentToString(DATABASE_FILE_DEFINITION_PATH);
		SchemaDSLAnalyzer schemaAnalyzer = new SchemaDSLAnalyzer();
		Database databaseToExecuteQueriesOn = schemaAnalyzer.getDatabaseObjectFromDefinition(databaseDefinition);
		
		
	}
}
