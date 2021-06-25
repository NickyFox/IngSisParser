package parser.nodes;

import parser.ASTVisitor;

public class IntegerNode extends ExpressionNode {

  private Float value;

  public IntegerNode(Float value) {
    super();
    this.value = value;
  }

  public Float getValue() {
    return value;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
