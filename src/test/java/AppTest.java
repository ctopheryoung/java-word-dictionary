import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Make your own dictionary!");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New Word"));
    fill("#term").with("Sweater");
    submit(".btn");
    assertThat(pageSource()).contains("Sweater");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#term").with("Sweater");
    submit(".btn");
    assertThat(pageSource()).contains("Sweater");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#term").with("Sweater");
    submit(".btn");
    click("a", withText("Sweater"));
    click("a", withText("Add a Definition"));
    assertThat(pageSource()).contains("Add a new definition for Sweater:");
  }

  @Test
  public void definitionIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#term").with("Blanket");
    submit(".btn");
    click("a", withText("Blanket"));
    click("a", withText("Add a Definition"));
    fill("#meaning").with("Warm thing");
    submit(".btn");
    assertThat(pageSource()).contains("Warm thing");
  }
}
