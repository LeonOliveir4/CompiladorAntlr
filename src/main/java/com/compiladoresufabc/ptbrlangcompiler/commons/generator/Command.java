package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;

public abstract class Command {

	public abstract String generateCode(LanguageType language);
}
