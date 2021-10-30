package com.epam.tc.hw3.test.ex1;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.util.LocatorsMainPage;
import com.epam.tc.hw3.util.TextsForComparison;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void sectionsImagesIframeTest() {

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(webDriver.findElement(LocatorsMainPage.HEADER_SECTION.get()).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(LocatorsMainPage.HEADER_SECTION.get()).getText(),
                TextsForComparison.HEADER_SECTION);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webDriver.findElements(LocatorsMainPage.BENEFIT_ICONS.get()).size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(webDriver.findElements(LocatorsMainPage.BENEFIT_ICONS_TEXT.get())
                .stream().map(WebElement::getText).collect(Collectors.toList()),
                TextsForComparison.TEXTS_FOR_BENEFITS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElement(LocatorsMainPage.FRAME_BUTTON_IFRAME.get()).isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(TextsForComparison.FRAME_BUTTON_IFRAME);
        softAssert.assertEquals(webDriver.findElement(LocatorsMainPage.FRAME_BUTTON.get())
                .getAttribute(TextsForComparison.FRAME_BUTTON_VALUE), TextsForComparison.FRAME_BUTTON_TEXT);

        //10. Switch to original window back
        webDriver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(webDriver.findElements(LocatorsMainPage.LEFT_SECTION.get())
                .stream().map(WebElement::getText).collect(Collectors.toList()),
                TextsForComparison.LEFT_SECTION);

        //12. Close Browser
        softAssert.assertAll();
    }
}
