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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP=17, 
		OP_AT=18, OPREL=19, ID=20, NUM=21, VIRG=22, PV=23, AP=24, FP=25, DP=26, 
		AND=27, OR=28, TEXTO=29, WS=30;
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
			"'number'", "'text'", "'se'", "'entao'", "'senao'", "'fimse'", "'enquanto'", 
			"'faca'", "'fimenquanto'", "'leia'", "'escreva'", null, null, null, null, 
			null, "','", "';'", "'('", "')'", "':'", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", "NUM", "VIRG", 
			"PV", "AP", "FP", "DP", "AND", "OR", "TEXTO", "WS"
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
		public TerminalNode ID() { return getToken(PtBrLangGrammarParser.ID, 0); }
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
			match(ID);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1159424L) != 0) );
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
			setState(59);
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
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(62);
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
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdAttrib();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				cmdLeitura();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdEscrita();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdIF();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				cmdWhile();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
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
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
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
			setState(72);
			match(T__7);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(74);
			match(AP);
			setState(75);
			expr();
			setState(76);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(78);
			expr();
			setState(79);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(81);
			match(T__8);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				comando();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1159424L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(88);
				match(T__9);
				 stack.push(new ArrayList<Command>()); 
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					comando();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1159424L) != 0) );

				                   currentIfCommand.setFalseList(stack.pop());
				                 
				}
			}

			setState(99);
			match(T__10);

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
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
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
			setState(102);
			match(T__11);
			 stack.push(new ArrayList<Command>());
										   strExpr = "";
										   whileCommand = new WhileCommand(false);
										 
			setState(104);
			match(AP);
			setState(105);
			expr();
			setState(106);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(108);
			expr();
			setState(109);
			match(FP);
			 whileCommand.setExpression(strExpr); 
			setState(111);
			match(T__12);
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				comando();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1159424L) != 0) );
			whileCommand.setTrueList(stack.pop());
			setState(118);
			match(T__13);

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
		public TerminalNode OPREL() { return getToken(PtBrLangGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(PtBrLangGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__12);
			 stack.push(new ArrayList<Command>());
										   strExpr = "";
										   whileCommand = new WhileCommand(true);
									
			setState(124); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(123);
					comando();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(126); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			whileCommand.setTrueList(stack.pop());
			setState(129);
			match(T__11);
			 strExpr = "";
			setState(131);
			match(AP);
			setState(132);
			expr();
			setState(133);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(135);
			expr();
			setState(136);
			match(FP);
			 whileCommand.setExpression(strExpr); 
			setState(138);
			match(T__13);

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
			setState(141);
			match(ID);
			 strExpr = "";
							   if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                   atribCommand = new AtribCommand(symbolTable.get(_input.LT(-1).getText()));
			                   
			                 
			setState(143);
			match(OP_AT);

								strOp = "";
								strOp = _input.LT(-1).getText();
								atribCommand.setStrOp(strOp);
								
			setState(145);
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
								
			setState(147);
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
			setState(149);
			match(T__14);
			setState(150);
			match(AP);
			setState(151);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(153);
			match(FP);
			setState(154);
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
			setState(156);
			match(T__15);
			setState(157);
			match(AP);
			{
			setState(158);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(161);
			match(FP);
			setState(162);
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
			setState(165);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(167);
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
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
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
				setState(171);
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
				setState(173);
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
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(177);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(179);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(186);
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
		"\u0004\u0001\u001e\u00bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000"+
		"\u000b\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000"+
		"\u000b\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003T\b\u0003"+
		"\u000b\u0003\f\u0003U\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003\\\b\u0003\u000b\u0003\f\u0003]\u0001\u0003\u0001\u0003\u0003"+
		"\u0003b\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004r\b\u0004\u000b"+
		"\u0004\f\u0004s\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005}\b\u0005\u000b\u0005\f\u0005"+
		"~\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b0"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u00b7\b\u000b\n\u000b\f\u000b\u00ba\t\u000b\u0001\u000b\u0000\u0000"+
		"\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000"+
		"\u00c0\u0000\u0018\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000"+
		"\u0004F\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000\bf\u0001"+
		"\u0000\u0000\u0000\ny\u0001\u0000\u0000\u0000\f\u008d\u0001\u0000\u0000"+
		"\u0000\u000e\u0095\u0001\u0000\u0000\u0000\u0010\u009c\u0001\u0000\u0000"+
		"\u0000\u0012\u00a5\u0001\u0000\u0000\u0000\u0014\u00af\u0001\u0000\u0000"+
		"\u0000\u0016\u00b8\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000"+
		"\u0000\u0019\u001a\u0005\u0014\u0000\u0000\u001a\u001c\u0006\u0000\uffff"+
		"\uffff\u0000\u001b\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 \"\u0005\u0002\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000"+
		"\'(\u0005\u0004\u0000\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001"+
		"\u0000\u0000\u0000*+\u0005\u0005\u0000\u0000+,\u0006\u0001\uffff\uffff"+
		"\u0000,-\u0005\u0014\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005"+
		"\u0016\u0000\u0000/0\u0005\u0014\u0000\u000002\u0006\u0001\uffff\uffff"+
		"\u00001.\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u00006;\u0005\u001a\u0000\u000078\u0005\u0006\u0000\u0000"+
		"8<\u0006\u0001\uffff\uffff\u00009:\u0005\u0007\u0000\u0000:<\u0006\u0001"+
		"\uffff\uffff\u0000;7\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0006\u0001\uffff\uffff\u0000>?\u0005\u0017"+
		"\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@G\u0003\f\u0006\u0000AG\u0003"+
		"\u000e\u0007\u0000BG\u0003\u0010\b\u0000CG\u0003\u0006\u0003\u0000DG\u0003"+
		"\b\u0004\u0000EG\u0003\n\u0005\u0000F@\u0001\u0000\u0000\u0000FA\u0001"+
		"\u0000\u0000\u0000FB\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u0005\u0001\u0000"+
		"\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0006\u0003\uffff\uffff\u0000JK\u0005"+
		"\u0018\u0000\u0000KL\u0003\u0012\t\u0000LM\u0005\u0013\u0000\u0000MN\u0006"+
		"\u0003\uffff\uffff\u0000NO\u0003\u0012\t\u0000OP\u0005\u0019\u0000\u0000"+
		"PQ\u0006\u0003\uffff\uffff\u0000QS\u0005\t\u0000\u0000RT\u0003\u0004\u0002"+
		"\u0000SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000Wa\u0006"+
		"\u0003\uffff\uffff\u0000XY\u0005\n\u0000\u0000Y[\u0006\u0003\uffff\uffff"+
		"\u0000Z\\\u0003\u0004\u0002\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_`\u0006\u0003\uffff\uffff\u0000`b\u0001\u0000\u0000"+
		"\u0000aX\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0005\u000b\u0000\u0000de\u0006\u0003\uffff\uffff\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fg\u0005\f\u0000\u0000gh\u0006\u0004\uffff"+
		"\uffff\u0000hi\u0005\u0018\u0000\u0000ij\u0003\u0012\t\u0000jk\u0005\u0013"+
		"\u0000\u0000kl\u0006\u0004\uffff\uffff\u0000lm\u0003\u0012\t\u0000mn\u0005"+
		"\u0019\u0000\u0000no\u0006\u0004\uffff\uffff\u0000oq\u0005\r\u0000\u0000"+
		"pr\u0003\u0004\u0002\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000uv\u0006\u0004\uffff\uffff\u0000vw\u0005\u000e\u0000\u0000"+
		"wx\u0006\u0004\uffff\uffff\u0000x\t\u0001\u0000\u0000\u0000yz\u0005\r"+
		"\u0000\u0000z|\u0006\u0005\uffff\uffff\u0000{}\u0003\u0004\u0002\u0000"+
		"|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0006\u0005\uffff\uffff\u0000\u0081\u0082\u0005\f\u0000\u0000"+
		"\u0082\u0083\u0006\u0005\uffff\uffff\u0000\u0083\u0084\u0005\u0018\u0000"+
		"\u0000\u0084\u0085\u0003\u0012\t\u0000\u0085\u0086\u0005\u0013\u0000\u0000"+
		"\u0086\u0087\u0006\u0005\uffff\uffff\u0000\u0087\u0088\u0003\u0012\t\u0000"+
		"\u0088\u0089\u0005\u0019\u0000\u0000\u0089\u008a\u0006\u0005\uffff\uffff"+
		"\u0000\u008a\u008b\u0005\u000e\u0000\u0000\u008b\u008c\u0006\u0005\uffff"+
		"\uffff\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0014"+
		"\u0000\u0000\u008e\u008f\u0006\u0006\uffff\uffff\u0000\u008f\u0090\u0005"+
		"\u0012\u0000\u0000\u0090\u0091\u0006\u0006\uffff\uffff\u0000\u0091\u0092"+
		"\u0003\u0012\t\u0000\u0092\u0093\u0006\u0006\uffff\uffff\u0000\u0093\u0094"+
		"\u0005\u0017\u0000\u0000\u0094\r\u0001\u0000\u0000\u0000\u0095\u0096\u0005"+
		"\u000f\u0000\u0000\u0096\u0097\u0005\u0018\u0000\u0000\u0097\u0098\u0005"+
		"\u0014\u0000\u0000\u0098\u0099\u0006\u0007\uffff\uffff\u0000\u0099\u009a"+
		"\u0005\u0019\u0000\u0000\u009a\u009b\u0005\u0017\u0000\u0000\u009b\u000f"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0010\u0000\u0000\u009d\u009e"+
		"\u0005\u0018\u0000\u0000\u009e\u009f\u0003\u0014\n\u0000\u009f\u00a0\u0006"+
		"\b\uffff\uffff\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u0019\u0000\u0000\u00a2\u00a3\u0005\u0017\u0000\u0000\u00a3\u00a4\u0006"+
		"\b\uffff\uffff\u0000\u00a4\u0011\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003"+
		"\u0014\n\u0000\u00a6\u00a7\u0006\t\uffff\uffff\u0000\u00a7\u00a8\u0003"+
		"\u0016\u000b\u0000\u00a8\u0013\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u0014\u0000\u0000\u00aa\u00b0\u0006\n\uffff\uffff\u0000\u00ab\u00ac\u0005"+
		"\u0015\u0000\u0000\u00ac\u00b0\u0006\n\uffff\uffff\u0000\u00ad\u00ae\u0005"+
		"\u001d\u0000\u0000\u00ae\u00b0\u0006\n\uffff\uffff\u0000\u00af\u00a9\u0001"+
		"\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b0\u0015\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0011\u0000\u0000\u00b2\u00b3\u0006\u000b\uffff\uffff\u0000\u00b3\u00b4"+
		"\u0003\u0014\n\u0000\u00b4\u00b5\u0006\u000b\uffff\uffff\u0000\u00b5\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b7\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b9\u0017\u0001\u0000\u0000\u0000\u00ba\u00b8"+
		"\u0001\u0000\u0000\u0000\f\u001e$3;FU]as~\u00af\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}