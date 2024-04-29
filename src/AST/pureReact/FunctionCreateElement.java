package AST.pureReact;

import AST.Space;
import AST.function.Value;
import AST.helpers.ObjectDeclaration;
import AST.statement.Statement;

import java.util.List;

public class FunctionCreateElement extends Statement {

    private Value value;

    private ObjectDeclaration objectDeclarationTY;

    private List<CreateFunctionParams> createFunctionParams;

    public FunctionCreateElement() {

    }


    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public ObjectDeclaration getObjectDeclarationTY() {
        return objectDeclarationTY;
    }

    public void setObjectDeclarationTY(ObjectDeclaration objectDeclarationTY) {
        this.objectDeclarationTY = objectDeclarationTY;
    }


    public List<CreateFunctionParams> getFunctionThirdParam() {
        return createFunctionParams;
    }

    public void setFunctionThirdParam(List<CreateFunctionParams> createFunctionParams) {
        this.createFunctionParams = createFunctionParams;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("FunctionCreateElement: {\n");
        Space.currentValue++;

        if (value != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(value.toString()).append(",\n");
        }
        if (objectDeclarationTY != null) {
            stringBuilder.append("\t".repeat(Space.currentValue)).append(objectDeclarationTY.toString()).append(",\n");
        }
        if (!createFunctionParams.isEmpty()) {
            for (CreateFunctionParams createFunctionParams1 : createFunctionParams) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(createFunctionParams1.toString()).append(",\n");
            }
        }

        Space.currentValue--;
        stringBuilder.append("\t".repeat(Space.currentValue)).append("}");

        return stringBuilder.toString();
    }
}
