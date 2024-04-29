package AST.expression;

import AST.jsx.HtmlBody;

public class HtmlBodyExpression extends Expression{
    private HtmlBody htmlBody;

    public HtmlBodyExpression() {

    }

    public HtmlBody getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(HtmlBody htmlBody) {
        this.htmlBody = htmlBody;
    }

    @Override
    public String toString() {
        return "HtmlBodyExpression: " + htmlBody.toString();
    }
}
