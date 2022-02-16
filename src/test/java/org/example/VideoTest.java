package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VideoTest extends TestFixture {


  @Test
  @DisplayName("Test Video")
  void videoExample() throws IOException {

    BrowserContext videoContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("target/videos/")));
    Page page = videoContext.newPage();
    // Go to https://example.com/
    page.navigate("https://example.com/");
    // Click text=More information...
    page.locator("text=More information...").click();
    // Click img[alt="Homepage"]
    page.locator("img[alt=\"Homepage\"]").click();
    videoContext.close();

    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Files.readAllBytes(page.video().path()))) {
      Allure.addAttachment("My attachment 2", "video/webm", byteArrayInputStream, ".webm");
    }
  }
}
