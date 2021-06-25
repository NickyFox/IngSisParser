package parser.nodes;

import parser.ASTVisitor;

public class MinorComparisonNode extends ExpressionNode {

  public MinorComparisonNode(ExpressionNode expLeft, ExpressionNode expRight) {
    super(expLeft, expRight);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
