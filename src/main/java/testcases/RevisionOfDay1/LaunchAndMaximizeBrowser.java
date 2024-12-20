package testcases.RevisionOfDay1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;

public class LaunchAndMaximizeBrowser {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arrayList));
        Page page = browser.newPage(new Browser.NewPageOptions().setViewportSize(null));
        page.navigate("http://way2automation.com");
        System.out.println("Title is: "+page.title());
        Thread.sleep(2000);
        browser.close();
        playwright.close();


    }
}
