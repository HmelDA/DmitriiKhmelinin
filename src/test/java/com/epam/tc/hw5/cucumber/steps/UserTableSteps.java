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
        assertThat(webDriver.getCurrentUrl()).isEqualTo(userTablePage.getPageURL());
    }

    @When("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkTypeDropdowns(int typeDropdownsQuantity) {
        assertThat(userTablePage.getTypeDropdownsQuantity())
                .isEqualTo(typeDropdownsQuantity);
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
        assertThat(userTablePage.getUserTableValuesList())
                .isEqualTo(userTableValuesFromFeature
                        .subList(1, userTableValuesFromFeature.size()));

    }

    @When("Droplist should contain values in column Type for user Roman")
    public void checkDroplistValuesInColumnTypeForUserRoman(DataTable droplistValuesTable) {
        List<List<String>> droplistFromFeature = droplistValuesTable.asLists(String.class);
        List<String> droplistFromFeatureToCompare = new ArrayList<>();
        droplistFromFeature.subList(1, droplistFromFeature.size())
                .forEach(droplistFromFeatureToCompare::addAll);
        assertThat(userTablePage.getRomanDroplistValues()).isEqualTo(droplistFromFeatureToCompare);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipSergeyIvanCheckbox() {
        userTablePage.selectVipSergeyIvanCheckbox();
    }

    @When("1 log row has {string} text in log section")
    public void checkLogRowTextInLogSection(String logRowText) {
        assertThat(userTablePage.getLogRowText()).isEqualTo(logRowText);
    }
}
