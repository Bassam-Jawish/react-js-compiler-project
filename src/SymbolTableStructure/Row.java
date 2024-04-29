package SymbolTableStructure;

public class Row {
    private String variableName;
    private String value;
    private  int scope_id = 0;

    public Row() {}

    public String getVariableName() {
        return variableName;
    }
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getScope_id() {
        return scope_id;
    }

    public void setScope_id(int scope_id) {
        this.scope_id = scope_id;
    }

}
