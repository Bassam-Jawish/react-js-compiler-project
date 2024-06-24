package AST.function;

import AST.Space;
import AST.expression.Expression;
import AST.statement.BlockStatement;
import AST.statement.Statement;

public class ArrowFunction extends   FunctionDeclaration{
    private ArrowParameters arrowParameters;

    private BlockStatement blockStatement;

    private  Expression expression;

    public BlockStatement getBlockStatement() {
        return blockStatement;
    }

    public void setBlockStatement(BlockStatement blockStatement) {
        this.blockStatement = blockStatement;
    }

    public Expression getExpressionPar() {
        return expression;
    }

    public void setExpressionPar(Expression expressionPar) {
        this.expression = expressionPar;
    }

    public ArrowFunction() {
        this.arrowParameters = arrowParameters;
    }

    public ArrowParameters getArrowParameters() {
        return arrowParameters;
    }

    public void setArrowParameters(ArrowParameters arrowParameters) {
        this.arrowParameters = arrowParameters;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Arrow Function Declaration: {\n");
        Space.currentValue++;
        if (arrowParameters != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Parameters: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(arrowParameters.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Parameters: {}\n");
        }

        if (blockStatement != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Function Body: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(blockStatement.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else if (expression != null){
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Function Body: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Function Body: {}");
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
        if (Space.isInsideReturn) {
            jsBuilder.append("(");
        }
        jsBuilder.append("(");
        if (arrowParameters != null) {
            jsBuilder.append(arrowParameters.convertToJs());
        }
        jsBuilder.append(") => ");
        if (blockStatement != null) {
            jsBuilder.append(blockStatement.convertToJs());
        } else if (expression != null) {
            jsBuilder.append(expression.convertToJs());
        }
        if (Space.isInsideReturn) {
            jsBuilder.append(")()");
        }
        return jsBuilder.toString();
    }
}
