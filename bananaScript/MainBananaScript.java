import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MainBananaScript {

    static HashMap<String, Object> vars = new HashMap<String, Object>();
    
    static Object evaluate(ParseTree t) {
        switch (t.getClass().getSimpleName()) {
            case "ProgramContext":
                for (int i = 0; i < t.getChildCount(); i++) {
                    evaluate(t.getChild(i));
                }
                return null;
            case "AssignmentContext": {
                String vName = t.getChild(0).getText();
                Object value = evaluate(t.getChild(2));
                vars.put(vName, value);
                return null;
            }
            case "PrintContext": {
                Object value = evaluate(t.getChild(1));
                System.out.print(value);
                return null;
            }
            case "SeqContext":
                for (int c = 0; c < t.getChildCount(); c++) {
                    evaluate(t.getChild(c));
                }
                return null;
            case "ConstContext":
                return t.getText();
            case "VarContext": {
                String vName = t.getText();
                if (vars.containsKey(vName)) {
                    return vars.get(vName);
                } else {
                    System.err.println("Variável não declarada: " + vName);
                    return null;
                }
            }
            case "OpContext": {
                Object left = evaluate(t.getChild(0));
                Object right = evaluate(t.getChild(2));
                String op = t.getChild(1).getText();
                switch (op) {
                    case "+":
                        return (double) left + (double) right;
                    case "-":
                        return (double) left - (double) right;
                    case "*":
                        return (double) left * (double) right;
                    case "/":
                        return (double) left / (double) right;
                    case "==":
                        return left.equals(right);
                    case "!=":
                        return !left.equals(right);
                    default:
                        System.err.println("Operador não suportado: " + op);
                        return null;
                }
            }
            default:
                System.err.println("Contexto não suportado: " + t.getClass().getSimpleName());
                return null;
        }
    }

    public static void main(String[] args) throws Exception {
        CharStream stream = CharStreams.fromFileName("exemplo.script");
        BananaScriptLexer lexer = new BananaScriptLexer(stream);
        CommonTokenStream tkStream = new CommonTokenStream(lexer);
        BananaScriptParser parser = new BananaScriptParser(tkStream);

        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("Programa reconhecido corretamente");
            System.out.println("Executando o programa:");
            evaluate(tree);
        } else {
            System.err.println("Programa possui erros, corrija-os");
        }
    }
}
