package AST.expression;

import AST.hook.Hook;

public class HookExpression extends Expression{
    private Hook hookDeclaration;

    public HookExpression(Hook hookDeclaration) {
        this.hookDeclaration = hookDeclaration;
    }

    public Hook getHookDeclaration() {
        return hookDeclaration;
    }

    public void setHookDeclaration(Hook hookDeclaration) {
        this.hookDeclaration = hookDeclaration;
    }

    @Override
    public String toString() {
        return "HookExpression: " + hookDeclaration.toString();
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
        return hookDeclaration != null ? hookDeclaration.convertToJs() : "";
    }
}
