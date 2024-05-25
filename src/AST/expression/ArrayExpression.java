package AST.expression;


import AST.helpers.ArrayDeclaration;

public class ArrayExpression extends Expression{
    private ArrayDeclaration arrayDeclaration;

    public ArrayExpression() {

    }

    public ArrayDeclaration getArrayDeclaration() {
        return arrayDeclaration;
    }

    public void setArrayDeclaration(ArrayDeclaration ArrayDeclaration) {
        this.arrayDeclaration = ArrayDeclaration;
    }

    @Override
    public String toString() {
        return "ArrayExpression: " + arrayDeclaration.toString();
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
        return "";
    }
}
