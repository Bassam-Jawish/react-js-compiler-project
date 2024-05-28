package AST.program;

import AST.statement.ImportStatement;
import AST.statement.Statement;

import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Program {
    private List<Statement> statements;

    public Program() {
        this.statements = new ArrayList<>();
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (Statement statement : statements)
        {

            stringBuilder.append(statement.toString()).append("\n");
        }
        return stringBuilder.toString();
    }


    public void generateOutputFiles() {
        String outputDir = "src/OutputFiles/";

        try {
            // Create output directory if it doesn't exist
            Files.createDirectories(Paths.get(outputDir));

            // Define file paths for HTML, CSS, and JS
            String htmlFilePath = outputDir + "output.html";
            String cssFilePath = outputDir + "styles.css";
            String jsFilePath = outputDir + "script.js";

            // FileWriter instances for HTML, CSS, and JS files
            FileWriter htmlWriter = new FileWriter(htmlFilePath);
            FileWriter cssWriter = new FileWriter(cssFilePath);
            FileWriter jsWriter = new FileWriter(jsFilePath);

            // Start HTML content with the basic structure
            htmlWriter.write("<!DOCTYPE html>\n");
            htmlWriter.write("<html>\n");
            htmlWriter.write("<head>\n");
            htmlWriter.write("<meta charset=\"UTF-8\">\n");
            htmlWriter.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            htmlWriter.write("<title>Output Page</title>\n");
            htmlWriter.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
            htmlWriter.write("</head>\n");
            htmlWriter.write("<body>\n");

            // Write contents from statements to HTML, CSS, and JS files
            for (Statement statement : statements)
            {
                String htmlContent = statement.convertToHtml();
                if (htmlContent != null && !htmlContent.isEmpty()) {
                    htmlWriter.write(htmlContent + "\n");
                }

                String cssContent = statement.convertToCss();
                if (cssContent != null && !cssContent.isEmpty()) {
                    cssWriter.write(cssContent + "\n");
                }

                String jsContent = statement.convertToJs();
                if (jsContent != null && !jsContent.isEmpty()) {
                    jsWriter.write(jsContent + "\n");
                }
            }

            // End the HTML structure
            htmlWriter.write("<script src=\"script.js\"></script>\n");
            htmlWriter.write("</body>\n");
            htmlWriter.write("</html>");

            // Close all writers
            htmlWriter.close();
            cssWriter.close();
            jsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
