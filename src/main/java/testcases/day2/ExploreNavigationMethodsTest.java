package testcases.day2;

import com.microsoft.playwright.*;

public class ExploreNavigationMethodsTest {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        /*ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(
                Paths.get("C:\\Users\\prati\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"),
                 new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setExecutablePath(
                        Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).setViewportSize(null)
                        .setHeadless(false).setArgs(arguments));

        Page page = browserContext.newPage();*/
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page  = browser.newPage();
        page.navigate("https://facebook.com");
        System.out.println("Welcome to Playwright Club");
        System.out.println("Title is: "+page.title());
        page.navigate("https://www.google.com");
        System.out.println("Title is : "+page.title());
        Thread.sleep(2000);
        page.goBack();
        System.out.println("After goBack Title is: "+page.title());
        Thread.sleep(2000);
        page.goForward();
        System.out.println("After goForward Title is: "+page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
