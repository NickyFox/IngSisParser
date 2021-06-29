package parser.states;

import lexer.tokens.*;
import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import parser.nodes.IfNode;
import parser.nodes.ProgramNode;

public class IfElseParserState extends AbstractParserState {

  private IfNode ifNode;

  public IfElseParserState() {
    this.ifNode = new IfNode();
  }

  @Override
  public ASTNode getNode() {
    return this.ifNode;
  }

  @Override
  public void visit(OpenParenthesisToken token) {
    getTokenProvider().next();
    this.ifNode.setCondition(
        (ExpressionNode) new OpenParenthesisParserState().parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(OpenBracketToken token) {
    getTokenProvider().next();
    this.ifNode.setProgram((ProgramNode) new OpenBracketParserState().parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(EOFToken token) {}

  @Override
  public void visit(ElseToken token) {}

  @Override
  public void visit(LetToken token) {}

  @Override
  public void visit(PrintToken token) {}

  @Override
  public void visit(IfToken token) {}

  @Override
  public void visit(ConstToken token) {}
}
