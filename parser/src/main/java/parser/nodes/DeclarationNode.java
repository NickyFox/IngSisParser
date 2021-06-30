package parser.nodes;

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
}
