package AST.helpers;

import AST.statement.ImportStatement;

import java.util.List;

public abstract class ImportDeclaration {
    public abstract String convertToHtml();
    public abstract String convertToCss();
    public abstract String convertToJs();
}
