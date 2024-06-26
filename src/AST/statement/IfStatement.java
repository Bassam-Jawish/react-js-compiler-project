
package AST.statement;

import AST.Space;
import AST.expression.Expression;

import java.util.List;

public class IfStatement extends Statement {
    private Expression condition;
    private BlockStatement ifBlock;
    private List<ElseIF> elseIfStatements;
    private BlockStatement elseStatement;

    public IfStatement() {

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("IfStatement: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Condition= ").append(condition.toString()).append(",\n");
        if (ifBlock != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("IfBloc= ").append(ifBlock.toString()).append(",\n");
        }
        if (!elseIfStatements.isEmpty()) {
            for (ElseIF elseIF : elseIfStatements) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append("ElseIfStatements= ").append(elseIF.toString()).append(",\n");
            }
        }

        if (elseStatement != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("ElseStatement= ").append(elseStatement.toString()).append(",\n");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }


    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public BlockStatement getIfBlock() {
        return ifBlock;
    }

    public void setIfBlock(BlockStatement ifBlock) {
        this.ifBlock = ifBlock;
    }

    public List<ElseIF> getElseIfStatements() {
        return elseIfStatements;
    }

    public void setElseIfStatements(List<ElseIF> elseIfStatements) {
        this.elseIfStatements = elseIfStatements;
    }

    public BlockStatement getBlockStatement() {
        return elseStatement;
    }

    public void elseStatement(BlockStatement blockStatement) {
        this.elseStatement = blockStatement;
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

        jsBuilder.append("if (").append(condition.convertToJs()).append(") \n");
        if (ifBlock != null) {
            jsBuilder.append(ifBlock.convertToJs());
        }
        jsBuilder.append("\n");

        for (ElseIF elseIF : elseIfStatements) {
            jsBuilder.append("else if (").append(elseIF.getExpression().convertToJs()).append(") \n");
            jsBuilder.append(elseIF.getStatements().convertToJs());
            jsBuilder.append("\n");
        }

        if (elseStatement != null) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append("else \n");
            jsBuilder.append(elseStatement.convertToJs());
        }

        return jsBuilder.toString();
    }
}
