package lexer;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.exeptions.IllegalGrammarException;
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

  Lexer lexer = new DefaultLexer("1.1");
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

  //    @Test(expected = IllegalGrammarException.class)
  @Test
  public void shouldParseExpectedASTFromNumberDeclaration() {

    // Given input
    String declaration = "let str: number = 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromNumberDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: number = nm + 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithMinusDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: number = nm - 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithMinusDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithMultiplicationDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: number = nm * 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithMultiplicationDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithDivisionDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: number = nm / 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithDivisionDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithGreaterDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: boolean = nm > 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithGreaterDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithGreaterEqualDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: boolean = nm >= 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithGreaterEqualDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithLessDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: boolean = nm < 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithLessDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test(expected = IllegalGrammarException.class)
  public void shouldThrowTypeAssignationError() {

    // Given input
    String declaration = "let nm = 3; ";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
  }

  @Test(expected = IllegalGrammarException.class)
  public void shouldThrowElseError() {

    // Given input
    String declaration = " let nm : number = 4; \n else { number = 4;} ";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
  }

  @Test
  public void shouldParseExpectedASTFromCombinedNumberWithLessEqualDeclaration() {

    // Given input
    String declaration = "let nm: number = 3; \n let nm2: boolean = nm <= 3;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithLessEqualDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintNumberDeclaration() {

    // Given input
    String declaration =
        "const finalNum: number = 3; \n let nm: number = 3; \n"
            + " if(nm > 1){ \n nm = 5; \n } else { println(\"false\"); } \n"
            + "let otherNum : number = 5;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithPrintNumberDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintIfDeclaration() {

    // Given input
    String declaration =
        "let nm: number = 3; \n if(nm > 1){ let newNum: number = 3;} else {  let num : number = 5; }";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedASTFromCombinedNumberWithPrintIfDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintIfAndEOFDeclaration() {

    // Given input
    String declaration =
        "let nm: number = 3; \n if(nm > 1){ let newNum: number = 3;} else {  let num : number = 5; } \n const otherNum : number = 10;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithPrintIfAndEOFDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintIfAndPrintlnDeclaration() {

    // Given input
    String declaration =
        "let nm: number = 3; \n if(nm > 1){ let newNum: number = 3;} else {  let num : number = 5; } \n println(10);";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithPrintIfAndPrintlnDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintIfAndIfDeclaration() {

    // Given input
    String declaration =
        "let nm: number = 3; \n if(nm > 1){ let newNum: number = 3;} else {  let num : number = 5; } \n if(true) {println(5);}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithPrintIfAndIfDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromPrintStringDeclaration() {

    // Given input
    String declaration = "let st: string = \"hola\"; \n println(st);";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node,
              "testing-resources/expectedASTFromCombinedNumberWithPrintStringDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromAndDeclaration() {

    // Given input
    String declaration = "let st: boolean = true && false; \n println(st);";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedASTFromAndDeclaration.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldParseExpectedASTFromOrDeclaration() {

    // Given input
    String declaration = "let st: boolean = true || false; \n st = true;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);

    try {
      boolean result =
          checkNodeMatchesFileResult(node, "testing-resources/expectedASTFromOrDeclaration.json");
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

  @Test
  public void shouldCreateAPrintNode() {
    PrintNode printNode = new PrintNode();
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    printNode.setExpressionNode(exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(printNode, "testing-resources/expectedPrintNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateOtherPrintNode() {

    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    PrintNode printNode = new PrintNode(exprNode);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              printNode, "testing-resources/expectedOtherPrintNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              printNode.getExpressionNode(),
              "testing-resources/expectedOtherPrintNodeExpressionCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateADivisionNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    DivisionNode divisionNode = new DivisionNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              divisionNode, "testing-resources/expectedDivisionNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMinorComparisonNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    MinorComparisonNode minorComparisonNode = new MinorComparisonNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedMinorComparisonNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMinorEqualComparisonNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    exprNode.setRight(
        new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    MinorIgualComparisonNode minorComparisonNode = new MinorIgualComparisonNode(null, exprNode);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              minorComparisonNode,
              "testing-resources/expectedMinorIgualComparisonNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              exprNode.left(),
              "testing-resources/expectedMinorIgualComparisonNodeCreationLeftExpressionNode.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              exprNode.right(),
              "testing-resources/expectedMinorIgualComparisonNodeCreationRightExpressionNode.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMayorEqualComparisonNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    MayorIgualComparisonNode mayorEqualComparisonNode =
        new MayorIgualComparisonNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              mayorEqualComparisonNode,
              "testing-resources/expectedMayorIgualComparisonNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMayorComparisonNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    MayorComparisonNode mayorComparisonNode = new MayorComparisonNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              mayorComparisonNode, "testing-resources/expectedMayorComparisonNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateASubtractionNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    SubtractionNode subtractionNode = new SubtractionNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              subtractionNode, "testing-resources/expectedSubtractionNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAAndNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    AndNode andNode = new AndNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(andNode, "testing-resources/expectedAndNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAOrNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    OrNode orNode = new OrNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(orNode, "testing-resources/expectedOrNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAAdditionNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    AdditionNode additionNode = new AdditionNode(null, exprNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(
              additionNode, "testing-resources/expectedAdditionCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAnAssigmentNode() {
    IdentifierNode identifierNode = new IdentifierNode("=");
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    AssigmentNode assigmentNode = new AssigmentNode(identifierNode, exprNode);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              assigmentNode, "testing-resources/expectedAssigmentNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              assigmentNode.getExpressionNode(),
              "testing-resources/expectedAssigmentNodeExpressionCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              assigmentNode.getIdentifierNode(),
              "testing-resources/expectedAssigmentNodeIdentifierCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAIfNode() {
    ExpressionNode exprNode = new BooleanNode(true);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode elseProgramNode = new ProgramNode();
    elseProgramNode.add(
        new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    IfNode ifNode = new IfNode();
    ifNode.setCondition(exprNode);
    ifNode.setProgram(node);
    ifNode.setElseNode(elseProgramNode);
    try {
      boolean result =
          checkNodeMatchesFileResult(ifNode, "testing-resources/expectedIfNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              ifNode.getProgram(), "testing-resources/expectedIfNodeProgram.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              ifNode.getCondition(), "testing-resources/expectedIfNodeCondition.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
    try {
      boolean result =
          checkNodeMatchesFileResult(
              ifNode.getElseNode(), "testing-resources/expectedIfNodeElseNode.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMultiplicationNode() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    MultiplicationNode multiplicationNode = new MultiplicationNode(null, exprNode);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedMultiplicationNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

  @Test
  public void shouldCreateAMultiplicationState() {
    ExpressionNode exprNode = new IntegerNode(1);
    exprNode.setLeft(new IntegerNode(1));
    ProgramNode node = new ProgramNode();
    node.add(new DeclarationNode(new IdentifierNode("integerNumber"), "number", exprNode, false));
    exprNode.setLeft(new IntegerNode(1));
    MultiplicationNode multiplicationNode = new MultiplicationNode(null, exprNode);

    try {
      boolean result =
          checkNodeMatchesFileResult(
              node, "testing-resources/expectedMultiplicationNodeCreation.json");
      Assert.assertTrue(result);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.assertEquals(false, true);
    }
  }

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
      return actualResult.equals(expectedResult);
    } catch (Exception e) {
      return false;
    }
  }
}
