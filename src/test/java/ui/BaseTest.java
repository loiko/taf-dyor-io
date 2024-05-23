package ui;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.dyor.taf.po.TokensPage;
import io.dyor.taf.singleton.Singleton;
import io.dyor.taf.utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeMethod
    public void setup() {
        browser = Singleton.getBrowser();
        page = browser.newPage();
        context = browser.newContext();

        TokensPage tokensPage = new TokensPage(page);
        tokensPage.openTokensPage();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && page != null) {
            String screenshotPath = "screenshots/" + result.getName() + ".png";
            ScreenshotUtil.takeScreenshot(page, screenshotPath);
            ScreenshotUtil.attachScreenshot(screenshotPath);
        }
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }

        Singleton.quitBrowser();
    }
}
