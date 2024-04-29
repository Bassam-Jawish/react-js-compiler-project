package AST.expression;

public class NotExpression extends Expression{
    private Expression expression;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "NotExpression: !" + expression.toString();
    }
}
