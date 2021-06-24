package parser.nodes;

import java.util.Objects;
import parser.ASTVisitor;

public class ExpressionNode extends AbstractASTNode {

  private ExpressionNode left;
  private ASTNode right;

  public ExpressionNode() {}

  public ExpressionNode(ExpressionNode left, ASTNode right) {
    this.left = left;
    this.right = right;
  }

  public ExpressionNode left() {
    return this.left;
  }

  public ASTNode right() {
    return this.right;
  }

  public void setLeft(ExpressionNode left) {
    this.left = left;
  }

  public void setRight(ASTNode right) {
    this.right = right;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ExpressionNode that = (ExpressionNode) o;
    System.out.println(
        "Expression node: "
            + (Objects.equals(left, that.left) && Objects.equals(right, that.right)));
    return Objects.equals(left, that.left) && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), left, right);
  }
}
