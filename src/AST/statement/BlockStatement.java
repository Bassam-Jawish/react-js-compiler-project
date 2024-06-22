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
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div>\n");
        for (Statement statement : statements) {
            htmlBuilder.append(statement.convertToHtml()).append("\n");
        }
        htmlBuilder.append("</div>");
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        for (Statement statement : statements) {
            cssBuilder.append(statement.convertToCss()).append("\n");
        }
        return cssBuilder.toString();
    }

    @Override
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append("{\n");
        Space.currentValue++;
        for (Statement statement : statements) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append(statement.convertToJs()).append("\n");
        }
        Space.currentValue--;
        jsBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return jsBuilder.toString();
    }

}
