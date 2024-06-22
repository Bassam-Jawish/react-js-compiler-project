package AST.expression;

import AST.Space;
import AST.jsx.HtmlBody;
import AST.statement.Statement;

public class ReturnExpression extends Expression {
    private Expression expression;
    private HtmlBody htmlBody;

    public ReturnExpression() {
        this.expression = expression;
        this.htmlBody = null;
    }

    public ReturnExpression(HtmlBody htmlBody) {
        this.htmlBody = htmlBody;
        this.expression = null;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public HtmlBody getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(HtmlBody htmlBody) {
        this.htmlBody = htmlBody;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Return Expression: {\n");
        if (htmlBody!= null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(htmlBody.toString()).append(",\n");
            Space.currentValue--;
        }

        if (expression!= null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
            Space.currentValue--;
        }

        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();

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
        Space.currentValue++;

        jsBuilder.append("return ");

        if (expression != null) {
            jsBuilder.append(expression.convertToJs()).append(";");
        } else if (htmlBody != null) {
            jsBuilder.append("`")
                    .append("\n")
                    .append("\t".repeat(Space.currentValue))
                    .append(htmlBody.convertToJs())
                    .append("\n");

            Space.currentValue--;
            jsBuilder.append("\t".repeat(Space.currentValue)).append("`;");
        } else {
            Space.currentValue--;
            jsBuilder.append("\t".repeat(Space.currentValue)).append(";");
        }
        return jsBuilder.toString();
    }
}
