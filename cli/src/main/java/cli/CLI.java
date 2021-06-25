package cli;

import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import common.provider.Provider;
import interpreter.Interpreter;
import interpreter.Terminal;
import java.util.List;
import java.util.function.Consumer;
import lexer.DefaultLexer;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import parser.*;
import parser.nodes.ASTNode;

public class CLI {
  public static void main(String[] args) {
    try {
      DefaultLexer lexer = new DefaultLexer("1.1");
      Parser parser = new Parser();
      Interpreter interpreter = new Interpreter(new Terminal());
      FileReader fileReader = new DefaultFileReader();
      String read = "let booleanResult: boolean = 5 > 3;\n" +
              "if(booleanResult) {\n" +
              "    println(\"if statement working correctly\");\n" +
              "}\n" +
              "println(\"outside of conditional\");";
      List<Token> tokenStream = lexer.lex(read);
      Provider input = new TokenProvider(tokenStream);
      ASTNode ast = parser.parse(input);
      interpreter.start(ast);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
