package AST.helpers;

import AST.Space;

public class ImportNamespaceSpecifier extends ImportDeclaration{

private String type;

    public ImportNamespaceSpecifier() {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImportNamespaceSpecifier {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("Name = ").append(type != null ? type : "").append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }
}
