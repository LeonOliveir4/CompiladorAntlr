package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;

import java.util.List;

public class IfCommand extends Command {

	private String expression;
	private List<Command> trueList;
	private List<Command> falseList;

	public IfCommand() {
		super();
	}

	public IfCommand(String expression, List<Command> trueList, List<Command> falseList) {
		super();
		this.expression = expression;
		this.trueList = trueList;
		this.falseList = falseList;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getTrueList() {
		return trueList;
	}

	public void setTrueList(List<Command> trueList) {
		this.trueList = trueList;
	}

	public List<Command> getFalseList() {
		return falseList;
	}

	public void setFalseList(List<Command> falseList) {
		this.falseList = falseList;
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
		builder.append("if (").append(expression).append(") {\n");
		for (Command cmdValue : trueList) {
			builder.append("\t\t\t").append(cmdValue.generateCode(LanguageType.JAVA));
		}
		builder.append("\t\t}\n");

		if (!falseList.isEmpty()) {
			builder.append("\t\telse {\n");
			for (Command cmdValue : falseList) {
				builder.append("\t\t\t").append(cmdValue.generateCode(LanguageType.JAVA));
			}
			builder.append("\t\t}\n");
		}

		return builder.toString();
	}

	private String generateCCode() {
		StringBuilder builder = new StringBuilder();
		builder.append("if (").append(expression).append(") {\n");
		for (Command cmdValue : trueList) {
			builder.append("\t").append(cmdValue.generateCode(LanguageType.C)).append("\n");
		}
		builder.append("}\n");

		if (!falseList.isEmpty()) {
			builder.append("else {\n");
			for (Command cmdValue : falseList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.C)).append("\n");
			}
			builder.append("}\n");
		}

		return builder.toString();
	}

	private String generatePythonCode() {
		StringBuilder builder = new StringBuilder();
		builder.append("if ").append(expression).append(":\n");
		for (Command cmdValue : trueList) {
			builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON)).append("\n");
		}

		if (!falseList.isEmpty()) {
			builder.append("else:\n");
			for (Command cmdValue : falseList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON)).append("\n");
			}
		}

		return builder.toString();
	}
}
