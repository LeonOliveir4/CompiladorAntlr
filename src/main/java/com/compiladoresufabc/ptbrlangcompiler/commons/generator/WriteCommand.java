package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;
import com.compiladoresufabc.ptbrlangcompiler.domains.Types;

public class WriteCommand extends Command {

	private String variableName;
	private Types variableType;

	public WriteCommand() {
		super();
	}

	public WriteCommand(String variableName, Types variableType) {
		this.variableName = variableName;
		this.variableType = variableType;
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
	public Types getVariableType() {
		return variableType;
	}

	public void setVariableType(Types variableType) {
		this.variableType = variableType;
	}

	@Override
	public String generateCode(LanguageType language, int indentLevel) {
		return switch (language) {
		case JAVA -> generateJavaCode();
		case C -> generateCCode();
		case PYTHON -> generatePythonCode();
		default -> null;
		};
	}

	private String generateJavaCode() {
		return "System.out.println(" + variableName + ");\n";
	}

	private String generateCCode() {
	    switch (variableType) {
	        case TEXT:
	            return "printf(\"%s\\n\", " + variableName + ");\n";
	        case BOOL:
	            return "printf(\"%s\\n\", " + "(" + variableName + " ? \"true\" : \"false\")" + ");\n";
	        case NUMBER:
	            return "printf(\"%.2f\\n\", " + variableName + ");\n";
	        default:
	            return "printf(\"%s\\n\", " + variableName + ");\n";
	    }
	}

	private String generatePythonCode() {
		return "print(" + variableName + ")\n";
	}
}
