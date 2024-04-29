package AST.pureReact;

import AST.Space;
import AST.function.Value;

public class CreateFunctionParams {

      private Value value;

      private FunctionCreateElement functionCreateElement;

    public CreateFunctionParams() {

    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public FunctionCreateElement getFunctionCreateElement() {
        return functionCreateElement;
    }

    public void setFunctionCreateElement(FunctionCreateElement functionCreateElement) {
        this.functionCreateElement = functionCreateElement;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("FunctionParams: {\n");
        Space.currentValue++;

        if (value != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(value.toString()).append(",\n");
        }
        else if (functionCreateElement != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(functionCreateElement.toString()).append(",\n");
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();


    }

}
