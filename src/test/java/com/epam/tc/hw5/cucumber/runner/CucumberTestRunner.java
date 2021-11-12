package com.epam.tc.hw5.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "",
        glue = "com.epam.tc.hw5.cucumber.steps",
        features = "src/test/resources/com.epam.tc.hw5/cucumber"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
