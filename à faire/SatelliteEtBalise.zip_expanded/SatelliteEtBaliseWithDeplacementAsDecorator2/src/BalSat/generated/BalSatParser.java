// Generated from BalSat.g4 by ANTLR 4.9.1
package BalSat.generated;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BalSatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SYMBOL=2, NB=3, VAR=4, WS=5, PARG=6, PARD=7, EQUAL=8, VIRG=9, 
		POINT=10, POINTVIRG=11;
	public static final int
		RULE_script = 0, RULE_command = 1, RULE_assign = 2, RULE_call = 3, RULE_valueAssign = 4, 
		RULE_creation = 5, RULE_value = 6, RULE_arguments = 7, RULE_arg = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "command", "assign", "call", "valueAssign", "creation", "value", 
			"arguments", "arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'new'", null, null, null, null, "'('", "')'", "'='", "','", "'.'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SYMBOL", "NB", "VAR", "WS", "PARG", "PARD", "EQUAL", "VIRG", 
			"POINT", "POINTVIRG"
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
	public String getGrammarFileName() { return "BalSat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BalSatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ScriptContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitScript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(18);
				command();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class CommandContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode POINTVIRG() { return getToken(BalSatParser.POINTVIRG, 0); }
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				assign();
				setState(26);
				match(POINTVIRG);
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BalSatParser.VAR, 0); }
		public TerminalNode EQUAL() { return getToken(BalSatParser.EQUAL, 0); }
		public ValueAssignContext valueAssign() {
			return getRuleContext(ValueAssignContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(VAR);
			setState(31);
			match(EQUAL);
			setState(32);
			valueAssign();
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

	public static class CallContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(BalSatParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(BalSatParser.VAR, i);
		}
		public TerminalNode POINT() { return getToken(BalSatParser.POINT, 0); }
		public TerminalNode PARG() { return getToken(BalSatParser.PARG, 0); }
		public TerminalNode PARD() { return getToken(BalSatParser.PARD, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(VAR);
			setState(35);
			match(POINT);
			setState(36);
			match(VAR);
			setState(37);
			match(PARG);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(38);
				arguments();
				}
			}

			setState(41);
			match(PARD);
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

	public static class ValueAssignContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CreationContext creation() {
			return getRuleContext(CreationContext.class,0);
		}
		public ValueAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterValueAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitValueAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitValueAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueAssignContext valueAssign() throws RecognitionException {
		ValueAssignContext _localctx = new ValueAssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valueAssign);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYMBOL:
			case NB:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				value();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				call();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				creation();
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

	public static class CreationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BalSatParser.VAR, 0); }
		public TerminalNode PARG() { return getToken(BalSatParser.PARG, 0); }
		public TerminalNode PARD() { return getToken(BalSatParser.PARD, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CreationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterCreation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitCreation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitCreation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreationContext creation() throws RecognitionException {
		CreationContext _localctx = new CreationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_creation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			match(VAR);
			setState(50);
			match(PARG);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(51);
				arguments();
				}
			}

			setState(54);
			match(PARD);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NB() { return getToken(BalSatParser.NB, 0); }
		public TerminalNode SYMBOL() { return getToken(BalSatParser.SYMBOL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !(_la==SYMBOL || _la==NB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> VIRG() { return getTokens(BalSatParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(BalSatParser.VIRG, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			arg();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(59);
				match(VIRG);
				setState(60);
				arg();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(BalSatParser.VAR, 0); }
		public TerminalNode EQUAL() { return getToken(BalSatParser.EQUAL, 0); }
		public ValueAssignContext valueAssign() {
			return getRuleContext(ValueAssignContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BalSatListener ) ((BalSatListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BalSatVisitor ) return ((BalSatVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(VAR);
			setState(67);
			match(EQUAL);
			setState(68);
			valueAssign();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rI\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\5\5*\n\5\3\5\3\5\3\6\3\6\3\6\5\6\61\n\6\3\7\3\7\3\7\3\7"+
		"\5\7\67\n\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\7\t@\n\t\f\t\16\tC\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\3\2\4\5\2F\2\27\3\2\2\2"+
		"\4\36\3\2\2\2\6 \3\2\2\2\b$\3\2\2\2\n\60\3\2\2\2\f\62\3\2\2\2\16:\3\2"+
		"\2\2\20<\3\2\2\2\22D\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2"+
		"\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32\37\5\b\5\2"+
		"\33\34\5\6\4\2\34\35\7\r\2\2\35\37\3\2\2\2\36\32\3\2\2\2\36\33\3\2\2\2"+
		"\37\5\3\2\2\2 !\7\6\2\2!\"\7\n\2\2\"#\5\n\6\2#\7\3\2\2\2$%\7\6\2\2%&\7"+
		"\f\2\2&\'\7\6\2\2\')\7\b\2\2(*\5\20\t\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2"+
		"+,\7\t\2\2,\t\3\2\2\2-\61\5\16\b\2.\61\5\b\5\2/\61\5\f\7\2\60-\3\2\2\2"+
		"\60.\3\2\2\2\60/\3\2\2\2\61\13\3\2\2\2\62\63\7\3\2\2\63\64\7\6\2\2\64"+
		"\66\7\b\2\2\65\67\5\20\t\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7"+
		"\t\2\29\r\3\2\2\2:;\t\2\2\2;\17\3\2\2\2<A\5\22\n\2=>\7\13\2\2>@\5\22\n"+
		"\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\21\3\2\2\2CA\3\2\2\2DE\7\6"+
		"\2\2EF\7\n\2\2FG\5\n\6\2G\23\3\2\2\2\b\27\36)\60\66A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}