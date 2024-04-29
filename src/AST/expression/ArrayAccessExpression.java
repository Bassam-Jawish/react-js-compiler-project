package AST.expression;

import AST.statement.ArrayAccess;

public class ArrayAccessExpression extends Expression{
    private ArrayAccess arrayAccess;

    public ArrayAccessExpression() {

    }

    public ArrayAccess getArrayDeclaration() {
        return arrayAccess;
    }

    public void setArrayDeclaration(ArrayAccess arrayAccess) {
        this.arrayAccess = arrayAccess;
    }

    @Override
    public String toString() {
        return "ArrayAccessExpression: " + arrayAccess.toString();
    }
}
