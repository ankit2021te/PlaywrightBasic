package testcases.day3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class HandleDropDownTest {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
//        page.selectOption("select","hi");
        page.selectOption("select", new SelectOption().setLabel("Eesti"));

        // best approach
        /*Locator locator = page.locator("select > option");
        System.out.println("Total number of options: "+locator.count());
        for (int i=0;i<locator.count();i++){
            System.out.println(locator.nth(i).innerText()+"--------"+locator.nth(i).getAttribute("lang"));

        }*/

        // alternate approach
        System.out.println("Welcome to alternate approach");
        List<ElementHandle> values = page.querySelectorAll("select > option");
        for (ElementHandle value : values){
            System.out.println(value.innerText()+"------"+value.getAttribute("lang"));
        }
        System.out.println("End...");
        page.close();
        browser.close();
        playwright.close();
    }

}
