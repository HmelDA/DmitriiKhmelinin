package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.driver.DriverSingleton;
import io.cucumber.java.After;

public class CucumberHooks {

    @After
    public void closeDriver() {
        DriverSingleton.closeDriver();
    }
}
