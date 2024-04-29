package AST.expression;

import AST.helpers.ObjectDeclaration;


public class ObjectExpression extends Expression{
    private ObjectDeclaration objectDeclaration;

    public ObjectExpression() {

    }

    public ObjectDeclaration getObjectDeclaration() {
        return objectDeclaration;
    }

    public void setObjectDeclaration(ObjectDeclaration ObjectDeclaration) {
        this.objectDeclaration = ObjectDeclaration;
    }

    @Override
    public String toString() {
        return "ObjectExpression: " + objectDeclaration.toString();
    }
}
