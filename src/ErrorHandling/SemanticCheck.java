package ErrorHandling;


import AST.expression.Expression;
import AST.program.Program;
import SymbolTableStructure.Row;
import SymbolTableStructure.SymbolTable;
import SymbolTableStructure.SymbolTable2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SemanticCheck {

////////////////////////////////////////////////////////////////////////////////////////////////////

    // List of Errors
    public static List<String> Errors = new ArrayList<>();

////////////////////////////////////////////////////////////////////////////////////////////////////

    // Symbol table

    SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // checkIfVariableUsedNotDefined
    Stack<Map<String, Integer>> checkScopes = new Stack<>();

    public Stack<Map<String, Integer>> getCheckScopes() {
        return checkScopes;
    }

    public void setCheckScopes(Stack<Map<String, Integer>> checkScopes) {
        this.checkScopes = checkScopes;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    // checkIfVariableUsedNotDefined

    private Map<String, String> declaredVariables = new HashMap<>();
    {
        declaredVariables.put("map@0", "function");
        declaredVariables.put("toLowerCase@0", "function");
        declaredVariables.put("includes@0", "function");
        declaredVariables.put("filter@0", "function");
    }

    public Map<String, String> getDeclaredVariables() {
        return declaredVariables;
    }

    public void setDeclaredVariables(Map<String, String> declaredVariables) {
        this.declaredVariables = declaredVariables;
    }

    public void setOneDeclaredVariable(String variableName, int scopeId, String type) {
        this.declaredVariables.put(variableName + "@" + scopeId, type);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // checkIfVariableIsDefinedAndConst
    private final Map<String, Boolean> usedConstVariables = new HashMap<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////


    // checkHooksTopLevel
    private int functionComponentScope = 0;

    public int getFunctionComponentScope() {
        return functionComponentScope;
    }

    public void setFunctionComponentScope(int functionComponentScope) {
        this.functionComponentScope = functionComponentScope;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // checkIfHooksAreImported
    public Boolean isReactImported = false;

    public Boolean isUseStateImported = false;

    public Boolean isUseEffectImported = false;

    public Boolean isUseRefImported = false;

    public Boolean getReactImported() {
        return isReactImported;
    }

    public void setReactImported(Boolean reactImported) {
        isReactImported = reactImported;
    }

    public Boolean getUseStateImported() {
        return isUseStateImported;
    }

    public void setUseStateImported(Boolean useStateImported) {
        isUseStateImported = useStateImported;
    }

    public Boolean getUseEffectImported() {
        return isUseEffectImported;
    }

    public void setUseEffectImported(Boolean useEffectImported) {
        isUseEffectImported = useEffectImported;
    }

    public Boolean getUseRefImported() {
        return isUseRefImported;
    }

    public void setUseRefImported(Boolean useRefImported) {
        isUseRefImported = useRefImported;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public void check(Program program) {
        try {
            String fileName = "test/semantic.txt";
            FileWriter test = new FileWriter(fileName);

            // Error Handling
            checkIfVariableAlreadyDefined();

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
                Map<String, Integer> top = checkScopes.peek();
                if (top.getOrDefault(name, 0) > 0) {
                    // Error
                    Errors.add("Error: Variable '" + name + "' is already defined in scope " + scopeId);
                } else {
                    top.put(name, top.getOrDefault(name, 0) + 1);
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

    public void checkIfVariableUsedNotDefined(String variableUsedName, int variableUsedScope) {
        boolean isDefined = false;
        String type  = "";
        for (int scope = variableUsedScope; scope >= 0; scope--) {
            if (declaredVariables.containsKey(variableUsedName + "@" + scope)) {
                isDefined = true;
                type = declaredVariables.get(variableUsedName + "@" + scope);
                break;
            }
        }
        if (!isDefined) {
            Errors.add("Error: Variable '" + variableUsedName + "' is used in scope " + variableUsedScope + " but not defined above in this scope or at the top levels");
        } else if (type.equals("const")) {
            this.usedConstVariables.put(variableUsedName, true);
        }
    }

    public void checkIfVariableIsConst(String variableUsedName) {
        if (this.usedConstVariables.getOrDefault(variableUsedName, false)) {
            Errors.add("Error: You cannot assign a value to a constant variable: " + variableUsedName);
        }
    }

    public void checkIfTwoTagsAreNotEquals(String tagOne, String tagTwo) {
        if (!tagOne.equals(tagTwo)) {
            Errors.add("Error: Open Tag: (" + tagOne + ") doesn't equal Closed Tag: (" + tagTwo + ")");
        }
    }

    public void checkHooksTopLevel(int scope, String hook) {
        if (scope != 1 || functionComponentScope != 1) {
            Errors.add("Error: Hook: (" + hook + ") is not inside a function component at the top level");
        }
    }

    public void checkIfHooksAreImported(String hookType) {
        if (!isUseStateImported && hookType.equals("UseState")) {
            Errors.add("Error: UseState is used but not imported!");
        } else if (!isUseEffectImported && hookType.equals("UseEffect")) {
            Errors.add("Error: UseEffect is used but not imported!");
        } else if (!isUseRefImported && hookType.equals("UseRef")) {
            Errors.add("Error: UseRef is used but not imported!");
        } else if (!isReactImported && hookType.equals("CreateElement")) {
            Errors.add("Error: CreateElement (Pure React) is used but not imported!");
        }
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
