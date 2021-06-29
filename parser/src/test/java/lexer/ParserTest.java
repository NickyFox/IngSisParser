package lexer;

import parser.nodes.*;

// public class ParserTest {
//
//  Lexer lexer = new DefaultLexer("1.0");
//  Parser parser = new Parser();
//
//  @Test
//  public void shouldParseExpectedASTFromStringDeclaration() {
//
//    // Given input
//    String declaration = "let str: string = \"some string\";";
//    List<Token> tokens = lexer.lex(declaration);
//    Provider input = new TokenProvider(tokens);
//    ASTNode node = parser.parse(input);
//
//    // Generating expected result for input
//    ExpressionNode exprNode = new StringNode("some string");
//    exprNode.setLeft(new StringNode("some string"));
//    ProgramNode expected = new ProgramNode();
//    expected.add(new DeclarationNode(new IdentifierNode("str"), "string", exprNode, false));
//
//    Assert.assertEquals(node, expected);
//  }
//
//  @Test
//  public void shouldParseExpectedASTFromBooleanDeclaration() {
//    // Given input
//    String declaration = "let bo: boolean = true;";
//    List<Token> tokens = lexer.lex(declaration);
//    Provider input = new TokenProvider(tokens);
//    ASTNode node = parser.parse(input);
//
//    ExpressionNode exprNode = new BooleanNode(true);
//    exprNode.setLeft(new BooleanNode(true));
//
//    // Generating expected result for input
//    ProgramNode expected = new ProgramNode();
//    expected.add(new DeclarationNode(new IdentifierNode("bo"), "boolean", exprNode, false));
//
//    Assert.assertEquals(node, expected);
//  }
//
//  @Test
//  public void shouldParseExpectedASTFromCombinedDeclaration() {
//
//    // Given input
//    String declaration = "let str: string = \"some string\";\nlet bo: boolean = true;";
//    List<Token> tokens = lexer.lex(declaration);
//    Provider input = new TokenProvider(tokens);
//    ASTNode node = parser.parse(input);
//
//    // Generating expected result for input
//    ProgramNode expected = new ProgramNode();
//    ExpressionNode strExprNode = new StringNode("some string");
//    strExprNode.setLeft(new StringNode("some string"));
//
//    expected.add(new DeclarationNode(new IdentifierNode("str"), "string", strExprNode, false));
//    ExpressionNode exprNode = new BooleanNode(true);
//    exprNode.setLeft(new BooleanNode(true));
//
//    expected.add(new DeclarationNode(new IdentifierNode("bo"), "boolean", exprNode, false));
//
//    Assert.assertEquals(node, expected);
//  }
// }
