package AST.helpers;

import AST.Space;
import AST.statement.Statement;

public abstract class VariableType {

    public abstract String convertToHtml();
    public abstract String convertToCss();
    public abstract String convertToJs();
}
