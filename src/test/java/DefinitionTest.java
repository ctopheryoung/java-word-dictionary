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

  @Test
  public void getId_returnsDefinitionId_true() {
    Definition testDefinition = new Definition("Sweaters for your feet");
    assertTrue(Definition.all().size() == testDefinition.getId());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition testDefinitionOne = new Definition("Sweaters for your feet");
    Definition testDefinitionTwo = new Definition("A piece of clothing that you wear on your feetsies");
    assertTrue(Definition.all().contains(testDefinitionOne));
    assertTrue(Definition.all().contains(testDefinitionTwo));
  }

  @Test
  public void newId_definitionsInstantiateWithAnID_true() {
    Definition testDefinition = new Definition("Sweaters for your feet");
    assertEquals(Definition.all().size(), testDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_multiple() {
    Definition testDefinitionOne = new Definition("Sweaters for your feet");
    Definition testDefinitionTwo = new Definition("A piece of clothing that you wear on your feetsies");
    assertEquals(Definition.find(testDefinitionOne.getId()), testDefinitionOne);
    assertEquals(Definition.find(testDefinitionTwo.getId()), testDefinitionTwo);
  }

}
