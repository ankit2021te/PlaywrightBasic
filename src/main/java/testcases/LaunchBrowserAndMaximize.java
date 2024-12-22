package testcases;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class LaunchBrowserAndMaximize {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("http://facebook.com");
        System.out.println(page.title());
        Thread.sleep(5000);
        page.close();
        playwright.close();



    }
}
