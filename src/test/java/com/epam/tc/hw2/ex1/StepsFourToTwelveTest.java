package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.SameStepsBaseTest;
import com.epam.tc.hw2.itemsandtexts.TextsNotEnums;
import com.epam.tc.hw2.locators.LocatorsVTwo;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StepsFourToTwelveTest extends SameStepsBaseTest {

    @Test
    public void exOneRestTest() {
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(webDriver.findElement(LocatorsVTwo.HEADER_SECTION.get()).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(LocatorsVTwo.HEADER_SECTION.get()).getText(),
                TextsNotEnums.HEADER_SECTION);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webDriver.findElements(LocatorsVTwo.BENEFIT_ICONS.get()).size(), 4);
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> benefits = new ArrayList<>();
        for (WebElement webElement : webDriver.findElements(LocatorsVTwo.BENEFIT_ICONS_TEXT.get())) {
            benefits.add(webElement.getText());
        }
        softAssert.assertEquals(benefits, TextsNotEnums.TEXTS_FOR_BENEFITS);
        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(LocatorsVTwo.FRAME_BUTTON_IFRAME.get()).isDisplayed());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(TextsNotEnums.FRAME_BUTTON_IFRAME);
        softAssert.assertEquals(webDriver.findElement(LocatorsVTwo.FRAME_BUTTON.get())
                .getAttribute(TextsNotEnums.FRAME_BUTTON_VALUE), TextsNotEnums.FRAME_BUTTON_TEXT);
        //10. Switch to original window back
        webDriver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        benefits.clear();
        for (WebElement webElement : webDriver.findElements(LocatorsVTwo.LEFT_SECTION.get())) {
            benefits.add(webElement.getText());
        }
        softAssert.assertEquals(benefits, TextsNotEnums.LEFT_SECTION);
        //12. Close Browser
        softAssert.assertAll();
    }
}
