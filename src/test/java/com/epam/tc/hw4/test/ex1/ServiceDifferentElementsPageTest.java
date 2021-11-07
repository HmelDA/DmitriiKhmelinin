package com.epam.tc.hw4.test.ex1;

import com.epam.tc.hw4.page.ServiceDifferentElementsPage;
import com.epam.tc.hw4.test.BaseTest;
import com.epam.tc.hw4.util.TextsForComparison;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Test for Service")
public class ServiceDifferentElementsPageTest extends BaseTest {

    ServiceDifferentElementsPage differentElementsPage;

    @Story("Test for checkboxes and logs")
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
        differentElementsPage.logsConfirmation();

        //10. Close Browser
        softAssert.assertAll();
    }
}
