package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;

import java.util.List;

public class ArrayDeclaration extends VariableType{

    private List<Expression> expressions;

    public ArrayDeclaration() {

    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array Declaration: {\n");
        Space.currentValue++;
        for (Expression expression : expressions) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
        }
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }

    @Override
    public String convertToHtml() {
        // Generate HTML from React JS array declaration
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<ul>\n");
        for (Expression expression : expressions) {
            htmlBuilder.append("\t<li>").append(expression).append("</li>\n");
        }
        htmlBuilder.append("</ul>");
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    @Override
    public String convertToJs() {
        // Generate JavaScript array declaration
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append("[\n");
        for (Expression expression : expressions) {
            jsBuilder.append("\t").append(expression.convertToJs()).append(",\n");
        }
        jsBuilder.append("]");
        return jsBuilder.toString();
    }
}
