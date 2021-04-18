import interpreter.*;
import org.junit.Test;

public class InterpreterTest {

  Console console = new Terminal();
  Memory memory = new LocalStorage();
  Interpreter interpreter = new Interpreter(console, memory);

  @Test
  public void interpreterTest() {}
}
