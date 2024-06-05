package AST.statement;

import AST.Space;
import AST.helpers.ImportDeclaration;
import AST.helpers.ImportDefaultSpecifier;
import AST.helpers.ImportNamedSpecifier;
import AST.helpers.ImportNamespaceSpecifier;


public class ImportStatement extends Statement {
    private ImportDeclaration importDeclaration;

    public ImportStatement() {
        this.importDeclaration = importDeclaration;
    }

    public ImportDeclaration getImportDeclaration() {
        return importDeclaration;
    }

    public void setImportDeclaration(ImportDeclaration importDeclaration) {
        this.importDeclaration = importDeclaration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (importDeclaration == null) {
            stringBuilder.append("Import Statement: {}");
        } else {
            stringBuilder.append("Import Statement: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("importDeclaration = ").append(importDeclaration.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        return stringBuilder.toString();
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
        if (importDeclaration != null) {
            return importDeclaration.convertToJs();
        }
        return "";
    }
}
