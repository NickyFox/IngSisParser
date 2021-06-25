package parser.nodes;

import java.util.Objects;
import parser.ASTVisitor;

public class DeclarationNode implements ASTNode {

  private IdentifierNode identifierNode;
  private String type;
  private ExpressionNode expressionNode;
  private boolean isFinal;

  public DeclarationNode(
      IdentifierNode identifierNode, String type, ExpressionNode expressionNode, boolean isFinal) {
    this.identifierNode = identifierNode;
    this.type = type;
    this.expressionNode = expressionNode;
    this.isFinal = isFinal;
  }

  public boolean isFinal() {
    return isFinal;
  }

  public IdentifierNode getIdentifierNode() {
    return identifierNode;
  }

  public ExpressionNode getExpressionNode() {
    return expressionNode;
  }

  public String getType() {
    return type;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DeclarationNode that = (DeclarationNode) o;

    boolean first = Objects.equals(identifierNode, that.identifierNode);
    boolean second = Objects.equals(type, that.type);
    boolean third = expressionNode.equals(that.expressionNode);
    return first && second && third;
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifierNode, type, expressionNode);
  }
}
