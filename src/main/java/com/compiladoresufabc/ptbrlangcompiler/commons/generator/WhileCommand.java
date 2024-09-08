package com.compiladoresufabc.ptbrlangcompiler.commons.generator;

import com.compiladoresufabc.ptbrlangcompiler.commons.enums.Constants;
import com.compiladoresufabc.ptbrlangcompiler.commons.enums.LanguageType;

import java.util.List;

public class WhileCommand extends Command {

    private List<String> expressions;
    private List<Command> trueList;
    private boolean isReverse;

    public WhileCommand() {
        super();
    }

    public WhileCommand(boolean isReverse) {
        super();
        this.isReverse = isReverse;
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
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
            for (Command cmdValue : trueList) {
                builder.append("\t\t\t").append(cmdValue.generateCode(LanguageType.JAVA));
            }
            builder.append("\t\t} while (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "&&").replace("OR", "||");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "true");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "false");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append(");\n");
        } else {
            builder.append("while (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "&&").replace("OR", "||");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "true");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "false");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append(") {\n");
            for (Command cmdValue : trueList) {
                builder.append("\t\t\t").append(cmdValue.generateCode(LanguageType.JAVA));
            }
            builder.append("\t\t}\n");
        }

        return builder.toString();
    }

    private String generateCCode() {
        StringBuilder builder = new StringBuilder();
        if (isReverse) {
            builder.append("do {\n");
            for (Command cmdValue : trueList) {
                builder.append("\t").append(cmdValue.generateCode(LanguageType.C)).append("\n");
            }
            builder.append("} while (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "&&").replace("OR", "||");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "true");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "false");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append(");\n");
        } else {
            builder.append("while (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "&&").replace("OR", "||");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "true");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "false");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append(") {\n");
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
            for (Command cmdValue : trueList) {
                builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON));
            }
            builder.append("\n\tif not (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "and").replace("OR", "or");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "True");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "False");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append("):\n\t break\n");
        } else {
            builder.append("while (");

            for (int i = 0; i < expressions.size(); i++) {
                String expressionPart = expressions.get(i).replace("AND", "and").replace("OR", "or");
                if (Constants.VERDADEIRO.getValue().equalsIgnoreCase(expressionPart)) {
                	expressionPart = expressionPart.replace(expressionPart, "True");
    			} else if (Constants.FALSO.getValue().equalsIgnoreCase(expressionPart)) {
    				expressionPart = expressionPart.replace(expressionPart, "False");
    			}
                builder.append(expressionPart);
                if (i < expressions.size() - 1) {
                    builder.append(" ");
                }
            }

            builder.append("):\n");
            for (Command cmdValue : trueList) {
                builder.append("\t").append(cmdValue.generateCode(LanguageType.PYTHON));
            }
        }

        return builder.toString();
    }
}
