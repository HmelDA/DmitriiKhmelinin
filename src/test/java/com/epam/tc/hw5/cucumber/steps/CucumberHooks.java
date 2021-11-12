package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    public WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = DriverSingleton.getWebDriver();
    }

    @After
    public void closeDriver() {
        DriverSingleton.closeDriver();
        System.out.println("_______________________________\n"
                + "_______________________________\n"
                + "_______________________________\n"
                + "_______________________________\n"
                + "_______________________________\n");
    }
}
