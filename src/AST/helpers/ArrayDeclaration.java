package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import AST.statement.Statement;
import ErrorHandling.SemanticCheck;

import java.util.List;

public class ArrayDeclaration extends VariableType {

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

    public void performSemanticChecks(SemanticCheck semanticCheck, String expressionGetText, int scopeId) {
        semanticCheck.setOneDeclaredVariable(expressionGetText, scopeId, "array");
    }

    @Override
    public String convertToHtml() {
        // Generate HTML from React JS array declaration
        StringBuilder htmlBuilder = new StringBuilder();
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
        if (expressions.size() == 2) {
            Space.valueUseState = expressions.get(0).convertToJs();
            Space.functionUseState = expressions.get(1).convertToJs();
        } else {
            jsBuilder.append("[");
            for (Expression expression : expressions) {
                jsBuilder.append("\t").append(expression.convertToJs()).append(",");
            }
            jsBuilder.append("]");
        }
        return jsBuilder.toString();
    }
}
