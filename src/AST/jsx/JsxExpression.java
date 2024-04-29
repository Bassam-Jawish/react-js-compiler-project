package AST.jsx;

import AST.Space;
import AST.expression.Expression;

import java.util.List;

public class JsxExpression{

    private List<Expression> expressions;

    public JsxExpression() {

    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!expressions.isEmpty()) {
            stringBuilder.append("Expressions: [\n");
            Space.currentValue++;
            for (Expression expression : expressions) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(expression.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("]");
        } else {
            stringBuilder.append("Expressions: {}");
        }
        return stringBuilder.toString();
    }
}
