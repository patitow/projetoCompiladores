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
    if (t instanceof ParserRuleContext) {
        String name = t.getClass().getName();
        name = name.substring(name.indexOf("$")+1);
        name = name.substring(0,name.indexOf("Context"));
        System.out.println(name);
        return name;
    } else {
        return "Unknown"; // Trate casos desconhecidos ou não-contextuais aqui, se necessário
    }
}

    static void generateCode(ParseTree t, BufferedWriter writer) throws IOException {
        switch (opName(t)) {
            case "Program":
                writer.write("public class GeneratedCode {\n");
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        main()    \n");
                writer.write("    }\n\n");
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                writer.write("  }\n\n");
                return;
            case "Function":
                String functionName = t.getChild(1).getText();
                String returnType = t.getChild(t.getChildCount() - 2).getText();
                writer.write("    public " + returnType + " " + functionName + "(");
                ParseTree functionParams = t.getChild(3);
                generateCode(functionParams, writer);
                writer.write(") {\n");
                ParseTree functionBlock = t.getChild(6);
                generateCode(functionBlock, writer);
                writer.write("    }\n\n");
                return;
            case "Params":
                if(t.getChild(0) != null){
                    ParseTree paramTree = t.getChild(0);
                    generateCode(paramTree, writer);
                }
                return;
            case "ParamOptional":
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                return;
            case "ParamRecursive":
                writer.write(", ");
                generateCode(t.getChild(1), writer);
                return;
            case "Param":
                generateCode(t.getChild(0), writer);
                writer.write(" ");
                generateCode(t.getChild(1), writer);
            case "Type":
                String typeVariable = t.getChild(0).getText();
                writer.write(typeVariable);
                return;
            case "Block":
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                    writer.write("\n");
                }
                return;
            case "Statement":
                ParseTree statExp = t.getChild(0);
                generateCode(statExp, writer);
                return;
            case "Assignment":
                String variableName = t.getChild(0).getText();
                ParseTree expression = t.getChild(2);
                writer.write("        " + variableName + " = ");
                generateCode(expression, writer);
                writer.write(";");
                return;
            case "IfStatement":
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
            case "ElseStatement":
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
            case "WhileStatement":
                writer.write("while (");
                ParseTree expWhile = t.getChild(1);
                generateCode(expWhile, writer);
                writer.write(") {\n");
                ParseTree whileBlock = t.getChild(3);
                generateCode(whileBlock, writer);
                writer.write("\n}");
                return;
            // Adicione mais casos conforme necessário para outros tipos de instruções
            case "ForStatement":
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
            case "TryCatchStatement":
                writer.write("try {\n");
                ParseTree tryBody = t.getChild(1);
                generateCode(tryBody, writer);
                String catchId = t.getChild(5).getText();
                writer.write("}\n catch(Exception " + catchId + ") {\n");
                ParseTree catchBody = t.getChild(10);
                generateCode(catchBody, writer);
                writer.write("}\n");
            case "ReturnStatement":
                ParseTree returnReturn = t.getChild(1);
                writer.write("return ");
                generateCode(returnReturn, writer);
                writer.write(";\n");
                return;
            case "Term": 
                ParseTree expTerm = t.getChild(0);
                generateCode(expTerm, writer);
                return;
            case "FunctionCall":  // ID '(' functionExpression? ')'; // Chamada de função
                ParseTree funC = t.getChild(0);
                generateCode(funC, writer);
                writer.write("(");
                ParseTree funExp = t.getChild(2);
                generateCode(funExp, writer);
                writer.write(")");
                return;
            case "FunctionExpression":  // ID '(' functionExpression? ')'; // Chamada de função
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer);
                }
                return;
            case "FunctionExpressionRecursive":  // ID '(' functionExpression? ')'; // Chamada de função
                writer.write(", ");
                ParseTree funExpR = t.getChild(1);
                generateCode(funExpR, writer);
                return;
            case "Expression": 
                ParseTree expExp = t.getChild(0);
                generateCode(expExp, writer);
                if (t.getChildCount() > 1){
                    String expOperator = t.getChild(1).getText();
                    writer.write(" " + expOperator + " ");
                    ParseTree expExp1 = t.getChild(2);
                    generateCode(expExp1, writer);
                }
                return;
            case "Print":
                writer.write("System.out.println(");
                ParseTree printTerm = t.getChild(2);
                generateCode(printTerm, writer);
                writer.write(");");
                return;
            default:
                if(t.getChildCount()>0){
                    for (int c = 0; c < t.getChildCount(); c++) {
                        //generateCode(t.getChild(c), writer);
                        writer.write(t.getChild(c).getText()+" ");
                    }
                } else {
                    if(t.getText() != "<EOF>"){
                        writer.write(t.getText());
                    }
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