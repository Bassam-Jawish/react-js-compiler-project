package AST.statement;

import java.util.List;

public class Test extends Statement{

 private String string;

 private List<Statement> statements;

    public Test() {
        this.string = string;
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    @Override
    public String toString() {
        return "Test{" +
                "string='" + string + '\'' +
                ((statements != null ) ? ", statements {" + statements.toString() +
                        '}' : ""
                  );
    }


    @Override
    public String convertToHtml() {
        return "";
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
