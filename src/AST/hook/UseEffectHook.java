package AST.hook;

import AST.function.ArrowFunction;
import AST.helpers.ArrayDeclaration;

public class UseEffectHook extends Hook{
    private ArrowFunction arrowFunction;
    private ArrayDeclaration arrayDeclaration;

    public UseEffectHook() {

    }

    public ArrowFunction getArrowFunction() {
        return arrowFunction;
    }

    public void setArrowFunction(ArrowFunction arrowFunction) {
        this.arrowFunction = arrowFunction;
    }

    public ArrayDeclaration getArrayDeclaration() {
        return arrayDeclaration;
    }

    public void setArrayDeclaration(ArrayDeclaration arrayDeclaration) {
        this.arrayDeclaration = arrayDeclaration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UseEffectHook: USE_EFFECT(");
        stringBuilder.append(arrowFunction.toString());
        if (arrayDeclaration != null) {
            stringBuilder.append(", ").append(arrayDeclaration.toString());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
