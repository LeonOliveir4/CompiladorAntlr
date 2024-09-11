package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;
import com.compiladoresufabc.ptbrlangcompiler.domains.Types;
import com.compiladoresufabc.ptbrlangcompiler.domains.Var;

public class ReadCommand extends Command {

	private Var var;

	public ReadCommand() {
		super();
	}

	public ReadCommand(Var var) {
		super();
		this.var = var;
	}

	public Var getVar() {
		return var;
	}

	public void setVar(Var var) {
		this.var = var;
	}

	@Override
	public String generateCode(LanguageType language, int indentLevel) {
		return switch (language) {
		case JAVA -> generateJavaCode();
		case C -> generateCCode(indentLevel);
		case PYTHON -> generatePythonCode(indentLevel);
		default -> null;
		};
	}

	private String generateJavaCode() {
		StringBuilder builder = new StringBuilder();
		builder.append(var.getId() + " = ");
		switch (var.getType()) {
		case Types.NUMBER -> {
			builder.append("_scTrx.nextDouble();\n");
			builder.append("\t\t_scTrx.nextLine();");
		}
		case Types.TEXT -> builder.append("_scTrx.nextLine();");
		case Types.BOOL -> builder.append("_scTrx.nextBoolean();");
		default -> throw new IllegalArgumentException("Unexpected value: " + var.getType());
		}
		builder.append("\n");
		return builder.toString();
	}

	private String generateCCode(int indentLevel) {
		StringBuilder builder = new StringBuilder();
	    String indent = "\t".repeat(indentLevel);  // Nível de indentação
	    if (var.getType().equals(Types.BOOL)) {
	        builder.append(indent).append("char input[6];\n")
	               .append(indent).append("\tscanf(\"%5s\", input);\n")
	               .append(indent).append("\tif (strcmp(input, \"true\") == 0) {\n")
	               .append(indent).append("\t\t").append(var.getId()).append(" = true;\n")
	               .append(indent).append("\t} else if (strcmp(input, \"false\") == 0) {\n")
	               .append(indent).append("\t\t").append(var.getId()).append(" = false;\n")
	               .append(indent).append("\t} else {\n")
	               .append(indent).append("\t\tprintf(\"Invalid boolean value\\n\");\n")
	               .append(indent).append("\t\texit(1);\n")
	               .append(indent).append("\t}\n");

	    } else if (var.getType().equals(Types.TEXT)) {
	        builder.append(indent).append("scanf(\"%100s\", ").append(var.getId()).append(");\n");

	    } else {
	        builder.append(indent).append("scanf(\"%")
	               .append(var.getType().equals(Types.NUMBER) ? "f" : "s")
	               .append("\", &").append(var.getId()).append(");\n");
	    }

	    return builder.toString();
	}

	private String generatePythonCode(int indentLevel) {
		StringBuilder builder = new StringBuilder();
		String indent = "\t".repeat(indentLevel); 

		if (var.getType().equals(Types.BOOL)) {
			builder.append(var.getId()).append(" = ").append("input().strip().lower()\n")
            .append(indent).append("if ").append(var.getId()).append(" == 'true':\n")
            .append(indent).append("\t").append(var.getId()).append(" = True\n")
            .append(indent).append("elif ").append(var.getId()).append(" == 'false':\n")
            .append(indent).append("\t").append(var.getId()).append(" = False\n")
            .append(indent).append("else:\n")
            .append(indent).append("\traise ValueError('Invalid boolean value')\n");
		} else {
			builder.append(var.getId()).append(" = ")
					.append(var.getType().equals(Types.NUMBER) ? "int(input())" : "input()").append("\n");
		}

		return builder.toString();
	}
}
