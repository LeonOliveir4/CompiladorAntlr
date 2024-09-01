package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

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
	public String generateCode() {
		StringBuilder builder = new StringBuilder();
		if (isReverse) {
			builder.append("do {");
			for (Command cmdValue: trueList) {
				builder.append(cmdValue.generateCode());
			}
			builder.append("} while (" + expression + ");");
		} else {
			builder.append("while (" + expression + ") {");
			for (Command cmdValue : trueList) {
				builder.append(cmdValue.generateCode());
			}

			builder.append("}");
		}
		
		return builder.toString();
	}

}
