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
	public String generateCode(LanguageType language) {
		return switch (language) {
			case JAVA -> generateJavaCode();
			case C -> generateCCode();
			case PYTHON -> generatePythonCode();
			default -> null;
		};
	}

	private String generateJavaCode() {
		StringBuilder builder = new StringBuilder();
		builder.append(var.getId() + " = ");
		switch (var.getType()) {
			case Types.NUMBER -> builder.append("_scTrx.nextInt();");
			case Types.TEXT -> builder.append("_scTrx.nextLine();");
			case Types.BOOL -> builder.append("_scTrx.nextBoolean();");
			default -> throw new IllegalArgumentException("Unexpected value: " + var.getType());
		}
		builder.append("\n");
		return builder.toString();
	}

	private String generateCCode() {
		StringBuilder builder = new StringBuilder();
		if (var.getType().equals(Types.BOOL)) {
		    builder.append("char input[6];\n")
		           .append("scanf(\"%s\", input);\n")
		           .append("if (strcmp(input, \"true\") == 0) {\n")
		           .append("    c = true;\n")
		           .append("} else if (strcmp(input, \"false\") == 0) {\n")
		           .append("    c = false;\n")
		           .append("} else {\n")
		           .append("    printf(\"Invalid boolean value\\n\");\n")
		           .append("    exit(1);\n")
		           .append("}\n");
		} else {
		    builder.append("scanf(\"%")
		           .append(var.getType().equals(Types.NUMBER) ? "d" : "s")
		           .append("\", &")
		           .append(var.getId())
		           .append(");\n");
		}
		return builder.toString();
	}

	private String generatePythonCode() {
		StringBuilder builder = new StringBuilder();

		if (var.getType().equals(Types.BOOL)) {
		    builder.append(var.getId()).append(" = ")
		           .append("input().strip().lower()\n")
		           .append("\tif ").append(var.getId()).append(" == 'true':\n")
		           .append("\t\t").append(var.getId()).append(" = True\n")
		           .append("\telif ").append(var.getId()).append(" == 'false':\n")
		           .append("\t\t").append(var.getId()).append(" = False\n")
		           .append("\telse:\n")
		           .append("\t\traise ValueError('Invalid boolean value')\n");
		} else {
		    builder.append(var.getId()).append(" = ")
		           .append(var.getType().equals(Types.NUMBER) ? "int(input())" : "input()")
		           .append("\n");
		}

		return builder.toString();
	}
}
