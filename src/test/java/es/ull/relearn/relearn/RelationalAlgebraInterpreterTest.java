package es.ull.relearn.relearn;

import org.junit.jupiter.api.Test;

import es.ull.relearn.RelationalAlgebraInterpreter;
import es.ull.relearn.SchemaDSLAnalyzer;
import es.ull.relearn.dbitems.Database;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RelationalAlgebraInterpreterTest extends TestCase {

	private static final String DEFAULT_DB_DEFINITION_PATH = "examples/r1r2r3r4.db";
	
	private Database database;
	private SchemaDSLAnalyzer schemaAnalyzer;
	private RelationalAlgebraInterpreter relalgInterpreter;
	
	protected void setUp() {
		schemaAnalyzer = new SchemaDSLAnalyzer();
		database = schemaAnalyzer.getDatabaseObjectFromDefinition(DEFAULT_DB_DEFINITION_PATH);
		relalgInterpreter = new RelationalAlgebraInterpreter(database);
    }
	
	@Test
	public void testSimpleProjectionTranslation() {
		String relalgQuery = "PROJECT A, B, C (R);";
		String expectedSqlTranslation = "SELECT A, B, C FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionCascadeTranslation() {
		String relalgQuery = "PROJECT A (PROJECT A, B (PROJECT A, B, C (R)));";
		String expectedSqlTranslation = "SELECT A FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithSum() {
		String relalgQuery = "PROJECT SUM(A) (R);";
		String expectedSqlTranslation = "SELECT SUM(A) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithCount() {
		String relalgQuery = "PROJECT COUNT(A) (R);";
		String expectedSqlTranslation = "SELECT COUNT(A) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithCountStar() {
		String relalgQuery = "PROJECT COUNT(*) (R);";
		String expectedSqlTranslation = "SELECT COUNT(*) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithMin() {
		String relalgQuery = "PROJECT MIN(A) (R);";
		String expectedSqlTranslation = "SELECT MIN(A) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithMax() {
		String relalgQuery = "PROJECT MAX(A) (R);";
		String expectedSqlTranslation = "SELECT MAX(A) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testProjectionWithAverage() {
		String relalgQuery = "PROJECT AVG(A) (R);";
		String expectedSqlTranslation = "SELECT AVG(A) FROM R;";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testSimpleSelectionTranslation() {
		String relalgQuery = "SELECT [A < 1] (R);";
		String expectedSqlTranslation = "SELECT * FROM R WHERE (A < 1);";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testSelectionTranslationAndCondition() {
		String relalgQuery = "SELECT [A < 1 AND B = 'b'] (R);";
		String expectedSqlTranslation = "SELECT * FROM R WHERE (A < 1) AND (B = 'b');";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
	
	@Test
	public void testSelectionTranslationOrCondition() {
		String relalgQuery = "SELECT [A < 1 OR B = 'b'] (R);";
		String expectedSqlTranslation = "SELECT * FROM R WHERE ((A < 1) OR (B = 'b'));";
		String actualSqlTranslation = relalgInterpreter.translate(relalgQuery);
		
		Assert.assertEquals(expectedSqlTranslation, actualSqlTranslation);
	}
}
