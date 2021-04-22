package parser.nodes;

import parser.ASTVisitor;

public class SubtractionNode extends ExpressionNode {

  public SubtractionNode(ExpressionNode expLeft, ExpressionNode expRight) {
    super(expLeft, expRight);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
