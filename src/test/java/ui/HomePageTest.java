package ui;

import io.dyor.taf.po.TokensPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void testMainTitleText() {
        TokensPage tokensPage = new TokensPage(page);
        tokensPage.openTokensPage();
        String expectedTitle = "Explore TON blockchain assets in real time";
        String actualTitle = tokensPage.getMainTitleText();
        Assert.assertEquals(actualTitle, expectedTitle, "Main title text should match the expected value");
    }
}

