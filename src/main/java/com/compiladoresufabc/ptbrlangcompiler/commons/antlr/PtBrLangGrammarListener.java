// Generated from PtBrLangGrammar.g4 by ANTLR 4.13.2
package com.compiladoresufabc.ptbrlangcompiler.commons.antlr;
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
	 * Enter a parse tree produced by {@link PtBrLangGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(PtBrLangGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PtBrLangGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(PtBrLangGrammarParser.ExprlContext ctx);
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
}