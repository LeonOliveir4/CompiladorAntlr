package com.compiladoresufabc.ptbrlangcompiler.runtime;

public class UnaryExpression extends AbstractExpression {
    private Double value;

    public UnaryExpression() {
        super();
    }

    public UnaryExpression(Double value) {
        super();
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return value;
    }

    @Override
    public String toJSON() {
        return "{\"value\": " + this.value + "}";
    }
}
