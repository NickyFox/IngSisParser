import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import common.provider.Provider;
import lexer.provider.TokenProvider;
import interpreter.Interpreter;
import interpreter.Terminal;
import lexer.DefaultLexer;
import lexer.tokens.Token;
import parser.nodes.ASTNode;
import parser.*;

import java.util.List;

public class CLI {
    public static void main(String[] args) {
        DefaultLexer lexer = new DefaultLexer();
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter(new Terminal());
        FileReader fileReader = new DefaultFileReader();
        List<Token> tokenStream = lexer.lex(fileReader.readFile(args[0]));
        Provider input = new TokenProvider(tokenStream);
        ASTNode ast = parser.parse(input);
        interpreter.start(ast);
    }
}
