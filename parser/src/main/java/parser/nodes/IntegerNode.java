package parser.nodes;

import parser.ASTVisitor;

public class IntegerNode extends ExpressionNode {

  private double value;

  public IntegerNode(double value) {
    super();
    this.value = value;
  }

  public Double getValue() {
    return value;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
