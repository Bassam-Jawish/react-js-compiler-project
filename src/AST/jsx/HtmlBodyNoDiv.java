package AST.jsx;

import AST.Space;

import java.util.List;

public class HtmlBodyNoDiv extends HtmlBody{
    private String tagName;
    private List<JsxAttribute> jsxAttributes;

    public HtmlBodyNoDiv() {
        this.tagName = tagName;
        this.jsxAttributes = jsxAttributes;
    }

    public String getTageName() {
        return tagName;
    }

    public void setTageName(String tagName) {
        this.tagName = tagName;
    }

    public List<JsxAttribute> getJsxAttributes() {
        return jsxAttributes;
    }

    public void setJsxAttributes(List<JsxAttribute> jsxAttributes) {
        this.jsxAttributes = jsxAttributes;
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


        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();

    }
}
