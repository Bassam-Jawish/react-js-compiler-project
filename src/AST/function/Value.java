package AST.function;

public class Value extends ArrowParameters{

    private String type;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value() {

    }

    @Override
    public String toString() {
        if (type != null && value != null) {
            if ("String".equals(type)) {
                return "{Type = " + type + ", Value = \"" + value + "\"}";
            } else {
                return "{Type = " + type + ", Value = " + value + "}";
            }
        }
        return "{Type = " + type + ", Value = " + value + "}";
    }
}
