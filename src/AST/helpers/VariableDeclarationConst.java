package AST.helpers;

import AST.Space;
import AST.expression.Expression;

public class VariableDeclarationConst {

    private Expression expression;
    private VariableType variableType;

    public VariableDeclarationConst() {
        this.expression = expression;
        variableType = variableType;
    }


    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public AST.helpers.VariableType getVariableType() {
        return variableType;
    }

    public void setVariableType(AST.helpers.VariableType variableType) {
        this.variableType = variableType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variable Const Declaration: {\n");

        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Variable Type (Assignable) = ").append(variableType.toString()).append(",\n");
        Space.currentValue--;


        if (expression != null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Value = ").append(expression.toString()).append(",\n");
            Space.currentValue--;
        }
        stringBuilder.append("\t".repeat(Space.currentValue)).append("},\n");
        return stringBuilder.toString();
    }
}
