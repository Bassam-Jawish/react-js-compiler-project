package AST.expression;

import AST.statement.ArrayAccess;
import AST.statement.FunctionCall;

public class FunctionCallExpression extends Expression{
    private FunctionCall functionCall;

    public FunctionCallExpression() {

    }

    public FunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(FunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    @Override
    public String toString() {
        return "FunctionCallExpression: " + functionCall.toString();
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
        return functionCall != null ? functionCall.convertToJs() : "";
    }
}
