package MyApp;


import AST.program.Program;
import CodeGeneration.Generation;
import ErrorHandling.SemanticCheck;
import Visitor.ASTVisitor;
import antlr.ReactjsLexer;
import antlr.ReactjsParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
        try {
            // String path = "test/test.txt";
            // String path = "test/test2.txt";
            // String path = "test/test3.txt";
            // String path = "test/test4.txt";
             String path = "test/test_interview.txt";
            // String path = "test/useState.txt";
            // String path = "test/useEffect.txt";
            // String path = "test/useReference.txt";
            // String path = "test/createElement.txt";
            // String path = "test/iteration.txt";
            // String path = "test/condition.txt";
            // String path = "test/expressions.txt";

            // Semantic Check Errors Test
            // String path = "test/error_handling_test/checkIfVariableAlreadyDefinedTest.txt";
            // String path = "test/error_handling_test/checkIfVariableUsedNotDefinedTest.txt";
            // String path = "test/error_handling_test/checkIfVariableIsConstTest.txt";
            // String path = "test/error_handling_test/checkIfTwoTagsAreNotEqualsTest.txt";
            // String path = "test/error_handling_test/checkHooksTopLevelTest.txt";
            // String path = "test/error_handling_test/checkIfHooksAreImportedTest.txt";
            // String path = "test/help.txt";
            CharStream input = fromFileName(path);
            ReactjsLexer lexer = new ReactjsLexer(input);
            CommonTokenStream token = new CommonTokenStream(lexer);
            ReactjsParser parser = new ReactjsParser(token);
            ReactjsParser.ProgramContext tree = parser.program();
            SemanticCheck semanticCheck = new SemanticCheck();
            ASTVisitor astVisitor = new ASTVisitor(semanticCheck);
            Program program = (astVisitor.visitProgram(tree));
            System.out.println(program);
            System.out.println(astVisitor.getSymbolTable().toString());
            semanticCheck.setSymbolTable(astVisitor.getSymbolTable());
            semanticCheck.check(program);
            Generation codeGeneration = new Generation();
            codeGeneration.generateOutputFiles(program);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}