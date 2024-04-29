package AST.iteration;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;

public class DoStatement extends IterationStatement {
    private Statement statement;
    private Expression expression;

    public DoStatement() {
        this.statement = statement;
        this.expression = expression;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Do Statement: {\n");
        Space.currentValue++;

        stringBuilder.append("\t".repeat(Space.currentValue)).append("Statement= ").append(statement.toString()).append(",\n");
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Condition= ").append(expression.toString()).append(",\n");

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }
}
