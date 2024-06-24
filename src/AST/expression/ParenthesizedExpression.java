package AST.expression;

import AST.Space;

public class ParenthesizedExpression extends Expression{
    private Expression expression;

    public ParenthesizedExpression() {
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ParenthesizedExpression: (" + expression.toString() + ")";
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
        String str = expression.toString().substring(0,4);
        if (Space.isInsideReturn || str.equals("Html")) {
            jsBuilder.append("`");
            Space.isInsideReturn = true;
        }
        else {
            jsBuilder.append("(");
        }
        jsBuilder.append(expression.convertToJs());
        if (Space.isInsideReturn || str.equals("Html")) {
            Space.isInsideReturn = false;
            jsBuilder.append("`");
        }
        else {
            jsBuilder.append(")");
        }
        return jsBuilder.toString();
    }
}
