package AST.expression;

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
}
