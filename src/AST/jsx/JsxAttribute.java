package AST.jsx;

import AST.Space;
import AST.expression.Expression;
import AST.helpers.ObjectDeclaration;


public class JsxAttribute {

    private String jsxAttributeName;

    private ObjectDeclaration objectDeclaration;

    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public JsxAttribute() {

    }

    public String getJsxAttributeName() {
        return jsxAttributeName;
    }

    public void setJsxAttributeName(String jsxAttributeName) {
        this.jsxAttributeName = jsxAttributeName;
    }

    public ObjectDeclaration getObjectDeclaration() {
        return objectDeclaration;
    }

    public void setObjectDeclaration(ObjectDeclaration objectDeclarationTY) {
        this.objectDeclaration = objectDeclarationTY;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("jsxAttributeInfo: {\n");
        Space.currentValue++;

        stringBuilder.append("\t".repeat(Space.currentValue)).append("jsxAttributeName: ").append(jsxAttributeName).append(",\n");

        if (objectDeclaration != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("jsxAttributeValue: ").append(objectDeclaration.toString()).append(",\n");
        }
        if (string != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("jsxAttributeValue: ").append(string).append(",\n");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();

    }

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        if (jsxAttributeName != null && objectDeclaration != null) {
            htmlBuilder.append(" ").append(jsxAttributeName).append("=\"").append(objectDeclaration.toString()).append("\"");
        } else if (jsxAttributeName != null && string != null) {
            htmlBuilder.append(" ").append(jsxAttributeName).append("=\"").append(string).append("\"");
        } else if (jsxAttributeName != null) {
            htmlBuilder.append(" ").append(jsxAttributeName);
        }
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        if (jsxAttributeName != null && objectDeclaration != null) {
            jsBuilder.append(" ").append(jsxAttributeName).append(": ").append(objectDeclaration.convertToJs()).append(",");
        } else if (jsxAttributeName != null && string != null) {
            jsBuilder.append(" ").append(jsxAttributeName).append(": \"").append(string).append("\",");
        } else if (jsxAttributeName != null) {
            jsBuilder.append(" ").append(jsxAttributeName).append(",");
        }
        return jsBuilder.toString();
    }
}
