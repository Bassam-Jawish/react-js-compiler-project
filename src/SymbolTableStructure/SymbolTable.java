package SymbolTableStructure;

import AST.Space;

import java.util.*;

public class SymbolTable {
    private List<Row> rows = new ArrayList<>();

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    private int currentScopeId = 0;

    public int getScopeId() {
        return currentScopeId;
    }

    public void setScopeId(int scopeId) {
        this.currentScopeId = scopeId;
    }

    public void enterScope() {
        currentScopeId++;
    }

    public void exitScope() {
        currentScopeId--;
    }


    public void addVariable(Row row) {
        rows.add(row);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Symbol Table:\n");
        stringBuilder.append("*").append("*".repeat(180)).append("*\n");
        stringBuilder.append(String.format("| %-10s | %-65s | %-65s \n", "Scope Id", "Variable Name", "Value"));
        stringBuilder.append("*").append("*".repeat(180)).append("*\n");

        // Find the maximum width needed for the fourth column
        int maxThirdColumnWidth = 0;
        for (Row row : rows) {
            if (row != null) {
                int valueLength = row.getValue().lines().mapToInt(String::length).max().orElse(0);
                maxThirdColumnWidth = Math.max(maxThirdColumnWidth, valueLength);
            }
        }

        for (Row row : rows) {
            if (row != null) {
                String[] valueLines = row.getValue().split("\\n");
                int maxValueLines = Math.max(valueLines.length, 1);

                for (int i = 0; i < maxValueLines; i++) {
                    String valueLine = (i < valueLines.length) ? valueLines[i] : "";
                    String variableName = (i == 0) ? row.getVariableName() : "";

                    stringBuilder.append(String.format("| %-10s | %-65s | %-65s  \n", (i == 0) ? row.getScopeId() : "", variableName, valueLine + " ".repeat(maxThirdColumnWidth - valueLine.length())));
                }

                stringBuilder.append("*").append("*".repeat(180)).append("*\n");
            }
        }

        return stringBuilder.toString();
    }

}
