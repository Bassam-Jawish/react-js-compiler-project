package SymbolTableStructure;

import AST.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    List <Row> rows = new ArrayList<>();
    public List<Row> getRows() {
        return rows;
    }

    public  void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Symbol Table:\n");
        stringBuilder.append("*").append("*".repeat(100)).append("*\n");
        stringBuilder.append(String.format("| %-12s | %-15s | %-60s |\n", "Scope Id","Variable Name","Value"));
        stringBuilder.append("*").append("*".repeat(100)).append("*\n");

        // Find the maximum width needed for the third column
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

                    stringBuilder.append(String.format("| %-12s | %-15s | %-60s | \n", (i==0)? row.getScope_id():"",variableName, valueLine + " ".repeat(maxThirdColumnWidth - valueLine.length())));
                }

                stringBuilder.append("*").append("*".repeat(100)).append("*\n");
            }
        }

        return stringBuilder.toString();
    }

}
