package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;

public class WriteCommand extends Command {

	private String content;

	public WriteCommand() {
		super();
	}

	public WriteCommand(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String generateCode(LanguageType language) {
		return switch (language) {
			case JAVA -> generateJavaCode();
			case C -> generateCCode();
			case PYTHON -> generatePythonCode();
			default -> null;
		};
	}

	private String generateJavaCode() {
		return "System.out.println(" + content + ");\n";
	}

	private String generateCCode() {
		// TODO: Precisamos corrigir print em C de acordo tipos, assim está errado.
		// Supondo que o conteúdo seja uma string literal ou uma variável
		if (content.startsWith("\"") && content.endsWith("\"")) {
			// Conteúdo é uma string literal
			return "printf(\"%s\\n\", " + content + ");\n";
		} else {
			// Conteúdo é uma variável, assumindo que seja um inteiro
			return "printf(\"%d\\n\", " + content + ");\n";
		}
	}

	private String generatePythonCode() {
		return "print(" + content + ")\n";
	}
}
