package com.compiladoresufabc.ptbrlangcompiler.commons.enums;

public enum Constants {

	VERDADEIRO("Verdadeiro"), FALSO("Falso");

	private String booleano;

	private Constants(String booleano) {
		this.booleano = booleano;
	}

	public String getValue() {
		return this.booleano;
	}
}
