package io.dyor.taf.singleton;

import com.microsoft.playwright.*;

import java.awt.*;


    public class Singleton {
        private static Browser browser;
        private static Playwright playwright;

        private Singleton() {
        }

        public static Browser getBrowser() {
            if (browser == null) {
                playwright = Playwright.create();
                browser = playwright.chromium().launch();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) screenSize.getWidth();
                int height = (int) screenSize.getHeight();
                BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
                Page page = context.newPage();
                page.setViewportSize(width, height);
            }
            return browser;
        }

        public static void quitBrowser() {
            if (browser != null) {
                browser.close();
                playwright.close();
                browser = null;
                playwright = null;
            }
        }
    }