package AST.function;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;

import java.util.List;

public class NormalFunction extends FunctionDeclaration {

    private String functionName;
    private List<Expression> expression;
    private List<Statement> statements;

    public NormalFunction() {

    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<Expression> getExpression() {
        return expression;
    }

    public void setExpression(List<Expression> expression) {
        this.expression = expression;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Normal Function Declaration: {\n");
        Space.currentValue++;

        stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Name: ").append(functionName.toString()).append(",\n");
        if (!expression.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Parameters: {\n");
            Space.currentValue++;
            for (Expression expression1 : expression) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(expression1.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Parameters: {}\n");
        }

        if (!statements.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Body: {\n");
            Space.currentValue++;
            for (Statement statement : statements) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(statement.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        else{
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Body: {}");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("\n}");

        return stringBuilder.toString();
    }
}
