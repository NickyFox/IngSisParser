package lexer;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import lexer.provider.TokenProvider;
import lexer.tokenizer.Tokenizer;
import lexer.tokenizer.state.TokenizerState;
import lexer.tokenizer.state.ValidState;
import lexer.tokens.Token;
import org.junit.Assert;
import org.junit.Test;

public class LexerTest {

  Lexer lexer = new DefaultLexer("1.0");
  ObjectMapper objectParser = new ObjectMapper();

  @Test
  public void createLexer() {
    Lexer lexer = new DefaultLexer("1.0");
    assertNotNull(lexer);
  }

  @Test
  public void createLexer2() {
    Lexer lexer = new DefaultLexer("1.1");
    assertNotNull(lexer);
  }

  @Test
  public void lex() {
    String declaration = "let str: string = \"someString\";";
    List<Token> tokens = lexer.lex(declaration);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens, "testing-resources/expectedTokenListForStringDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexBooleanDeclarationWithAndToken() {
    String declaration = "let bl: boolean = true && false;";
    List<Token> tokens = lexer.lex(declaration);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens, "testing-resources/expectedTokenListForBooleanDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void validStateToString() {
    String declaration = "let bl: boolean = true && false;";
    List<Token> tokens = lexer.lex(declaration);
    TokenizerState state = new ValidState(tokens.get(0));
    Tokenizer tknzr = new Tokenizer(state);
    Assert.assertNotNull(tknzr.toString());
  }

  @Test
  public void lexerTokenProvider() {
    String declaration = "let bl: boolean = true && false;";
    List<Token> tokens = lexer.lex(declaration);
    TokenProvider tp = new TokenProvider(tokens);
    Assert.assertTrue(tp.hasNext());
    Assert.assertEquals(tp.get(), tokens.get(0));
    tp.next();
    Assert.assertEquals(tp.get(), tokens.get(1));
  }

  @Test
  public void lexStringSumDeclarations() {
    String declaration1 = "let str: string = \"someString\" + \"someString\" ;";
    List<Token> tokens1 = lexer.lex(declaration1);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens1, "testing-resources/expectedTokenListForStringSumDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexBooleanDeclarationsWithoutTokens() {
    String declaration1 = "let bool: boolean = true;";
    List<Token> tokens1 = lexer.lex(declaration1);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens1, "testing-resources/lexBooleanDeclarationsWithoutTokens.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexBooleanDeclarationsWithOrToken() {
    String declaration1 = "let bool: boolean = true || false;";
    List<Token> tokens1 = lexer.lex(declaration1);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens1, "testing-resources/lexBooleanDeclarationsWithOrToken.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexBooleanDeclarationWithNotEquals() {
    String declaration = "let bool: boolean = (2-2) != 0;";
    List<Token> tokens = lexer.lex(declaration);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens, "testing-resources/lexBooleanDeclarationWithNotEquals.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexStringPlusNumberDeclarations() {
    String declaration4 = "let str: string = \"someString\" + 3;";
    List<Token> tokens4 = lexer.lex(declaration4);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              tokens4, "testing-resources/lexStringPlusNumberDeclarations.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexArithmeticDeclarations() {
    String declaration7 = "let num: number = (1 * 2)/ 2;";
    List<Token> tokens7 = lexer.lex(declaration7);
    try {
      boolean result =
          checkNodeMatchesFileResult(tokens7, "testing-resources/lexArithmeticDeclarations.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void lexPrintDeclarations() {
    String declaration8 = "if(true) {print(\"someString\");};";
    List<Token> tokens8 = lexer.lex(declaration8);
    try {
      boolean result =
          checkNodeMatchesFileResult(tokens8, "testing-resources/lexPrintDeclarations.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  /** Returns true if expected matches current */
  private boolean checkNodeMatchesFileResult(List<Token> tokens, String url) {
    try {
      String actualResult = objectParser.writeValueAsString(tokens);
      FileReader fr = new FileReader(url);
      Scanner scanner = new Scanner(fr);
      String expectedResult = "";
      while (scanner.hasNext()) {
        expectedResult = expectedResult + scanner.next();
      }
      System.out.println(actualResult);
      System.out.println(expectedResult);
      return actualResult.equals(expectedResult);
    } catch (Exception e) {
      return false;
    }
  }
}
