package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

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
	public String generateCode() {
		return "System.out.println(" + content + ");\n";
	}

}
