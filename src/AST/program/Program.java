package AST.program;

import AST.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class Program {
    private List<Statement> statements;

    public Program() {
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
        for (Statement statement : statements)
        {

            stringBuilder.append(statement.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
