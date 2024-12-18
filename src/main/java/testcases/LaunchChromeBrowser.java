package testcases;

import com.microsoft.playwright.*;

import java.awt.*;
import java.text.MessageFormat;

public class LaunchChromeBrowser {

    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println(MessageFormat.format("Width is {0} and Height is {1}",width,height));
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,937));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setScreenSize(width,height));
        Page page = browserContext.newPage();
        System.out.println("Self");
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
