package AST.helpers;

import AST.Space;
import AST.statement.Statement;

import java.util.List;

public class ObjectDeclaration extends VariableType{
    private List<ObjectProperty> objectProperty;

    public ObjectDeclaration( ) {

    }

    public List<ObjectProperty> getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(List<ObjectProperty> objectProperty) {
        this.objectProperty = objectProperty;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        if (!objectProperty.isEmpty()) {
            stringBuilder.append("Object Declaration: {\n");
            Space.currentValue++;
            for (ObjectProperty objectProperty1 : objectProperty) {
                stringBuilder.append("\t".repeat(Space.currentValue)).append(objectProperty1.toString()).append(",\n");
            }
            Space.currentValue--;
            stringBuilder.append("\t".repeat(Space.currentValue)).append("}");
        } else {
            stringBuilder.append("Object Declaration: {}");
        }
        return stringBuilder.toString();
    }
}
