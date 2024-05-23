package io.dyor.taf.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ScreenshotUtil {
    public static void takeScreenshot(Page page, String screenshotPath) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(String screenshotPath) {
        try {
            return Files.readAllBytes(Paths.get(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
