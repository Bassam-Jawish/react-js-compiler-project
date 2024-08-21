package AST.helpers;

import AST.Space;
import AST.expression.Expression;
import ErrorHandling.SemanticCheck;

public class VariableDeclarationConst {

    private Expression expression;
    private VariableType variableType;

    public VariableDeclarationConst() {
        this.expression = expression;
        variableType = variableType;
    }


    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public AST.helpers.VariableType getVariableType() {
        return variableType;
    }

    public void setVariableType(AST.helpers.VariableType variableType) {
        this.variableType = variableType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variable Const Declaration: {\n");

        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Variable Type (Assignable) = ").append(variableType.toString()).append(",\n");
        Space.currentValue--;


        if (expression != null) {
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Value = ").append(expression.toString()).append(",\n");
            Space.currentValue--;
        }
        stringBuilder.append("\t".repeat(Space.currentValue)).append("},\n");
        return stringBuilder.toString();
    }

    public void performSemanticCheck(SemanticCheck semanticCheck, int scopeId) {
        if (variableType != null) {
            String variableName = variableType.toString();
            semanticCheck.setOneDeclaredVariable(variableName, scopeId, "const");
        }
    }

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        variableType.convertToJs();
        if (variableType.toString().equals("App")) {
            Space.isAppComponent = true;
        }

        if (expression != null) {
            jsBuilder.append(expression.convertToJs());
        }

        if (Space.isUseState) {
            jsBuilder.append("window.").append(Space.valueUseState).append(" = ").append("window.").append(Space.valueUseState).append(" || ").append(Space.initialUseState).append(";\n");
            jsBuilder.append("\t".repeat(Space.currentValue)).append("window.").append(Space.functionUseState).append(" = ").append("function ").append(Space.functionUseState).append("(").append(Space.functionUseState).append(")").append(" {").append("\n");
            Space.currentValue++;
            jsBuilder.append("\t".repeat(Space.currentValue)).append("window.").append(Space.valueUseState).append(" = ").append(Space.functionUseState).append(";\n");
            jsBuilder.append("\t".repeat(Space.currentValue)).append("document.querySelector(\"#app\").innerHTML = App();\n");
            Space.currentValue--;
            jsBuilder.append("\t".repeat(Space.currentValue)).append("};\n");
        }

        return jsBuilder.toString();
    }
}
