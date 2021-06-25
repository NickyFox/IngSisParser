package cli;

import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import common.provider.Provider;
import interpreter.Interpreter;
import interpreter.Terminal;
import java.util.ArrayList;
import java.util.List;
import lexer.DefaultLexer;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import parser.*;
import parser.nodes.ASTNode;

public class CLI {
  public static void main(String[] args) {
    DefaultLexer lexer = new DefaultLexer("1.1");
    Parser parser = new Parser();
    List<String> auxPrint = new ArrayList<>();
    String read =
        "let someNumber: number = 1;\n"
            + "let someString: string = \"hello world \";\n"
            + "println(someString + someNumber);";
    Interpreter interpreter = new Interpreter(new Terminal(), auxPrint);
    FileReader fileReader = new DefaultFileReader();
    List<Token> tokenStream = lexer.lex(read);
    Provider input = new TokenProvider(tokenStream);
    ASTNode ast = parser.parse(input);
    interpreter.start(ast);
    interpreter.getEmitter();
    //    forEach(emitter::accept);
  }
}
