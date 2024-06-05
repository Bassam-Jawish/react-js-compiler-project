package AST.expression;

import AST.function.FunctionDeclaration;

public class FunctionExpression extends Expression{
    private FunctionDeclaration functionDeclaration;

    public FunctionExpression() {

    }

    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }

    public void setFunctionDeclaration(FunctionDeclaration functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }

    @Override
    public String toString() {
        return "FunctionExpression: " + functionDeclaration.toString();
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
        return functionDeclaration != null ? functionDeclaration.convertToJs() : "";
    }
}
