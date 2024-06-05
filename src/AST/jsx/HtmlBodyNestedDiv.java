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

        stringBuilder.append("<").append(tagName);
        for (JsxAttribute attr : jsxAttributes) {
            stringBuilder.append(" ").append(attr.convertToHtml());
        }
        stringBuilder.append(">");

        if (jsxContent != null) {
            stringBuilder.append(jsxContent.convertToHtml());
        }

        stringBuilder.append("</").append(tagName).append(">");
        return stringBuilder.toString();
    }

    @Override
    public String convertToCss() {
        return "";
    }

    @Override
    public String convertToJs() {
        return "";
    }
}
