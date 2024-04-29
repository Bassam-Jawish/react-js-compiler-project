package AST.hook;

import java.util.ArrayList;
import java.util.List;

import AST.function.Value;
import AST.helpers.VariableType;

public class UseRefHook extends Hook{
    private String refTagName;
    private List<Value> values;

    public UseRefHook() {

    }

    public String getRefIdentifier() {
        return refTagName;
    }

    public void setRefIdentifier(String refIdentifier) {
        this.refTagName = refIdentifier;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UseRefHook: USE_REF");
        if (refTagName != null) {
            stringBuilder.append(" <").append(refTagName).append(">");
        }
        if (values != null && !values.isEmpty()) {
            stringBuilder.append(" (");
            for (Value value : values) {
                stringBuilder.append(value.toString()).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

}
