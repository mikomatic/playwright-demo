package org.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TracingTest extends TestFixture {


  @Test
  @DisplayName("Test Tracing")
  void traceExample() throws IOException {

    // Start tracing before creating / navigating a page.
    context.tracing().start(new Tracing.StartOptions()
            .setSources(false)
            .setScreenshots(true)
            .setSnapshots(true));

    // Open new page
    Page page = context.newPage();

    // Go to https://github.com/
    page.navigate("https://github.com/");

    // Click [placeholder="Search\ GitHub"]
    page.locator("[placeholder=\"Search\\ GitHub\"]").click();

    // Fill [placeholder="Search\ GitHub"]
    page.locator("[placeholder=\"Search\\ GitHub\"]").fill("playwright");

    // Click text=playwright
    page.locator("text=playwright").click();
    // assert page.url().equals("https://github.com/search?q=playwright");

    // Click text=microsoft/playwright-java >> em
    page.locator("text=microsoft/playwright-java >> em").click();
    // assert page.url().equals("https://github.com/microsoft/playwright-java");

    // Click text=About Java version of the Playwright testing and automation library playwright.d >> a[role="link"]
    Page page1 = page.waitForPopup(() -> page.locator("text=About Java version of the Playwright testing and automation library playwright.d >> a[role=\"link\"]").click());

    // Click text=Get started
    page1.locator("text=Get started").click();

    // Stop tracing and export it into a zip archive.
    final Path tracePath = Paths.get("target/trace.zip");
    context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));

    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Files.readAllBytes(tracePath))) {
      Allure.addAttachment("My Trace", "application/zip", byteArrayInputStream, ".zip");
    }
  }

}
