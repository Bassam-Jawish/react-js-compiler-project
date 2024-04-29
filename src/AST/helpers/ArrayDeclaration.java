package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;

import java.util.List;

public class ArrayDeclaration extends VariableType{

    private List<Expression> expressions;

    public ArrayDeclaration() {

    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Array Declaration: {\n");
        Space.currentValue++;
        for (Expression expression : expressions) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
        }
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }
}
