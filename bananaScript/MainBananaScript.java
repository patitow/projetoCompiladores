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
        String text = t.getText();
        name = name.substring(name.indexOf("$")+1);
        name = name.substring(0,name.indexOf("Context"));
        //System.out.println(name);
        return name;
    } else {
        return "Unknown";
    }
}

    static void generateCode(ParseTree t, BufferedWriter writer, int indentLevel) throws IOException {
        String indent = "    ".repeat(indentLevel);
        switch (opName(t)) {
            case "Program":
                writer.write("public class GeneratedCode {\n");
                writer.write("    public static void main(String[] args) {\n");
                writer.write("        main();\n");
                writer.write("}\n\n");
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer, 1);
                }
                writer.write("}\n\n");
                return;
            case "Function":
                String functionName = t.getChild(1).getText();
                String returnType = t.getChild(t.getChildCount() - 2).getText();
                writer.write(indent);
                writer.write("public static " + returnType + " " + functionName + "(");
                ParseTree functionParams = t.getChild(3);
                generateCode(functionParams, writer, indentLevel);
                writer.write(") {\n");
                ParseTree functionBlock = t.getChild(6);
                generateCode(functionBlock, writer, indentLevel+1);
                writer.write(indent);
                writer.write("}\n");
                return;
            case "Params":
                if(t.getChild(0) != null){
                    ParseTree paramTree = t.getChild(0);
                    generateCode(paramTree, writer, indentLevel);
                }
                return;
            case "ParamOptional":
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer, indentLevel);
                }
                return;
            case "ParamRecursive":
                writer.write(", ");
                generateCode(t.getChild(1), writer, indentLevel);
                return;
            case "Param":
                String varType = t.getChild(0).getText();
                writer.write(varType + " ");
                String varName = t.getChild(1).getText();
                writer.write(varName + " ");
            case "Type":
                return;
            case "FunType":
                String funTypeType = t.getChild(0).getText();
                writer.write(funTypeType);
                return;
            case "Block":
                for (int c = 0; c < t.getChildCount(); c++) {
                    writer.write(indent);
                    generateCode(t.getChild(c), writer, indentLevel);
                    writer.write("\n");
                }
                return;
            case "Statement":
                ParseTree statExp = t.getChild(0);
                generateCode(statExp, writer, indentLevel);
                return;
            case "Assignment":
                String variableType = t.getChild(0).getText();
                String variableName = t.getChild(1).getText();
                ParseTree expression = t.getChild(3);
                writer.write(variableType + " " + variableName + " = ");
                generateCode(expression, writer, indentLevel);
                writer.write(";");
                return;
            case "IfStatement":
                writer.write("if (");
                ParseTree expIF = t.getChild(1);
                generateCode(expIF, writer, indentLevel);
                writer.write(") {\n");
                ParseTree ifBlock = t.getChild(2);
                generateCode(ifBlock, writer, indentLevel+1);
                // agora vem o else ou o :
                ParseTree elseOrDoubleDots = t.getChild(3);
                if (elseOrDoubleDots.getText() == ":"){
                    writer.write(indent);
                    writer.write("}\n");
                } else {
                    writer.write(indent);
                    writer.write("} ");
                    generateCode(t.getChild(3), writer, indentLevel);
                }
                return;
            case "ElsifStatement":
                writer.write("else if (");
                ParseTree expElseif = t.getChild(1);
                generateCode(expElseif, writer, indentLevel);
                writer.write(") {\n");
                ParseTree elseifBlock = t.getChild(2);
                generateCode(elseifBlock, writer, indentLevel+1);
                // agora vem o else ou outro  :
                ParseTree elseOrElsif = t.getChild(3);
                if (elseOrElsif.getText() == "elsif"){
                    writer.write(indent);
                    writer.write("}\n");
                } else {
                    writer.write(indent);
                    writer.write("} ");
                    generateCode(t.getChild(3), writer, indentLevel);
                }
                return;
            case "ElseStatement":
                writer.write("else {\n");
                ParseTree expElse = t.getChild(1);
                generateCode(expElse, writer, indentLevel+1);
                writer.write(indent);
                writer.write("}");
                return;
            case "WhileStatement":
                writer.write("while (");
                ParseTree expWhile = t.getChild(1);
                generateCode(expWhile, writer, indentLevel);
                writer.write(") {\n");
                ParseTree whileBlock = t.getChild(2);
                generateCode(whileBlock, writer, indentLevel+1);
                writer.write(indent);
                writer.write("} ");
                return;
            case "ForStatement":
                writer.write("for (int ");
                ParseTree forID = t.getChild(1);
                generateCode(forID, writer, indentLevel);
                writer.write("= ");
                ParseTree forExp = t.getChild(3);
                generateCode(forExp, writer, indentLevel);
                writer.write("; ");
                ParseTree forBooleanExp = t.getChild(5);
                generateCode(forBooleanExp, writer, indentLevel);
                writer.write("; ");
                ParseTree forID2 = t.getChild(7);
                generateCode(forID2, writer, 2);
                writer.write(t.getChild(8) + ") {\n");
                ParseTree forBlock = t.getChild(9);    
                generateCode(forBlock, writer, indentLevel+1);
                writer.write(indent);
                writer.write("}");
                return;       
            case "TryCatchStatement":
                writer.write("try {\n");
                ParseTree tryBody = t.getChild(1);
                generateCode(tryBody, writer, indentLevel+1);
                String catchId = t.getChild(4).getText();
                writer.write(indent);
                writer.write("} catch (Exception " + catchId + ") {\n");
                ParseTree catchBody = t.getChild(6);
                generateCode(catchBody, writer, indentLevel+1);
                writer.write(indent);
                writer.write("}");
                return;
            case "ReturnStatement":
                ParseTree returnReturn = t.getChild(1);
                writer.write("return ");
                generateCode(returnReturn, writer, indentLevel);
                writer.write(";");
                return;
            case "ThrowStatement":
                ParseTree throwReturn = t.getChild(1);
                writer.write("throw new IOException(");
                generateCode(throwReturn, writer, indentLevel);
                writer.write(");");
                return;
            case "Term": 
                ParseTree expTerm = t.getChild(0);
                generateCode(expTerm, writer, indentLevel);
                return;
            case "FunctionCall":
                ParseTree funC = t.getChild(0);
                generateCode(funC, writer, indentLevel);
                writer.write("(");
                ParseTree funExp = t.getChild(2);
                generateCode(funExp, writer, indentLevel);
                writer.write(")");
                return;
            case "FunctionExpression":
                for (int c = 0; c < t.getChildCount(); c++) {
                    generateCode(t.getChild(c), writer, indentLevel);
                }
                return;
            case "FunctionExpressionRecursive":
                writer.write(", ");
                ParseTree funExpR = t.getChild(1);
                generateCode(funExpR, writer, indentLevel);
                return;
            case "Expression": 
                ParseTree expExp = t.getChild(0);
                generateCode(expExp, writer, indentLevel);
                if (t.getChildCount() > 1){
                    String expOperator = t.getChild(1).getText();
                    writer.write(" " + expOperator + " ");
                    ParseTree expExp1 = t.getChild(2);
                    generateCode(expExp1, writer, indentLevel);
                }
                return;
            case "Operation": 
                ParseTree operation = t.getChild(0);
                generateCode(operation, writer, indentLevel);
                if (t.getChildCount() > 1){
                    String opOperator = t.getChild(1).getText();
                    writer.write(" " + opOperator + " ");
                    ParseTree operation1 = t.getChild(2);
                    generateCode(operation1, writer, indentLevel);
                }
                writer.write(";");
                return;
            case "Print":
                writer.write("System.out.println(");
                ParseTree printTerm = t.getChild(1);
                generateCode(printTerm, writer, indentLevel);
                writer.write(");");
                return;
            default:
                if(t.getChildCount()>0){
                    for (int c = 0; c < t.getChildCount(); c++) {
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
        generateCode(tree, writer, 0);

        writer.close();
    }
}
