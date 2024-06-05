package AST.function;

import AST.Space;
import AST.expression.Expression;
import AST.statement.BlockStatement;
import AST.statement.Statement;

import java.util.List;

public class AnonymousFunction extends   FunctionDeclaration{
    private List<Expression> expression;
    private BlockStatement blockStatement;

    public AnonymousFunction() {

    }

    public List<Expression> getExpression() {
        return expression;
    }

    public void setExpression(List<Expression> expression) {
        this.expression = expression;
    }

    public BlockStatement getBlockStatement() {
        return blockStatement;
    }

    public void setBlockStatement(BlockStatement blockStatement) {
        this.blockStatement = blockStatement;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Anonymous Function Declaration: {\n");
        Space.currentValue++;
        if (!expression.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Parameters: {\n");
            Space.currentValue++;
            for (Expression expression1 : expression) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(expression1.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Parameters: {}\n");
        }

        if (blockStatement != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Body: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(blockStatement.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else{
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Body: {}\n");
        }

        Space.currentValue--;
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
        jsBuilder.append("function (");
        if (!expression.isEmpty()) {
            for (int i = 0; i < expression.size(); i++) {
                jsBuilder.append(expression.get(i).convertToJs());
                if (i < expression.size() - 1) {
                    jsBuilder.append(", ");
                }
            }
        }
        jsBuilder.append(") ");
        if (blockStatement != null) {
            jsBuilder.append(blockStatement.convertToJs());
        }
        return jsBuilder.toString();
    }
}
