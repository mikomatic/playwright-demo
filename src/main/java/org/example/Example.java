package org.example;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Open new page
            Page page = context.newPage();

            // Go to https://github.com/
            page.navigate("https://github.com/");

            // Click [placeholder="Search GitHub"]
            page.locator("[placeholder=\"Search GitHub\"]").click();

            // Fill [placeholder="Search GitHub"]
            page.locator("[placeholder=\"Search GitHub\"]").fill("playwright");

            // Click text=playwright
            page.locator("text=playwright").click();
            assertThat(page).hasURL("https://github.com/search?q=playwright");

            // Click text=microsoft/playwright Playwright is a framework for Web Testing and Automation. I >> em >> nth=0
            page.locator("text=microsoft/playwright Playwright is a framework for Web Testing and Automation. I >> em").first().click();
            assertThat(page).hasURL("https://github.com/microsoft/playwright");

            // Click text=v1.25.1
            page.locator("text=v1.25.1").click();
            assertThat(page).hasURL("https://github.com/microsoft/playwright/releases/tag/v1.25.1");

            // Click text=Source code (zip) >> span
            Download download = page.waitForDownload(() -> {
                page.locator("text=Source code (zip) >> span").click();
            });
        }
    }
}