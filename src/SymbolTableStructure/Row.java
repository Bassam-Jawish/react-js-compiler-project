package SymbolTableStructure;

public class Row {
    private int line;
    private String variableName;
    private String type;
    private String value;
    private int scopeId = 0;

    public Row() {}


    public int getLine() {
        return line;
    }
    public void setLine(int line) {
        this.line = line;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

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

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeid(int scopeId) {
        this.scopeId = scopeId;
    }

}
