package parser.nodes;

import parser.ASTVisitor;

public class MayorIgualComparisonNode extends ExpressionNode {

  public MayorIgualComparisonNode(ExpressionNode expLeft, ExpressionNode expRight) {
    super(expLeft, expRight);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
