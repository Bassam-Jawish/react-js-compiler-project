package AST.statement;

import AST.Space;
import AST.helpers.VarHelper;
import AST.helpers.VariableDeclaration;
import AST.helpers.VariableDeclarationConst;

import java.util.ArrayList;
import java.util.List;

public class VariableStatement extends Statement {
    private VarHelper varHelper;
    private List<VariableDeclaration> variableDeclarations;

    private List<VariableDeclarationConst> variableConstDeclarations;

    public VariableStatement() {
        this.varHelper = null;
        this.variableDeclarations = new ArrayList<>();
        this.variableConstDeclarations = new ArrayList<>();
    }

    public VarHelper getVarHelper() {
        return varHelper;
    }

    public void setVarHelper(VarHelper varHelper) {
        this.varHelper = varHelper;
    }

    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    public void setVariableDeclarations(List<VariableDeclaration> variableDeclarations) {
        this.variableDeclarations = variableDeclarations;
    }

    public List<VariableDeclarationConst> getVariableConstDeclarations() {
        return variableConstDeclarations;
    }

    public void setVariableConstDeclarations(List<VariableDeclarationConst> variableConstDeclarations) {
        this.variableConstDeclarations = variableConstDeclarations;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variable Statement: {\n");
        Space.currentValue++;

        if (!variableDeclarations.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Var/let Variable Declarations: [\n");
            Space.currentValue++;
            for (VariableDeclaration variableDeclaration : variableDeclarations) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(variableDeclaration.toString());
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("]\n");
        }
        if (!variableConstDeclarations.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Const Variable Declarations: [\n");
            Space.currentValue++;
            for (VariableDeclarationConst variableDeclarationConst : variableConstDeclarations) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(variableDeclarationConst.toString());
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("]\n");
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

        if (!variableDeclarations.isEmpty()) {
            for (VariableDeclaration variableDeclaration : variableDeclarations) {
                jsBuilder.append(varHelper.toString()).append(" ").append(variableDeclaration.convertToJs()).append(";\n");
            }
        }

        if (!variableConstDeclarations.isEmpty()) {
            for (VariableDeclarationConst variableDeclarationConst : variableConstDeclarations) {
                jsBuilder.append("const ").append(variableDeclarationConst.convertToJs()).append(";\n");
            }
        }

        return jsBuilder.toString();
    }
}
