package AST.hook;

import java.util.ArrayList;
import java.util.List;

import AST.Space;
import AST.function.Value;
import AST.helpers.VariableType;

public class UseStateHook extends Hook{
    private List<Value> values;

    public UseStateHook() {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UseStateHook: USE_STATE(");
        for (Value value : values) {
            stringBuilder.append(value.toString()).append(",");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
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
        StringBuilder js = new StringBuilder();
        if (values != null && !values.isEmpty()) {
            js.append("const [state, setState] = useState(");
            for (Value value : values) {
                js.append(value.toString()).append(", ");
            }
            if (!values.isEmpty()) {
                js.delete(js.length() - 2, js.length()); // Remove trailing comma
            }
            js.append(");\n");
        }
        return js.toString();
    }
}
