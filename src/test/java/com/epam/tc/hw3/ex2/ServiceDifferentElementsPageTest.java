package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.util.LocatorsDifElPage;
import com.epam.tc.hw3.util.TextsForComparison;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ServiceDifferentElementsPageTest extends BaseTest {

    @Test
    public void checkboxesRadioDropdownLogsTest() {

        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(LocatorsDifElPage.SERVICE.get()).click();
        webDriver.findElement(LocatorsDifElPage.DIFFERENT_ELEMENTS.get()).click();
        new WebDriverWait(webDriver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), TextsForComparison.DIFFERENT_ELEMENTS_URL);

        //6. Select checkboxes
        WebElement waterCheckbox = webDriver.findElement(LocatorsDifElPage.WATER_CHECKBOX.get());
        waterCheckbox.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(waterCheckbox, true)));
        WebElement windCheckbox = webDriver.findElement(LocatorsDifElPage.WIND_CHECKBOX.get());
        windCheckbox.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(windCheckbox, true)));

        //7. Select radio
        WebElement selenRadio = webDriver.findElement(LocatorsDifElPage.SELEN_RADIO.get());
        selenRadio.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(selenRadio, true)));

        //8. Select in dropdown
        webDriver.findElement(LocatorsDifElPage.DROPDOWN_COLORS.get()).click();
        WebElement yellowColor = webDriver.findElement(LocatorsDifElPage.YELLOW.get());
        yellowColor.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions.elementSelectionStateToBe(yellowColor, true)));

        //9. Verify that the logs are displayed and match the expected values
        softAssert.assertEquals(webDriver.findElements(LocatorsDifElPage.LOGS_PANEL.get())
                .stream().map(logMessage -> logMessage.getText().substring(logMessage.getText().indexOf(" ") + 1))
                .collect(Collectors.toList()), TextsForComparison.LOG_CHANGES);

        //10. Close Browser
        softAssert.assertAll();
    }
}
