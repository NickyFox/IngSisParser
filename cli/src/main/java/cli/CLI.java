package cli;

import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import common.provider.Provider;
import interpreter.Interpreter;
import interpreter.Terminal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import lexer.DefaultLexer;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import parser.*;
import parser.nodes.ASTNode;

public class CLI {
//  public static void main(String[] args, String version, Consumer<String> emitter) {
//    DefaultLexer lexer = new DefaultLexer(version);
//    Parser parser = new Parser();
//    List<String> auxPrint = new ArrayList<>();
//    Interpreter interpreter = new Interpreter(new Terminal(), auxPrint);
//    FileReader fileReader = new DefaultFileReader();
//    List<Token> tokenStream = lexer.lex(fileReader.readFile(args[0]));
//    Provider input = new TokenProvider(tokenStream);
//    ASTNode ast = parser.parse(input);
//    interpreter.start(ast);
//    interpreter.getEmitter().forEach(emitter::accept);
//  }
  public static void main(String[] args) {
    DefaultLexer lexer = new DefaultLexer("1.1");
    String text = "if(true) { println(\"hola\"); } else { println(123); }";
    Parser parser = new Parser();
    List<String> auxPrint = new ArrayList<>();
    Interpreter interpreter = new Interpreter(new Terminal(), auxPrint);
    FileReader fileReader = new DefaultFileReader();
    List<Token> tokenStream = lexer.lex(text);
    Provider input = new TokenProvider(tokenStream);
    ASTNode ast = parser.parse(input);
    interpreter.start(ast);
  }
}
