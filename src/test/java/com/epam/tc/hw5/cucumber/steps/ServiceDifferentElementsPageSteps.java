package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.TextsForComparison;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


@Feature("Test for Service")
@Story("Test for checkboxes and logs")
public class ServiceDifferentElementsPageSteps extends AbstractBaseStep {


    @When("I click on \"Service\" button in Header")
    public void clickOnButtonInHeader() {
        differentElementsPage.clickToServiceButton();
    }

    @When("I click on \"Different elements\" button in Service Dropdown")
    public void clickOnButtonInServiceDropdown() {
        differentElementsPage.clickToDifferentElementsButton();
    }

    @When("\"Different elements\" page should be opened")
    public void pageShouldBeOpened() {
        assertThat(differentElementsPage.getDifferentElementsURL())
                .isEqualTo(TextsForComparison.DIFFERENT_ELEMENTS_URL);
    }

    @When("I click on \"Water\" and \"Wind\" checkboxes")
    public void clickOnCheckboxes() {
        differentElementsPage.selectWaterCheckbox();
        differentElementsPage.selectWindCheckbox();
    }

    @When("Elements are checked")
    public void checboxesAreChecked() {
        differentElementsPage.isWaterCheckboxSelected();
        differentElementsPage.isWindCheckboxSelected();
    }

    @When("I click on \"Selen\" radio")
    public void clickOnRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @When("Radio is checked")
    public void radioIsChecked() {
        differentElementsPage.isSelenRadioSelected();
    }

    @When("I select \"Yellow\" color in dropdown")
    public void selectColorInDropdown() {
        differentElementsPage.clickDropdownColors();
        differentElementsPage.selectYellow();
    }

    @When("Element is checked")
    public void yellowIsChecked() {
        differentElementsPage.isSelenRadioSelected();
    }

    @When("Log rows are displayed in the Log Panel and its status"
            + " corresponding to selected checkboxes, radio and color")
    public void logRowsAreDisplayedAndStatusCorrespondingToSelected() {
        assertThat(differentElementsPage.getLogsPanelText())
                .isEqualTo(TextsForComparison.LOG_CHANGES);
    }
}
