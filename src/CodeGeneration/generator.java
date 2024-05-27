package CodeGeneration;


import AST.program.Program;

import java.io.FileWriter;
import java.io.IOException;

public class generator {
    int pages = 1, inputs = 0;

    // code

    /*-----------------------------To Be Continued----------------------------------------------------------------*/

    private void generate(String s, FileWriter fw) {
        try {
//            System.out.print(s);
            fw.append(s);
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    String maa(String maav) {
        if (maav == "MainAxisAlignment.start")
            return "display:flex;" +
                    "flex-direction:row;" +
                    "justify-content:flex-start";
        else if (maav == "MainAxisAlignment.end")
            return "display:flex;" +
                    "flex-direction:row;" +
                    "justify-content:flex-end";
        else if (maav == "MainAxisAlignment.center")
            return "display:flex;" +
                    "flex-direction:row;" +
                    "justify-content:flex-center";
        return " ";
    }

    String init() {
        return "\n<style>\n" +
                "  .container {\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "    height: 100vh;\n" +
                "  }\n" +
                "  .hidden {\n" +
                "    display: none;\n" +
                "  }\n" +
                "</style>\n";
    }
}
