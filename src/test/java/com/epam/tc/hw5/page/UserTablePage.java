package com.epam.tc.hw5.page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class UserTablePage extends AbstractPage {

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public void clickOnUserTable() {
    }

    public void isPageOpened() {
    }

    public int getNumberTypeDropdownsQuantity() {
        return 0;
    }

    public int getUsernamesQuantity() {
        return 0;
    }

    public int getDescriptionTextsUnderImagesQuantity() {
        return 0;
    }

    public int getCheckboxesQuantity() {
        return 0;
    }

    public List<List<String>> getUserTableValuesList() {
        List<List<String>> userTableValuesList = new ArrayList<>();
        return userTableValuesList;
    }

    public List<String> getDroplistValuesList() {
        return new ArrayList<String>();
    }

    public void selectVipCheckbox() {
    }

    public String getLogRowText() {
        return null;
    }
}
