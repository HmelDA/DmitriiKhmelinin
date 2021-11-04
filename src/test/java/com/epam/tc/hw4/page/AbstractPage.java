package com.epam.tc.hw4.page;

import com.epam.tc.hw4.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;


    protected abstract AbstractPage openPage();

    protected static final int WAIT = 5;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
