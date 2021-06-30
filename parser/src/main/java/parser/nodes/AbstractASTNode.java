package parser.nodes;

public abstract class AbstractASTNode<T> implements ASTNode {

  private T value;
  private int line;
  private int column;

  public T getValue() {
    return value;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }
}
