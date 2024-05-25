package AST.statement;

import AST.Space;

import java.util.ArrayList;
import java.util.List;

public class  BlockStatement extends Statement {

    private List<Statement> statements;

    public BlockStatement() {
        this.statements = new ArrayList<>();
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (statements.isEmpty()) {
            stringBuilder.append("Block Statement: {}");
        }
        else {
            stringBuilder.append("Block Statement: {\n");
            Space.currentValue++;
            for (Statement statement : statements) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(statement.toString()).append(",\n");
            }
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
        return "";
    }

    /*
    public void execute() {
        // Implement logic to execute each statement within the block
        for (Statement statement : statements) {
            statement.execute();
        }
    }
    */
}
