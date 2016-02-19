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

  @Test
  public void getTerm_returnsTerm_true() {
    Word myWord = new Word("Sock");
    assertEquals("Sock", myWord.getTerm());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Sock");
    Word secondWord = new Word("Kimono");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void getId_returnsWordId_true() {
    Word myWord = new Word("Sock");
    assertTrue(Word.all().size() == myWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word myWord = new Word("Sock");
    assertTrue(myWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
    Word myWord = new Word("Sock");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word myWord = new Word("Sweaters");
    assertEquals(Word.find(myWord.getId()), myWord);
  }

}
