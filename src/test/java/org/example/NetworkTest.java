package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Route;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkTest {

    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;
    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    @DisplayName("Test Network Interception")
    void shouldInterceptNetworkCall() {

        // Mock network
        page.route("**/api", route -> route.fulfill(new Route.FulfillOptions().setStatus(200).setBody("Hello World!")));

        page.navigate("https://example.com/api");

        assertTrue(page.content().contains("Hello World!"));
        Allure.addAttachment("My attachment 2", new ByteArrayInputStream(page.screenshot()));
    }

}
