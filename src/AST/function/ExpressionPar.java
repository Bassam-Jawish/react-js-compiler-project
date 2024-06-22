package AST.function;

import AST.expression.Expression;

import java.util.List;

public class ExpressionPar extends ArrowParameters{
    private List<Expression> expression;

    public ExpressionPar() {

    }

    public List<Expression> getExpression() {
        return expression;
    }

    public void setExpression(List<Expression> expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return expression.toString();
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
        StringBuilder jsBuilder = new StringBuilder();
        if (!expression.isEmpty()) {
            for (int i = 0; i < expression.size(); i++) {
                jsBuilder.append(expression.get(i).convertToJs());
                if (i < expression.size() - 1) {
                    jsBuilder.append(",");
                }
            }
        }
        return jsBuilder.toString();
    }
}
