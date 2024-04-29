package AST.statement;

import java.util.ArrayList;
import java.util.List;

import AST.expression.Expression;

public class FunctionCall extends Statement{
    private String functionName;
    private List<Expression> expressions;

    public FunctionCall() {
        this.functionName = functionName;
        this.expressions = expressions;
    }
    public String getFunctionName() {
        return functionName;
    }
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
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
        stringBuilder.append("FunctionCall: ").append(functionName).append("(");
        for (int i = 0; i < expressions.size(); i++) {
            stringBuilder.append(expressions.get(i).toString());
            if (i < expressions.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
