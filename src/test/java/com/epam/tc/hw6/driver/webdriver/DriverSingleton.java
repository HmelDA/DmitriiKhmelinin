package com.epam.tc.hw6.driver.webdriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver webDriver;

    private DriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            String launchType = System.getProperty("launch.type", "local");
            String browserName = System.getProperty("browser.name", "chrome");
            webDriver = WebDriverFactory.createWebDriver(launchType,
                    Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
