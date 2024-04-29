package AST.statement;


import AST.helpers.ExportDeclaration;
import AST.helpers.ExportDefaultDeclaration;

public abstract class ExportStatement extends Statement{/*
    private ExportDefaultDeclaration exportDefaultDeclaration;
    private ExportDeclaration exportDeclaration;

    public ExportStatement() {
        this.exportDefaultDeclaration = exportDefaultDeclaration;
        this.exportDeclaration = exportDeclaration;
    }

    public ExportDefaultDeclaration getExportDefaultDeclaration() {
        return exportDefaultDeclaration;
    }

    public void setExportDefaultDeclaration(ExportDefaultDeclaration exportDefaultDeclaration) {
        this.exportDefaultDeclaration = exportDefaultDeclaration;
    }

    public ExportDeclaration getExportDeclaration() {
        return exportDeclaration;
    }

    public void setExportDeclaration(ExportDeclaration exportDeclaration) {
        this.exportDeclaration = exportDeclaration;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportStatement: {\n");

        if (exportDefaultDeclaration != null) {
            stringBuilder.append(exportDefaultDeclaration);
        }
        if (exportDeclaration != null) {
            stringBuilder.append(exportDeclaration);
        }

        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }*/
}
