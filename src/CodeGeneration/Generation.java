package CodeGeneration;

import AST.program.Program;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Generation {

    public Generation() {}

    public void generateOutputFiles(Program program) {
        String outputDir = "src/OutputFiles/";

        try {
            Files.createDirectories(Paths.get(outputDir));

            String htmlFilePath = outputDir + "output.html";
            String cssFilePath = outputDir + "styles.css";
            String jsFilePath = outputDir + "script.js";

            FileWriter htmlWriter = new FileWriter(htmlFilePath);
            FileWriter cssWriter = new FileWriter(cssFilePath);
            FileWriter jsWriter = new FileWriter(jsFilePath);

            String htmlContent = program.convertToHtml();
            String cssContent = program.convertToCss();
            String jsContent = program.convertToJs();

            htmlWriter.write(htmlContent);
            cssWriter.write(cssContent);
            jsWriter.write(jsContent);

            htmlWriter.close();
            cssWriter.close();
            jsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
