package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class UserTableSteps extends AbstractBaseStep {

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableInServiceDropdown() {
        userTablePage.clickOnUserTable();
    }

    @When("\"User Table\" page should be opened")
    public void isUserTablePageOpened() {
        userTablePage.isPageOpened();
    }

    @When("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdowns(int numberTypeDropdownsQuantity) {
        assertThat(userTablePage.getNumberTypeDropdownsQuantity())
                .isEqualTo(numberTypeDropdownsQuantity);
    }

    @When("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUsernames(int usernamesQuantity) {
        assertThat(userTablePage.getUsernamesQuantity())
                .isEqualTo(usernamesQuantity);
    }

    @When("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkDescriptionTextsUnderImages(int descriptionTextsQuantity) {
        assertThat(userTablePage.getDescriptionTextsUnderImagesQuantity())
                .isEqualTo(descriptionTextsQuantity);
    }

    @When("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes(int checkboxesQuantity) {
        assertThat(userTablePage.getCheckboxesQuantity())
                .isEqualTo(checkboxesQuantity);
    }

    @When("User table should contain following values:")
    public void checkUserTableValues(DataTable userTable) {
        List<List<String>> userTableValuesFromFeature = userTable.asLists(String.class);
        userTableValuesFromFeature.remove(0);
        assertThat(userTablePage.getUserTableValuesList()).isEqualTo(userTableValuesFromFeature);

    }

    @When("Droplist should contain values in column Type for user Roman")
    public void checkDroplistValuesInColumnTypeForUserRoman(DataTable droplistValuesTable) {
        List<List<String>> droplistFromFeature = droplistValuesTable.asLists(String.class);
        droplistFromFeature.remove(0);
        List<String> droplistFromFeatureToCompare = new ArrayList<>();
        droplistFromFeature.forEach(droplistFromFeatureToCompare::addAll);
        assertThat(userTablePage.getDroplistValuesList()).isEqualTo(droplistFromFeatureToCompare);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckbox() {
        userTablePage.selectVipCheckbox();
    }

    @When("1 log row has {string} text in log section")
    public void checkLogRowTextInLogSection(String logRowText) {
        assertThat(userTablePage.getLogRowText()).isEqualTo(logRowText);
    }
}
