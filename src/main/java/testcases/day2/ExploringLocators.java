package testcases.day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExploringLocators {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");
//        page.locator("#identifierId").type("abc@gmail.com");
        page.type("#identifierId","abcdef@gmail.com",new Page.TypeOptions().setDelay(100));
    }
}
