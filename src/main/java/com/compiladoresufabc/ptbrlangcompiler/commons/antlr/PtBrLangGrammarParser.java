// Generated from PtBrLangGrammar.g4 by ANTLR 4.13.2
package com.compiladoresufabc.ptbrlangcompiler.commons.antlr;

import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
import com.compiladoresufabc.ptbrlangcompiler.domains.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.generator.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PtBrLangGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		OP=18, OP_AT=19, OPREL=20, ID=21, NUM=22, VIRG=23, PV=24, AP=25, FP=26, 
		DP=27, AND=28, OR=29, TEXTO=30, WS=31, BOOL=32, CLASS=33;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_comando = 2, RULE_cmdIF = 3, 
		RULE_cmdWhile = 4, RULE_cmdWhileReverse = 5, RULE_cmdAttrib = 6, RULE_cmdLeitura = 7, 
		RULE_cmdEscrita = 8, RULE_expr = 9, RULE_termo = 10, RULE_exprl = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "comando", "cmdIF", "cmdWhile", "cmdWhileReverse", 
			"cmdAttrib", "cmdLeitura", "cmdEscrita", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprograma'", "'declare'", 
			"'number'", "'text'", "'bool'", "'se'", "'entao'", "'senao'", "'fimse'", 
			"'enquanto'", "'faca'", "'fimenquanto'", "'leia'", "'escreva'", null, 
			null, null, null, null, "','", "';'", "'('", "')'", "':'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", "NUM", 
			"VIRG", "PV", "AP", "FP", "DP", "AND", "OR", "TEXTO", "WS", "BOOL", "CLASS"
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
	public String getGrammarFileName() { return "PtBrLangGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    private Program program = new Program();
	    private String strExpr = "";
	    private String strOp = "";
	    private IfCommand currentIfCommand;
	    private WhileCommand whileCommand;
	    private AtribCommand atribCommand;
	    
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    
	    
	    public void updateType(){
	    	for(Var v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    public void exibirVar(){
	        for (String id: symbolTable.keySet()){
	        	System.out.println(symbolTable.get(id));
	        }
	    }
	    
	    public Program getProgram(){
	    	return this.program;
	    	}
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }

	public PtBrLangGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(PtBrLangGrammarParser.CLASS, 0); }
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(CLASS);
			 program.setName(_input.LT(-1).getText());
			                               	stack.push(new ArrayList<Command>()); 
			                             	
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declaravar();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(32);
			match(T__1);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2318848L) != 0) );
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);

			                  program.setSymbolTable(symbolTable);
			                  program.setCommandList(stack.pop());
			               
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PtBrLangGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PtBrLangGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(PtBrLangGrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(PtBrLangGrammarParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(PtBrLangGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(PtBrLangGrammarParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__4);
			 currentDecl.clear(); 
			setState(44);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(46);
				match(VIRG);
				setState(47);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(DP);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(55);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(57);
				match(T__6);
				currentType = Types.TEXT;
				}
				break;
			case T__7:
				{
				setState(59);
				match(T__7);
				currentType = Types.BOOL;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(64);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIFContext cmdIF() {
			return getRuleContext(CmdIFContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdWhileReverseContext cmdWhileReverse() {
			return getRuleContext(CmdWhileReverseContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdAttrib();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdLeitura();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdIF();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdWhile();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdWhileReverse();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIFContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(PtBrLangGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdIF(this);
		}
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__8);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(76);
			match(AP);
			setState(77);
			expr();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(78);
				match(OPREL);
				}
			}

			 strExpr += _input.LT(-1).getText(); 
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5375000576L) != 0)) {
				{
				setState(82);
				expr();
				}
			}

			setState(85);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(87);
			match(T__9);
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				comando();
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2318848L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(94);
				match(T__10);
				 stack.push(new ArrayList<Command>()); 
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(96);
					comando();
					}
					}
					setState(99); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2318848L) != 0) );

				                   currentIfCommand.setFalseList(stack.pop());
				                 
				}
			}

			setState(105);
			match(T__11);

			               	   stack.peek().add(currentIfCommand);
			               
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(PtBrLangGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__12);
			 stack.push(new ArrayList<Command>());
										   strExpr = "";
										   whileCommand = new WhileCommand(false);
										 
			setState(110);
			match(AP);
			setState(111);
			expr();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(112);
				match(OPREL);
				 strExpr += _input.LT(-1).getText(); 
				setState(114);
				expr();
				}
			}

			setState(117);
			match(FP);
			 whileCommand.setExpression(strExpr); 
			setState(119);
			match(T__13);
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				comando();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2318848L) != 0) );
			whileCommand.setTrueList(stack.pop());
			setState(126);
			match(T__14);

			               	   stack.peek().add(whileCommand);
			               		
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileReverseContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(PtBrLangGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public CmdWhileReverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhileReverse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdWhileReverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdWhileReverse(this);
		}
	}

	public final CmdWhileReverseContext cmdWhileReverse() throws RecognitionException {
		CmdWhileReverseContext _localctx = new CmdWhileReverseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdWhileReverse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__13);
			 stack.push(new ArrayList<Command>());
										   strExpr = "";
										   whileCommand = new WhileCommand(true);
									
			setState(132); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(131);
					comando();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(134); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			whileCommand.setTrueList(stack.pop());
			setState(137);
			match(T__12);
			 strExpr = "";
			setState(139);
			match(AP);
			setState(140);
			expr();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPREL) {
				{
				setState(141);
				match(OPREL);
				 strExpr += _input.LT(-1).getText(); 
				setState(143);
				expr();
				}
			}

			setState(146);
			match(FP);
			 whileCommand.setExpression(strExpr); 
			setState(148);
			match(T__14);

			               	   stack.peek().add(whileCommand);
			               		
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PtBrLangGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(PtBrLangGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(PtBrLangGrammarParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(ID);
			 strExpr = "";
							   if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                   atribCommand = new AtribCommand(symbolTable.get(_input.LT(-1).getText()));
			                   
			                 
			setState(153);
			match(OP_AT);

								strOp = "";
								strOp = _input.LT(-1).getText();
								atribCommand.setStrOp(strOp);
								
			setState(155);
			expr();

									atribCommand.setExprString(strExpr);
					                if (strOp.equalsIgnoreCase("++") || strOp.equalsIgnoreCase("--")) {
										System.out.println("Left  Side Expression Type = "+leftType);
										atribCommand.setExprString(null);
									} else {
										System.out.println("Left  Side Expression Type = "+leftType);
					                	System.out.println("Right Side Expression Type = "+rightType);
										if (leftType.getValue() < rightType.getValue()){
						                   throw new SemanticException("Type Mismatchig on Assignment");
						                }
									}
									stack.peek().add(atribCommand);
								
			setState(157);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(PtBrLangGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(PtBrLangGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(PtBrLangGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__15);
			setState(160);
			match(AP);
			setState(161);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(163);
			match(FP);
			setState(164);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(PtBrLangGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(PtBrLangGrammarParser.PV, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__16);
			setState(167);
			match(AP);
			{
			setState(168);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(171);
			match(FP);
			setState(172);
			match(PV);
			 rightType = null;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(177);
			exprl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PtBrLangGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(PtBrLangGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(PtBrLangGrammarParser.TEXTO, 0); }
		public TerminalNode BOOL() { return getToken(PtBrLangGrammarParser.BOOL, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termo);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                       throw new SemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
				                    }
				                    if (rightType == null){
				                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                    }   
				                    else{
				                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                          
				                       }
				                    }
				                  
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(NUM);
				  if (rightType == null) {
							 				rightType = Types.NUMBER;
							            }
							            else{
							                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
							                	rightType = Types.NUMBER;
							                }
							            }
							         
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(TEXTO);
				  if (rightType == null) {
							 				rightType = Types.TEXT;
							            }
							            else{
							                if (rightType.getValue() < Types.TEXT.getValue()){			                    
							                	rightType = Types.TEXT;
							                }
							            }
							         
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(BOOL);
				    if (rightType == null) {
							 				rightType = Types.BOOL;
							            }
							            else{
							                if (rightType.getValue() < Types.BOOL.getValue()){			                    
							                	rightType = Types.BOOL;
							                }
							            }
								   
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(PtBrLangGrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(PtBrLangGrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PtBrLangGrammarListener ) ((PtBrLangGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(189);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(191);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(198);
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

	public static final String _serializedATN =
		"\u0004\u0001!\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000\u000b"+
		"\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000\u000b"+
		"\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001>\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003P\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003T\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003Z\b\u0003\u000b\u0003"+
		"\f\u0003[\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"b\b\u0003\u000b\u0003\f\u0003c\u0001\u0003\u0001\u0003\u0003\u0003h\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004t\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004z\b"+
		"\u0004\u000b\u0004\f\u0004{\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0085\b\u0005\u000b"+
		"\u0005\f\u0005\u0086\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0091\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bc\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c3\b\u000b"+
		"\n\u000b\f\u000b\u00c6\t\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u00d2\u0000\u0018"+
		"\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004H\u0001\u0000"+
		"\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000"+
		"\n\u0081\u0001\u0000\u0000\u0000\f\u0097\u0001\u0000\u0000\u0000\u000e"+
		"\u009f\u0001\u0000\u0000\u0000\u0010\u00a6\u0001\u0000\u0000\u0000\u0012"+
		"\u00af\u0001\u0000\u0000\u0000\u0014\u00bb\u0001\u0000\u0000\u0000\u0016"+
		"\u00c4\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019"+
		"\u001a\u0005!\u0000\u0000\u001a\u001c\u0006\u0000\uffff\uffff\u0000\u001b"+
		"\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0005"+
		"\u0002\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005\u0004"+
		"\u0000\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0005\u0000\u0000+,\u0006\u0001\uffff\uffff\u0000,-\u0005"+
		"\u0015\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0017\u0000"+
		"\u0000/0\u0005\u0015\u0000\u000002\u0006\u0001\uffff\uffff\u00001.\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u00006=\u0005\u001b\u0000\u000078\u0005\u0006\u0000\u00008>\u0006\u0001"+
		"\uffff\uffff\u00009:\u0005\u0007\u0000\u0000:>\u0006\u0001\uffff\uffff"+
		"\u0000;<\u0005\b\u0000\u0000<>\u0006\u0001\uffff\uffff\u0000=7\u0001\u0000"+
		"\u0000\u0000=9\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0006\u0001\uffff\uffff\u0000@A\u0005\u0018\u0000"+
		"\u0000A\u0003\u0001\u0000\u0000\u0000BI\u0003\f\u0006\u0000CI\u0003\u000e"+
		"\u0007\u0000DI\u0003\u0010\b\u0000EI\u0003\u0006\u0003\u0000FI\u0003\b"+
		"\u0004\u0000GI\u0003\n\u0005\u0000HB\u0001\u0000\u0000\u0000HC\u0001\u0000"+
		"\u0000\u0000HD\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\u0005\u0001\u0000\u0000"+
		"\u0000JK\u0005\t\u0000\u0000KL\u0006\u0003\uffff\uffff\u0000LM\u0005\u0019"+
		"\u0000\u0000MO\u0003\u0012\t\u0000NP\u0005\u0014\u0000\u0000ON\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0006"+
		"\u0003\uffff\uffff\u0000RT\u0003\u0012\t\u0000SR\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005\u001a\u0000"+
		"\u0000VW\u0006\u0003\uffff\uffff\u0000WY\u0005\n\u0000\u0000XZ\u0003\u0004"+
		"\u0002\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"]g\u0006\u0003\uffff\uffff\u0000^_\u0005\u000b\u0000\u0000_a\u0006\u0003"+
		"\uffff\uffff\u0000`b\u0003\u0004\u0002\u0000a`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000ef\u0006\u0003\uffff\uffff\u0000fh\u0001"+
		"\u0000\u0000\u0000g^\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0005\f\u0000\u0000jk\u0006\u0003\uffff\uffff"+
		"\u0000k\u0007\u0001\u0000\u0000\u0000lm\u0005\r\u0000\u0000mn\u0006\u0004"+
		"\uffff\uffff\u0000no\u0005\u0019\u0000\u0000os\u0003\u0012\t\u0000pq\u0005"+
		"\u0014\u0000\u0000qr\u0006\u0004\uffff\uffff\u0000rt\u0003\u0012\t\u0000"+
		"sp\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uv\u0005\u001a\u0000\u0000vw\u0006\u0004\uffff\uffff\u0000wy\u0005"+
		"\u000e\u0000\u0000xz\u0003\u0004\u0002\u0000yx\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0006\u0004\uffff\uffff\u0000~\u007f"+
		"\u0005\u000f\u0000\u0000\u007f\u0080\u0006\u0004\uffff\uffff\u0000\u0080"+
		"\t\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u000e\u0000\u0000\u0082\u0084"+
		"\u0006\u0005\uffff\uffff\u0000\u0083\u0085\u0003\u0004\u0002\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0006\u0005\uffff\uffff\u0000"+
		"\u0089\u008a\u0005\r\u0000\u0000\u008a\u008b\u0006\u0005\uffff\uffff\u0000"+
		"\u008b\u008c\u0005\u0019\u0000\u0000\u008c\u0090\u0003\u0012\t\u0000\u008d"+
		"\u008e\u0005\u0014\u0000\u0000\u008e\u008f\u0006\u0005\uffff\uffff\u0000"+
		"\u008f\u0091\u0003\u0012\t\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005\u001a\u0000\u0000\u0093\u0094\u0006\u0005\uffff\uffff\u0000"+
		"\u0094\u0095\u0005\u000f\u0000\u0000\u0095\u0096\u0006\u0005\uffff\uffff"+
		"\u0000\u0096\u000b\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0015\u0000"+
		"\u0000\u0098\u0099\u0006\u0006\uffff\uffff\u0000\u0099\u009a\u0005\u0013"+
		"\u0000\u0000\u009a\u009b\u0006\u0006\uffff\uffff\u0000\u009b\u009c\u0003"+
		"\u0012\t\u0000\u009c\u009d\u0006\u0006\uffff\uffff\u0000\u009d\u009e\u0005"+
		"\u0018\u0000\u0000\u009e\r\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0010"+
		"\u0000\u0000\u00a0\u00a1\u0005\u0019\u0000\u0000\u00a1\u00a2\u0005\u0015"+
		"\u0000\u0000\u00a2\u00a3\u0006\u0007\uffff\uffff\u0000\u00a3\u00a4\u0005"+
		"\u001a\u0000\u0000\u00a4\u00a5\u0005\u0018\u0000\u0000\u00a5\u000f\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0005\u0011\u0000\u0000\u00a7\u00a8\u0005"+
		"\u0019\u0000\u0000\u00a8\u00a9\u0003\u0014\n\u0000\u00a9\u00aa\u0006\b"+
		"\uffff\uffff\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\u001a\u0000\u0000\u00ac\u00ad\u0005\u0018\u0000\u0000\u00ad\u00ae\u0006"+
		"\b\uffff\uffff\u0000\u00ae\u0011\u0001\u0000\u0000\u0000\u00af\u00b0\u0003"+
		"\u0014\n\u0000\u00b0\u00b1\u0006\t\uffff\uffff\u0000\u00b1\u00b2\u0003"+
		"\u0016\u000b\u0000\u00b2\u0013\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005"+
		"\u0015\u0000\u0000\u00b4\u00bc\u0006\n\uffff\uffff\u0000\u00b5\u00b6\u0005"+
		"\u0016\u0000\u0000\u00b6\u00bc\u0006\n\uffff\uffff\u0000\u00b7\u00b8\u0005"+
		"\u001e\u0000\u0000\u00b8\u00bc\u0006\n\uffff\uffff\u0000\u00b9\u00ba\u0005"+
		" \u0000\u0000\u00ba\u00bc\u0006\n\uffff\uffff\u0000\u00bb\u00b3\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b5\u0001\u0000\u0000\u0000\u00bb\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u0015\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005\u0012\u0000\u0000\u00be\u00bf\u0006"+
		"\u000b\uffff\uffff\u0000\u00bf\u00c0\u0003\u0014\n\u0000\u00c0\u00c1\u0006"+
		"\u000b\uffff\uffff\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u0017"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u0010\u001e"+
		"$3=HOS[cgs{\u0086\u0090\u00bb\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}