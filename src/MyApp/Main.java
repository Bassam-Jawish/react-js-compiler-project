package MyApp;


import AST.program.Program;
import Visitor.ASTVisitor;
import antlr.ReactjsLexer;
import antlr.ReactjsParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
        try {
            //String path = "test/test.txt";
            // String path = "test/test2.txt";
            // String path = "test/test3.txt";
            String path = "test/test_interview.txt";
            // String path = "test/useState.txt";
            // String path = "test/useEffect.txt";
            // String path = "test/useReference.txt";
            // String path = "test/createElement.txt";
            // String path = "test/iteration.txt";
            //String path = "test/condition.txt";
            //String path = "test/expressions.txt";
            CharStream input = fromFileName(path);
            ReactjsLexer lexer = new ReactjsLexer(input);
            CommonTokenStream token = new CommonTokenStream(lexer);
            ReactjsParser parser = new ReactjsParser(token);
            ReactjsParser.ProgramContext tree = parser.program();
            ASTVisitor astVisitor = new ASTVisitor();
            Program program = (astVisitor.visitProgram(tree));
            System.out.println(program);
            System.out.println(astVisitor.s.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
