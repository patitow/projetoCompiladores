// Generated from /workspaces/projetoCompiladores/projetoBaseLCSM/Imp.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, NUM=12, OP=13, ESPACOS=14;
	public static final int
		RULE_program = 0, RULE_exp = 1, RULE_com = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "exp", "com"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "';'", "'print'", "'{'", "'}'", "'if'", "'else'", 
			"'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"NUM", "OP", "ESPACOS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ImpParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			com();
			setState(7);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GroupContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public GroupContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class OpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OP() { return getToken(ImpParser.OP, 0); }
		public OpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class VarContext extends ExpContext {
		public TerminalNode ID() { return getToken(ImpParser.ID, 0); }
		public VarContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ConstContext extends ExpContext {
		public TerminalNode NUM() { return getToken(ImpParser.NUM, 0); }
		public ConstContext(ExpContext ctx) { copyFrom(ctx); }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				_localctx = new ConstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(10);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(ID);
				}
				break;
			case T__0:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				match(T__0);
				setState(13);
				exp(0);
				setState(14);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(new ExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(18);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(19);
					match(OP);
					setState(20);
					exp(3);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends ComContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(ComContext ctx) { copyFrom(ctx); }
	}
	public static class AtribContext extends ComContext {
		public TerminalNode ID() { return getToken(ImpParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AtribContext(ComContext ctx) { copyFrom(ctx); }
	}
	public static class WhileContext extends ComContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
	}
	public static class IfContext extends ComContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public IfContext(ComContext ctx) { copyFrom(ctx); }
	}
	public static class SeqContext extends ComContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public SeqContext(ComContext ctx) { copyFrom(ctx); }
	}

	public final ComContext com() throws RecognitionException {
		ComContext _localctx = new ComContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_com);
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AtribContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(ID);
				setState(27);
				match(T__2);
				setState(28);
				exp(0);
				setState(29);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__4);
				setState(32);
				exp(0);
				setState(33);
				match(T__3);
				}
				break;
			case T__5:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(T__5);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << ID))) != 0)) {
					{
					{
					setState(36);
					com();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(T__7);
				setState(44);
				match(T__0);
				setState(45);
				exp(0);
				setState(46);
				match(T__1);
				setState(47);
				com();
				setState(48);
				match(T__8);
				setState(49);
				com();
				}
				break;
			case T__9:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(T__9);
				setState(52);
				match(T__0);
				setState(53);
				exp(0);
				setState(54);
				match(T__1);
				setState(55);
				com();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\23\n\3\3\3\3\3"+
		"\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\2\3\4\5\2\4\6\2\2\2B\2\b\3\2\2\2\4\22"+
		"\3\2\2\2\6;\3\2\2\2\b\t\5\6\4\2\t\n\7\2\2\3\n\3\3\2\2\2\13\f\b\3\1\2\f"+
		"\23\7\16\2\2\r\23\7\r\2\2\16\17\7\3\2\2\17\20\5\4\3\2\20\21\7\4\2\2\21"+
		"\23\3\2\2\2\22\13\3\2\2\2\22\r\3\2\2\2\22\16\3\2\2\2\23\31\3\2\2\2\24"+
		"\25\f\4\2\2\25\26\7\17\2\2\26\30\5\4\3\5\27\24\3\2\2\2\30\33\3\2\2\2\31"+
		"\27\3\2\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33\31\3\2\2\2\34\35\7\r\2\2\35"+
		"\36\7\5\2\2\36\37\5\4\3\2\37 \7\6\2\2 <\3\2\2\2!\"\7\7\2\2\"#\5\4\3\2"+
		"#$\7\6\2\2$<\3\2\2\2%)\7\b\2\2&(\5\6\4\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2"+
		"\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,<\7\t\2\2-.\7\n\2\2./\7\3\2\2/\60\5\4"+
		"\3\2\60\61\7\4\2\2\61\62\5\6\4\2\62\63\7\13\2\2\63\64\5\6\4\2\64<\3\2"+
		"\2\2\65\66\7\f\2\2\66\67\7\3\2\2\678\5\4\3\289\7\4\2\29:\5\6\4\2:<\3\2"+
		"\2\2;\34\3\2\2\2;!\3\2\2\2;%\3\2\2\2;-\3\2\2\2;\65\3\2\2\2<\7\3\2\2\2"+
		"\6\22\31);";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}