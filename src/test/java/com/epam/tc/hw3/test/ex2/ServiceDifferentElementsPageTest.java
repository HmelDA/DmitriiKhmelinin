package com.epam.tc.hw3.test.ex2;

import com.epam.tc.hw3.page.ServiceDifferentElementsPage;
import com.epam.tc.hw3.test.BaseTest2;
import com.epam.tc.hw3.util.TextsForComparison;
import org.testng.annotations.Test;


public class ServiceDifferentElementsPageTest extends BaseTest2 {

    ServiceDifferentElementsPage differentElementsPage;

    @Test
    public void checkboxesRadioDropdownLogsTest() {

        differentElementsPage = mainPage.toDifferentElementsPage();
        //5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.toService();
        differentElementsPage.toDifferentElements();
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
