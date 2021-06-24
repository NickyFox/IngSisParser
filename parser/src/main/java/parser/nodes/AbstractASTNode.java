package parser.nodes;

import java.util.Objects;

public abstract class AbstractASTNode<T> implements ASTNode {

  private T value;
  private int line;
  private int column;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public int getLine() {
    return line;
  }

  public void setLine(int line) {
    this.line = line;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractASTNode<?> that = (AbstractASTNode<?>) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
