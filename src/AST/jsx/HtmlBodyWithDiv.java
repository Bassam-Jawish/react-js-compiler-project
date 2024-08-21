package AST.jsx;

import AST.Space;
import AST.program.Program;
import AST.statement.Statement;
import ErrorHandling.SemanticCheck;

import java.util.ArrayList;
import java.util.List;

public class HtmlBodyWithDiv extends HtmlBody {
    private String openTagName;
    private List<JsxAttribute> jsxAttributes;
    private JsxContent jsxContent;
    private String closeTagName;

    public HtmlBodyWithDiv() {
        this.openTagName = openTagName;
        this.jsxAttributes = jsxAttributes;
        this.jsxContent = jsxContent;
        this.closeTagName = closeTagName;
    }

    public String getOpenTagName() {
        return openTagName;
    }

    public void setOpenTagName(String identifier) {
        this.openTagName = identifier;
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

    public String getCloseTagName() {
        return closeTagName;
    }

    public void setCloseTagName(String closeTagName) {
        this.closeTagName = closeTagName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Html Body: {\n");
        Space.currentValue++;

        if (openTagName != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Open Tag Name : ").append(openTagName).append(",\n");
        }

        if (jsxAttributes.isEmpty()) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Attributes: {}\n");
        } else {
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
        } else {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Jsx Content: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(jsxContent.toString());
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}\n");
        }

        if (closeTagName != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append("Close Tag Name : ").append(closeTagName).append(",\n");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }

    public void validateTags(SemanticCheck semanticCheck, int lineNumber) {
        String openTag = this.openTagName != null ? this.openTagName : "";
        String closeTag = this.closeTagName != null ? this.closeTagName : "";

        semanticCheck.checkIfTwoTagsAreNotEquals(openTag, closeTag, lineNumber);
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
        StringBuilder jsBuilder = new StringBuilder();

        if (openTagName != null) {
            jsBuilder.append("<").append(openTagName);
        }
        if (!jsxAttributes.isEmpty()) {
            Space.isJsxAttr = true;
            for (JsxAttribute attr : jsxAttributes) {
                jsBuilder.append(attr.convertToJs(true));
            }
            Space.isJsxAttr = false;
        }
        if (openTagName != null) {
            jsBuilder.append(">\n");
        }
        if (jsxContent != null) {
            jsBuilder.append(jsxContent.convertToJs());
        }
        if (closeTagName != null) {
            jsBuilder.append("\t".repeat(Space.currentValue)).append("</").append(closeTagName).append(">");
        }
        return jsBuilder.toString();
    }
}
