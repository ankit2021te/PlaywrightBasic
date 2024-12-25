package testcases.day4;

import com.microsoft.playwright.*;

public class HandleIframeTest {

    public static void main(String[] args) {

        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
//        Locator iframe = page.locator("iframe");
//        System.out.println(iframe.count());
//        for (int i=0;i<iframe.count();i++){
//            System.out.println(iframe.nth(i).getAttribute("id"));
//        }

        page.frameLocator("[name='iframeResult']").locator("body > button").click();

    }
}
