package parser.nodes;

import java.util.Objects;
import parser.ASTVisitor;

public class IdentifierNode extends ExpressionNode {

  private String identifier;

  public IdentifierNode(String identifier) {
    this.identifier = identifier;
  }

  public String getIdentifier() {
    return identifier;
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
    IdentifierNode that = (IdentifierNode) o;
    return Objects.equals(identifier, that.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), identifier);
  }
}
