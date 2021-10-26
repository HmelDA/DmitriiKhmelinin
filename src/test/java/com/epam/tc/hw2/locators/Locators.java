package com.epam.tc.hw2.locators;

import org.openqa.selenium.By;

public enum Locators {
    //Login locators
    USER_ICON("user-icon"),
    LOGIN_FIELD("name"),
    PASSWORD_FIELD("password"),
    LOGIN_BUTTON("login-button"),
    USER_NAME("user-name"),
    //Header locator
    HEADER_SECTION("uui-navigation"),
    //Benefit icons
    BENEFIT_ICONS("benefit-icon"),
    BENEFIT_ICONS_TEXT("benefit-txt");


    String locator;

    Locators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }

    public By id() {
        return By.id(getLocator());
    }

    public By css() {
        return By.cssSelector(getLocator());
    }

    public By className() {
        return By.className(getLocator());
    }
}
