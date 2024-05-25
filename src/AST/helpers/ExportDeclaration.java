package AST.helpers;

import AST.Space;
import AST.function.FunctionDeclaration;
import AST.statement.ClassDeclaration;
import AST.statement.ExportStatement;
import AST.statement.VariableStatement;

public class ExportDeclaration extends ExportStatement {
    private VariableStatement variableStatement;
    private ClassDeclaration classDeclaration;
    private FunctionDeclaration functionDeclaration;

    public ExportDeclaration() {

    }

///////
    public VariableStatement getVariableStatement() {
        return variableStatement;
    }

    public void setVariableStatement(VariableStatement variableStatement) {
        this.variableStatement = variableStatement;
    }

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }

    public void setFunctionDeclaration(FunctionDeclaration functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExportDeclaration: {\n");
        if (variableStatement != null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(variableStatement.toString());
            Space.currentValue--;
        }
        if (classDeclaration != null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(classDeclaration.toString());
            Space.currentValue--;
        }
        if (functionDeclaration != null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(functionDeclaration.toString());
            Space.currentValue--;
        }
        stringBuilder.append("\t".repeat(Space.currentValue)).append("\n}");
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
}