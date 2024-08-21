package AST.helpers;

import ErrorHandling.SemanticCheck;

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

    public void validateImport(SemanticCheck semanticCheck, int symbolTableScopeId) {
        if (type != null && !type.isEmpty()) {
            String[] parts = type.split(" AS ");
            String originalName = parts[0];
            semanticCheck.setOneDeclaredVariable(originalName, symbolTableScopeId, "import");

            if (originalName.equals("React")) {
                semanticCheck.setReactImported(true);
            } else if (originalName.equals("useState")) {
                semanticCheck.setUseStateImported(true);
            } else if (originalName.equals("useEffect")) {
                semanticCheck.setUseEffectImported(true);
            } else if (originalName.equals("useRef")) {
                semanticCheck.setUseRefImported(true);
            }
        }
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
