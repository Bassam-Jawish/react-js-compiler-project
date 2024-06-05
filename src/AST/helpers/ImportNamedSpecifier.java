package AST.helpers;

import AST.Space;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ImportNamedSpecifier extends ImportDeclaration{
    private List<ImportSpecifier> importSpecifiers;


    public void setImportSpecifiers(List<ImportSpecifier> importSpecifiers) {
        this.importSpecifiers = importSpecifiers;
    }

    public ImportNamedSpecifier() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImportNamedSpecifier: [\n");
        Space.currentValue++;
        for (ImportSpecifier importSpecifier : importSpecifiers) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(importSpecifier.toString()).append(",\n");
        }
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
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
        StringBuilder jsBuilder = new StringBuilder();
        return jsBuilder.toString();
    }
}
