package AST.jsx;

import AST.Space;

import java.util.ArrayList;
import java.util.List;
public class HtmlBodyNestedDiv extends HtmlBody{
    private String tagName;
    private List<JsxAttribute> jsxAttributes;
    private JsxContent jsxContent;

    public HtmlBodyNestedDiv() {
        this.tagName = tagName;
        this.jsxAttributes = jsxAttributes;
        this.jsxContent = jsxContent;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<JsxAttribute> getJsxAttributes() {
        return jsxAttributes;
    }

    public void setJsxAttributes(List<JsxAttribute> jsxAttributes) {
        this.jsxAttributes = jsxAttributes;
    }

    public JsxContent getJsxContent() {
        return jsxContent;
    }

    public void setJsxContent(JsxContent jsxContent) {
        this.jsxContent = jsxContent;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Html Body: {\n");
        Space.currentValue++;

        if (tagName != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Open Tag Name : ").append(tagName).append(",\n");
        }

        if (jsxAttributes.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Attributes: {}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Attributes: {\n");
            Space.currentValue++;
            for (JsxAttribute jsxAttribute : jsxAttributes) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxAttribute.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }

        if (jsxContent == null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Content: {}\n");
        }
        else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Content: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxContent.toString());
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();

    }

    @Override
    public String convertToHtml() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    @Override
    public String convertToCss() {
        return "";
    }

    @Override
    public String convertToJs() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isHtmlTag = Character.isLowerCase(tagName.charAt(0));
        if (!isHtmlTag) {
            Space.isNotComponentParametersCall = false;
        }
        if (isHtmlTag) {
            stringBuilder.append("<").append(tagName);
            Space.isJsxAttr = true;
            for (JsxAttribute attr : jsxAttributes) {
                stringBuilder.append(attr.convertToJs(isHtmlTag));
            }
            Space.isJsxAttr = false;
            stringBuilder.append(" />");

            Space.currentValue++;
            if (jsxContent != null) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxContent.convertToJs());
            }
            Space.currentValue--;
        } else {
            stringBuilder.append("${").append(tagName).append("(");
            if (!jsxAttributes.isEmpty()) {
                stringBuilder.append("{ ");
            }
            for (int i = 0; i < jsxAttributes.size(); i++) {
                JsxAttribute attr = jsxAttributes.get(i);
                stringBuilder.append(attr.convertToJs(isHtmlTag));
                if (i < jsxAttributes.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
            if (!jsxAttributes.isEmpty()) {
                stringBuilder.append(" }");
            }
            stringBuilder.append(")}");
        }
        Space.isNotComponentParametersCall = true;
        return stringBuilder.toString();
    }

}
