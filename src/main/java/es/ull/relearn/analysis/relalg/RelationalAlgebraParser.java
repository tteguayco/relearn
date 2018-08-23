package es.ull.relearn.analysis.relalg;

// Generated from RelationalAlgebra.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationalAlgebraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, PROJECTION=6, SELECTION=7, RENAME=8, 
		UNION=9, DIFFERENCE=10, CARTESIAN_PRODUCT=11, INTERSECTION=12, NATURAL_JOIN=13, 
		JOIN=14, GROUP_BY=15, HAVING=16, LEFT_OUTER_JOIN=17, RIGHT_OUTER_JOIN=18, 
		FULL_OUTER_JOIN=19, DIVISION=20, SUM=21, COUNT=22, MIN=23, MAX=24, AVERAGE=25, 
		EQUAL=26, NOT_EQUAL=27, GREATER_THAN=28, GREATER_EQUAL=29, LESS_THAN=30, 
		LESS_EQUAL=31, BOOLEAN_AND=32, BOOLEAN_OR=33, BOOLEAN_NOT=34, STRING=35, 
		IDENTIFIER=36, NUMBER=37, WHITESPACES=38, MULTILINE_COMMENT=39, LINE_COMMENT=40;
	public static final int
		RULE_start = 0, RULE_view = 1, RULE_expr = 2, RULE_aggrlist = 3, RULE_attrlist = 4, 
		RULE_condlist = 5, RULE_condlistaggr = 6, RULE_comparator = 7, RULE_compared = 8, 
		RULE_aggrfunction = 9, RULE_relation = 10, RULE_attribute = 11;
	public static final String[] ruleNames = {
		"start", "view", "expr", "aggrlist", "attrlist", "condlist", "condlistaggr", 
		"comparator", "compared", "aggrfunction", "relation", "attribute"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'*'", null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "'='", null, "'>'", "'>='", "'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "PROJECTION", "SELECTION", "RENAME", 
		"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
		"JOIN", "GROUP_BY", "HAVING", "LEFT_OUTER_JOIN", "RIGHT_OUTER_JOIN", "FULL_OUTER_JOIN", 
		"DIVISION", "SUM", "COUNT", "MIN", "MAX", "AVERAGE", "EQUAL", "NOT_EQUAL", 
		"GREATER_THAN", "GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", 
		"BOOLEAN_OR", "BOOLEAN_NOT", "STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", 
		"MULTILINE_COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RelationalAlgebraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RelationalAlgebraParser.EOF, 0); }
		public List<ViewContext> view() {
			return getRuleContexts(ViewContext.class);
		}
		public ViewContext view(int i) {
			return getRuleContext(ViewContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					view();
					setState(25);
					match(T__0);
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(32);
			expr(0);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(33);
				match(T__0);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewContext extends ParserRuleContext {
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
	 
		public ViewContext() { }
		public void copyFrom(ViewContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ViewAssignmentContext extends ViewContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ViewAssignmentContext(ViewContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterViewAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitViewAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitViewAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_view);
		try {
			_localctx = new ViewAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(IDENTIFIER);
			setState(42);
			match(EQUAL);
			setState(43);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RightOuterJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_OUTER_JOIN() { return getToken(RelationalAlgebraParser.RIGHT_OUTER_JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public RightOuterJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRightOuterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRightOuterJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRightOuterJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode UNION() { return getToken(RelationalAlgebraParser.UNION, 0); }
		public UnionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FullOuterJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FULL_OUTER_JOIN() { return getToken(RelationalAlgebraParser.FULL_OUTER_JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public FullOuterJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterFullOuterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitFullOuterJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitFullOuterJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(RelationalAlgebraParser.DIVISION, 0); }
		public DivisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CartesianProductContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CARTESIAN_PRODUCT() { return getToken(RelationalAlgebraParser.CARTESIAN_PRODUCT, 0); }
		public CartesianProductContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterCartesianProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitCartesianProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitCartesianProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectionContext extends ExprContext {
		public TerminalNode SELECTION() { return getToken(RelationalAlgebraParser.SELECTION, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RenameContext extends ExprContext {
		public TerminalNode RENAME() { return getToken(RelationalAlgebraParser.RENAME, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RenameContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRename(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NaturalJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NATURAL_JOIN() { return getToken(RelationalAlgebraParser.NATURAL_JOIN, 0); }
		public NaturalJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNaturalJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNaturalJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNaturalJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationFromExprContext extends ExprContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public RelationFromExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRelationFromExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRelationFromExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationFromExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntersectionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INTERSECTION() { return getToken(RelationalAlgebraParser.INTERSECTION, 0); }
		public IntersectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitIntersection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DifferenceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIFFERENCE() { return getToken(RelationalAlgebraParser.DIFFERENCE, 0); }
		public DifferenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProjectionContext extends ExprContext {
		public TerminalNode PROJECTION() { return getToken(RelationalAlgebraParser.PROJECTION, 0); }
		public List<AttrlistContext> attrlist() {
			return getRuleContexts(AttrlistContext.class);
		}
		public AttrlistContext attrlist(int i) {
			return getRuleContext(AttrlistContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode GROUP_BY() { return getToken(RelationalAlgebraParser.GROUP_BY, 0); }
		public TerminalNode HAVING() { return getToken(RelationalAlgebraParser.HAVING, 0); }
		public CondlistaggrContext condlistaggr() {
			return getRuleContext(CondlistaggrContext.class,0);
		}
		public ProjectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(RelationalAlgebraParser.JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public JoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketsExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketsExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterBracketsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitBracketsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftOuterJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEFT_OUTER_JOIN() { return getToken(RelationalAlgebraParser.LEFT_OUTER_JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public LeftOuterJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterLeftOuterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitLeftOuterJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLeftOuterJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new RelationFromExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(46);
				relation();
				}
				break;
			case T__1:
				{
				_localctx = new BracketsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__1);
				setState(48);
				expr(0);
				setState(49);
				match(T__2);
				}
				break;
			case PROJECTION:
				{
				_localctx = new ProjectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(PROJECTION);
				setState(52);
				match(T__1);
				setState(53);
				attrlist();
				setState(54);
				match(T__2);
				setState(55);
				match(T__1);
				setState(56);
				expr(0);
				setState(57);
				match(T__2);
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(58);
					match(GROUP_BY);
					setState(59);
					match(T__1);
					setState(60);
					attrlist();
					setState(61);
					match(T__2);
					setState(64);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(62);
						match(HAVING);
						setState(63);
						condlistaggr(0);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case SELECTION:
				{
				_localctx = new SelectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(SELECTION);
				setState(69);
				match(T__1);
				setState(70);
				condlist(0);
				setState(71);
				match(T__2);
				setState(72);
				match(T__1);
				setState(73);
				expr(0);
				setState(74);
				match(T__2);
				}
				break;
			case RENAME:
				{
				_localctx = new RenameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(RENAME);
				setState(77);
				match(T__1);
				setState(78);
				attrlist();
				setState(79);
				match(T__2);
				setState(80);
				match(T__1);
				setState(81);
				expr(0);
				setState(82);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(87);
						match(UNION);
						setState(88);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new CartesianProductContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(90);
						match(CARTESIAN_PRODUCT);
						setState(91);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(93);
						match(DIFFERENCE);
						setState(94);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new NaturalJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(96);
						match(NATURAL_JOIN);
						setState(97);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new IntersectionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(99);
						match(INTERSECTION);
						setState(100);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(102);
						match(DIVISION);
						setState(103);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new JoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(105);
						match(JOIN);
						setState(106);
						expr(0);
						setState(107);
						match(T__1);
						setState(108);
						condlist(0);
						setState(109);
						match(T__2);
						}
						break;
					case 8:
						{
						_localctx = new LeftOuterJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(112);
						match(LEFT_OUTER_JOIN);
						setState(113);
						expr(0);
						setState(114);
						match(T__1);
						setState(115);
						condlist(0);
						setState(116);
						match(T__2);
						}
						break;
					case 9:
						{
						_localctx = new RightOuterJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(119);
						match(RIGHT_OUTER_JOIN);
						setState(120);
						expr(0);
						setState(121);
						match(T__1);
						setState(122);
						condlist(0);
						setState(123);
						match(T__2);
						}
						break;
					case 10:
						{
						_localctx = new FullOuterJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(126);
						match(FULL_OUTER_JOIN);
						setState(127);
						expr(0);
						setState(128);
						match(T__1);
						setState(129);
						condlist(0);
						setState(130);
						match(T__2);
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AggregatelistContext extends ParserRuleContext {
		public AggregatelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggrlist; }
	 
		public AggregatelistContext() { }
		public void copyFrom(AggregatelistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AggrFromAggrListContext extends AggregatelistContext {
		public AggrfunctionContext aggrfunction() {
			return getRuleContext(AggrfunctionContext.class,0);
		}
		public AggrFromAggrListContext(AggregatelistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrFromAggrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrFromAggrList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrFromAggrList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrListContext extends AggregatelistContext {
		public AggrfunctionContext aggrfunction() {
			return getRuleContext(AggrfunctionContext.class,0);
		}
		public AggregatelistContext aggrlist() {
			return getRuleContext(AggregatelistContext.class,0);
		}
		public AggrListContext(AggregatelistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggregateList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregatelistContext aggrlist() throws RecognitionException {
		AggregatelistContext _localctx = new AggregatelistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aggrlist);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AggrFromAggrListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				aggrfunction();
				}
				break;
			case 2:
				_localctx = new AggrListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				aggrfunction();
				setState(139);
				match(T__3);
				setState(140);
				aggrlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrlistContext extends ParserRuleContext {
		public AttrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrlist; }
	 
		public AttrlistContext() { }
		public void copyFrom(AttrlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeFromAttrlistContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromAttrlistContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeFromAttrlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeFromAttrlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromAttrlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeListContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public AttributeListContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrlistContext attrlist() throws RecognitionException {
		AttrlistContext _localctx = new AttrlistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrlist);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AttributeFromAttrlistContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				attribute();
				setState(146);
				match(T__3);
				setState(147);
				attrlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondlistContext extends ParserRuleContext {
		public CondlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condlist; }
	 
		public CondlistContext() { }
		public void copyFrom(CondlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketsCondlistContext extends CondlistContext {
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public BracketsCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterBracketsCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitBracketsCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotCondlistContext extends CondlistContext {
		public TerminalNode BOOLEAN_NOT() { return getToken(RelationalAlgebraParser.BOOLEAN_NOT, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public NotCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNotCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNotCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNotCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparedCondlistContext extends CondlistContext {
		public List<ComparedContext> compared() {
			return getRuleContexts(ComparedContext.class);
		}
		public ComparedContext compared(int i) {
			return getRuleContext(ComparedContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ComparedCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterComparedCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitComparedCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitComparedCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_AND() { return getToken(RelationalAlgebraParser.BOOLEAN_AND, 0); }
		public AndCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAndCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAndCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAndCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_OR() { return getToken(RelationalAlgebraParser.BOOLEAN_OR, 0); }
		public OrCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterOrCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitOrCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitOrCondlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondlistContext condlist() throws RecognitionException {
		return condlist(0);
	}

	private CondlistContext condlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondlistContext _localctx = new CondlistContext(_ctx, _parentState);
		CondlistContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_condlist, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN_NOT:
				{
				_localctx = new NotCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(152);
				match(BOOLEAN_NOT);
				setState(153);
				condlist(3);
				}
				break;
			case T__1:
				{
				_localctx = new BracketsCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(T__1);
				setState(155);
				condlist(0);
				setState(156);
				match(T__2);
				}
				break;
			case STRING:
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new ComparedCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				compared();
				setState(159);
				comparator();
				setState(160);
				compared();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AndCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(164);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(165);
						match(BOOLEAN_AND);
						setState(166);
						condlist(6);
						}
						break;
					case 2:
						{
						_localctx = new OrCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(167);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(168);
						match(BOOLEAN_OR);
						setState(169);
						condlist(5);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondlistaggrContext extends ParserRuleContext {
		public CondlistaggrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condlistaggr; }
	 
		public CondlistaggrContext() { }
		public void copyFrom(CondlistaggrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndCondlistAggrContext extends CondlistaggrContext {
		public List<CondlistaggrContext> condlistaggr() {
			return getRuleContexts(CondlistaggrContext.class);
		}
		public CondlistaggrContext condlistaggr(int i) {
			return getRuleContext(CondlistaggrContext.class,i);
		}
		public TerminalNode BOOLEAN_AND() { return getToken(RelationalAlgebraParser.BOOLEAN_AND, 0); }
		public AndCondlistAggrContext(CondlistaggrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAndCondlistAggr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAndCondlistAggr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAndCondlistAggr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrCondlistAggrContext extends CondlistaggrContext {
		public List<CondlistaggrContext> condlistaggr() {
			return getRuleContexts(CondlistaggrContext.class);
		}
		public CondlistaggrContext condlistaggr(int i) {
			return getRuleContext(CondlistaggrContext.class,i);
		}
		public TerminalNode BOOLEAN_OR() { return getToken(RelationalAlgebraParser.BOOLEAN_OR, 0); }
		public OrCondlistAggrContext(CondlistaggrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterOrCondlistAggr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitOrCondlistAggr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitOrCondlistAggr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketsCondlistaggrContext extends CondlistaggrContext {
		public CondlistaggrContext condlistaggr() {
			return getRuleContext(CondlistaggrContext.class,0);
		}
		public BracketsCondlistaggrContext(CondlistaggrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterBracketsCondlistaggr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitBracketsCondlistaggr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsCondlistaggr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparedCondlistaggrContext extends CondlistaggrContext {
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public List<ComparedContext> compared() {
			return getRuleContexts(ComparedContext.class);
		}
		public ComparedContext compared(int i) {
			return getRuleContext(ComparedContext.class,i);
		}
		public List<AggrfunctionContext> aggrfunction() {
			return getRuleContexts(AggrfunctionContext.class);
		}
		public AggrfunctionContext aggrfunction(int i) {
			return getRuleContext(AggrfunctionContext.class,i);
		}
		public ComparedCondlistaggrContext(CondlistaggrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterComparedCondlistaggr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitComparedCondlistaggr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitComparedCondlistaggr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondlistaggrContext condlistaggr() throws RecognitionException {
		return condlistaggr(0);
	}

	private CondlistaggrContext condlistaggr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondlistaggrContext _localctx = new CondlistaggrContext(_ctx, _parentState);
		CondlistaggrContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_condlistaggr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new BracketsCondlistaggrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176);
				match(T__1);
				setState(177);
				condlistaggr(0);
				setState(178);
				match(T__2);
				}
				break;
			case SUM:
			case COUNT:
			case MIN:
			case MAX:
			case AVERAGE:
			case STRING:
			case IDENTIFIER:
			case NUMBER:
				{
				_localctx = new ComparedCondlistaggrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case IDENTIFIER:
				case NUMBER:
					{
					setState(180);
					compared();
					}
					break;
				case SUM:
				case COUNT:
				case MIN:
				case MAX:
				case AVERAGE:
					{
					setState(181);
					aggrfunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(184);
				comparator();
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case IDENTIFIER:
				case NUMBER:
					{
					setState(185);
					compared();
					}
					break;
				case SUM:
				case COUNT:
				case MIN:
				case MAX:
				case AVERAGE:
					{
					setState(186);
					aggrfunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new OrCondlistAggrContext(new CondlistaggrContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlistaggr);
						setState(191);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(192);
						match(BOOLEAN_OR);
						setState(193);
						condlistaggr(5);
						}
						break;
					case 2:
						{
						_localctx = new AndCondlistAggrContext(new CondlistaggrContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlistaggr);
						setState(194);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(195);
						match(BOOLEAN_AND);
						setState(196);
						condlistaggr(4);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
	 
		public ComparatorContext() { }
		public void copyFrom(ComparatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualContext extends ComparatorContext {
		public TerminalNode EQUAL() { return getToken(RelationalAlgebraParser.EQUAL, 0); }
		public EqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends ComparatorContext {
		public TerminalNode LESS_THAN() { return getToken(RelationalAlgebraParser.LESS_THAN, 0); }
		public LessThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualContext extends ComparatorContext {
		public TerminalNode NOT_EQUAL() { return getToken(RelationalAlgebraParser.NOT_EQUAL, 0); }
		public NotEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualContext extends ComparatorContext {
		public TerminalNode GREATER_EQUAL() { return getToken(RelationalAlgebraParser.GREATER_EQUAL, 0); }
		public GreaterEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterGreaterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitGreaterEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessEqualContext extends ComparatorContext {
		public TerminalNode LESS_EQUAL() { return getToken(RelationalAlgebraParser.LESS_EQUAL, 0); }
		public LessEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterLessEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitLessEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends ComparatorContext {
		public TerminalNode GREATER_THAN() { return getToken(RelationalAlgebraParser.GREATER_THAN, 0); }
		public GreaterThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparator);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(NOT_EQUAL);
				}
				break;
			case GREATER_THAN:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(GREATER_THAN);
				}
				break;
			case GREATER_EQUAL:
				_localctx = new GreaterEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				match(GREATER_EQUAL);
				}
				break;
			case LESS_THAN:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(206);
				match(LESS_THAN);
				}
				break;
			case LESS_EQUAL:
				_localctx = new LessEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(207);
				match(LESS_EQUAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparedContext extends ParserRuleContext {
		public ComparedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compared; }
	 
		public ComparedContext() { }
		public void copyFrom(ComparedContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringFromComparedContext extends ComparedContext {
		public TerminalNode STRING() { return getToken(RelationalAlgebraParser.STRING, 0); }
		public StringFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterStringFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitStringFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStringFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeFromComparedContext extends ComparedContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberFromComparedContext extends ComparedContext {
		public TerminalNode NUMBER() { return getToken(RelationalAlgebraParser.NUMBER, 0); }
		public NumberFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNumberFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNumberFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNumberFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparedContext compared() throws RecognitionException {
		ComparedContext _localctx = new ComparedContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compared);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new AttributeFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				attribute();
				}
				break;
			case STRING:
				_localctx = new StringFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggrfunctionContext extends ParserRuleContext {
		public AggrfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggrfunction; }
	 
		public AggrfunctionContext() { }
		public void copyFrom(AggrfunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AggrMinContext extends AggrfunctionContext {
		public TerminalNode MIN() { return getToken(RelationalAlgebraParser.MIN, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AggrMinContext(AggrfunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrMin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrMin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrMaxContext extends AggrfunctionContext {
		public TerminalNode MAX() { return getToken(RelationalAlgebraParser.MAX, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AggrMaxContext(AggrfunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrMax(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrMax(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrSumContext extends AggrfunctionContext {
		public TerminalNode SUM() { return getToken(RelationalAlgebraParser.SUM, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AggrSumContext(AggrfunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrCountContext extends AggrfunctionContext {
		public TerminalNode COUNT() { return getToken(RelationalAlgebraParser.COUNT, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AggrCountContext(AggrfunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrCount(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrCount(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggrAvgContext extends AggrfunctionContext {
		public TerminalNode AVERAGE() { return getToken(RelationalAlgebraParser.AVERAGE, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AggrAvgContext(AggrfunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAggrAvg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAggrAvg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAggrAvg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggrfunctionContext aggrfunction() throws RecognitionException {
		AggrfunctionContext _localctx = new AggrfunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_aggrfunction);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUM:
				_localctx = new AggrSumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(SUM);
				setState(216);
				match(T__1);
				setState(217);
				attribute();
				setState(218);
				match(T__2);
				}
				break;
			case COUNT:
				_localctx = new AggrCountContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(COUNT);
				setState(221);
				match(T__1);
				setState(224);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(222);
					attribute();
					}
					break;
				case T__4:
					{
					setState(223);
					match(T__4);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(226);
				match(T__2);
				}
				break;
			case MIN:
				_localctx = new AggrMinContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(MIN);
				setState(228);
				match(T__1);
				setState(229);
				attribute();
				setState(230);
				match(T__2);
				}
				break;
			case MAX:
				_localctx = new AggrMaxContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(MAX);
				setState(233);
				match(T__1);
				setState(234);
				attribute();
				setState(235);
				match(T__2);
				}
				break;
			case AVERAGE:
				_localctx = new AggrAvgContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				match(AVERAGE);
				setState(238);
				match(T__1);
				setState(239);
				attribute();
				setState(240);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationIdentifierContext extends RelationContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public RelationIdentifierContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRelationIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRelationIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relation);
		try {
			_localctx = new RelationIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AttributeIdentifierContext extends AttributeContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public AttributeIdentifierContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attribute);
		try {
			_localctx = new AttributeIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 5:
			return condlist_sempred((CondlistContext)_localctx, predIndex);
		case 6:
			return condlistaggr_sempred((CondlistaggrContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean condlist_sempred(CondlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condlistaggr_sempred(CondlistaggrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00fb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\7\2"+
		"%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\5\4E\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4W\n"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0087\n\4\f\4\16\4"+
		"\u008a\13\4\3\5\3\5\3\5\3\5\3\5\5\5\u0091\n\5\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0098\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a5\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ad\n\7\f\7\16\7\u00b0\13\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00b9\n\b\3\b\3\b\3\b\5\b\u00be\n\b\5\b\u00c0\n\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c8\n\b\f\b\16\b\u00cb\13\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u00d3\n\t\3\n\3\n\3\n\5\n\u00d8\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00e3\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f5\n\13\3\f"+
		"\3\f\3\r\3\r\3\r\2\5\6\f\16\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u0117"+
		"\2\37\3\2\2\2\4+\3\2\2\2\6V\3\2\2\2\b\u0090\3\2\2\2\n\u0097\3\2\2\2\f"+
		"\u00a4\3\2\2\2\16\u00bf\3\2\2\2\20\u00d2\3\2\2\2\22\u00d7\3\2\2\2\24\u00f4"+
		"\3\2\2\2\26\u00f6\3\2\2\2\30\u00f8\3\2\2\2\32\33\5\4\3\2\33\34\7\3\2\2"+
		"\34\36\3\2\2\2\35\32\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \""+
		"\3\2\2\2!\37\3\2\2\2\"&\5\6\4\2#%\7\3\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2"+
		"\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\2\2\3*\3\3\2\2\2+,\7&\2\2,-\7\34"+
		"\2\2-.\5\6\4\2.\5\3\2\2\2/\60\b\4\1\2\60W\5\26\f\2\61\62\7\4\2\2\62\63"+
		"\5\6\4\2\63\64\7\5\2\2\64W\3\2\2\2\65\66\7\b\2\2\66\67\7\4\2\2\678\5\n"+
		"\6\289\7\5\2\29:\7\4\2\2:;\5\6\4\2;D\7\5\2\2<=\7\21\2\2=>\7\4\2\2>?\5"+
		"\n\6\2?B\7\5\2\2@A\7\22\2\2AC\5\16\b\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2D"+
		"<\3\2\2\2DE\3\2\2\2EW\3\2\2\2FG\7\t\2\2GH\7\4\2\2HI\5\f\7\2IJ\7\5\2\2"+
		"JK\7\4\2\2KL\5\6\4\2LM\7\5\2\2MW\3\2\2\2NO\7\n\2\2OP\7\4\2\2PQ\5\n\6\2"+
		"QR\7\5\2\2RS\7\4\2\2ST\5\6\4\2TU\7\5\2\2UW\3\2\2\2V/\3\2\2\2V\61\3\2\2"+
		"\2V\65\3\2\2\2VF\3\2\2\2VN\3\2\2\2W\u0088\3\2\2\2XY\f\f\2\2YZ\7\13\2\2"+
		"Z\u0087\5\6\4\r[\\\f\13\2\2\\]\7\r\2\2]\u0087\5\6\4\f^_\f\n\2\2_`\7\f"+
		"\2\2`\u0087\5\6\4\13ab\f\t\2\2bc\7\17\2\2c\u0087\5\6\4\nde\f\b\2\2ef\7"+
		"\16\2\2f\u0087\5\6\4\tgh\f\3\2\2hi\7\26\2\2i\u0087\5\6\4\4jk\f\7\2\2k"+
		"l\7\20\2\2lm\5\6\4\2mn\7\4\2\2no\5\f\7\2op\7\5\2\2p\u0087\3\2\2\2qr\f"+
		"\6\2\2rs\7\23\2\2st\5\6\4\2tu\7\4\2\2uv\5\f\7\2vw\7\5\2\2w\u0087\3\2\2"+
		"\2xy\f\5\2\2yz\7\24\2\2z{\5\6\4\2{|\7\4\2\2|}\5\f\7\2}~\7\5\2\2~\u0087"+
		"\3\2\2\2\177\u0080\f\4\2\2\u0080\u0081\7\25\2\2\u0081\u0082\5\6\4\2\u0082"+
		"\u0083\7\4\2\2\u0083\u0084\5\f\7\2\u0084\u0085\7\5\2\2\u0085\u0087\3\2"+
		"\2\2\u0086X\3\2\2\2\u0086[\3\2\2\2\u0086^\3\2\2\2\u0086a\3\2\2\2\u0086"+
		"d\3\2\2\2\u0086g\3\2\2\2\u0086j\3\2\2\2\u0086q\3\2\2\2\u0086x\3\2\2\2"+
		"\u0086\177\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\7\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0091\5\24\13\2\u008c"+
		"\u008d\5\24\13\2\u008d\u008e\7\6\2\2\u008e\u008f\5\b\5\2\u008f\u0091\3"+
		"\2\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0091\t\3\2\2\2\u0092\u0098"+
		"\5\30\r\2\u0093\u0094\5\30\r\2\u0094\u0095\7\6\2\2\u0095\u0096\5\n\6\2"+
		"\u0096\u0098\3\2\2\2\u0097\u0092\3\2\2\2\u0097\u0093\3\2\2\2\u0098\13"+
		"\3\2\2\2\u0099\u009a\b\7\1\2\u009a\u009b\7$\2\2\u009b\u00a5\5\f\7\5\u009c"+
		"\u009d\7\4\2\2\u009d\u009e\5\f\7\2\u009e\u009f\7\5\2\2\u009f\u00a5\3\2"+
		"\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\5\22\n\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u0099\3\2\2\2\u00a4\u009c\3\2\2\2\u00a4\u00a0\3\2"+
		"\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a7\f\7\2\2\u00a7\u00a8\7\"\2\2\u00a8"+
		"\u00ad\5\f\7\b\u00a9\u00aa\f\6\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ad\5\f"+
		"\7\7\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\r\3\2\2\2\u00b0\u00ae\3\2\2\2"+
		"\u00b1\u00b2\b\b\1\2\u00b2\u00b3\7\4\2\2\u00b3\u00b4\5\16\b\2\u00b4\u00b5"+
		"\7\5\2\2\u00b5\u00c0\3\2\2\2\u00b6\u00b9\5\22\n\2\u00b7\u00b9\5\24\13"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd"+
		"\5\20\t\2\u00bb\u00be\5\22\n\2\u00bc\u00be\5\24\13\2\u00bd\u00bb\3\2\2"+
		"\2\u00bd\u00bc\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00b1\3\2\2\2\u00bf\u00b8"+
		"\3\2\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\f\6\2\2\u00c2\u00c3\7#\2\2\u00c3"+
		"\u00c8\5\16\b\7\u00c4\u00c5\f\5\2\2\u00c5\u00c6\7\"\2\2\u00c6\u00c8\5"+
		"\16\b\6\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\17\3\2\2\2\u00cb\u00c9\3\2\2"+
		"\2\u00cc\u00d3\7\34\2\2\u00cd\u00d3\7\35\2\2\u00ce\u00d3\7\36\2\2\u00cf"+
		"\u00d3\7\37\2\2\u00d0\u00d3\7 \2\2\u00d1\u00d3\7!\2\2\u00d2\u00cc\3\2"+
		"\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\21\3\2\2\2\u00d4\u00d8\5\30\r"+
		"\2\u00d5\u00d8\7%\2\2\u00d6\u00d8\7\'\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\23\3\2\2\2\u00d9\u00da\7\27\2\2\u00da"+
		"\u00db\7\4\2\2\u00db\u00dc\5\30\r\2\u00dc\u00dd\7\5\2\2\u00dd\u00f5\3"+
		"\2\2\2\u00de\u00df\7\30\2\2\u00df\u00e2\7\4\2\2\u00e0\u00e3\5\30\r\2\u00e1"+
		"\u00e3\7\7\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00f5\7\5\2\2\u00e5\u00e6\7\31\2\2\u00e6\u00e7\7\4\2\2\u00e7"+
		"\u00e8\5\30\r\2\u00e8\u00e9\7\5\2\2\u00e9\u00f5\3\2\2\2\u00ea\u00eb\7"+
		"\32\2\2\u00eb\u00ec\7\4\2\2\u00ec\u00ed\5\30\r\2\u00ed\u00ee\7\5\2\2\u00ee"+
		"\u00f5\3\2\2\2\u00ef\u00f0\7\33\2\2\u00f0\u00f1\7\4\2\2\u00f1\u00f2\5"+
		"\30\r\2\u00f2\u00f3\7\5\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00d9\3\2\2\2\u00f4"+
		"\u00de\3\2\2\2\u00f4\u00e5\3\2\2\2\u00f4\u00ea\3\2\2\2\u00f4\u00ef\3\2"+
		"\2\2\u00f5\25\3\2\2\2\u00f6\u00f7\7&\2\2\u00f7\27\3\2\2\2\u00f8\u00f9"+
		"\7&\2\2\u00f9\31\3\2\2\2\27\37&BDV\u0086\u0088\u0090\u0097\u00a4\u00ac"+
		"\u00ae\u00b8\u00bd\u00bf\u00c7\u00c9\u00d2\u00d7\u00e2\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}