package AST.program;

import AST.Space;
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
        htmlBuilder.append("<html lang=\"en\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("    <meta charset=\"UTF-8\">\n");
        htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlBuilder.append("    <title>Generated Page</title>\n");
        htmlBuilder.append("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        /*for (Statement statement : statements) {
            htmlBuilder.append(statement.convertToHtml()).append("\n");
        }*/
        // htmlBuilder.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        htmlBuilder.append("    <div id=\"app\"></div>\n");
        htmlBuilder.append("    <script src=\"script.js\"></script>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        cssBuilder.append("/* styles.css */\n");
        /*for (Statement statement : statements) {
            cssBuilder.append(statement.convertToCss()).append("\n");
        }*/

        cssBuilder.append("#root {\n")
                .append("  /* max-width: 1280px; */\n")
                .append("  width: 100%;\n")
                .append("  height: 100vh;\n")
                .append("  /* margin: 0 auto; */\n")
                .append("  text-align: center;\n")
                .append("}\n\n")

                .append("/* App.css */\n")
                .append("body {\n")
                .append("  margin: 0;\n")
                .append("  font-family: Arial, sans-serif;\n")
                .append("  background-color: #f0f0f0;\n")
                .append("  display: flex;\n")
                .append("  justify-content: center;\n")
                .append("}\n\n")

                .append(".app {\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  width: 100%;\n")
                .append("  height: 100%;\n")
                .append("}\n\n")

                .append(".navigation {\n")
                .append("  display: flex;\n")
                .append("  background-color: #232F3E;\n")
                .append("  color: #fff;\n")
                .append("  text-align: center;\n")
                .append("  width: 90%;\n")
                .append("  padding-block: 20px;\n")
                .append("  align-items: center;\n")
                .append("  padding-inline: 5%;\n")
                .append("}\n\n")

                .append(".navigation img {\n")
                .append("  width: 40px;\n")
                .append("  height: 40px;\n")
                .append("  border-radius: 50%;\n")
                .append("  border: 5px solid black;\n")
                .append("}\n\n")

                .append(".search-bar {\n")
                .append("  margin-inline-start: 12%;\n")
                .append("  width: 60%;\n")
                .append("}\n\n")

                .append(".search-bar input {\n")
                .append("  width: 100%;\n")
                .append("  border: none;\n")
                .append("  outline: none;\n")
                .append("  height: 40px;\n")
                .append("  border-radius: 2px;\n")
                .append("}\n\n")

                .append(".search-bar input:focus {\n")
                .append("  box-shadow: 0 0 20px blue;\n")
                .append("}\n\n")

                .append(".content {\n")
                .append("  display: flex;\n")
                .append("  margin: 0;\n")
                .append("}\n\n")

                .append(".panner {\n")
                .append("  width: 100%;\n")
                .append("  /* background-color: black; */\n")
                .append("  display: flex;\n")
                .append("  justify-content: center;\n")
                .append("}\n\n")

                .append(".panner img {\n")
                .append("  max-width: 85%;\n")
                .append("}\n\n")

                .append(".sidebar {\n")
                .append("  flex: 1.4;\n")
                .append("  background-color: #F7F7F7;\n")
                .append("  margin: 0;\n")
                .append("  height: 100%;\n")
                .append("  padding-inline-start: 10px;\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: start;\n")
                .append("}\n\n")

                .append(".side-section {\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: start;\n")
                .append("  width: 100%;\n")
                .append("  margin-bottom: 20px;\n")
                .append("}\n\n")

                .append(".side-section h2 {\n")
                .append("  font-size: 22px;\n")
                .append("  font-weight: bold;\n")
                .append("  text-transform: capitalize;\n")
                .append("  margin-bottom: 10px;\n")
                .append("}\n\n")

                .append(".side-check {\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: start;\n")
                .append("  gap: 10px;\n")
                .append("  width: 100%;\n")
                .append("}\n\n")

                .append(".sidebar-product {\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: flex-start;\n")
                .append("  margin-block-start: 40px;\n")
                .append("  background-color: #fff;\n")
                .append("  border-bottom: 1px solid black;\n")
                .append("  gap: 20px;\n")
                .append("}\n\n")

                .append(".sidebar-product img {\n")
                .append("  width: 100%;\n")
                .append("}\n\n")

                .append(".sidebar-product div {\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: flex-start;\n")
                .append("  text-align: left;\n")
                .append("  gap: 10px;\n")
                .append("}\n\n")

                .append(".sidebar-product div h2 {\n")
                .append("  font-size: 30px;\n")
                .append("}\n\n")

                .append(".sidebar-product div p {\n")
                .append("  font-size: 18px;\n")
                .append("}\n\n")

                .append(".sidebar button {\n")
                .append("  margin-top: 40px;\n")
                .append("  margin-left: 20px;\n")
                .append("  cursor: pointer;\n")
                .append("  width: 45px;\n")
                .append("  height: 50px;\n")
                .append("  border: none;\n")
                .append("  outline: none;\n")
                .append("  background-color: #232F3E;\n")
                .append("  color: white;\n")
                .append("  font-size: 30px;\n")
                .append("  display: flex;\n")
                .append("  align-items: center;\n")
                .append("  justify-content: center;\n")
                .append("  border-radius: 50%;\n")
                .append("  border: 2px solid black;\n")
                .append("  transition: transform 0.1s ease-in-out;\n")
                .append("}\n\n")

                .append(".sidebar button:hover {\n")
                .append("  /* background-color: #232F3E; */\n")
                .append("  box-shadow: 0 0 5px white;\n")
                .append("  transform: scale(1.05);\n")
                .append("}\n\n")

                .append(".catalog {\n")
                .append("  flex: 8;\n")
                .append("  padding-inline: 2%;\n")
                .append("  padding-block-start: 2rem;\n")
                .append("}\n\n")

                .append(".product-list {\n")
                .append("  margin-top: 20px;\n")
                .append("  display: flex;\n")
                .append("  flex-wrap: wrap;\n")
                .append("  gap: 20px;\n")
                .append("  justify-content: center;\n")
                .append("  width: 100%;\n")
                .append("}\n\n")

                .append(".product-item {\n")
                .append("  width: 20%;\n")
                .append("  height: 300px;\n")
                .append("  cursor: pointer;\n")
                .append("  display: flex;\n")
                .append("  flex-direction: column;\n")
                .append("  align-items: center;\n")
                .append("  border-radius: 5px;\n")
                .append("  transition: transform 0.3s ease-in-out;\n")
                .append("  background-color: #fff;\n")
                .append("  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n")
                .append("}\n\n")

                .append(".product-item:hover {\n")
                .append("  transform: scale(1.05);\n")
                .append("}\n\n")

                .append(".product-image {\n")
                .append("  width: 150px;\n")
                .append("  height: 90%;\n")
                .append("  border-radius: 5px;\n")
                .append("  transform: scale(0.9);\n")
                .append("}\n\n")

                .append(".product-name {\n")
                .append("  margin-top: 10px;\n")
                .append("  font-weight: bold;\n")
                .append("  justify-self: end;\n")
                .append("  width: 100%;\n")
                .append("  height: 10%;\n")
                .append("}\n");

        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append("// script.js\n");
        for (Statement statement : statements) {
            if (!statement.convertToJs().isEmpty()) {
                jsBuilder.append(statement.convertToJs()).append("\n");
            }
        }
        jsBuilder.append("document.querySelector(\"#app\").innerHTML = App();");
        return jsBuilder.toString();
    }
}
