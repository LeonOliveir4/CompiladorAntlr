package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import java.util.HashMap;
import java.util.List;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;
import com.compiladoresufabc.ptbrlangcompiler.domains.Types;
import com.compiladoresufabc.ptbrlangcompiler.domains.Var;

public class Program {

	private String name;
	private HashMap<String, Var> symbolTable;
	private List<Command> commandList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Var> getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(HashMap<String, Var> symbolTable) {
		this.symbolTable = symbolTable;
	}

	public List<Command> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}

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
		builder.append("import java.util.Scanner;\n");
		builder.append("public class " + name + " {\n");
		builder.append("\tpublic static void main(String args[]) {\n");
		builder.append("\t\tScanner _scTrx = new Scanner(System.in);\n");
		for (String varId : symbolTable.keySet()) {
			Var var = symbolTable.get(varId);
			if (var.getType() == Types.NUMBER) {
				builder.append("\t\tint ");
			} else if (var.getType() == Types.TEXT) {
				builder.append("\t\tString ");
			} else if (var.getType() == Types.BOOL) {
				builder.append("\t\tboolean ");
			}
			builder.append(var.getId() + ";\n");
		}

		for (Command cmdValue : commandList) {
			builder.append("\t\t").append(cmdValue.generateCode(LanguageType.JAVA));
		}
		builder.append("\t\t_scTrx.close();\n");
		builder.append("\t}\n");
		builder.append("}");
		return builder.toString();
	}

	private String generateCCode() {
		StringBuilder builder = new StringBuilder();
		builder.append("#include <stdio.h>\n");
		builder.append("#include <stdlib.h>\n");
		builder.append("#include <stdbool.h>\n");
		builder.append("#include <string.h>\n");
		builder.append("int main() { \n");
		for (String varId : symbolTable.keySet()) {
			Var var = symbolTable.get(varId);
			if (var.getType() == Types.NUMBER) {
				builder.append("    int ");
			} else if (var.getType() == Types.TEXT) {
				builder.append("    char ");
			} else if (var.getType() == Types.BOOL) {
				builder.append("   bool ");
			}
			builder.append(var.getId() + ";\n");
		}

		for (Command cmdValue : commandList) {
			builder.append(cmdValue.generateCode(LanguageType.C));
		}
		builder.append("   return 0;\n");
		builder.append("}\n");
		return builder.toString();
	}

	private String generatePythonCode() {
		StringBuilder builder = new StringBuilder();
		for (String varId : symbolTable.keySet()) {
			Var var = symbolTable.get(varId);
			if (var.getType() == Types.NUMBER) {
				builder.append(var.getId()).append(": int = None\n");
			} else if (var.getType() == Types.TEXT) {
				builder.append(var.getId()).append(": str = None\n");
			} else if (var.getType() == Types.BOOL) {
				builder.append(var.getId()).append(": bool = None\n");
			}
		}

		for (Command cmdValue : commandList) {
			builder.append(cmdValue.generateCode(LanguageType.PYTHON)).append("\n");
		}
		return builder.toString();
	}
}
