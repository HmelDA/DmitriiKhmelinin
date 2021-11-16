package com.epam.tc.hw6.page;

import com.epam.tc.hw6.driver.webdriver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected Logger logger = LogManager.getRootLogger();


    protected abstract AbstractPage openPage();

    protected static final int WAIT = 5;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
