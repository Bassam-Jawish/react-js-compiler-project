package AST.helpers;

import AST.Space;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ImportNamedSpecifier extends ImportDeclaration{
    private List<ImportSpecifier> importSpecifiers;


    public void setImportSpecifiers(List<ImportSpecifier> importSpecifiers) {
        this.importSpecifiers = importSpecifiers;
    }

    public ImportNamedSpecifier() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImportNamedSpecifier: [\n");
        Space.currentValue++;
        for (ImportSpecifier importSpecifier : importSpecifiers) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(importSpecifier.toString()).append(",\n");
        }
        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        return stringBuilder.toString();
    }

    public  void convertToHtml() {
        String outputDir = "src/OutputFiles/";
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div>").append("<h3>Import Named Specifier</h3>").append("<ul>");
        for (ImportSpecifier importSpecifier : importSpecifiers) {
            String specifierHtml = importSpecifier.toString(); // Convert specifier to string
            if (specifierHtml != null) {
                htmlBuilder.append("<li>").append(specifierHtml).append("</li>");
            }
        }
        htmlBuilder.append("</ul>").append("</div>");

        // Write the HTML content to a file
        try {
            // Create output directory if it doesn't exist
            Files.createDirectories(Paths.get(outputDir));

            // Define file path for HTML
            String htmlFilePath = outputDir + "output.html";

            // Use try-with-resources to ensure the FileWriter is closed
            try (FileWriter fileWriter = new FileWriter(htmlFilePath)) {
                fileWriter.write(htmlBuilder.toString());
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to convert to CSS
    public String convertToCss() {
        // Implement conversion logic to CSS here
        return "/* CSS for ImportNamedSpecifier */";
    }

    // Method to convert to JavaScript
    public String convertToJs() {
        // Implement conversion logic to JavaScript here
        return "// JavaScript for ImportNamedSpecifier";
    }
}
