package io.dyor.taf.po;

import com.microsoft.playwright.Page;
import io.dyor.taf.singleton.Singleton;

public class TokensPage extends BasePage {
    private Page page;
    private final String TOKENSPAGE_URL = "https://test.dyor.io/";
    private String mainTitleLocator = "//h1";

    public TokensPage(Page page) {
        super(page);
        this.page = page;
    }

    public void openTokensPage() {
        page.navigate(TOKENSPAGE_URL);
    }

    public boolean isMainTitleDisplayed() {
        page.waitForSelector(mainTitleLocator, new Page.WaitForSelectorOptions().setTimeout(20000));
        boolean isDisplayed = page.isVisible(mainTitleLocator);
        return isDisplayed;
    }

    public String getMainTitleText() {
        page.waitForSelector(mainTitleLocator, new Page.WaitForSelectorOptions().setTimeout(20000));
        return page.textContent(mainTitleLocator);
    }
}
