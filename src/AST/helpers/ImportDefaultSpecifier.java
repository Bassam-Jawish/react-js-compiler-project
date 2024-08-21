package AST.helpers;

import AST.Space;
import ErrorHandling.SemanticCheck;

public class ImportDefaultSpecifier extends ImportDeclaration {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ImportDefaultSpecifier() {
        super();

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImportDefaultSpecifier: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Name = ").append(type != null ? type : "").append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }

    public void validateImport(SemanticCheck semanticCheck, int symbolTableScopeId) {
        if (type != null) {
            if (type.equals("react")) {
                semanticCheck.setReactImported(true);
            } else if (!type.isEmpty()) {
                semanticCheck.setOneDeclaredVariable(type, symbolTableScopeId, "import");
            }
        }
    }

    @Override
    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    @Override
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        return jsBuilder.toString();
    }



}
