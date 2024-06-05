package AST.jsx;

import AST.Space;
import AST.statement.Statement;

import java.util.List;

public class JsxContent {
    private List<JsxText> textElements;
    private List<HtmlBody> htmlBodies;
    private List<JsxExpression> expressions;

    public JsxContent() {

    }

    public List<JsxText> getTextElements() {
        return textElements;
    }

    public void setTextElements(List<JsxText> textElements) {
        this.textElements = textElements;
    }

    public List<HtmlBody> getHtmlBodies() {
        return htmlBodies;
    }

    public void setHtmlBodies(List<HtmlBody> htmlBodies) {
        this.htmlBodies = htmlBodies;
    }

    public List<JsxExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<JsxExpression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        if (!textElements.isEmpty()) {
            stringBuilder.append("Text Elements: {\n");
            Space.currentValue++;
            for (JsxText jsxText : textElements) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxText.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("},\n");
        }
        else {
            stringBuilder.append("Text Elements: {}\n");
        }

        if (!htmlBodies.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("HTML Bodies: {\n");
            Space.currentValue++;
            for (HtmlBody htmlBody : htmlBodies) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(htmlBody.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("},\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("HTML Bodies: {}\n");
        }

        if (!expressions.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Expressions: {\n");
            Space.currentValue++;
            for (JsxExpression jsxExpression : expressions) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxExpression.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Expressions: {}\n");

        }


        return stringBuilder.toString();
    }

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();

        for (JsxText textElement : textElements) {
            htmlBuilder.append(textElement.convertToHtml());
        }

        for (HtmlBody htmlBody : htmlBodies) {
            htmlBuilder.append(htmlBody.convertToHtml());
        }

        for (JsxExpression expression : expressions) {
            htmlBuilder.append(expression.convertToHtml());
        }

        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();

        for (JsxExpression expression : expressions) {
            jsBuilder.append(expression.convertToJs());
        }

        return jsBuilder.toString();
    }
}
