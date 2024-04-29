package AST.statement;

import AST.Space;
import AST.expression.Expression;
import AST.jsx.HtmlBody;

public class ReturnStatement extends Statement{
    private Expression expression;
    private HtmlBody htmlBody;

    public ReturnStatement() {
        this.expression = expression;
        this.htmlBody = null;
    }

    public ReturnStatement(HtmlBody htmlBody) {
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
        stringBuilder.append("Return Statement: {\n");
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

}
