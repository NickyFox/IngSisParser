package parser.nodes;

import parser.ASTVisitor;

public class IfNode implements ASTNode {

  private ExpressionNode condition;
  private ProgramNode program;
  private ProgramNode elseNode;

  public ProgramNode getElseNode() {
    return elseNode;
  }

  public void setElseNode(ProgramNode elseNode) {
    this.elseNode = elseNode;
  }

  public IfNode() {}

  public void setCondition(ExpressionNode condition) {
    this.condition = condition;
  }

  public void setProgram(ProgramNode program) {
    this.program = program;
  }

  public ExpressionNode getCondition() {
    return condition;
  }

  public ProgramNode getProgram() {
    return program;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
