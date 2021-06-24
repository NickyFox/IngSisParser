package parser.nodes;

import java.util.Objects;
import parser.ASTVisitor;

public class StringNode extends ExpressionNode {

  private String value;

  public StringNode(String value) {
    super();
    this.value = value;
  }

  public String getValue() {
    return value;
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
    StringNode that = (StringNode) o;
    System.out.printf("String node: " + value.equals(that.value));
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), value);
  }
}
