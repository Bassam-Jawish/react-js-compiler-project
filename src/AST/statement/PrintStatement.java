package AST.statement;
import AST.Space;
import AST.expression.Expression;

public class PrintStatement extends Statement{

    private Expression expression;
    private String console ;
    private String log;


    public void setConsole(String console) {
        this.console = console;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getConsole() {
        return console;
    }

    public String getLog() {
        return log;
    }

    public PrintStatement() {
        this.expression = expression;
        this.console = console;
        this.log = log;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (expression == null) {
            stringBuilder.append("Print Statement: {}");
        }
        else {
            stringBuilder.append("Print Statement: {\n");
            Space.currentValue++;
            stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        }
        return stringBuilder.toString();

    }


    @Override
    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    @Override
    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }
    @Override
    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append("console").append(".").append("log").append("(");
        if (expression != null) {
            jsBuilder.append(expression.convertToJs());
        }
        jsBuilder.append(");");
        return jsBuilder.toString();
    }
}
