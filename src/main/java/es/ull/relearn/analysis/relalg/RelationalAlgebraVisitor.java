package es.ull.relearn.analysis.relalg;

// Generated from RelationalAlgebra.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RelationalAlgebraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RelationalAlgebraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rightOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightOuterJoin(RelationalAlgebraParser.RightOuterJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullOuterJoin(RelationalAlgebraParser.FullOuterJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rename}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename(RelationalAlgebraParser.RenameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftOuterJoin(RelationalAlgebraParser.LeftOuterJoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrFromAggrList}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrFromAggrList(RelationalAlgebraParser.AggrFromAggrListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrList}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateList(RelationalAlgebraParser.AggregatelistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCondlistAggr}
	 * labeled alternative in {@link RelationalAlgebraParser#condlistaggr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondlistAggr(RelationalAlgebraParser.AndCondlistAggrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCondlistAggr}
	 * labeled alternative in {@link RelationalAlgebraParser#condlistaggr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondlistAggr(RelationalAlgebraParser.OrCondlistAggrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsCondlistaggr}
	 * labeled alternative in {@link RelationalAlgebraParser#condlistaggr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsCondlistaggr(RelationalAlgebraParser.BracketsCondlistaggrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparedCondlistaggr}
	 * labeled alternative in {@link RelationalAlgebraParser#condlistaggr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparedCondlistaggr(RelationalAlgebraParser.ComparedCondlistaggrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(RelationalAlgebraParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(RelationalAlgebraParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(RelationalAlgebraParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqual(RelationalAlgebraParser.LessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrSum}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrSum(RelationalAlgebraParser.AggrSumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrCount}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrCount(RelationalAlgebraParser.AggrCountContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrMin}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrMin(RelationalAlgebraParser.AggrMinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrMax}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrMax(RelationalAlgebraParser.AggrMaxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggrAvg}
	 * labeled alternative in {@link RelationalAlgebraParser#aggrfunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggrAvg(RelationalAlgebraParser.AggrAvgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
}