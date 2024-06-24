package AST.hook;

import AST.Space;
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

    @Override
    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        return "";
    }

    @Override
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        Space.isInsideUseEffect = true;
        jsBuilder.append("addEventListener('input', (event) => ");
        if (arrowFunction.getBlockStatement() != null) {
            jsBuilder.append(arrowFunction.getBlockStatement().convertToJs());
        }
        if (arrowFunction.getExpressionPar() != null) {
            jsBuilder.append(arrowFunction.getExpressionPar().convertToJs());
        }
        if (!jsBuilder.isEmpty()) {
            jsBuilder.deleteCharAt(jsBuilder.length() - 1);
        }
        jsBuilder.append("\t".repeat(Space.currentValue)).append("App();\n");
        jsBuilder.append("\t".repeat(Space.currentValue)).append("});\n");
        Space.isInsideUseEffect = false;
        return jsBuilder.toString();
    }
}
