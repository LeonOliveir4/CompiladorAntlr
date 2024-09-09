package com.compiladoresufabc.ptbrlangcompiler.commons.errors;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import java.util.List;

public class SyntaxErrorListener extends BaseErrorListener {
    private final List<String> syntaxErrors;

    public SyntaxErrorListener(List<String> syntaxErrors) {
        this.syntaxErrors = syntaxErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        // Adiciona os erros à lista em vez de interromper
        syntaxErrors.add("Erro na linha " + line + ":" + charPositionInLine + " - " + msg);
    }
}
