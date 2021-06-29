package parser.states;

import lexer.tokens.*;
import parser.nodes.ASTNode;

public class OpenParenthesisParserState extends AbstractParserState {

  private ASTNode expressionNode;

  @Override
  public ASTNode getNode() {
    return this.expressionNode;
  }

  @Override
  public void visit(StringValueToken token) {
    assignExpression();
  }

  @Override
  public void visit(NumberValueToken token) {
    assignExpression();
  }

  @Override
  public void visit(IdentifierToken token) {
    assignExpression();
  }

  @Override
  public void visit(BooleanValueToken token) {
    assignExpression();
  }

  @Override
  public void visit(ClosingParenthesisToken token) {
    getTokenProvider().next();
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(OpenBracketToken token) {}

  @Override
  public void visit(SemicolonToken token) {}

  private void assignExpression() {
    this.expressionNode = new ExpressionParserState().parse(getTokenProvider());
    getTokenProvider().get().accept(this);
  }
}
