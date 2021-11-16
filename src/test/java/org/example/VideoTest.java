package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoTest {


    @Test
    @DisplayName("Test Video")
    void videoExample() throws IOException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("target/videos/")));
        Page page = context.newPage();
        // Go to https://example.com/
        page.navigate("https://example.com/");
        // Click text=More information...
        page.click("text=More information...");
        // Click img[alt="Homepage"]
        page.click("img[alt=\"Homepage\"]");
        context.close();

        Allure.addAttachment("My attachment 2", "video/webm", new ByteArrayInputStream(Files.readAllBytes(page.video().path())), ".webm");
    }
}
