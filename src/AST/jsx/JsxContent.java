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



        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();

        Space.currentValue++;

        for (JsxText textElement : textElements) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append(textElement.convertToJs()).append("\n");
        }

        for (HtmlBody htmlBody : htmlBodies) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append(htmlBody.convertToJs()).append("\n");
        }

        for (JsxExpression expression : expressions) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append(expression.convertToJs()).append("\n");
        }
        Space.currentValue--;

        return jsBuilder.toString();
    }
}
