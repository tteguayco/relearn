package es.ull.relearn.analysis.relalg;

// Generated from RelationalAlgebra.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationalAlgebraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROJECTION=1, SELECTION=2, RENAME=3, UNION=4, DIFFERENCE=5, CARTESIAN_PRODUCT=6, 
		INTERSECTION=7, NATURAL_JOIN=8, JOIN=9, GROUP_BY=10, HAVING=11, LEFT_OUTER_JOIN=12, 
		RIGHT_OUTER_JOIN=13, FULL_OUTER_JOIN=14, DIVISION=15, SUM=16, COUNT=17, 
		MIN=18, MAX=19, AVERAGE=20, EQUAL=21, NOT_EQUAL=22, GREATER_THAN=23, GREATER_EQUAL=24, 
		LESS_THAN=25, LESS_EQUAL=26, BOOLEAN_AND=27, BOOLEAN_OR=28, BOOLEAN_NOT=29, 
		STRING=30, IDENTIFIER=31, NUMBER=32, WHITESPACES=33, NULL_VAL=34, SEMICOLON=35, 
		COMMA=36, LEFT_BRACKET=37, RIGHT_BRACKET=38, LEFT_SQUARE_BRACKET=39, RIGHT_SQUARE_BRACKET=40, 
		ASTERISK=41, MULTILINE_COMMENT=42, LINE_COMMENT=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PROJECTION", "SELECTION", "RENAME", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", 
		"INTERSECTION", "NATURAL_JOIN", "JOIN", "GROUP_BY", "HAVING", "LEFT_OUTER_JOIN", 
		"RIGHT_OUTER_JOIN", "FULL_OUTER_JOIN", "DIVISION", "SUM", "COUNT", "MIN", 
		"MAX", "AVERAGE", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", 
		"LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", 
		"STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "NULL_VAL", "SEMICOLON", 
		"COMMA", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", 
		"ASTERISK", "MULTILINE_COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'='", null, "'>'", 
		"'>='", "'<'", "'<='", null, null, null, null, null, null, null, null, 
		"';'", "','", "'('", "')'", "'['", "']'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROJECTION", "SELECTION", "RENAME", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", 
		"INTERSECTION", "NATURAL_JOIN", "JOIN", "GROUP_BY", "HAVING", "LEFT_OUTER_JOIN", 
		"RIGHT_OUTER_JOIN", "FULL_OUTER_JOIN", "DIVISION", "SUM", "COUNT", "MIN", 
		"MAX", "AVERAGE", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", 
		"LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", 
		"STRING", "IDENTIFIER", "NUMBER", "WHITESPACES", "NULL_VAL", "SEMICOLON", 
		"COMMA", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_SQUARE_BRACKET", "RIGHT_SQUARE_BRACKET", 
		"ASTERISK", "MULTILINE_COMMENT", "LINE_COMMENT"
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


	public RelationalAlgebraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0248\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2h\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3v\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0084\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0091\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6\u009e\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b5\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00cc\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e7\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00f2\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0104\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0112\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0132\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0154\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u0174\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0187\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u018f\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u019b\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u01a3\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u01ab\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\5\25\u01b3\n\25\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\5\27\u01bb\n\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u01cd\n\34\3\35\3\35\3\35\3\35\5\35\u01d3"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01db\n\36\3\37\3\37\7\37\u01df"+
		"\n\37\f\37\16\37\u01e2\13\37\3\37\3\37\3\37\7\37\u01e7\n\37\f\37\16\37"+
		"\u01ea\13\37\3\37\5\37\u01ed\n\37\3 \6 \u01f0\n \r \16 \u01f1\3 \7 \u01f5"+
		"\n \f \16 \u01f8\13 \3 \3 \6 \u01fc\n \r \16 \u01fd\3 \7 \u0201\n \f "+
		"\16 \u0204\13 \6 \u0206\n \r \16 \u0207\5 \u020a\n \3!\6!\u020d\n!\r!"+
		"\16!\u020e\3\"\6\"\u0212\n\"\r\"\16\"\u0213\3\"\3\"\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\5#\u0220\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		"+\3+\7+\u0234\n+\f+\16+\u0237\13+\3+\3+\3+\3+\3+\3,\3,\3,\3,\7,\u0242"+
		"\n,\f,\16,\u0245\13,\3,\3,\5\u01e0\u01e8\u0235\2-\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-\3\2\b\4\2ZZzz\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u0274\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3g\3\2\2\2\5u\3\2\2\2\7\u0083"+
		"\3\2\2\2\t\u0090\3\2\2\2\13\u009d\3\2\2\2\r\u00b4\3\2\2\2\17\u00cb\3\2"+
		"\2\2\21\u00e6\3\2\2\2\23\u00f1\3\2\2\2\25\u0103\3\2\2\2\27\u0111\3\2\2"+
		"\2\31\u0131\3\2\2\2\33\u0153\3\2\2\2\35\u0173\3\2\2\2\37\u0186\3\2\2\2"+
		"!\u018e\3\2\2\2#\u019a\3\2\2\2%\u01a2\3\2\2\2\'\u01aa\3\2\2\2)\u01b2\3"+
		"\2\2\2+\u01b4\3\2\2\2-\u01ba\3\2\2\2/\u01bc\3\2\2\2\61\u01be\3\2\2\2\63"+
		"\u01c1\3\2\2\2\65\u01c3\3\2\2\2\67\u01cc\3\2\2\29\u01d2\3\2\2\2;\u01da"+
		"\3\2\2\2=\u01ec\3\2\2\2?\u01ef\3\2\2\2A\u020c\3\2\2\2C\u0211\3\2\2\2E"+
		"\u021f\3\2\2\2G\u0221\3\2\2\2I\u0223\3\2\2\2K\u0225\3\2\2\2M\u0227\3\2"+
		"\2\2O\u0229\3\2\2\2Q\u022b\3\2\2\2S\u022d\3\2\2\2U\u022f\3\2\2\2W\u023d"+
		"\3\2\2\2YZ\7R\2\2Z[\7T\2\2[\\\7Q\2\2\\]\7L\2\2]^\7G\2\2^_\7E\2\2_h\7V"+
		"\2\2`a\7r\2\2ab\7t\2\2bc\7q\2\2cd\7l\2\2de\7g\2\2ef\7e\2\2fh\7v\2\2gY"+
		"\3\2\2\2g`\3\2\2\2h\4\3\2\2\2ij\7U\2\2jk\7G\2\2kl\7N\2\2lm\7G\2\2mn\7"+
		"E\2\2nv\7V\2\2op\7u\2\2pq\7g\2\2qr\7n\2\2rs\7g\2\2st\7e\2\2tv\7v\2\2u"+
		"i\3\2\2\2uo\3\2\2\2v\6\3\2\2\2wx\7T\2\2xy\7G\2\2yz\7P\2\2z{\7C\2\2{|\7"+
		"O\2\2|\u0084\7G\2\2}~\7t\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0081"+
		"\7c\2\2\u0081\u0082\7o\2\2\u0082\u0084\7g\2\2\u0083w\3\2\2\2\u0083}\3"+
		"\2\2\2\u0084\b\3\2\2\2\u0085\u0086\7W\2\2\u0086\u0087\7P\2\2\u0087\u0088"+
		"\7K\2\2\u0088\u0089\7Q\2\2\u0089\u0091\7P\2\2\u008a\u008b\7w\2\2\u008b"+
		"\u008c\7p\2\2\u008c\u008d\7k\2\2\u008d\u008e\7q\2\2\u008e\u0091\7p\2\2"+
		"\u008f\u0091\7W\2\2\u0090\u0085\3\2\2\2\u0090\u008a\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\n\3\2\2\2\u0092\u0093\7O\2\2\u0093\u0094\7K\2\2\u0094\u0095"+
		"\7P\2\2\u0095\u0096\7W\2\2\u0096\u009e\7U\2\2\u0097\u0098\7o\2\2\u0098"+
		"\u0099\7k\2\2\u0099\u009a\7p\2\2\u009a\u009b\7w\2\2\u009b\u009e\7u\2\2"+
		"\u009c\u009e\7/\2\2\u009d\u0092\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u009c"+
		"\3\2\2\2\u009e\f\3\2\2\2\u009f\u00a0\7E\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2"+
		"\7Q\2\2\u00a2\u00a3\7U\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7\"\2\2\u00a5"+
		"\u00a6\7L\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8\7K\2\2\u00a8\u00b5\7P\2\2"+
		"\u00a9\u00aa\7e\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad"+
		"\7u\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7\"\2\2\u00af\u00b0\7l\2\2\u00b0"+
		"\u00b1\7q\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b5\7p\2\2\u00b3\u00b5\t\2\2"+
		"\2\u00b4\u009f\3\2\2\2\u00b4\u00a9\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\16"+
		"\3\2\2\2\u00b6\u00b7\7K\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9\7V\2\2\u00b9"+
		"\u00ba\7G\2\2\u00ba\u00bb\7T\2\2\u00bb\u00bc\7U\2\2\u00bc\u00bd\7G\2\2"+
		"\u00bd\u00be\7E\2\2\u00be\u00cc\7V\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7t\2\2\u00c4"+
		"\u00c5\7u\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7e\2\2\u00c7\u00cc\7v\2\2"+
		"\u00c8\u00c9\7\u00e4\2\2\u00c9\u00ca\7\u02c8\2\2\u00ca\u00cc\7\u00ab\2"+
		"\2\u00cb\u00b6\3\2\2\2\u00cb\u00bf\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cc\20"+
		"\3\2\2\2\u00cd\u00ce\7P\2\2\u00ce\u00cf\7C\2\2\u00cf\u00d0\7V\2\2\u00d0"+
		"\u00d1\7W\2\2\u00d1\u00d2\7T\2\2\u00d2\u00d3\7C\2\2\u00d3\u00d4\7N\2\2"+
		"\u00d4\u00d5\7\"\2\2\u00d5\u00d6\7L\2\2\u00d6\u00d7\7Q\2\2\u00d7\u00d8"+
		"\7K\2\2\u00d8\u00e7\7P\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7c\2\2\u00db"+
		"\u00dc\7v\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7c\2\2"+
		"\u00df\u00e0\7n\2\2\u00e0\u00e1\7\"\2\2\u00e1\u00e2\7l\2\2\u00e2\u00e3"+
		"\7q\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e7\7p\2\2\u00e5\u00e7\5S*\2\u00e6"+
		"\u00cd\3\2\2\2\u00e6\u00d9\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\22\3\2\2"+
		"\2\u00e8\u00e9\7L\2\2\u00e9\u00ea\7Q\2\2\u00ea\u00eb\7K\2\2\u00eb\u00f2"+
		"\7P\2\2\u00ec\u00ed\7l\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7k\2\2\u00ef"+
		"\u00f2\7p\2\2\u00f0\u00f2\7[\2\2\u00f1\u00e8\3\2\2\2\u00f1\u00ec\3\2\2"+
		"\2\u00f1\u00f0\3\2\2\2\u00f2\24\3\2\2\2\u00f3\u00f4\7I\2\2\u00f4\u00f5"+
		"\7T\2\2\u00f5\u00f6\7Q\2\2\u00f6\u00f7\7W\2\2\u00f7\u00f8\7R\2\2\u00f8"+
		"\u00f9\7\"\2\2\u00f9\u00fa\7D\2\2\u00fa\u0104\7[\2\2\u00fb\u00fc\7i\2"+
		"\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100"+
		"\7r\2\2\u0100\u0101\7\"\2\2\u0101\u0102\7d\2\2\u0102\u0104\7{\2\2\u0103"+
		"\u00f3\3\2\2\2\u0103\u00fb\3\2\2\2\u0104\26\3\2\2\2\u0105\u0106\7J\2\2"+
		"\u0106\u0107\7C\2\2\u0107\u0108\7X\2\2\u0108\u0109\7K\2\2\u0109\u010a"+
		"\7P\2\2\u010a\u0112\7I\2\2\u010b\u010c\7j\2\2\u010c\u010d\7c\2\2\u010d"+
		"\u010e\7x\2\2\u010e\u010f\7k\2\2\u010f\u0110\7p\2\2\u0110\u0112\7i\2\2"+
		"\u0111\u0105\3\2\2\2\u0111\u010b\3\2\2\2\u0112\30\3\2\2\2\u0113\u0114"+
		"\7N\2\2\u0114\u0115\7G\2\2\u0115\u0116\7H\2\2\u0116\u0117\7V\2\2\u0117"+
		"\u0118\7\"\2\2\u0118\u0119\7Q\2\2\u0119\u011a\7W\2\2\u011a\u011b\7V\2"+
		"\2\u011b\u011c\7G\2\2\u011c\u011d\7T\2\2\u011d\u011e\7\"\2\2\u011e\u011f"+
		"\7L\2\2\u011f\u0120\7Q\2\2\u0120\u0121\7K\2\2\u0121\u0132\7P\2\2\u0122"+
		"\u0123\7n\2\2\u0123\u0124\7g\2\2\u0124\u0125\7h\2\2\u0125\u0126\7v\2\2"+
		"\u0126\u0127\7\"\2\2\u0127\u0128\7q\2\2\u0128\u0129\7w\2\2\u0129\u012a"+
		"\7v\2\2\u012a\u012b\7g\2\2\u012b\u012c\7t\2\2\u012c\u012d\7\"\2\2\u012d"+
		"\u012e\7l\2\2\u012e\u012f\7q\2\2\u012f\u0130\7k\2\2\u0130\u0132\7p\2\2"+
		"\u0131\u0113\3\2\2\2\u0131\u0122\3\2\2\2\u0132\32\3\2\2\2\u0133\u0134"+
		"\7T\2\2\u0134\u0135\7K\2\2\u0135\u0136\7I\2\2\u0136\u0137\7J\2\2\u0137"+
		"\u0138\7V\2\2\u0138\u0139\7\"\2\2\u0139\u013a\7Q\2\2\u013a\u013b\7W\2"+
		"\2\u013b\u013c\7V\2\2\u013c\u013d\7G\2\2\u013d\u013e\7T\2\2\u013e\u013f"+
		"\7\"\2\2\u013f\u0140\7L\2\2\u0140\u0141\7Q\2\2\u0141\u0142\7K\2\2\u0142"+
		"\u0154\7P\2\2\u0143\u0144\7t\2\2\u0144\u0145\7k\2\2\u0145\u0146\7i\2\2"+
		"\u0146\u0147\7j\2\2\u0147\u0148\7v\2\2\u0148\u0149\7\"\2\2\u0149\u014a"+
		"\7q\2\2\u014a\u014b\7w\2\2\u014b\u014c\7v\2\2\u014c\u014d\7g\2\2\u014d"+
		"\u014e\7t\2\2\u014e\u014f\7\"\2\2\u014f\u0150\7l\2\2\u0150\u0151\7q\2"+
		"\2\u0151\u0152\7k\2\2\u0152\u0154\7p\2\2\u0153\u0133\3\2\2\2\u0153\u0143"+
		"\3\2\2\2\u0154\34\3\2\2\2\u0155\u0156\7H\2\2\u0156\u0157\7W\2\2\u0157"+
		"\u0158\7N\2\2\u0158\u0159\7N\2\2\u0159\u015a\7\"\2\2\u015a\u015b\7Q\2"+
		"\2\u015b\u015c\7W\2\2\u015c\u015d\7V\2\2\u015d\u015e\7G\2\2\u015e\u015f"+
		"\7T\2\2\u015f\u0160\7\"\2\2\u0160\u0161\7L\2\2\u0161\u0162\7Q\2\2\u0162"+
		"\u0163\7K\2\2\u0163\u0174\7P\2\2\u0164\u0165\7h\2\2\u0165\u0166\7w\2\2"+
		"\u0166\u0167\7n\2\2\u0167\u0168\7n\2\2\u0168\u0169\7\"\2\2\u0169\u016a"+
		"\7q\2\2\u016a\u016b\7w\2\2\u016b\u016c\7v\2\2\u016c\u016d\7g\2\2\u016d"+
		"\u016e\7t\2\2\u016e\u016f\7\"\2\2\u016f\u0170\7l\2\2\u0170\u0171\7q\2"+
		"\2\u0171\u0172\7k\2\2\u0172\u0174\7p\2\2\u0173\u0155\3\2\2\2\u0173\u0164"+
		"\3\2\2\2\u0174\36\3\2\2\2\u0175\u0176\7F\2\2\u0176\u0177\7K\2\2\u0177"+
		"\u0178\7X\2\2\u0178\u0179\7K\2\2\u0179\u017a\7U\2\2\u017a\u017b\7K\2\2"+
		"\u017b\u017c\7Q\2\2\u017c\u0187\7P\2\2\u017d\u017e\7f\2\2\u017e\u017f"+
		"\7k\2\2\u017f\u0180\7x\2\2\u0180\u0181\7k\2\2\u0181\u0182\7u\2\2\u0182"+
		"\u0183\7k\2\2\u0183\u0184\7q\2\2\u0184\u0187\7p\2\2\u0185\u0187\7\61\2"+
		"\2\u0186\u0175\3\2\2\2\u0186\u017d\3\2\2\2\u0186\u0185\3\2\2\2\u0187 "+
		"\3\2\2\2\u0188\u0189\7U\2\2\u0189\u018a\7W\2\2\u018a\u018f\7O\2\2\u018b"+
		"\u018c\7u\2\2\u018c\u018d\7w\2\2\u018d\u018f\7o\2\2\u018e\u0188\3\2\2"+
		"\2\u018e\u018b\3\2\2\2\u018f\"\3\2\2\2\u0190\u0191\7E\2\2\u0191\u0192"+
		"\7Q\2\2\u0192\u0193\7W\2\2\u0193\u0194\7P\2\2\u0194\u019b\7V\2\2\u0195"+
		"\u0196\7e\2\2\u0196\u0197\7q\2\2\u0197\u0198\7w\2\2\u0198\u0199\7p\2\2"+
		"\u0199\u019b\7v\2\2\u019a\u0190\3\2\2\2\u019a\u0195\3\2\2\2\u019b$\3\2"+
		"\2\2\u019c\u019d\7O\2\2\u019d\u019e\7K\2\2\u019e\u01a3\7P\2\2\u019f\u01a0"+
		"\7o\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a3\7p\2\2\u01a2\u019c\3\2\2\2\u01a2"+
		"\u019f\3\2\2\2\u01a3&\3\2\2\2\u01a4\u01a5\7O\2\2\u01a5\u01a6\7C\2\2\u01a6"+
		"\u01ab\7Z\2\2\u01a7\u01a8\7o\2\2\u01a8\u01a9\7c\2\2\u01a9\u01ab\7z\2\2"+
		"\u01aa\u01a4\3\2\2\2\u01aa\u01a7\3\2\2\2\u01ab(\3\2\2\2\u01ac\u01ad\7"+
		"C\2\2\u01ad\u01ae\7X\2\2\u01ae\u01b3\7I\2\2\u01af\u01b0\7c\2\2\u01b0\u01b1"+
		"\7x\2\2\u01b1\u01b3\7i\2\2\u01b2\u01ac\3\2\2\2\u01b2\u01af\3\2\2\2\u01b3"+
		"*\3\2\2\2\u01b4\u01b5\7?\2\2\u01b5,\3\2\2\2\u01b6\u01b7\7#\2\2\u01b7\u01bb"+
		"\7?\2\2\u01b8\u01b9\7>\2\2\u01b9\u01bb\7@\2\2\u01ba\u01b6\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01bb.\3\2\2\2\u01bc\u01bd\7@\2\2\u01bd\60\3\2\2\2\u01be"+
		"\u01bf\7@\2\2\u01bf\u01c0\7?\2\2\u01c0\62\3\2\2\2\u01c1\u01c2\7>\2\2\u01c2"+
		"\64\3\2\2\2\u01c3\u01c4\7>\2\2\u01c4\u01c5\7?\2\2\u01c5\66\3\2\2\2\u01c6"+
		"\u01c7\7C\2\2\u01c7\u01c8\7P\2\2\u01c8\u01cd\7F\2\2\u01c9\u01ca\7c\2\2"+
		"\u01ca\u01cb\7p\2\2\u01cb\u01cd\7f\2\2\u01cc\u01c6\3\2\2\2\u01cc\u01c9"+
		"\3\2\2\2\u01cd8\3\2\2\2\u01ce\u01cf\7Q\2\2\u01cf\u01d3\7T\2\2\u01d0\u01d1"+
		"\7q\2\2\u01d1\u01d3\7t\2\2\u01d2\u01ce\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		":\3\2\2\2\u01d4\u01d5\7P\2\2\u01d5\u01d6\7Q\2\2\u01d6\u01db\7V\2\2\u01d7"+
		"\u01d8\7p\2\2\u01d8\u01d9\7q\2\2\u01d9\u01db\7v\2\2\u01da\u01d4\3\2\2"+
		"\2\u01da\u01d7\3\2\2\2\u01db<\3\2\2\2\u01dc\u01e0\7$\2\2\u01dd\u01df\13"+
		"\2\2\2\u01de\u01dd\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01ed\7$"+
		"\2\2\u01e4\u01e8\7)\2\2\u01e5\u01e7\13\2\2\2\u01e6\u01e5\3\2\2\2\u01e7"+
		"\u01ea\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01eb\3\2"+
		"\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ed\7)\2\2\u01ec\u01dc\3\2\2\2\u01ec"+
		"\u01e4\3\2\2\2\u01ed>\3\2\2\2\u01ee\u01f0\t\3\2\2\u01ef\u01ee\3\2\2\2"+
		"\u01f0\u01f1\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f6"+
		"\3\2\2\2\u01f3\u01f5\t\4\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u0209\3\2\2\2\u01f8\u01f6\3\2"+
		"\2\2\u01f9\u0205\7\60\2\2\u01fa\u01fc\t\3\2\2\u01fb\u01fa\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0202\3\2"+
		"\2\2\u01ff\u0201\t\4\2\2\u0200\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0205\u01fb\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0205\3\2\2\2\u0207"+
		"\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u01f9\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a@\3\2\2\2\u020b\u020d\t\5\2\2\u020c\u020b\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020fB\3\2\2\2\u0210"+
		"\u0212\t\6\2\2\u0211\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3\2"+
		"\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\b\"\2\2\u0216"+
		"D\3\2\2\2\u0217\u0218\7P\2\2\u0218\u0219\7W\2\2\u0219\u021a\7N\2\2\u021a"+
		"\u0220\7N\2\2\u021b\u021c\7p\2\2\u021c\u021d\7w\2\2\u021d\u021e\7n\2\2"+
		"\u021e\u0220\7n\2\2\u021f\u0217\3\2\2\2\u021f\u021b\3\2\2\2\u0220F\3\2"+
		"\2\2\u0221\u0222\7=\2\2\u0222H\3\2\2\2\u0223\u0224\7.\2\2\u0224J\3\2\2"+
		"\2\u0225\u0226\7*\2\2\u0226L\3\2\2\2\u0227\u0228\7+\2\2\u0228N\3\2\2\2"+
		"\u0229\u022a\7]\2\2\u022aP\3\2\2\2\u022b\u022c\7_\2\2\u022cR\3\2\2\2\u022d"+
		"\u022e\7,\2\2\u022eT\3\2\2\2\u022f\u0230\7\61\2\2\u0230\u0231\7,\2\2\u0231"+
		"\u0235\3\2\2\2\u0232\u0234\13\2\2\2\u0233\u0232\3\2\2\2\u0234\u0237\3"+
		"\2\2\2\u0235\u0236\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0238\3\2\2\2\u0237"+
		"\u0235\3\2\2\2\u0238\u0239\7,\2\2\u0239\u023a\7\61\2\2\u023a\u023b\3\2"+
		"\2\2\u023b\u023c\b+\3\2\u023cV\3\2\2\2\u023d\u023e\7\61\2\2\u023e\u023f"+
		"\7\61\2\2\u023f\u0243\3\2\2\2\u0240\u0242\n\7\2\2\u0241\u0240\3\2\2\2"+
		"\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0246"+
		"\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0247\b,\3\2\u0247X\3\2\2\2+\2gu\u0083"+
		"\u0090\u009d\u00b4\u00cb\u00e6\u00f1\u0103\u0111\u0131\u0153\u0173\u0186"+
		"\u018e\u019a\u01a2\u01aa\u01b2\u01ba\u01cc\u01d2\u01da\u01e0\u01e8\u01ec"+
		"\u01f1\u01f4\u01f6\u01fd\u0200\u0202\u0207\u0209\u020e\u0213\u021f\u0235"+
		"\u0243\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}