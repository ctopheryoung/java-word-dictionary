import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void word_instantiatesCorrectly_true() {
    Word myWord = new Word("Sock");
    assertEquals(true, myWord instanceof Word);
  }

}
