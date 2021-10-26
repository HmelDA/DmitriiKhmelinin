package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.locators.Locators.*;

import com.epam.tc.hw2.SameStepsBaseTest;
import com.epam.tc.hw2.dataprovider.LoginDataProvider;
import com.epam.tc.hw2.itemsandtexts.HeaderSection;
import com.epam.tc.hw2.itemsandtexts.TextsForIcons;
import com.epam.tc.hw2.itemsandtexts.TextsNotEnums;
import com.epam.tc.hw2.locators.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                TextsNotEnums.HEADER_SECTION);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webDriver.findElements(BENEFIT_ICONS.className()).size(), 4);
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> benefits = new ArrayList<>();
        for (WebElement webElement : webDriver.findElements(BENEFIT_ICONS_TEXT.className())) {
            benefits.add(webElement.getText());
        }
        softAssert.assertEquals(benefits, TextsNotEnums.TEXTS_FOR_BENEFITS);
        softAssert.assertAll();
    }
}
/*    @AfterMethod
    public void clear() {
        webDriver.close();
    }*/

