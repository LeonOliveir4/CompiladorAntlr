package com.compiladoresufabc.ptbrlangcompiler.runtime;

public class UnaryExpression extends AbstractExpression {
    private Double numericValue;
    private String stringValue;
    private Boolean booleanValue;

    public UnaryExpression() {
        super();
    }

    public UnaryExpression(Double value) {
        super();
        this.numericValue = value;
    }

    public UnaryExpression(String value) {
        super();
        this.stringValue = value;
    }

    public UnaryExpression(boolean value) {
        super();
        this.booleanValue = value;
    }

    public Double getNumericValue() {
        return this.numericValue;
    }

    public void setNumericValue(Double value) {
        this.numericValue = value;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public void setStringValue(String value) {
        this.stringValue = value;
    }

    public Boolean getBooleanValue() {
        return this.booleanValue;
    }

    public void setBooleanValue(Boolean value) {
        this.booleanValue = value;
    }

    @Override
    public double evaluate() {
        if (numericValue != null) {
            return numericValue;
        } else if (booleanValue != null) {
            return booleanValue ? 1.0 : 0.0;
        } else {
            throw new UnsupportedOperationException("Cannot evaluate a non-numeric expression");
        }
    }

    @Override
    public String toJSON() {
        if (numericValue != null) {
            return "{\"value\": " + this.numericValue + "}";
        } else if (stringValue != null) {
            return "{\"value\": \"" + this.stringValue + "\"}";
        } else if (booleanValue != null) {
            return "{\"value\": " + this.booleanValue + "}";
        } else {
            return "{\"value\": null}";
        }
    }
}
