package com.epam.tc.hw3.test.ex2;

import com.epam.tc.hw4.page.ServiceDifferentElementsPage;
import com.epam.tc.hw4.test.BaseTest;
import com.epam.tc.hw4.util.TextsForComparison;
import org.testng.annotations.Test;


public class ServiceDifferentElementsPageTest extends BaseTest {

    ServiceDifferentElementsPage differentElementsPage;

    @Test
    public void checkboxesRadioDropdownLogsTest() {

        differentElementsPage = mainPage.getServiceDifferentElementsPageInstance();
        //5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.clickToServiceButton();
        differentElementsPage.clickToDifferentElementsButton();
        softAssert.assertEquals(differentElementsPage.getDifferentElementsURL(),
                TextsForComparison.DIFFERENT_ELEMENTS_URL);

        //6. Select checkboxes
        differentElementsPage.selectWaterCheckbox();
        differentElementsPage.selectWindCheckbox();

        //7. Select radio
        differentElementsPage.selectSelenRadio();

        //8. Select in dropdown
        differentElementsPage.clickDropdownColors();
        differentElementsPage.selectYellow();

        //9. Verify that the logs are displayed and match the expected values
        softAssert.assertEquals(differentElementsPage.getLogsPanelText(),
                TextsForComparison.LOG_CHANGES);

        //10. Close Browser
        softAssert.assertAll();
    }
}
