import common.exeptions.IllegalGrammarException;
import org.junit.Test;

public class CommonExceptionTest {

  @Test(expected = IllegalGrammarException.class)
  public void testException() {
    throw new IllegalGrammarException();
  }

  //    @Test(expected = IllegalGrammarException.class)
  //    public void testExceptionWithMessage() throws Exception{
  //        IllegalGrammarException ex = Assert.assertThrows(IllegalGrammarException.class, () -> {
  //            throw new IllegalGrammarException("Message");
  //        });
  //        Assert.assertEquals(ex.getMessage(), "Message");
  //    }
  @Test(expected = IllegalGrammarException.class)
  public void testExceptionWithMessage() throws Exception {
    throw new IllegalGrammarException("Message");
  }
}
