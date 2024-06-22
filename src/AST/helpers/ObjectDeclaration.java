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
        Space.currentValue++;
        if (objectProperty.size() != 1) {
            jsBuilder.append("{");
        }
        for (int i = 0; i < objectProperty.size(); i++) {
            ObjectProperty objectPropertyy =  objectProperty.get(i);
            if (i == objectProperty.size() - 1) {
                jsBuilder.append(objectPropertyy.convertToJs());
            }
            else {
                jsBuilder.append(objectPropertyy.convertToJs()).append(", ");
            }
        }
        Space.currentValue--;
        if (objectProperty.size() != 1) {
            jsBuilder.append("}");
        }
        return jsBuilder.toString();
    }
}
