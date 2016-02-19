import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void definition_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition("Sweaters for your feet");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getMeaning_returnsMeaning_true() {
    Definition testDefinition = new Definition("Sweaters for your feet");
    assertEquals("Sweaters for your feet", testDefinition.getMeaning());
  }

}
