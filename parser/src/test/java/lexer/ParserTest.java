package lexer;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.provider.Provider;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import org.junit.Assert;
import org.junit.Test;
import parser.Parser;
import parser.nodes.*;

public class ParserTest {

  Lexer lexer = new DefaultLexer("1.0");
  Parser parser = new Parser();
  ObjectMapper objectParser = new ObjectMapper();

  @Test
  public void shouldParseExpectedASTFromStringDeclaration() {

    // Given input
    String declaration = "let str: string = \"someString\";";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromStringDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromBooleanDeclaration() {
    // Given input
    String declaration = "let bo: boolean = true;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedBooleanDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedDeclaration() {

    // Given input
    String declaration = "let str: string = \"someString\";\n" + "let bo: boolean = true;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateABooleanNode() {

    ExpressionNode exprNode = new BooleanNode(true);
    exprNode.setLeft(new BooleanNode(true));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("bo"), "boolean", exprNode, false));

    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedBooleanNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAStringNode() {
    ExpressionNode exprNode = new StringNode("someString");
    exprNode.setLeft(new StringNode("someString"));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("str"), "string", exprNode, false));
    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedStringNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateANumberNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));

    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedNumberNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  //    @Test
  //    public void shouldCreateAPrintNode() {
  //        ExpressionNode exprNode = new PrintNode(1);
  //        exprNode.setLeft(new IntegerNode(1));
  //        ProgramNode node = new ProgramNode();
  //        node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode,
  // false));
  //
  //        try {
  //            objectParser.writeValue(new
  // File("testing-resources/expectedPrintNodeCreation.json"), node);
  //        } catch (Exception e) {
  //            e.printStackTrace();
  //        }
  //
  //        try {
  //            boolean result =
  //                    checkNodeMatchesFileResult(node,
  // "testing-resources/expectedPrintNodeCreation.json");
  //            Assert.assertTrue(result);
  //        } catch (Exception e) {
  //            e.printStackTrace();
  //            Assert.assertEquals(false, true);
  //        }
  //    }

  /** Returns true if expected matches current */
  private boolean checkNodeMatchesFileResult(ASTNode node, String url) {
    try {
      String actualResult = objectParser.writeValueAsString(node);
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
