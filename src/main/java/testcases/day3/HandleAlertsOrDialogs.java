package testcases.day3;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Consumer;

public class HandleAlertsOrDialogs {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(
                Paths.get("C:\\Users\\prati\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"),
                new BrowserType.LaunchPersistentContextOptions().setChannel("chrome").setExecutablePath(
                                Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).setViewportSize(null)
                        .setHeadless(false).setArgs(arguments));

        Page page = browserContext.newPage();


        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        Consumer<Dialog> dialogListener = dialog -> {
            System.out.println("Dialog detected: " + dialog.message());
            dialog.accept(); // Accept the dialog
        };


        page.onDialog(dialogListener);

        page.offDialog(dialogListener);

        Locator element= page.locator("//*[@id=\"content\"]/div/ul/li[1]/button");
        System.out.println(element.innerText());
        element.click();

//        page.close();
//        playwright.close();

    }
}
