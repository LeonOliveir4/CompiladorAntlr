// Generated from PtBrLangGrammar.g4 by ANTLR 4.13.2
package com.compiladoresufabc.ptbrlangcompiler.commons.antlr;

import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
import com.compiladoresufabc.ptbrlangcompiler.domains.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.errors.*;
import com.compiladoresufabc.ptbrlangcompiler.commons.generator.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PtBrLangGrammarParser}.
 */
public interface PtBrLangGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PtBrLangGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PtBrLangGrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(PtBrLangGrammarParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(PtBrLangGrammarParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(PtBrLangGrammarParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(PtBrLangGrammarParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void enterCmdIF(PtBrLangGrammarParser.CmdIFContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void exitCmdIF(PtBrLangGrammarParser.CmdIFContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(PtBrLangGrammarParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(PtBrLangGrammarParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(PtBrLangGrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(PtBrLangGrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(PtBrLangGrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(PtBrLangGrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PtBrLangGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PtBrLangGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(PtBrLangGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(PtBrLangGrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(PtBrLangGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(PtBrLangGrammarParser.ExprlContext ctx);
}