package lexer;

import common.provider.Provider;
import lexer.tokens.Token;
import lexer.tokens.VisitableToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import parser.nodes.ASTNode;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    Lexer lexer = new DefaultLexer();
    Parser parser = new Parser();

    @Test
    public void parse() {
        String declaration = "let str: string = \"some string\";";
        List<Token> tokens = lexer.lex(declaration);
        ASTNode node = parser.parse((Provider<VisitableToken>) tokens);
        Assert.assertEquals(tokens.size(), 8);
    }
}