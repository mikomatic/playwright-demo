package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example {
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
            page.fill("[aria-label=\"Rech.\"]", "chocolat");

            // Click text=Chocolat
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz"), () ->
            page.waitForNavigation(() -> page.click("text=Chocolat"));
            // assert page.url().equals("https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz");

            // Click text=Chocolate - Wikipedia, la enciclopedia libre
            page.click("text=Chocolate - Wikipedia, la enciclopedia libre");
            // assert page.url().equals("https://es.wikipedia.org/wiki/Chocolate");

            // Go to https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz
            page.navigate("https://www.google.com/search?q=chocolate&source=hp&ei=7F2OYfSSKsarqtsP4KCkgAg&iflsig=ALs-wAMAAAAAYY5r_AE6QCMR8_KQRW-Mz6oAmD8w4FMD&gs_ssp=eJzj4tDP1TcwMijLMWB0YPDiTM7IT87PSSxJBQBIuAbI&oq=chocolat&gs_lcp=Cgdnd3Mtd2l6EAEYADIFCC4QgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCC4QgAQyCwguEIAEEMcBEKMCMgUIABCABDIFCC4QgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAVC8DljCHmDFTGgBcAB4AIABiwKIAYAJkgEFMC43LjGYAQCgAQGwAQA&sclient=gws-wiz");

            // Double click [aria-label="Rech."]
            page.dblclick("[aria-label=\"Rech.\"]");

            // Fill [aria-label="Rech."]
            page.fill("[aria-label=\"Rech.\"]", "chocolatelin");

            // Double click [aria-label="Rech."]
            page.dblclick("[aria-label=\"Rech.\"]");

            // Fill [aria-label="Rech."]
            page.fill("[aria-label=\"Rech.\"]", "lindor");

            // Press Enter
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=lindor&ei=A16OYauNKIusqtsPoqmFmAg&oq=lindor&gs_lcp=Cgdnd3Mtd2l6EAMyBAgAEEMyBggAEAoQQzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgcIABBHELADOgcIABCwAxBDOgoILhDIAxCwAxBDOgQILhBDOgQIABAKOgcIABCABBAKOgQILhAKOgUILhCABDoLCC4QgAQQxwEQowI6CggAEOoCELQCEEM6CgguEOoCELQCEEM6CwguEIAEEMcBENEDOgsILhCABBDHARCvAToKCC4QxwEQ0QMQQzoICAAQgAQQyQM6CgguEMcBEK8BEApKBQg4EgExSgQIQRgAUMAXWKqOAWCWngFoCXACeAGAAaACiAG6F5IBBjAuMTQuNJgBAKABAbABCsgBD8ABAQ&sclient=gws-wiz&ved=0ahUKEwjrmq3Q6ZL0AhULlmoFHaJUAYMQ4dUDCA4&uact=5"), () ->
            page.waitForNavigation(() -> page.press("[aria-label=\"Rech.\"]", "Enter"));
            // assert page.url().equals("https://www.google.com/search?q=lindor&ei=A16OYauNKIusqtsPoqmFmAg&oq=lindor&gs_lcp=Cgdnd3Mtd2l6EAMyBAgAEEMyBggAEAoQQzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgcIABBHELADOgcIABCwAxBDOgoILhDIAxCwAxBDOgQILhBDOgQIABAKOgcIABCABBAKOgQILhAKOgUILhCABDoLCC4QgAQQxwEQowI6CggAEOoCELQCEEM6CgguEOoCELQCEEM6CwguEIAEEMcBENEDOgsILhCABBDHARCvAToKCC4QxwEQ0QMQQzoICAAQgAQQyQM6CgguEMcBEK8BEApKBQg4EgExSgQIQRgAUMAXWKqOAWCWngFoCXACeAGAAaACiAG6F5IBBjAuMTQuNJgBAKABAbABCsgBD8ABAQ&sclient=gws-wiz&ved=0ahUKEwjrmq3Q6ZL0AhULlmoFHaJUAYMQ4dUDCA4&uact=5");

            // Click text=Images
            // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.google.com/search?q=lindor&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj8yczk6ZL0AhW9mGoFHfaLC6QQ_AUoAXoECAEQAw&biw=1280&bih=720&dpr=1"), () ->
            page.waitForNavigation(() -> page.click("text=Images"));
            // assert page.url().equals("https://www.google.com/search?q=lindor&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj8yczk6ZL0AhW9mGoFHfaLC6QQ_AUoAXoECAEQAw&biw=1280&bih=720&dpr=1");
        }
    }
}