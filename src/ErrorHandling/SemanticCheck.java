package ErrorHandling;


import AST.program.Program;
import SymbolTableStructure.Row;
import SymbolTableStructure.SymbolTable;
import SymbolTableStructure.SymbolTable2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SemanticCheck {

    public static List<String> Errors = new ArrayList<>();

    SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }


    // checkIfVariableUsedNotDefined
    Stack<Map<String, Integer>> checkScopes = new Stack<>();

    public Stack<Map<String, Integer>> getCheckScopes() {
        return checkScopes;
    }

    public void setCheckScopes(Stack<Map<String, Integer>> checkScopes) {
        this.checkScopes = checkScopes;
    }


    // checkIfVariableUsedNotDefined

    private Map<String, Boolean> declaredVariables = new HashMap<>();

    public Map<String, Boolean> getDeclaredVariables() {
        return declaredVariables;
    }

    public void setDeclaredVariables(Map<String, Boolean> declaredVariables) {
        declaredVariables = declaredVariables;
    }

    public void setOneDeclaredVariable(String variableName) {
        this.declaredVariables.put(variableName, true);
    }

    private Map<String, Boolean> declaredConstVariables = new HashMap<>();

    public Map<String, Boolean> getDeclaredConstVariables() {
        return declaredConstVariables;
    }

    public void setDeclaredConstVariables(Map<String, Boolean> declaredConstVariables) {
        declaredConstVariables = declaredConstVariables;
    }

    public void setOneDeclaredConstVariable(String variableName) {
        this.declaredConstVariables.put(variableName, true);
    }

    public void check(Program program) {
        try {
            FileWriter test = new FileWriter("semantic.txt");

            // Error Handling
            checkIfVariableAlreadyDefined();
            checkHooksTopLevel();
            // checkLine();

            // print Errors
            printErrors();

            test.append("Semantic Check : \n");
            for (int i = 0; i < Errors.size(); i++) {
                test.append(Errors.get(i)).append("\n");
            }
            test.flush();
            test.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkIfVariableAlreadyDefined() {
        List<Row> variables = symbolTable.getRows();
        if (!variables.isEmpty()) {
            int cur = 0;
            checkScopes.push(new HashMap<>());
            for (Row row : variables) {
                int scopeId = row.getScopeId();
                String name = row.getVariableName();
                while (cur < scopeId) {
                    cur++;
                    checkScopes.push(new HashMap<>());
                }
                while (cur > scopeId) {
                    checkScopes.pop();
                    cur--;
                }
                Map<String, Integer> top = checkScopes.isEmpty() ? new HashMap<>() : checkScopes.peek();
                if (top.getOrDefault(name, 0) > 0) {
                    // Error
                    Errors.add("Error: Variable '" + name + "' is already defined in scope " + scopeId);
                } else {
                    top.put(name, top.getOrDefault(name, 0) + 1);
                    checkScopes.push(top);
                }
            }
        }

//        if (!variables.isEmpty()) {
//            int lastScope = variables.get(0).getScopeId();
//            String variableName = variables.get(0).getVariableName();
//            Map<String, Boolean> mapForFirstScope = new HashMap<>();
//            mapForFirstScope.put(variableName, true);
//            checkScopes.push(mapForFirstScope);
//            for (int i = 1; i < variables.size(); i++) {
//                Row row = variables.get(i);
//                int scope = row.getScopeId();
//                String name = row.getVariableName();
//                if (scope > lastScope) {
//                    Map<String, Boolean> mapInside = new HashMap<>();
//                    mapInside.put(name,true);
//                    checkScopes.push(mapInside);
//                }
//                else if (scope < lastScope) {
//                    while (lastScope > scope) {
//                        checkScopes.pop();
//                        lastScope--;
//                    }
//                    // scope == lastScope
//                    Map<String, Boolean> mapEquals = checkScopes.pop();
//                    if (mapEquals.get(scope) == null) {
//                        mapEquals.put(name,true);
//                        checkScopes.push(mapEquals);
//                    }
//                    else {
//                        // Error
//                        System.out.println("Error");
//
//                        checkScopes.push(mapEquals);
//                    }
//                }
//                else {
//                    Map<String, Boolean> mapEquals = checkScopes.pop();
//                    if (mapEquals.get(scope) == null) {
//                        mapEquals.put(name,true);
//                        checkScopes.push(mapEquals);
//                    }
//                    else {
//                        // Error
//                        System.out.println("Error");
//
//                        checkScopes.push(mapEquals);
//                    }
//                }
//
//                lastScope = scope;
//            }
//        }
    }

    public void checkIfVariableUsedNotDefined(String variableUsedName) {
        if (!this.declaredVariables.getOrDefault(variableUsedName, false)) {
            Errors.add("Error: Variable '" + variableUsedName + "' is used but not defined.");
        }
    }

    public void checkIfVariableIsConst(String variableUsedName) {
        if (!this.declaredConstVariables.getOrDefault(variableUsedName, false) && this.declaredVariables.getOrDefault(variableUsedName, false)) {
            Errors.add("Error: You cannot assign a value to a constant variable");
        }
    }

    public void checkIfTwoTagsAreNotEquals (String tagOne, String tagTwo) {
        if (!tagOne.equals(tagTwo)) {
            Errors.add("Error: Open Tag: (" + tagOne + ") doesn't equal Closed Tag: (" + tagTwo + ")");
        }
    }


    public void checkHooksTopLevel() {

    }

    private void printErrors() {
        for (String errors : Errors) {
            System.out.println(errors);
        }
    }


    public void checkLine() {
        boolean isError = false;
        /*
        for (int i=0;i<symbolTable.getGlobalScopes().size();i++) {
            if (!isError) {
                // for (int  k=0 ; k<symbolTable.getGlobalScopes().size() ; k++)
                //  System.out.println("wwwwwwwwwwwww"+symbolTable.getGlobalScopes().get(i).getClass());
                //   for (int j = 0; j < symbolTable.getGlobalScopes().size(); j++) {
                //     if (symbolTable.getGlobalScopes().get(i).getName().getClass().getName().contains("global-program") && symbolTable.getGlobalScopes().get(j).getGlobalVar().contains("global-program")&& i!=j) {
                //       if (symbolTable.getGlobalScopes().get(i).getGlobalVar().equals(symbolTable.getGlobalScopes().get(j).getGlobalVar())) {
                //         Errors.add("the link with title " + symbolTable.getGlobalScopes().get(i).getGlobalVar() + " is already exist in line " + symbolTable.getGlobalScopes().get(i));
                //       break;
                //    }
                //}
                // }
            }
//            System.out.println("----------------------------------------------------");
            for (GlobalScope global : symbolTable.getGlobalScopes()) {
                if(global.getNestedScopes().size() > 0)
                {
                    for(int j = 0 ; j<global.getNestedScopes().size() ; j++){
                        for(int k=0; k<global.getNestedScopes().get(j).getSymbols().size();k++){
                            SymbolBase sb = (SymbolBase) global.getNestedScopes().get(j).getSymbols().get(k);
                            for(int l=0; l<global.getNestedScopes().get(j).getSymbols().size();l++){
                                if(l!=k){
                                    SymbolBase sb1 = (SymbolBase) global.getNestedScopes().get(j).getSymbols().get(l);
//                                    System.out.println("sb = " +sb.getName() + " type =  " + sb.getType() + " \nsb1 = " + sb1.getName() + " type =  " + sb1.getType()+"\n\n");
                                    if(sb.getName().equals(sb1.getName())){
                                        Errors.add("Error " + sb.getName() + " is already exist as " +sb1.getType());
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        */
    }
}
