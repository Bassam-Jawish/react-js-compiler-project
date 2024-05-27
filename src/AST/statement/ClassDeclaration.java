package AST.statement;

import AST.Space;
import AST.expression.Expression;

import java.util.List;

public class ClassDeclaration extends Statement {

    private String className;
    private Expression extendedClass;

    private BlockStatement blockStatement;

    public BlockStatement getBlockStatement() {
        return blockStatement;
    }

    public void setBlockStatement(BlockStatement blockStatement) {
        this.blockStatement = blockStatement;
    }

    public ClassDeclaration() {
        this.className = className;
        this.extendedClass = extendedClass;
        this.blockStatement = blockStatement;
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassName: ").append(className).append("\n");
        if (extendedClass != null) {
            stringBuilder.append("Extends: ").append(extendedClass).append("\n");
        }
        if (blockStatement == null) {
            stringBuilder.append("Class Body: {}");
        }
        else {
            stringBuilder.append("Class Body: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(blockStatement.toString()).append("\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        return stringBuilder.toString();
    }

}
