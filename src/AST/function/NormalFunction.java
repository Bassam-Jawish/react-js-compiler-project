package AST.function;

import AST.Space;
import AST.expression.Expression;
import AST.statement.BlockStatement;
import AST.statement.Statement;
import ErrorHandling.SemanticCheck;

import java.util.List;

public class NormalFunction extends FunctionDeclaration {

    private String functionName;
    private List<Expression> expression;
    private BlockStatement blockStatement;

    public NormalFunction() {

    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
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
        stringBuilder.append("Normal Function Declaration: {\n");
        Space.currentValue++;

        stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Name: ").append(functionName.toString()).append(",\n");
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
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        else{
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Function Body: {}");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("\n}");

        return stringBuilder.toString();
    }

    public void performSemanticChecks(SemanticCheck semanticCheck, int scopeId) {
        semanticCheck.setOneDeclaredVariable(functionName, scopeId, "function");
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
        jsBuilder.append("function ").append(functionName).append("(");
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
