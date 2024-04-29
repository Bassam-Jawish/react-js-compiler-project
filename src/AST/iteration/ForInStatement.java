package AST.iteration;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;
import AST.statement.VariableStatement;

import java.util.List;

public class ForInStatement extends IterationStatement {
    private List<Expression> expressions;

    private VariableStatement variableStatement;

    private Statement statement;

    public ForInStatement() {
        this.expressions = expressions;
        this.variableStatement = variableStatement;
        this.statement = statement;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public VariableStatement getVariableStatement() {
        return variableStatement;
    }

    public void setVariableStatement(VariableStatement variableStatement) {
        this.variableStatement = variableStatement;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("For In Statement: {\n");
        Space.currentValue++;

        if (variableStatement != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(variableStatement.toString()).append(",\n");
        }

        if (!expressions.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Expressions: [").append("\n");
            Space.currentValue++;
            for (Expression expression : expressions) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("],\n");
        }

        stringBuilder.append("\t".repeat(Space.currentValue)).append("Statement= ").append(statement.toString()).append(",\n");

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }
}
