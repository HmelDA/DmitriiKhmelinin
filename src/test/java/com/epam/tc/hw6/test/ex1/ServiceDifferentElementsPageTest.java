package com.epam.tc.hw6.test.ex1;

import com.epam.tc.hw6.page.ServiceDifferentElementsPage;
import com.epam.tc.hw6.test.BaseTest;
import com.epam.tc.hw6.util.TextsForComparison;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Test for Service")
@Story("Test for checkboxes and logs")
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
        differentElementsPage.logsConfirmation();

        //10. Close Browser
        softAssert.assertAll();
    }
}
