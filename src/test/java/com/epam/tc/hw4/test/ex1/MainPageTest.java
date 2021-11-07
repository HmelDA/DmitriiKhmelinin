package com.epam.tc.hw4.test.ex1;

import com.epam.tc.hw4.test.BaseTest;
import com.epam.tc.hw4.util.TextsForComparison;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Test for Main Page")
public class MainPageTest extends BaseTest {

    @Story("Test for sections and images")
    @Test
    public void sectionsImagesIframeTest() {

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(mainPage.getHeaderSection().isDisplayed());
        softAssert.assertEquals(mainPage.getHeaderSectionText(),
                TextsForComparison.HEADER_SECTION);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(mainPage.checkThatBenefitIconsPresented());
        softAssert.assertEquals(mainPage.getBenefitIconsQuantity(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(mainPage.getBenefitIconsText(),
                TextsForComparison.TEXTS_FOR_BENEFITS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(mainPage.getIframe().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPage.switchToFrameButton();
        softAssert.assertEquals(mainPage.getFrameButtonText(),
                TextsForComparison.FRAME_BUTTON_TEXT);

        //10. Switch to original window back
        mainPage.toParentPage();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(mainPage.getLeftSectionText(),
                TextsForComparison.LEFT_SECTION);
        mainPage.leftSectionConfirmation();

        //12. Close Browser
        softAssert.assertAll();
    }
}
