package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;

public class ObjectProperty {

    private String identifier;
    private Expression expression;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    public ObjectProperty() {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Object Property: {");
        if (identifier != null) {
            stringBuilder.append(identifier).append(" : ").append(expression);
        }
        else {
            stringBuilder.append(expression);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        if (identifier != null) {
            jsBuilder.append(identifier).append(": ").append(expression.convertToJs());
        } else {
            jsBuilder.append(expression.convertToJs());
        }
        return jsBuilder.toString();
    }

}
