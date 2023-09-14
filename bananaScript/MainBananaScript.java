import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MainBananaScript {

    static void print(String fmt, Object... args) {
        System.out.print(String.format(fmt, args));
    }

    static void println(String fmt, Object... args) {
        System.out.println(String.format(fmt, args));
    }

    static String opName(ParseTree t) {
        String name = t.getClass().getName();
        name = name.substring(name.indexOf("$") + 1);
        name = name.substring(0, name.indexOf("Context"));
        return name;
    }

    static void generateCode(ParseTree t, BufferedWriter writer) throws IOException {
        switch (opName(t)) {
            case "Program":
                writer.write("public class GeneratedCode {\n");
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        GeneratedCode generatedCode = new GeneratedCode();\n");
                writer.write("        generatedCode.run(args);\n");
                writer.write("    }\n\n");
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                return;
            case "Function":
                String functionName = t.getChild(1).getText();
                String returnType = t.getChild(t.getChildCount() - 2).getText();
                writer.write("    public " + returnType + " " + functionName + "(");
                // Processar parâmetros, bloco e outras partes da função aqui
                writer.write(") {\n");
                // Escrever a lógica da função aqui
                writer.write("    }\n\n");
                return;
            case "Assignment":
                String variableName = t.getChild(0).getText();
                ParseTree expression = t.getChild(2);
                writer.write("        " + variableName + " = ");
                generateCode(expression, writer);
                writer.write(";\n");
                return;
            // Adicione mais casos conforme necessário para outros tipos de instruções
            default:
                // Tratar outros tipos de instruções aqui
        }
    }

    public void run(String[] args) {
        // Implementar a lógica para executar os argumentos da main aqui
    }

    public static void main(String[] args) throws Exception {
        CharStream stream = CharStreams.fromFileName("banana.ban");
        BananaScriptLexer lexer = new BananaScriptLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        BananaScriptParser parser = new BananaScriptParser(tokenStream);

        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() == 0)
            System.out.println("Programa reconhecido corretamente");
        else {
            System.out.println("Programa possui erros, corrija-os");
            return;
        }

        File outputDir = new File("out");
        outputDir.mkdir(); // Cria a pasta 'out' se ela não existir

        File outputFile = new File(outputDir, "GeneratedCode.java");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        println("Gerando artefatos de código em %s:", outputFile.getAbsolutePath());
        generateCode(tree, writer);

        writer.close();
    }
}