package AST.helpers;

public class ImportSpecifier {
    private String type;

    public ImportSpecifier() {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImportSpecifier: {" +
                "Name = " +  (type != null ? type.toString() : "") +
                '}';
    }
}
