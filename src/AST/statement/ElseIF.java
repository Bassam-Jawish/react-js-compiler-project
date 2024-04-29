package AST.statement;

import AST.Space;
import AST.expression.Expression;

public class ElseIF extends Statement{

    private BlockStatement statements;
    private Expression expression ;

    public BlockStatement getStatements() {
        return statements;
    }

    public void setStatements(BlockStatement statements) {
        this.statements = statements;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public ElseIF() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Else If: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Condition=").append(expression.toString()).append(",\n");
        stringBuilder.append("\t".repeat(Space.currentValue)).append(statements.toString()).append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }


}
