import common.FileReader.DefaultFileReader;
import common.FileReader.FileReader;
import org.junit.Assert;
import org.junit.Test;

public class CommonFileReaderTest {

  FileReader fr = new DefaultFileReader();

  @Test(expected = RuntimeException.class)
  public void readFileWithWrongPathExceptionTest() {
    fr.readFile("notAPath");
  }

  @Test
  public void readFileWithExistingPathAndNullContent() {
    fr.readFile(System.getProperty("user.dir") + "/src/test/empty-test.txt");
  }

  @Test
  public void readFileWithExistingPathAndSomeContent() {
    String result = fr.readFile(System.getProperty("user.dir") + "/src/test/not-empty-test.txt");
    System.out.println(result);
    Assert.assertEquals(result, "not empty");
  }
}
