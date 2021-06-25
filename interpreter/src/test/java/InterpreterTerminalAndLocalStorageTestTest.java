import common.exeptions.IllegalGrammarException;
import interpreter.LocalStorage;
import interpreter.Terminal;
import interpreter.value.BooleanValue;
import interpreter.value.NumberValue;
import interpreter.value.StringValue;
import interpreter.value.Value;
import org.junit.Assert;
import org.junit.Test;

public class InterpreterTerminalAndLocalStorageTestTest {

  Terminal terminal = new Terminal();
  LocalStorage ls = new LocalStorage();

  @Test
  public void testTerminar() {
    terminal.log("Log");
    terminal.error(new Exception("Exception"));
  }

  @Test
  public void testLocalStorage() {
    ls.save("some-key", new StringValue("some-string"), true);
    Assert.assertTrue(ls.has("some-key"));
    Assert.assertFalse(ls.has("not-some-key"));
    Assert.assertEquals("some-string", ls.read("some-key").getValue());
  }

  @Test
  public void testStringValue() {
    StringValue strValue = new StringValue("some");
    Value result = strValue.plus(new StringValue("-string"));
    Assert.assertEquals("some-string", result.getValue());

    StringValue strValue1 = new StringValue("some-number-");
    Value result1 = strValue1.plus(new NumberValue(1));
    Assert.assertEquals("some-number-1.0", result1.getValue());

    StringValue strValue2 = new StringValue("nuequen");
    Value result2 = strValue2.plus((Value) new StringValue("nuequen"));
    Assert.assertEquals("nuequennuequen", result2.getValue());
    Assert.assertEquals("string", strValue.getType());
    Assert.assertNotEquals("string", strValue.toString());
  }

  @Test
  public void testStringValueIsType() {
    StringValue stringValue = new StringValue("value");
    boolean result = stringValue.is("string");
    Assert.assertTrue(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithStringValueUsingDivide() {
    StringValue strValue1 = new StringValue("some");
    strValue1.divide(new BooleanValue(true));
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithValueUsingDivide() {
    StringValue strValue1 = new StringValue("some");
    Value value = new BooleanValue(true);
    strValue1.divide(value);
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithStringValueUsingAnd() {
    StringValue strValue = new StringValue("some");
    strValue.and(new NumberValue(2));
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithValueUsingAnd() {
    StringValue strValue = new StringValue("some");
    Value newValue = new NumberValue(2);
    strValue.and(newValue);
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithStringValueUsingOr() {
    StringValue strValue = new StringValue("some");
    strValue.or(new NumberValue(1));
  }

  @Test(expected = IllegalGrammarException.class)
  public void grammarExceptionWithStringValueUsingTimes() {
    StringValue strValue = new StringValue("some");
    strValue.times((Value) new StringValue("some"));
  }

  @Test
  public void interpreterBooleanValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.and(new BooleanValue(true));
    Assert.assertEquals("boolean", result.getType());
    Assert.assertTrue((boolean) result.getValue());

    BooleanValue bool1 = new BooleanValue(true);
    Value result1 = bool1.or(new BooleanValue(true));
    Assert.assertEquals("boolean", result.getType());
    Assert.assertTrue((boolean) result.getValue());
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanDivideNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.divide(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanDivideValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value value = new NumberValue(1);
    bool.divide(value);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanDivideBooleanValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.divide(new BooleanValue(true));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanDivideStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value newValue = new StringValue("value");
    Value result = bool.divide(newValue);
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanTimesNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.times(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanTimesValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value value = new NumberValue(1);
    Value result = bool.times(value);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanTimesBooleanValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.times(new BooleanValue(true));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanTimesStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.times(new StringValue("value"));
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanPlusNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.plus(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanPlusValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = new NumberValue(1);
    bool.plus(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanPlusBooleanValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.plus(new BooleanValue(true));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterPlusTimesStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.plus(new StringValue("value"));
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanMinusNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.minus(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanMinusValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = new NumberValue(1);
    bool.minus(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanMinusBooleanValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.minus(new BooleanValue(true));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanMinusStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.minus(new StringValue("value"));
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanAndNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.and(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanAndValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = new NumberValue(1);
    bool.and(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanAndStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.and(new StringValue("value"));
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanOrNumberValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.or(new NumberValue(1));
    System.out.println(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanOrValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = new NumberValue(1);
    bool.or(result);
  }

  @Test(expected = IllegalGrammarException.class)
  public void interpreterBooleanOrStringValueTest() {
    BooleanValue bool = new BooleanValue(true);
    Value result = bool.or(new StringValue("value"));
  }

  @Test
  public void interpreterBooleanIsBooleanTypeTest() {
    BooleanValue bool = new BooleanValue(true);
    Boolean result = bool.is("boolean");
    Assert.assertEquals(true, result);
  }

  @Test
  public void interpreterBooleanIsStringTypeTest() {
    BooleanValue bool = new BooleanValue(true);
    Boolean result = bool.is("string");
    Assert.assertEquals(false, result);
  }

  @Test
  public void interpreterNumberValueTest() {
    NumberValue numberValue1 = new NumberValue(1);
    Value result = numberValue1.plus(new StringValue("value"));
    Assert.assertEquals("1.0value", result.getValue());

    NumberValue numberValue2 = new NumberValue(1);
    Value result2 = numberValue2.plus(new NumberValue(1));
    Assert.assertEquals(2, result2.getValue());

    NumberValue numberValue3 = new NumberValue(1);
    Value result3 = numberValue3.minus(new NumberValue(1));
    Assert.assertEquals(0, result3.getValue());

    NumberValue numberValue4 = new NumberValue(1);
    Value result4 = numberValue4.times(new NumberValue(1));
    Assert.assertEquals(1, result4.getValue());

    NumberValue numberValue5 = new NumberValue(1);
    Value result5 = numberValue5.divide(new NumberValue(1));
    Assert.assertEquals(1, result5.getValue());

    NumberValue numberValue0 = new NumberValue(1);
    String type = numberValue0.getType();
    boolean isNumber = numberValue0.is("number");
    double numberValue = numberValue0.getValue();

    Assert.assertEquals("number", type);
    Assert.assertTrue(isNumber);
    Assert.assertEquals(1, numberValue, 0);
  }

  @Test(expected = ArithmeticException.class)
  public void interpreterNumberValueDivideBy0Test() {
    NumberValue numberValue5 = new NumberValue(0);
    Value result5 = numberValue5.divide(new NumberValue(1));
  }
}
