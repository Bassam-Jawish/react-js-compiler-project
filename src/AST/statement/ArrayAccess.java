package AST.statement;

import AST.Space;
import AST.expression.Expression;

public class ArrayAccess extends Statement {
    private String arrayName;
    private Expression index;

    public ArrayAccess() {
        this.arrayName = arrayName;
        this.index = index;
    }

    public String getArrayName() {
        return arrayName;
    }

    public Expression getIndex() {
        return index;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArrayAccess: {\n");
        Space.currentValue++;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("arrayName='").append(arrayName).append(", index=").append(index).append(",\n");
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }

    @Override
    public String convertToHtml() {
        return "";
    }

    @Override
    public String convertToCss() {
        return "";
    }

    @Override
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append(arrayName).append("[");
        if (index != null) {
            if (Space.isInsideReturn) {
                jsBuilder.append("${");
            }
            jsBuilder.append(index.convertToJs());
            if (Space.isInsideReturn) {
                jsBuilder.append("}");
            }
        }
        jsBuilder.append("]");
        return jsBuilder.toString();
    }
}
