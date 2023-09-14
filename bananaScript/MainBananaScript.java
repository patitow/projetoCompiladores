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
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        System.out.println(main());\n");
                writer.write("    }\n");
                writer.write("}\n");
                return;
            case "Function":
                String functionName = t.getChild(1).getText();
                String returnType = t.getChild(t.getChildCount() - 2).getText();
                writer.write("    public static " + returnType + " " + functionName + "(");
                if (t.getChildCount() > 5) {
                    for (int i = 3; i < t.getChildCount() - 2; i += 2) {
                        String paramType = t.getChild(i - 1).getText();
                        String paramName = t.getChild(i).getText();
                        writer.write(paramType + " " + paramName);
                        if (i < t.getChildCount() - 3) {
                            writer.write(", ");
                        }
                    }
                }
                writer.write(") {\n");
                // Processar o bloco da função aqui
                generateCode(t.getChild(t.getChildCount() - 1), writer);
                writer.write("    }\n");
                return;
            case "ReturnStatement":
                ParseTree expression = t.getChild(1);
                writer.write("        return ");
                generateCode(expression, writer);
                writer.write(";\n");
                return;
            case "FunctionCall":
                String functionNameCall = t.getChild(0).getText();
                writer.write(functionNameCall + "(");
                if (t.getChildCount() > 2) {
                    for (int i = 1; i < t.getChildCount() - 1; i += 2) {
                        generateCode(t.getChild(i), writer);
                        if (i < t.getChildCount() - 2) {
                            writer.write(", ");
                        }
                    }
                }
                writer.write(")");
                return;
            case "Int":
            case "String":
            case "ID":
                writer.write(t.getText());
                return;
            default:
                for (int i = 0; i < t.getChildCount(); i++) {
                    generateCode(t.getChild(i), writer);
                }
        }
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
