package AST.expression;

import AST.Space;
import AST.function.Value;
import AST.helpers.VariableType;

public class ValueExpression extends Expression{
    private Value valueDeclaration;

    public ValueExpression() {

    }

    public Value getValueDeclaration() {
        return valueDeclaration;
    }

    public void setValueDeclaration(Value valueDeclaration) {
        this.valueDeclaration = valueDeclaration;
    }

    @Override
    public String toString() {
        return "ValueExpression: " + valueDeclaration.toString();
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
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append(valueDeclaration.convertToJs());
        return jsBuilder.toString();
    }
}
