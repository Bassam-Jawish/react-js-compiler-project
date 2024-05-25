package AST.helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
public class ImportSpecifier {

    private String type;

    public ImportSpecifier() {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImportSpecifier: {" +
                "Name = " +  (type != null ? type.toString() : "") +
                '}';
    }

    public String convertToHtml() {
       // System.out.println("sdfddddddddddddddd");
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div>").append("<h3>Import Specifier</h3>").append("<ul>");
        if (type != null) {
            htmlBuilder.append("<li>").append("Name: ").append(type).append("</li>");
        }
        htmlBuilder.append("</ul>").append("</div>");
        return htmlBuilder.toString();
    }

    // Method to convert to CSS
    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        if (type != null) {
            cssBuilder.append(".import-specifier {").append("\n")
                    .append("  content: '").append(type).append("';").append("\n")
                    .append("}").append("\n");
        }
        return cssBuilder.toString();
    }

    // Method to convert to JavaScript
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        if (type != null) {
            jsBuilder.append("const importSpecifier = {").append("\n")
                    .append("  name: '").append(type).append("'").append("\n")
                    .append("};").append("\n");
        }
        return jsBuilder.toString();
    }

}
