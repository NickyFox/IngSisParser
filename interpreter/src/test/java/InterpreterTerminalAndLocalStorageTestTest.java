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
        ls.save("some-key", new StringValue("some-string"));
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
        Assert.assertEquals("some-number-1", result1.getValue());

        StringValue strValue2 = new StringValue("nuequen");
        Value result2 = strValue2.plus((Value) new StringValue("nuequen"));
        Assert.assertEquals("nuequennuequen", result2.getValue());
        Assert.assertEquals("string", strValue.getType());
        Assert.assertNotEquals("string", strValue.toString());
    }

    @Test(expected = IllegalGrammarException.class)
    public void grammarExceptionWithStringValueUsingDivide() {
        StringValue strValue1 = new StringValue("some");
        strValue1.divide(new BooleanValue(true));
    }

    @Test(expected = IllegalGrammarException.class)
    public void grammarExceptionWithStringValueUsingAnd() {
        StringValue strValue = new StringValue("some");
        strValue.and(new NumberValue(2));
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

}
