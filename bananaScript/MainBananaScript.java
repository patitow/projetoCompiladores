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
            case "program":
                writer.write("public class GeneratedCode {\n");
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        System.out.println(main());    \n");
                writer.write("    }\n\n");
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                writer.write("  }\n\n");
                return;
            case "dunction":
                String functionName = t.getChild(1).getText();
                String returnType = t.getChild(t.getChildCount() - 2).getText();
                writer.write("    public " + returnType + " " + functionName + "(");
                // Processar parâmetros, bloco e outras partes da função aqui
                writer.write(") {\n");
                ParseTree functionBlock = t.getChild(6);
                generateCode(functionBlock, writer);
                writer.write("    }\n\n");
                return;
            case "params":
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                    if (c+1 == t.getChildCount() -1) {
                        writer.write(", ");
                    }
                }
                return;
            case "type":
                String typeVariable = t.getChild(0).getText();
                writer.write(typeVariable);
                return;
            case "assignment":
                String variableName = t.getChild(0).getText();
                ParseTree expression = t.getChild(2);
                writer.write("        " + variableName + " = ");
                generateCode(expression, writer);
                writer.write(";\n");
                return;
            case "ifStatement":
                writer.write("if (");
                ParseTree expIF = t.getChild(1);
                generateCode(expIF, writer);
                writer.write(") {\n");
                ParseTree ifBlock = t.getChild(3);
                generateCode(ifBlock, writer);
                writer.write("\n}");
                if (t.getChildCount() == 4) {
                    generateCode(t.getChild(4), writer);
                }
                return;
            case "elseStatement":
                writer.write("else {");
                ParseTree expElse = t.getChild(1);
                writer.write("\n");
                ParseTree elseBlock = t.getChild(3);
                generateCode(elseBlock, writer);
                writer.write("\n}");
                if (t.getChildCount() == 4) {
                    generateCode(t.getChild(4), writer);
                }
                return;
            case "whileStatement":
                writer.write("while (");
                ParseTree expWhile = t.getChild(1);
                generateCode(expWhile, writer);
                writer.write(") {\n");
                ParseTree whileBlock = t.getChild(3);
                generateCode(whileBlock, writer);
                writer.write("\n}");
                return;
            // Adicione mais casos conforme necessário para outros tipos de instruções
            case "forStatement":
                writer.write("for (int ");
                ParseTree forID = t.getChild(1);
                generateCode(forID, writer);
                writer.write("= ");
                ParseTree forExp = t.getChild(3);
                generateCode(forExp, writer);
                writer.write("; ");
                ParseTree forBooleanExp = t.getChild(5);
                generateCode(forBooleanExp, writer);
                writer.write("; ");
                ParseTree forID2 = t.getChild(7);
                generateCode(forID2, writer);
                writer.write(t.getChild(8) + ") {\n");
                ParseTree forBlock = t.getChild(10);    
                generateCode(forBlock, writer);
                writer.write("\n}");
                return;       
            case "tryCatchStatement":
                writer.write("try {\n");
                ParseTree tryBody = t.getChild(1);
                generateCode(tryBody, writer);
                String catchId = t.getChild(5).getText();
                writer.write("}\n catch(Exception " + catchId + ") {\n");
                ParseTree catchBody = t.getChild(10);
                generateCode(catchBody, writer);
                writer.write("}\n");
            case "returnStatement":
                String returnReturn = t.getChild(1).getText();
                writer.write("return " + returnReturn + ";\n");
                return;
            case "expressionStatement": // term (('*' | '+' | '-' | '/') term)*;
                ParseTree expExp = t.getChild(0);
                generateCode(expExp, writer);
                String expOperator = t.getChild(1).getText();
                writer.write(" " + expOperator + " ");
                ParseTree expExp1 = t.getChild(2);
                generateCode(expExp1, writer);
                return;
            default:
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                if (t.getChildCount() == 1) {
                    writer.write(t.getChild(0).getText());
                }
                return;
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