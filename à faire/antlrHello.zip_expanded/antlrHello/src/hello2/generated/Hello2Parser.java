// Generated from Hello2.g4 by ANTLR 4.9.1
package hello2.generated;

// example :
// lundi : Sleeping 10; Practice swimming 1; Meeting John;
// mardi : Sleeping 7; Practice running 2; Meeting Bill;
// mercredi : None;

// Exercice : Compléter l'exemple 2 avec :
// - Méta-modélisation : Spécifier un méta-modèle pour le langage en Java
// - Outils d'analyse : Construire un visiteur "Antlr" pour construire les instances de votre méta-model
// - Back-end XML : Construire un visiteur "classique" pour produire du XML à partir des instances du méta-model

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Hello2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NB=7, ID=8, WS=9;
	public static final int
		RULE_schedule = 0, RULE_dayActivities = 1, RULE_actualActivities = 2, 
		RULE_day = 3, RULE_activity = 4, RULE_sleeping = 5, RULE_practice = 6, 
		RULE_meeting = 7, RULE_none = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"schedule", "dayActivities", "actualActivities", "day", "activity", "sleeping", 
			"practice", "meeting", "none"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "';'", "'Sleeping'", "'Practice'", "'Meeting'", "'None'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NB", "ID", "WS"
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
	public String getGrammarFileName() { return "Hello2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Hello2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ScheduleContext extends ParserRuleContext {
		public List<DayActivitiesContext> dayActivities() {
			return getRuleContexts(DayActivitiesContext.class);
		}
		public DayActivitiesContext dayActivities(int i) {
			return getRuleContext(DayActivitiesContext.class,i);
		}
		public ScheduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schedule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterSchedule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitSchedule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitSchedule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScheduleContext schedule() throws RecognitionException {
		ScheduleContext _localctx = new ScheduleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_schedule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(18);
				dayActivities();
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

	public static class DayActivitiesContext extends ParserRuleContext {
		public DayContext day() {
			return getRuleContext(DayContext.class,0);
		}
		public ActualActivitiesContext actualActivities() {
			return getRuleContext(ActualActivitiesContext.class,0);
		}
		public DayActivitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dayActivities; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterDayActivities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitDayActivities(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitDayActivities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DayActivitiesContext dayActivities() throws RecognitionException {
		DayActivitiesContext _localctx = new DayActivitiesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dayActivities);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			day();
			setState(25);
			match(T__0);
			setState(26);
			actualActivities();
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

	public static class ActualActivitiesContext extends ParserRuleContext {
		public ActualActivitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualActivities; }
	 
		public ActualActivitiesContext() { }
		public void copyFrom(ActualActivitiesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoActivityContext extends ActualActivitiesContext {
		public NoneContext none() {
			return getRuleContext(NoneContext.class,0);
		}
		public NoActivityContext(ActualActivitiesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterNoActivity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitNoActivity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitNoActivity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ActivitiesContext extends ActualActivitiesContext {
		public List<ActivityContext> activity() {
			return getRuleContexts(ActivityContext.class);
		}
		public ActivityContext activity(int i) {
			return getRuleContext(ActivityContext.class,i);
		}
		public ActivitiesContext(ActualActivitiesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterActivities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitActivities(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitActivities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualActivitiesContext actualActivities() throws RecognitionException {
		ActualActivitiesContext _localctx = new ActualActivitiesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_actualActivities);
		int _la;
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
				_localctx = new ActivitiesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(28);
					activity();
					}
					}
					setState(31); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
				}
				break;
			case T__5:
				_localctx = new NoActivityContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				none();
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

	public static class DayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Hello2Parser.ID, 0); }
		public DayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_day; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterDay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitDay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitDay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DayContext day() throws RecognitionException {
		DayContext _localctx = new DayContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_day);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ID);
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

	public static class ActivityContext extends ParserRuleContext {
		public SleepingContext sleeping() {
			return getRuleContext(SleepingContext.class,0);
		}
		public MeetingContext meeting() {
			return getRuleContext(MeetingContext.class,0);
		}
		public PracticeContext practice() {
			return getRuleContext(PracticeContext.class,0);
		}
		public ActivityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterActivity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitActivity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitActivity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActivityContext activity() throws RecognitionException {
		ActivityContext _localctx = new ActivityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_activity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(38);
				sleeping();
				}
				break;
			case T__4:
				{
				setState(39);
				meeting();
				}
				break;
			case T__3:
				{
				setState(40);
				practice();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(43);
			match(T__1);
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

	public static class SleepingContext extends ParserRuleContext {
		public TerminalNode NB() { return getToken(Hello2Parser.NB, 0); }
		public SleepingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleeping; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterSleeping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitSleeping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitSleeping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepingContext sleeping() throws RecognitionException {
		SleepingContext _localctx = new SleepingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sleeping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__2);
			setState(46);
			match(NB);
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

	public static class PracticeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Hello2Parser.ID, 0); }
		public TerminalNode NB() { return getToken(Hello2Parser.NB, 0); }
		public PracticeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_practice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterPractice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitPractice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitPractice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PracticeContext practice() throws RecognitionException {
		PracticeContext _localctx = new PracticeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_practice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__3);
			setState(49);
			match(ID);
			setState(50);
			match(NB);
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

	public static class MeetingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Hello2Parser.ID, 0); }
		public MeetingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meeting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterMeeting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitMeeting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitMeeting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeetingContext meeting() throws RecognitionException {
		MeetingContext _localctx = new MeetingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_meeting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__4);
			setState(53);
			match(ID);
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

	public static class NoneContext extends ParserRuleContext {
		public NoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_none; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).enterNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Hello2Listener ) ((Hello2Listener)listener).exitNone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Hello2Visitor ) return ((Hello2Visitor<? extends T>)visitor).visitNone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoneContext none() throws RecognitionException {
		NoneContext _localctx = new NoneContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_none);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__5);
			setState(56);
			match(T__1);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\3\3\3\4\6\4 \n\4\r\4\16\4!\3\4\5\4%"+
		"\n\4\3\5\3\5\3\6\3\6\3\6\5\6,\n\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2\28\2\27\3"+
		"\2\2\2\4\32\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n+\3\2\2\2\f/\3\2\2\2\16\62"+
		"\3\2\2\2\20\66\3\2\2\2\229\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3"+
		"\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32\33\5"+
		"\b\5\2\33\34\7\3\2\2\34\35\5\6\4\2\35\5\3\2\2\2\36 \5\n\6\2\37\36\3\2"+
		"\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#%\5\22\n\2$\37\3\2\2"+
		"\2$#\3\2\2\2%\7\3\2\2\2&\'\7\n\2\2\'\t\3\2\2\2(,\5\f\7\2),\5\20\t\2*,"+
		"\5\16\b\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,-\3\2\2\2-.\7\4\2\2.\13\3\2\2"+
		"\2/\60\7\5\2\2\60\61\7\t\2\2\61\r\3\2\2\2\62\63\7\6\2\2\63\64\7\n\2\2"+
		"\64\65\7\t\2\2\65\17\3\2\2\2\66\67\7\7\2\2\678\7\n\2\28\21\3\2\2\29:\7"+
		"\b\2\2:;\7\4\2\2;\23\3\2\2\2\6\27!$+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}