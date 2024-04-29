package AST.expression;

import AST.pureReact.FunctionCreateElement;

public class FunctionCreateElementExpression extends Expression{
    private FunctionCreateElement functionCreateElement;

    public FunctionCreateElementExpression() {

    }

    public FunctionCreateElement getFunctionCreateElement() {
        return functionCreateElement;
    }

    public void setFunctionCreateElement(FunctionCreateElement functionCreateElement) {
        this.functionCreateElement = functionCreateElement;
    }

    @Override
    public String toString() {
        return "FunctionCreateElementExpression: " + functionCreateElement.toString();
    }
}
