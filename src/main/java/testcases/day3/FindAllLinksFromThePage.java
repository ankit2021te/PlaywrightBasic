package testcases.day3;

import com.microsoft.playwright.*;

public class FindAllLinksFromThePage {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        Locator links = page.locator("a");

        for (int i=0;i<links.count();i++){
            System.out.println(links.nth(i).innerHTML()+"---"+links.nth(i).getAttribute("href"));
        }
        System.out.println("Total links count: "+links.count());
        System.out.println("**************************************************");
        Locator block = page.locator("nav[class='other-projects']");
        Locator blockLinks = block.locator("a");
        for (int i=0;i<blockLinks.count();i++){
            System.out.println(blockLinks.nth(i).innerText()+"----"+blockLinks.nth(i).getAttribute("href"));
        }
        System.out.println("Block Link count is: "+blockLinks.count());
        page.close();
        playwright.close();
    }
}
