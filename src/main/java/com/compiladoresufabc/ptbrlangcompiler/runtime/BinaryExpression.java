package com.compiladoresufabc.ptbrlangcompiler.runtime;

public class BinaryExpression extends AbstractExpression {
    private char operator;
    private  AbstractExpression left;
    private  AbstractExpression right;

    public BinaryExpression(char operator, AbstractExpression left, AbstractExpression right) {
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public BinaryExpression(char operator) {
        super();
        this.operator = operator;
    }

    public BinaryExpression() {
        super();
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public AbstractExpression getLeft() {
        return left;
    }

    public void setLeft(AbstractExpression left) {
        this.left = left;
    }

    public AbstractExpression getRight() {
        return right;
    }

    public void setRight(AbstractExpression right) {
        this.right = right;
    }

    @Override
    public Double evaluate() {
        return switch (this.operator) {
            case '+' -> this.left.evaluate() + this.right.evaluate();
            case '-' -> this.left.evaluate() - this.right.evaluate();
            case '*' -> this.left.evaluate() * this.right.evaluate();
            case '/' -> this.left.evaluate() / this.right.evaluate();
            default -> 0.0;
        };
    }

    @Override
    public String toJSON() {
        return "{" +
                "\"operator\": \"" + this.operator + "\", " +
                "\"left\": " + this.left.toJSON() + ", " +
                "\"right\": " + this.right.toJSON() +
                "}";
    }
}
