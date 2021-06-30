package parser.nodes;

import parser.ASTVisitor;

public class MinorIgualComparisonNode extends ExpressionNode {

  public MinorIgualComparisonNode(ExpressionNode expLeft, ExpressionNode expRight) {
    super(expLeft, expRight);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
