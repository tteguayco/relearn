package es.ull.relearn.analysis.dbschema;

// Generated from Database.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DatabaseLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, DATABASE=7, TABLE=8, STRING=9, 
		CHAR=10, INT=11, FLOAT=12, DATE=13, STRING_VAL=14, NUMBER=15, ID=16, WHITESPACES=17, 
		COMMENT=18, LINE_COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES", 
		"COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'=>'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "DATABASE", "TABLE", "STRING", 
		"CHAR", "INT", "FLOAT", "DATE", "STRING_VAL", "NUMBER", "ID", "WHITESPACES", 
		"COMMENT", "LINE_COMMENT"
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


	public DatabaseLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Database.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0119\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009d\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ba\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00cb\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d9\n\16\3\17\3\17\7\17\u00dd"+
		"\n\17\f\17\16\17\u00e0\13\17\3\17\3\17\3\20\6\20\u00e5\n\20\r\20\16\20"+
		"\u00e6\3\20\7\20\u00ea\n\20\f\20\16\20\u00ed\13\20\3\21\6\21\u00f0\n\21"+
		"\r\21\16\21\u00f1\3\21\7\21\u00f5\n\21\f\21\16\21\u00f8\13\21\3\22\6\22"+
		"\u00fb\n\22\r\22\16\22\u00fc\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0105"+
		"\n\23\f\23\16\23\u0108\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\7\24\u0113\n\24\f\24\16\24\u0116\13\24\3\24\3\24\3\u0106\2\25\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25\3\2\b\7\2,-/;B\\aac|\3\2\62;\4\2\60\60\62;\4\2C\\c|"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0133\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2"+
		"\2\17N\3\2\2\2\21_\3\2\2\2\23s\3\2\2\2\25\u009c\3\2\2\2\27\u00b9\3\2\2"+
		"\2\31\u00ca\3\2\2\2\33\u00d8\3\2\2\2\35\u00da\3\2\2\2\37\u00e4\3\2\2\2"+
		"!\u00ef\3\2\2\2#\u00fa\3\2\2\2%\u0100\3\2\2\2\'\u010e\3\2\2\2)*\7=\2\2"+
		"*\4\3\2\2\2+,\7*\2\2,\6\3\2\2\2-.\7+\2\2.\b\3\2\2\2/\60\7?\2\2\60\61\7"+
		"@\2\2\61\n\3\2\2\2\62\63\7.\2\2\63\f\3\2\2\2\64\65\7<\2\2\65\16\3\2\2"+
		"\2\66\67\7F\2\2\678\7C\2\289\7V\2\29:\7C\2\2:;\7D\2\2;<\7C\2\2<=\7U\2"+
		"\2=O\7G\2\2>?\7F\2\2?@\7c\2\2@A\7v\2\2AB\7c\2\2BC\7d\2\2CD\7c\2\2DE\7"+
		"u\2\2EO\7g\2\2FG\7f\2\2GH\7c\2\2HI\7v\2\2IJ\7c\2\2JK\7d\2\2KL\7c\2\2L"+
		"M\7u\2\2MO\7g\2\2N\66\3\2\2\2N>\3\2\2\2NF\3\2\2\2O\20\3\2\2\2PQ\7V\2\2"+
		"QR\7C\2\2RS\7D\2\2ST\7N\2\2T`\7G\2\2UV\7V\2\2VW\7c\2\2WX\7d\2\2XY\7n\2"+
		"\2Y`\7g\2\2Z[\7v\2\2[\\\7c\2\2\\]\7d\2\2]^\7n\2\2^`\7g\2\2_P\3\2\2\2_"+
		"U\3\2\2\2_Z\3\2\2\2`\22\3\2\2\2ab\7U\2\2bc\7V\2\2cd\7T\2\2de\7K\2\2ef"+
		"\7P\2\2ft\7I\2\2gh\7U\2\2hi\7v\2\2ij\7t\2\2jk\7k\2\2kl\7p\2\2lt\7i\2\2"+
		"mn\7u\2\2no\7v\2\2op\7t\2\2pq\7k\2\2qr\7p\2\2rt\7i\2\2sa\3\2\2\2sg\3\2"+
		"\2\2sm\3\2\2\2t\24\3\2\2\2uv\7E\2\2vw\7J\2\2wx\7C\2\2x\u009d\7T\2\2yz"+
		"\7E\2\2z{\7j\2\2{|\7c\2\2|\u009d\7t\2\2}~\7e\2\2~\177\7j\2\2\177\u0080"+
		"\7c\2\2\u0080\u009d\7t\2\2\u0081\u0082\7E\2\2\u0082\u0083\7j\2\2\u0083"+
		"\u0084\7c\2\2\u0084\u0085\7t\2\2\u0085\u0086\7c\2\2\u0086\u0087\7e\2\2"+
		"\u0087\u0088\7v\2\2\u0088\u0089\7g\2\2\u0089\u009d\7t\2\2\u008a\u008b"+
		"\7e\2\2\u008b\u008c\7j\2\2\u008c\u008d\7c\2\2\u008d\u008e\7t\2\2\u008e"+
		"\u008f\7c\2\2\u008f\u0090\7e\2\2\u0090\u0091\7v\2\2\u0091\u0092\7g\2\2"+
		"\u0092\u009d\7t\2\2\u0093\u0094\7E\2\2\u0094\u0095\7J\2\2\u0095\u0096"+
		"\7C\2\2\u0096\u0097\7T\2\2\u0097\u0098\7C\2\2\u0098\u0099\7E\2\2\u0099"+
		"\u009a\7V\2\2\u009a\u009b\7G\2\2\u009b\u009d\7T\2\2\u009cu\3\2\2\2\u009c"+
		"y\3\2\2\2\u009c}\3\2\2\2\u009c\u0081\3\2\2\2\u009c\u008a\3\2\2\2\u009c"+
		"\u0093\3\2\2\2\u009d\26\3\2\2\2\u009e\u009f\7K\2\2\u009f\u00a0\7P\2\2"+
		"\u00a0\u00a1\7V\2\2\u00a1\u00a2\7G\2\2\u00a2\u00a3\7I\2\2\u00a3\u00a4"+
		"\7G\2\2\u00a4\u00ba\7T\2\2\u00a5\u00a6\7K\2\2\u00a6\u00a7\7p\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7i\2\2\u00aa\u00ab\7g\2\2"+
		"\u00ab\u00ba\7t\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af"+
		"\7v\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7i\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\u00ba\7t\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7P\2\2\u00b5\u00ba\7V\2\2"+
		"\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8\u00ba\7v\2\2\u00b9\u009e"+
		"\3\2\2\2\u00b9\u00a5\3\2\2\2\u00b9\u00ac\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9"+
		"\u00b6\3\2\2\2\u00ba\30\3\2\2\2\u00bb\u00bc\7H\2\2\u00bc\u00bd\7N\2\2"+
		"\u00bd\u00be\7Q\2\2\u00be\u00bf\7C\2\2\u00bf\u00cb\7V\2\2\u00c0\u00c1"+
		"\7H\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7c\2\2\u00c4"+
		"\u00cb\7v\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7q\2\2"+
		"\u00c8\u00c9\7c\2\2\u00c9\u00cb\7v\2\2\u00ca\u00bb\3\2\2\2\u00ca\u00c0"+
		"\3\2\2\2\u00ca\u00c5\3\2\2\2\u00cb\32\3\2\2\2\u00cc\u00cd\7F\2\2\u00cd"+
		"\u00ce\7C\2\2\u00ce\u00cf\7V\2\2\u00cf\u00d9\7G\2\2\u00d0\u00d1\7F\2\2"+
		"\u00d1\u00d2\7c\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d9\7g\2\2\u00d4\u00d5"+
		"\7f\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d9\7g\2\2\u00d8"+
		"\u00cc\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d9\34\3\2\2"+
		"\2\u00da\u00de\7)\2\2\u00db\u00dd\t\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\36\3\2\2\2\u00e3\u00e5\t\3\2\2"+
		"\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea\t\4\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec \3\2\2\2"+
		"\u00ed\u00eb\3\2\2\2\u00ee\u00f0\t\5\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f6\3\2\2\2\u00f3"+
		"\u00f5\t\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb"+
		"\t\6\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b\22\2\2\u00ff$\3\2\2\2"+
		"\u0100\u0101\7\61\2\2\u0101\u0102\7,\2\2\u0102\u0106\3\2\2\2\u0103\u0105"+
		"\13\2\2\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0106\u0104\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a"+
		"\7,\2\2\u010a\u010b\7\61\2\2\u010b\u010c\3\2\2\2\u010c\u010d\b\23\3\2"+
		"\u010d&\3\2\2\2\u010e\u010f\7\61\2\2\u010f\u0110\7\61\2\2\u0110\u0114"+
		"\3\2\2\2\u0111\u0113\n\7\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0117\u0118\b\24\3\2\u0118(\3\2\2\2\25\2N_s\u009c\u00b9\u00ca\u00d8"+
		"\u00dc\u00de\u00e6\u00e9\u00eb\u00f1\u00f4\u00f6\u00fc\u0106\u0114\4\b"+
		"\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}