import common.exeptions.IllegalGrammarException;
import common.provider.Provider;
import interpreter.*;
import interpreter.value.NumberValue;
import interpreter.value.StringValue;
import java.util.List;
import lexer.DefaultLexer;
import lexer.Lexer;
import lexer.provider.TokenProvider;
import lexer.tokens.Token;
import org.junit.Assert;
import org.junit.Test;
import parser.Parser;
import parser.nodes.*;

public class InterpreterTest {

  Lexer lexer = new DefaultLexer("1.0");
  Parser parser = new Parser();
  Console console = new Terminal();
  Memory memory = new LocalStorage();
  Interpreter interpreter = new Interpreter(console, memory);

  @Test
  public void InterpreterShouldSaveStringValueInMemory() {
    String declaration = "let str: string = \"some string\";";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    StringValue val = (StringValue) memory.read("str");
    Assert.assertEquals(val.getValue(), "some string");
    Assert.assertEquals(val.getType(), "string");
  }

  @Test
  public void InterpreterShouldSaveTheSumValueInMemory() {
    String declaration = "let sum: number = 5 + 4;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("sum");
    Assert.assertEquals(val.getValue(),9, 0);
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIf() {
    String declaration = "let num: number = 1;\nif(true){num = 3;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(),new Double(3));
  }

  @Test(expected = IllegalGrammarException.class)
  public void InterpreterShouldBreakBecauseOfAnException() {
    // As there is a ; missing after '3', it should break
    String declaration = "let num: number = 1;\nif(true){num = 3}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
  }
}
