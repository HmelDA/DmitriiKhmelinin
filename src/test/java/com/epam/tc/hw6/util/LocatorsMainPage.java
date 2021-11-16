package com.epam.tc.hw6.util;

import org.openqa.selenium.By;

public enum LocatorsMainPage {

    //ex1
    //Login locators
    USER_ICON(By.id("user-icon")),
    LOGIN_FIELD(By.id("name")),
    PASSWORD_FIELD(By.id("password")),
    LOGIN_BUTTON(By.id("login-button")),
    USER_NAME(By.id("user-name")),
    //Header locator
    HEADER_SECTION(By.className("uui-navigation")),
    //Benefit icons + texts
    BENEFIT_ICONS(By.className("benefit-icon")),
    BENEFIT_ICONS_TEXT(By.className("benefit-txt")),
    //Frame button
    FRAME_BUTTON_IFRAME(By.id("frame")),
    FRAME_BUTTON(By.id("frame-button")),
    //Left Section
    LEFT_SECTION(By.cssSelector("#mCSB_1_container > ul > li"));


    By locator;

    LocatorsMainPage(By locator) {
        this.locator = locator;
    }

    public By get() {
        return locator;
    }

}
