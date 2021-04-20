package lexer;

import java.util.List;

import common.provider.Provider;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import lexer.tokens.VisitableToken;
import org.junit.Assert;
import org.junit.Test;
import parser.Parser;
import parser.nodes.ASTNode;

public class ParserTest {

  Lexer lexer = new DefaultLexer();
  Parser parser = new Parser();
  String declaration = "let str: string = \"some string\";";
  List<Token> tokens = lexer.lex(declaration);
  TokenProvider prov = new TokenProvider(tokens);

      @Test
      public void parse() {
        Provider<VisitableToken> token = new Provider<VisitableToken>() {
          @Override
          public void next() {

          }

          @Override
          public VisitableToken get() {
            return null;
          }

          @Override
          public boolean hasNext() {
            return false;
          }
        }
          ASTNode node = parser.parse(prov);
          Assert.assertEquals(tokens.size(), 8);
      }
}
