package parser.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import parser.ASTVisitor;

public class ProgramNode implements ASTNode {

  private List<ASTNode> nodes;

  public ProgramNode() {
    this.nodes = new ArrayList<>();
  }

  public void add(ASTNode node) {
    this.nodes.add(node);
  }

  public List<ASTNode> getNodes() {
    return nodes;
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProgramNode that = (ProgramNode) o;

    System.out.println("Program node: " + nodes.equals(that.nodes));

    return nodes.equals(that.nodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes);
  }
}
