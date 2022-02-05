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
            .setSources(true)
            .setScreenshots(true)
            .setSnapshots(true));

    // Open new page
    Page page = context.newPage();

    // Go to https://github.com/
    page.navigate("https://github.com/");

    // Click [placeholder="Search GitHub"]
    page.click("[placeholder=\"Search GitHub\"]");

    // Fill [placeholder="Search GitHub"]
    page.fill("[placeholder=\"Search GitHub\"]", "playwright");

    // Press Enter
    page.press("[placeholder=\"Search GitHub\"]", "Enter");

    // Click text=microsoft/playwright-java >> em
    page.click("text=microsoft/playwright-java >> em");

    // Click text=About Java version of the Playwright testing and automation library playwright.d >> a[role="link"]
    Page page1 = page.waitForPopup(() -> page.click("text=About Java version of the Playwright testing and automation library playwright.d >> a[role=\"link\"]"));

    // Click text=Get started
    page1.click("text=Get started");

    // Stop tracing and export it into a zip archive.
    final Path tracePath = Paths.get("target/trace.zip");
    context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));

    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Files.readAllBytes(tracePath))) {
      Allure.addAttachment("My Trace", "application/zip", byteArrayInputStream, ".zip");
    }
  }

}
