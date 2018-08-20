package es.ull.relearn.analysis.dbschema;

// Generated from Database.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DatabaseParser}.
 */
public interface DatabaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DatabaseParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DatabaseParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DatabaseParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DatabaseParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code databaseCreation}
	 * labeled alternative in {@link DatabaseParser#database}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseCreation(DatabaseParser.DatabaseCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code databaseCreation}
	 * labeled alternative in {@link DatabaseParser#database}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseCreation(DatabaseParser.DatabaseCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableCreation}
	 * labeled alternative in {@link DatabaseParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTableCreation(DatabaseParser.TableCreationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableCreation}
	 * labeled alternative in {@link DatabaseParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTableCreation(DatabaseParser.TableCreationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleAttribute}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterSingleAttribute(DatabaseParser.SingleAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleAttribute}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitSingleAttribute(DatabaseParser.SingleAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(DatabaseParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(DatabaseParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleDatum}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 */
	void enterSingleDatum(DatabaseParser.SingleDatumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleDatum}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 */
	void exitSingleDatum(DatabaseParser.SingleDatumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dList}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 */
	void enterDList(DatabaseParser.DListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dList}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 */
	void exitDList(DatabaseParser.DListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeValue}
	 * labeled alternative in {@link DatabaseParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(DatabaseParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeValue}
	 * labeled alternative in {@link DatabaseParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(DatabaseParser.AttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 */
	void enterStringDatum(DatabaseParser.StringDatumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 */
	void exitStringDatum(DatabaseParser.StringDatumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 */
	void enterNumberDatum(DatabaseParser.NumberDatumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 */
	void exitNumberDatum(DatabaseParser.NumberDatumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(DatabaseParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(DatabaseParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterCharValue(DatabaseParser.CharValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitCharValue(DatabaseParser.CharValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterIntegerValue(DatabaseParser.IntegerValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitIntegerValue(DatabaseParser.IntegerValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(DatabaseParser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(DatabaseParser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDateValue(DatabaseParser.DateValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDateValue(DatabaseParser.DateValueContext ctx);
}