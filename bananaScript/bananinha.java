import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class bananinha {

    static HashMap<String, Object> vars = new HashMap<String, Object>();
    
    static Object evaluate(ParseTree t) {
        
        return t;
    }

    public static void main(String[] args) throws Exception {
        CharStream stream = CharStreams.fromFileName("banana.ban");
        BananaScriptLexer lexer = new BananaScriptLexer(stream);
        CommonTokenStream tkStream = new CommonTokenStream(lexer);
        BananaScriptParser parser = new BananaScriptParser(tkStream);
        System.out.println("parser: " + parser.program().toStringTree());
        System.out.println("tokenstream: " + tkStream.getText());
        System.out.println("lexer: " + lexer.getText());
        System.out.println("stream: " + stream.toString());
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("Programa reconhecido corretamente");
            System.out.println("Executando o programa:");
            //evaluate(tree);
        } else {
            System.err.println("Programa possui erros, por favor confira a linha e colunas citadas acima.");
        }
    }
}
