package com.epam.tc.hw3.page;

import com.epam.tc.hw3.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver webDriver;


    protected abstract AbstractPage openPage();

    protected final int wait = 5;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = DriverSingleton.getWebDriver();
    }
}
