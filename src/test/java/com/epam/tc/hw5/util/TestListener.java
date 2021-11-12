package com.epam.tc.hw5.util;

import com.epam.tc.hw5.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener {

    private Logger log = LogManager.getRootLogger();

    public void onTestFailure(ITestResult itestresult) {
        WebDriver webDriver = DriverSingleton.getWebDriver();
        saveScreenshot(webDriver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] saveScreenshot(WebDriver webDriver) {
        File screenCapture = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString()
                            + ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
