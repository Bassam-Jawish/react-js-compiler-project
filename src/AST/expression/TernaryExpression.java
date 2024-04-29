package AST.expression;

import AST.Space;

public class TernaryExpression extends Expression{
    private Expression condition;
    private Expression trueExpression;
    private Expression falseExpression;

    public TernaryExpression(Expression condition, Expression trueExpression, Expression falseExpression) {
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Expression getTrueExpression() {
        return trueExpression;
    }

    public void setTrueExpression(Expression trueExpression) {
        this.trueExpression = trueExpression;
    }

    public Expression getFalseExpression() {
        return falseExpression;
    }

    public void setFalseExpression(Expression falseExpression) {
        this.falseExpression = falseExpression;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("TernaryExpression: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Condition = ").append(condition.toString()).append(", Operator = ?").append(" , TrueExpression = ").append(trueExpression.toString()).append(", Operator = :").append(" , FalseExpression = ").append(falseExpression.toString()).append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }


}
