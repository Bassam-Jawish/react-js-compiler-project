package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import AST.statement.ExportStatement;

public class ExportDefaultDeclaration extends ExportStatement {
    private Expression expression;

    public ExportDefaultDeclaration() {

    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (expression == null) {
            stringBuilder.append("Export Default Declaration: {}");
        }
        else {
            stringBuilder.append("Export Default Declaration: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Expression = ").append(expression.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
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
        /*jsBuilder.append("export default ");
        if (expression != null) {
            jsBuilder.append(expression.convertToJs());
        }
        jsBuilder.append(";");*/
        return jsBuilder.toString();
    }
}
