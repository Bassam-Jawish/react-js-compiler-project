package AST.iteration;

import AST.Space;
import AST.statement.Statement;

import AST.expression.Expression;

public class WhileStatement extends IterationStatement {
    private  Expression expression;
    private Statement statement;

    public WhileStatement() {
        this.expression = expression;
        this.statement = statement;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("While Statement: {\n");
        Space.currentValue++;

        stringBuilder.append("\t".repeat(Space.currentValue)).append("Condition= ").append(expression.toString()).append(",\n");
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Statement= ").append(statement.toString()).append(",\n");

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }

    @Override
    public String convertToHtml() {
        return "";
    }

    @Override
    public String convertToCss() {
        return "";
    }

    @Override
    public String convertToJs() {
        return "";
    }
}
