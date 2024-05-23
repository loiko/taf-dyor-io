import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPlaywright {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        //String chromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
//        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
//                .setExecutablePath(Paths.get(chromePath))
//                .setHeadless(false);
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://test.dyor.io");

//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("English")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Russian")).click();
        //page.getByLabel("Russian").getByText("Russian").click();
//        page.getByText("English").click();
//        page.getByText("Russian").click();
        //assertThat(page).hasTitle("Explore TON blockchain assets in real time");
        assertThat(page.locator("h1")).containsText("Explore TON blockchain assets in real time");
        //assertThat(page).hasURL("https://test.dyor.io/");
        page.close();
        browser.close();
        playwright.close();
    }
}


        //assertThat(page.locator("h1")).containsText("Explore TON blockchain assets in real time");
