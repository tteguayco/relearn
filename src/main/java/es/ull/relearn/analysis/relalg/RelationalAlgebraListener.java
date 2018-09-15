package es.ull.relearn.analysis.relalg;

// Generated from RelationalAlgebra.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RelationalAlgebraParser}.
 */
public interface RelationalAlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 */
	void enterViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 */
	void exitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rightOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRightOuterJoin(RelationalAlgebraParser.RightOuterJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rightOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRightOuterJoin(RelationalAlgebraParser.RightOuterJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFullOuterJoin(RelationalAlgebraParser.FullOuterJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFullOuterJoin(RelationalAlgebraParser.FullOuterJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rename}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRename(RelationalAlgebraParser.RenameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rename}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRename(RelationalAlgebraParser.RenameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLeftOuterJoin(RelationalAlgebraParser.LeftOuterJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftOuterJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLeftOuterJoin(RelationalAlgebraParser.LeftOuterJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterEqual(RelationalAlgebraParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitEqual(RelationalAlgebraParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(RelationalAlgebraParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(RelationalAlgebraParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(RelationalAlgebraParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(RelationalAlgebraParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterLessEqual(RelationalAlgebraParser.LessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitLessEqual(RelationalAlgebraParser.LessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterNullFromCompared(RelationalAlgebraParser.NullFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitNullFromCompared(RelationalAlgebraParser.NullFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggrSum}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAggrSum(RelationalAlgebraParser.AggrSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggrSum}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAggrSum(RelationalAlgebraParser.AggrSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggrCount}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAggrCount(RelationalAlgebraParser.AggrCountContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggrCount}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAggrCount(RelationalAlgebraParser.AggrCountContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggrMin}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAggrMin(RelationalAlgebraParser.AggrMinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggrMin}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAggrMin(RelationalAlgebraParser.AggrMinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggrMax}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAggrMax(RelationalAlgebraParser.AggrMaxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggrMax}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAggrMax(RelationalAlgebraParser.AggrMaxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aggrAvg}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAggrAvg(RelationalAlgebraParser.AggrAvgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aggrAvg}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAggrAvg(RelationalAlgebraParser.AggrAvgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
}