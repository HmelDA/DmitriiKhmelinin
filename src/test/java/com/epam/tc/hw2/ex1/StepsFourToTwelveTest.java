package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.locators.Locators.*;

import com.epam.tc.hw2.SameStepsBaseTest;
import com.epam.tc.hw2.dataprovider.LoginDataProvider;
import com.epam.tc.hw2.itemsandtexts.HeaderSection;
import com.epam.tc.hw2.locators.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StepsFourToTwelveTest extends SameStepsBaseTest {

    @Test
    public void exOneRestTest() {
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(webDriver.findElement(HEADER_SECTION.className()).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(HEADER_SECTION.className()).getText(),
                HeaderSection.values());

    }

/*    @AfterMethod
    public void clear() {
        webDriver.close();
    }*/
}
