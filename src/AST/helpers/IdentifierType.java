package AST.helpers;

public class IdentifierType extends VariableType{

    private String identifier;

    public IdentifierType() {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
