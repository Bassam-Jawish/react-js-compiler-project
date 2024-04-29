package AST.statement;

import AST.Space;
import AST.expression.Expression;

import java.util.List;

public class ClassDeclaration extends Statement {

    private String className;
    private Expression extendedClass;
    private List<Statement> statements;

    public ClassDeclaration() {
        this.className = className;
        this.extendedClass = extendedClass;
        this.statements = statements;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Expression getExtendedClass() {
        return extendedClass;
    }

    public void setExtendedClassName(Expression extendedClass) {
        this.extendedClass = extendedClass;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassName: ").append(className).append("\n");
        if (extendedClass != null) {
            stringBuilder.append("Extends: ").append(extendedClass).append("\n");
        }
        if (statements.isEmpty()) {
            stringBuilder.append("Class Body: {}");
        }
        else {
            stringBuilder.append("Class Body: {\n");
            Space.currentValue++;
            for (Statement statement : statements) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(statement.toString()).append("\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        return stringBuilder.toString();
    }

}
