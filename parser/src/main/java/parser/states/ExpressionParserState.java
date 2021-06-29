package parser.states;

import common.exeptions.IllegalGrammarException;
import lexer.tokens.*;
import parser.nodes.*;

public class ExpressionParserState extends AbstractParserState {

  private ExpressionNode expressionNode;
  private boolean literal;

  public ExpressionParserState() {
    this.literal = false;
  }

  public ExpressionParserState(ExpressionNode expressionNode) {
    this.literal = false;
    this.expressionNode = expressionNode;
  }

  @Override
  public ExpressionNode getNode() {
    return this.expressionNode;
  }

  @Override
  public void visit(StringValueToken token) {
    checkStateLiteral();
    getTokenProvider().next();
    StringNode node = new StringNode(token.getValue());
    if (this.expressionNode == null) this.expressionNode = node;
    else this.expressionNode.setLeft(node);
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(NumberValueToken token) {
    checkStateLiteral();
    getTokenProvider().next();
    IntegerNode node = new IntegerNode(Double.parseDouble(token.getValue()));
    if (this.expressionNode == null) this.expressionNode = node;
    else this.expressionNode.setLeft(node);
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(BooleanValueToken token) {
    checkStateLiteral();
    getTokenProvider().next();
    BooleanNode node = new BooleanNode(Boolean.parseBoolean(token.getValue()));
    if (this.expressionNode == null) this.expressionNode = node;
    else this.expressionNode.setLeft(node);
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(IdentifierToken token) {
    checkStateLiteral();
    getTokenProvider().next();
    IdentifierNode node = new IdentifierNode(token.getValue());
    if (this.expressionNode == null) this.expressionNode = node;
    else this.expressionNode.setLeft(node);
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(PlusToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    ExpressionNode node = this.expressionNode;
    this.expressionNode = new AdditionNode(null, null);
    this.expressionNode.setRight(new ExpressionParserState().parse(getTokenProvider()));
    this.expressionNode.setLeft(node);
  }

  @Override
  public void visit(MinusToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    ExpressionNode node = this.expressionNode;
    this.expressionNode = new SubtractionNode(null, null);
    this.expressionNode.setRight(new ExpressionParserState().parse(getTokenProvider()));
    this.expressionNode.setLeft(node);
  }

  @Override
  public void visit(MultiplicationToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new MultiplicationNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(DivisionToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new DivisionNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(MayorComparisonToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new MayorComparisonNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(MinorComparisonToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new MinorComparisonNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(AndToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new AndNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(OrToken token) {
    checkStateNotLiteral();
    getTokenProvider().next();
    this.expressionNode =
        (ExpressionNode)
            new ExpressionParserState(new OrNode(null, this.expressionNode))
                .parse(getTokenProvider());
  }

  @Override
  public void visit(ClosingParenthesisToken token) {
    checkStateNotLiteral();
  }

  @Override
  public void visit(SemicolonToken token) {
    checkStateNotLiteral();
  }

  private void checkStateLiteral() {
    if (literal) {
      throw new IllegalGrammarException();
    }
    this.literal = true;
  }

  private void checkStateNotLiteral() {
    if (!literal) {
      throw new IllegalGrammarException();
    }

    this.literal = false;
  }
}
