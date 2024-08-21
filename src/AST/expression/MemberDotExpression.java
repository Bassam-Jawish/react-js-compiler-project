package AST.expression;

import AST.Space;
import ErrorHandling.SemanticCheck;


public class MemberDotExpression extends Expression{
    private Expression leftExpression;
    private Expression rightExpression;
    private boolean isOptionalChaining;

    public MemberDotExpression() {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.isOptionalChaining = isOptionalChaining;
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

    public boolean isOptionalChaining() {
        return isOptionalChaining;
    }

    public void setOptionalChaining(boolean optionalChaining) {
        isOptionalChaining = optionalChaining;
    }

    @Override
    public String toString() {
        String operator = isOptionalChaining ? "?." : ".";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("MemberDotExpression: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Left = ").append(leftExpression.toString()).append(", Operator = ").append(operator).append(" , Right = ").append(rightExpression.toString()).append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }

    public void performSemanticChecks(SemanticCheck semanticCheck, int scopeId, int line) {
        semanticCheck.checkIfVariableUsedNotDefined(rightExpression.toString(), scopeId, line);
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
        StringBuilder stringBuilder = new StringBuilder();
        String operator = isOptionalChaining ? "?." : ".";
        stringBuilder.append(leftExpression.convertToJs() + operator + rightExpression.convertToJs());
        return stringBuilder.toString();
    }
}
