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
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs(boolean isHtmlTag) {
        StringBuilder jsBuilder = new StringBuilder();

        String name = "";
        if (jsxAttributeName != null) {
            name = jsxAttributeName;
        }
        if (name.equals("className")) {
            name = "class";
        }
        if (name.equals("onChange")) {
            name = "oninput";
        }
        if (name.equals("onClick")) {
            name = "onclick";
        }

        if (isHtmlTag) {
            if (!name.isEmpty() && objectDeclaration != null) {
                jsBuilder.append(" ").append(name).append("=").append(objectDeclaration.convertToJs());
            } else if (!name.isEmpty() && string != null) {
                if (string.equals("\"search-bar\"")) {
                    Space.isSearchFound = true;
                }
                jsBuilder.append(" ").append(name).append("=").append(string);
            } else if (!name.isEmpty()) {
                jsBuilder.append(" ").append(name);
            }
        }
        else {
            if (!name.isEmpty() && objectDeclaration != null) {
                jsBuilder.append(name).append(": ").append(objectDeclaration.convertToJs());
            } else if (!name.isEmpty() && string != null) {
                jsBuilder.append(name).append(": ").append(string);
            } else if (!name.isEmpty()) {
                jsBuilder.append(name);
            }
        }
        return jsBuilder.toString();
    }

}
