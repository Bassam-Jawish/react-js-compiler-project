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

}
