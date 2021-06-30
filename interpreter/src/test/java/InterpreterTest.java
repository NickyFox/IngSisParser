import common.exeptions.IllegalGrammarException;
import common.provider.Provider;
import interpreter.*;
import interpreter.value.NumberValue;
import interpreter.value.StringValue;
import java.util.ArrayList;
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

  Lexer lexer = new DefaultLexer("1.1");
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
  public void InterpreterShouldNotBreak() {
    List<String> emitter = new ArrayList<>();
    Interpreter interpreter1 = new Interpreter(console, memory);
    Interpreter interpreter2 = new Interpreter(console, emitter);
    Interpreter interpreter3 = new Interpreter(console);
    Assert.assertNotNull(interpreter1);
    Assert.assertNotNull(interpreter2);
    Assert.assertNotNull(interpreter3);
    Assert.assertNotNull(interpreter2.getEmitter());
  }

  @Test
  public void InterpreterShouldSaveTheSumValueInMemory() {
    String declaration = "let sum: number = 5 + 4;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("sum");
    Assert.assertEquals(val.getValue(), 9, 0);
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIf() {
    String declaration = "let num: number = 1;\nif(true){num = 3;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(3));
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfElse() {
    String declaration = "let num: number = 1;\nif(false){num = 3;}else{num = 4;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(4));
  }

  @Test
  public void InterpreterPrint() {
    List<String> emitter = new ArrayList<>();
    Interpreter interpreter2 = new Interpreter(console, emitter);
    String declaration = "println(\"hola\");";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter2.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertNull(val);

    declaration = "println(3 + 3);";
    tokens = lexer.lex(declaration);
    input = new TokenProvider(tokens);
    node = parser.parse(input);
    interpreter2.start(node);
    val = (NumberValue) memory.read("num");
    Assert.assertNull(val);

    declaration = "println(3.57);";
    tokens = lexer.lex(declaration);
    input = new TokenProvider(tokens);
    node = parser.parse(input);
    interpreter2.start(node);
    val = (NumberValue) memory.read("num");
    Assert.assertNull(val);

    declaration = "const aValue: number = 3; \n println(aValue);";
    tokens = lexer.lex(declaration);
    input = new TokenProvider(tokens);
    node = parser.parse(input);
    interpreter2.start(node);
    val = (NumberValue) memory.read("num");
    Assert.assertNull(val);
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

  @Test(expected = IllegalGrammarException.class)
  public void InterpreterShouldBreakBecauseOfAVariableDefinedException() {
    // As there is a ; missing after '3', it should break
    String declaration = "let pi: number = \"hola\";";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
  }
  //
  @Test(expected = IllegalGrammarException.class)
  public void InterpreterShouldBreakBecauseOfAVariableNotDefinedException() {
    // As there is a ; missing after '3', it should break
    String declaration = "println(5)";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
  }
  //
  //  @Test(expected = IllegalGrammarException.class)
  //  public void InterpreterShouldBreakBecauseOfAnGreaterThanException() {
  //    // As there is a ; missing after '3', it should break
  //    String declaration = "true < false";
  //    List<Token> tokens = lexer.lex(declaration);
  //    Provider input = new TokenProvider(tokens);
  //    ASTNode node = parser.parse(input);
  //    interpreter.start(node);
  //  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIfWithDivision() {
    String declaration = "let num: number = 1;\nif(true){num = 4 / 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(2));
  }

  @Test
  public void InterpreterShouldCalculateMinus() {
    String declaration = "let num: number = 3-1;";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(2));
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIfWithMultiplication() {
    String declaration = "let num: number = 1;\nif(true){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(8));
  }

  @Test
  public void InterpreterShouldNotChangeValueBecauseOfIfWithAnd() {
    String declaration = "let num: number = 1;\nif(true && false){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(1));
  }

  @Test
  public void InterpreterShouldNotChangeValueBecauseOfIfWithOr() {
    String declaration = "let num: number = 1;\nif(true || false){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(8));
  }

  @Test(expected = IllegalGrammarException.class)
  public void InterpreterShouldBreakWhenUsingOrWithNumberAndBoolean() {
    String declaration = "let num: number = 1;\nif(1 || false){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
  }

  @Test
  public void InterpreterShouldNotChangeValueBecauseOfIfWithGraterThan() {
    String declaration = "let num: number = 1;\nif(1 > 2){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(1));
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIfWithLessThan() {
    String declaration = "let num: number = 1;\nif(1 < 2){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(8));
  }

  @Test
  public void InterpreterShouldNotChangeValueBecauseOfIfWithGraterThanEquals() {
    String declaration = "let num: number = 1;\nif(1 >= 2){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(1));
  }

  @Test
  public void InterpreterShouldChangeValueBecauseOfIfWithLessThanEquals() {
    String declaration = "let num: number = 1;\nif(1 <= 2){num = 4 * 2;}";
    List<Token> tokens = lexer.lex(declaration);
    Provider input = new TokenProvider(tokens);
    ASTNode node = parser.parse(input);
    interpreter.start(node);
    NumberValue val = (NumberValue) memory.read("num");
    Assert.assertEquals(val.getValue(), new Double(8));
  }
}
