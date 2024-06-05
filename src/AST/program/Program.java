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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Statement statement : statements) {

            stringBuilder.append(statement.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!-- output.html -->\n");
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<meta charset=\"UTF-8\">\n");
        htmlBuilder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlBuilder.append("<title>Output Page</title>\n");
        htmlBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");

        for (Statement statement : statements) {
            htmlBuilder.append(statement.convertToHtml()).append("\n");
        }

        // htmlBuilder.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        htmlBuilder.append("<script src=\"script.js\"></script>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        cssBuilder.append("/* styles.css */\n");
        for (Statement statement : statements) {
            cssBuilder.append(statement.convertToCss()).append("\n");
        }
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append("// script.js\n");
        for (Statement statement : statements) {
            jsBuilder.append(statement.convertToJs()).append("\n");
        }
        return jsBuilder.toString();
    }
}
