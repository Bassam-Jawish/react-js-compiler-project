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
        htmlBuilder.append("<div id=\"import-statement\"></div>");
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        return  "#import-statement {\n"
                + "    font-family: Arial, sans-serif;\n"
                + "    margin: 20px;\n"
                + "    padding: 10px;\n"
                + "    border: 1px solid #ccc;\n"
                + "}\n"
                + ".import-declaration {\n"
                + "    margin-left: 20px;\n"
                + "    color: #333;\n"
                + "}\n";
    }

    @Override
    public String convertToJs() {
        return  "document.addEventListener('DOMContentLoaded', function() {\n"
                + "    const importStatementDiv = document.getElementById('import-statement');\n"
                + "    if (importStatementDiv) {\n"
                + "        importStatementDiv.innerHTML = `<div class=\"import-statement\">\n"
                + "            <p>Import Statement: {</p>\n"
                + "            <div class=\"import-declaration\" style=\"margin-left: ${Space.currentValue * 20}px;\">\n"

                + "            </div>\n"
                + "            <p>}</p>\n"
                + "        </div>`;\n"
                + "    }\n"
                + "});\n";
    }
}
