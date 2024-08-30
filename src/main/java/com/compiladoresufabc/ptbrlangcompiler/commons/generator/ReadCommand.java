package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

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
	public String generateCode() {
		return var.getId() + " = " + (var.getType().equals(Types.NUMBER) ? "_scTrx.nextInt();" : "_scTrx.nextLine();")
				+ "\n";
	}

}
