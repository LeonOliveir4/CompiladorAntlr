package com.compiladoresufabc.ptbrlangcompiler.commons.enums;

public enum LanguageType {
    JAVA("java"),
    C("c"),
    PYTHON("python");

    private final String language;

    LanguageType(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public String getLanguageExtension() {
        return switch (this) {
            case JAVA -> ".java";
            case C -> ".c";
            case PYTHON -> ".py";
            default -> throw new IllegalArgumentException("Linguagem não suportada: " + language);
        };
    }

    public static LanguageType fromString(String language) {
        for (LanguageType type : LanguageType.values()) {
            if (type.language.equalsIgnoreCase(language)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Linguagem não suportada: " + language);
    }
}