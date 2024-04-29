package AST.expression;

public class ParenthesizedExpression extends Expression{
    private Expression expression;

    public ParenthesizedExpression() {
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ParenthesizedExpression: (" + expression.toString() + ")";
    }
}
