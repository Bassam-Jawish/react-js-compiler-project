package AST.expression;

import AST.Space;

public class LogicalOrExpression extends Expression{
    private Expression leftExpression;
    private Expression rightExpression;

    public LogicalOrExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(Expression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(Expression rightExpression) {
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("LogicalOrExpression: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Left = ").append(leftExpression.toString()).append(", Operator = ||").append(" , Right = ").append(rightExpression.toString()).append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }
}
