package org.example;

import com.microsoft.playwright.Route;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkTest extends TestFixture {

  @Test
  @DisplayName("Test Network Interception")
  void shouldInterceptNetworkCall() throws IOException {

    // Mock network
    page.route("**/api", route -> route.fulfill(new Route.FulfillOptions().setStatus(200).setBody("Hello World!")));

    page.navigate("https://example.com/api");

    assertTrue(page.content().contains("Hello World!"));

    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(page.screenshot())) {
      Allure.addAttachment("My attachment 2", byteArrayInputStream);
    }
  }

}
