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
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        return jsBuilder.toString();
    }

}
