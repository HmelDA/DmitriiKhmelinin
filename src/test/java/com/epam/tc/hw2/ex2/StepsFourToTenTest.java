package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.SameStepsBaseTest;
import com.epam.tc.hw2.itemsandtexts.TextsNotEnums;
import com.epam.tc.hw2.locators.LocatorsVTwo;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class StepsFourToTenTest extends SameStepsBaseTest {

    @Test
    public void exTwoRemainingStepsTest() {
        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(LocatorsVTwo.SERVICE.get()).click();
        webDriver.findElement(LocatorsVTwo.DIFFERENT_ELEMENTS.get()).click();
        new WebDriverWait(webDriver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), TextsNotEnums.DIFFERENT_ELEMENTS_URL);
        //6. Select checkboxes
        webElement = webDriver.findElement(LocatorsVTwo.WATER_CHECKBOX.get());
        webElement.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(webElement, true)));
        webElement = webDriver.findElement(LocatorsVTwo.WIND_CHECKBOX.get());
        webElement.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(webElement, true)));
        //7. Select radio
        webElement = webDriver.findElement(LocatorsVTwo.SELEN_RADIO.get());
        webElement.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(webElement, true)));
        //8. Select in dropdown
        webDriver.findElement(LocatorsVTwo.DROPDOWN_COLORS.get()).click();
        webElement = webDriver.findElement(LocatorsVTwo.YELLOW.get());
        webElement.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(webElement, true)));
        //9. Verify that the logs are displayed and match the expected values
        List<String> textsToCompare = new ArrayList<>();
        for (WebElement webElement : webDriver.findElements(LocatorsVTwo.LOGS_PANEL.get())) {
            textsToCompare.add(webElement.getText());
        }
        for (int x = 0; x < textsToCompare.size(); x++) {
            softAssert.assertTrue(textsToCompare.get(x).contains(TextsNotEnums.LOG_CHANGES.get(x)));
        }
        //10. Close Browser
        softAssert.assertAll();
    }
}
