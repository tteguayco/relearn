package es.ull.relearn.analysis.dbschema;

// Generated from Database.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DatabaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DatabaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DatabaseParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(DatabaseParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code databaseCreation}
	 * labeled alternative in {@link DatabaseParser#database}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabaseCreation(DatabaseParser.DatabaseCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableCreation}
	 * labeled alternative in {@link DatabaseParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCreation(DatabaseParser.TableCreationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleAttribute}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAttribute(DatabaseParser.SingleAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link DatabaseParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(DatabaseParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleDatum}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleDatum(DatabaseParser.SingleDatumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dList}
	 * labeled alternative in {@link DatabaseParser#datalist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDList(DatabaseParser.DListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeValue}
	 * labeled alternative in {@link DatabaseParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(DatabaseParser.AttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDatum(DatabaseParser.StringDatumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberDatum}
	 * labeled alternative in {@link DatabaseParser#datum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDatum(DatabaseParser.NumberDatumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(DatabaseParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharValue(DatabaseParser.CharValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerValue(DatabaseParser.IntegerValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(DatabaseParser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateValue}
	 * labeled alternative in {@link DatabaseParser#datatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateValue(DatabaseParser.DateValueContext ctx);
}