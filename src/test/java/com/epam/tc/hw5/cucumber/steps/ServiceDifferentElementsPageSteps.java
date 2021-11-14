package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.TextsForComparison;
import io.cucumber.java.en.Then;
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

    @When("I click on {string} checkbox")
    public void clickOnCheckboxes(String checkboxType) {
        switch (checkboxType) {
            case "Water":
                differentElementsPage.selectWaterCheckbox();
                break;
            case "Wind":
                differentElementsPage.selectWindCheckbox();
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    @Then("{string} checbox is checked")
    public void checboxIsChecked(String checkboxType) {
        switch (checkboxType) {
            case "Water":
                differentElementsPage.isWaterCheckboxSelected();
                break;
            case "Wind":
                differentElementsPage.isWindCheckboxSelected();
                break;
            default: throw new UnsupportedOperationException();
        }
    }


    @When("I click on {string} radio")
    public void clickOnRadio(String ratioType) {
        switch (ratioType) {
            case "Selen":
                differentElementsPage.selectSelenRadio();
                break;
            case "notSelen":
                System.out.println("notSelen");
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    @When("{string} radio is checked")
    public void radioIsChecked(String ratioType) {
        switch (ratioType) {
            case "Selen":
                differentElementsPage.isSelenRadioSelected();
                break;
            case "notSelen":
                System.out.println("notSelen");
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    @When("I select {string} color in dropdown")
    public void selectColorInDropdown(String color) {
        differentElementsPage.clickDropdownColors();
        switch (color) {
            case "Yellow":
                differentElementsPage.selectYellow();
                break;
            case "Red":
                System.out.println("Red");
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    @When("{string} color is checked")
    public void yellowIsChecked(String color) {
        switch (color) {
            case "Yellow":
                differentElementsPage.isYellowSelected();
                break;
            case "Red":
                System.out.println("Red");
                break;
            default: throw new UnsupportedOperationException();
        }
    }

    @When("Log rows are displayed in the Log Panel and its status"
            + " corresponding to selected checkboxes, radio and color")
    public void logRowsAreDisplayedAndStatusCorrespondingToSelected() {
        assertThat(differentElementsPage.getLogsPanelText())
                .isEqualTo(TextsForComparison.LOG_CHANGES);
    }
}
