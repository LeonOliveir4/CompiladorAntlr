package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;

import java.util.List;

public class WhileCommand extends Command {

	private String expression;
	private List<Command> trueList;
	private boolean isReverse;

	public WhileCommand() {
		super();
	}

	public WhileCommand(boolean isReverse) {
		super();
		this.isReverse = isReverse;
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
		if (isReverse) {
			builder.append("do {\n");
			for (Command cmdValue: trueList) {
				builder.append("\t\t\t" + cmdValue.generateCode(LanguageType.JAVA));
			}
			builder.append("\t\t} while (" + expression + ");\n");
		} else {
			builder.append("while (" + expression + ") {\n");
			for (Command cmdValue : trueList) {
				builder.append("\t\t\t" + cmdValue.generateCode(LanguageType.JAVA));
			}

			builder.append("\t\t}\n");
		}

		return builder.toString();
	}

	private String generateCCode() {
		StringBuilder builder = new StringBuilder();
		if (isReverse) {
			builder.append("do {\n");
			for (Command cmdValue: trueList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.C)).append("\n");
			}
			builder.append("} while (").append(expression).append(");\n");
		} else {
			builder.append("while (").append(expression).append(") {\n");
			for (Command cmdValue : trueList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.C)).append("\n");
			}
			builder.append("}\n");
		}

		return builder.toString();
	}

	private String generatePythonCode() {
		StringBuilder builder = new StringBuilder();
		if (isReverse) {
			builder.append("while True:\n");
			for (Command cmdValue: trueList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON));
			}
			builder.append("\n\tif not (").append(expression).append("):\n\t break\n");
		} else {
			builder.append("while (").append(expression).append("):\n");
			for (Command cmdValue : trueList) {
				builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON));
			}
		}

		return builder.toString();
	}
}
