package AST.helpers;

import AST.Space;

import java.util.List;

public class ImportNamedSpecifier extends ImportDeclaration{
    private List<ImportSpecifier> importSpecifiers;

    public List<ImportSpecifier> getImportSpecifiers() {
        return importSpecifiers;
    }

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
}
