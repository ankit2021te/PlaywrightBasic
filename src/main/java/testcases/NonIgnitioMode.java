package testcases;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;


public class NonIgnitioMode {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setHeadless(false));

        Page page = browserContext.newPage();
        page.navigate("http://facebook.com");
        System.out.println("Title is: "+page.title());





    }
}
