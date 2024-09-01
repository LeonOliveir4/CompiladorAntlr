package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import java.util.HashMap;
import java.util.List;

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

	public String generateCode() {
		StringBuilder builder = new StringBuilder();
		builder.append("import java.util.Scanner;\n");
		builder.append("public class " + name + "{ \n");
		builder.append("    public static void main(String args[]) { \n");
		builder.append("	Scanner _scTrx = new Scanner(System.in);\n");
		for (String varId : symbolTable.keySet()) {
			Var var = symbolTable.get(varId);
			if (var.getType() == Types.NUMBER) {
				builder.append("    int ");
			} else {
				builder.append("    String ");
			}
			builder.append(var.getId() + ";\n");
		}

		for (Command cmdValue : commandList) {
			builder.append(cmdValue.generateCode());
		}
		builder.append("   }\n");
		builder.append("}");
		return builder.toString();
	}
}
