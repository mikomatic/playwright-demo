package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExampleBug {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Open new page
            Page page = context.newPage();

            page.pause();

            // Go to https://www.google.com/
            page.navigate("https://www.google.com/");

            // Click [aria-label="Rech."]
            page.click("[aria-label=\"Rech.\"]");

            // Fill [aria-label="Rech."]
            page.fill("[aria-label=\"Rech.\"]", "chocolate");

            // Click text=Chocolat
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz"), () ->
            page.waitForNavigation(() -> page.click("text=Chocolat"));
            // assert page.url().equals("https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz");
        }
    }
}