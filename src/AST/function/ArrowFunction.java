package AST.function;

import AST.Space;
import AST.expression.Expression;
import AST.statement.BlockStatement;
import AST.statement.Statement;

public class ArrowFunction extends   FunctionDeclaration{
    private ArrowParameters ArrowParameters;

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
        this.ArrowParameters = ArrowParameters;
    }

    public ArrowParameters getArrowParameters() {
        return ArrowParameters;
    }

    public void setArrowParameters(ArrowParameters ArrowParameters) {
        this.ArrowParameters = ArrowParameters;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Arrow Function Declaration: {\n");
        Space.currentValue++;
        if (ArrowParameters != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Arrow Parameters: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(ArrowParameters.toString()).append(",\n");
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
}
