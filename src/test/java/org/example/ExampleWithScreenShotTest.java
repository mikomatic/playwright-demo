package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("First Test")
public class ExampleWithScreenShotTest extends TestFixture {

  @Test
  @Story("Write Allure environment")
  void allureEnvironmentWriter() throws IOException {
    AllureEnvironmentWriter.allureEnvironmentWriter();
  }

  @Test
  @Story("I can click a button")
  void shouldClickButton() {
    page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
    page.locator("button").click();
    assertEquals("Clicked", page.evaluate("result"));
  }

  @Test
  @Story("I can check a box")
  void shouldCheckTheBox() {
    page.setContent("<input id='checkbox' type='checkbox'></input>");
    page.locator("input").check();
    assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
  }

  @Test
  @Tag("navigation")
  @Story("I can use a webpage")
  void shouldSearchWiki() throws IOException {
    page.navigate("https://www.wikipedia.org/");
    page.locator("input[name=\"search\"]").click();
    page.locator("input[name=\"search\"]").fill("playwright");
    page.locator("input[name=\"search\"]").press("Enter");


    try (ByteArrayInputStream content = new ByteArrayInputStream(page.screenshot())) {
      Allure.addAttachment("My attachment 1", content);
    }
  }

}
