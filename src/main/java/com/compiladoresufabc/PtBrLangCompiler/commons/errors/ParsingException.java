package com.compiladoresufabc.PtBrLangCompiler.commons.errors;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

public class ParsingException extends Exception {
	
	private static final long serialVersionUID = 4619596390004108148L;

	public ParsingException(String message) {
        super(message);
    }

    public ParsingException(RecognitionException e) {
        super(buildErrorMessage(e));
    }

    private static String buildErrorMessage(RecognitionException e) {
        Token offendingToken = e.getOffendingToken();
        if (offendingToken != null) {
            return "Erro de análise léxica ou sintática na linha " +
                   offendingToken.getLine() +
                   ", posição " + offendingToken.getCharPositionInLine() +
                   ". Token ofensivo: " + offendingToken.getText();
        } else {
            return "Erro de análise léxica ou sintática desconhecido.";
        }
    }
}