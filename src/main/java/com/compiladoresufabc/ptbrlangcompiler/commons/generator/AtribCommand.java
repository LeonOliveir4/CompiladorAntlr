package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.domains.Var;

public class AtribCommand extends Command {

	private Var var;
	private String exprString;
	private String strOp;

	public AtribCommand() {
		super();
	}

	public AtribCommand(Var var) {
		super();
		this.var = var;
	}

	public Var getVar() {
		return var;
	}

	public void setVar(Var var) {
		this.var = var;
	}

	public String getExprString() {
		return exprString;
	}

	public void setExprString(String exprString) {
		this.exprString = exprString;
	}

	public String getStrOp() {
		return strOp;
	}

	public void setStrOp(String strOp) {
		this.strOp = strOp;
	}

	@Override
	public String generateCode() {
		StringBuilder atribBuild = new StringBuilder();
		atribBuild.append(var.getId() + " " + strOp  + " ");
		if (null != exprString) {
			atribBuild.append(exprString);
		}
		atribBuild.append(";");

		return atribBuild.toString();
	}

}
