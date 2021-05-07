import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import common.provider.Provider;
import interpreter.Interpreter;
import interpreter.Terminal;
import java.util.List;
import lexer.DefaultLexer;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import parser.*;
import parser.nodes.ASTNode;

public class CLI {
  public static void main(String[] args) {
    DefaultLexer lexer = new DefaultLexer();
    Parser
            parser = new Parser();
    Interpreter interpreter = new Interpreter(new Terminal());
                      FileReader fileReader = new DefaultFileReader();
    List<Token>
            tokenStream = lexer.lex(fileReader.readFile(args[0]));
    Provider input =
            new TokenProvider(tokenStream);
    ASTNode ast =
                                    parser.parse(input);
    interpreter.start(ast);
  }
}
