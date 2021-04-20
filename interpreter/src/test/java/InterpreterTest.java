import interpreter.*;
import org.junit.Test;
import parser.nodes.ASTNode;
import parser.nodes.AdditionNode;
import parser.nodes.ExpressionNode;

public class InterpreterTest {

  Console console = new Terminal();
  Memory memory = new LocalStorage();
  Interpreter interpreter = new Interpreter(console, memory);

  @Test
  public void interpreterTest() {

  }
}
