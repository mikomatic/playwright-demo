package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TracingTest {


    @Test
    @DisplayName("Test Tracing")
    void shouldInterceptNetworkCall() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

            // Open new page
            Page page = context.newPage();
            // Go to https://example.com/
            page.navigate("https://example.com/");
            // Click text=More information...
            page.click("text=More information...");
            // Click text=About
            page.click("text=About");

            // Stop tracing and export it into a zip archive.
            final Path tracePath = Paths.get("target/trace.zip");
            context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));

            Allure.addAttachment("My Trace", "application/zip", new ByteArrayInputStream(Files.readAllBytes(tracePath)), ".zip");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
