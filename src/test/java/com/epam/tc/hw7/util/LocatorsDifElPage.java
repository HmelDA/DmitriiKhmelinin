package com.epam.tc.hw7.util;

import org.openqa.selenium.By;

public enum LocatorsDifElPage {

    //ex2
    //Service -> Different Elements Page
    SERVICE(By.linkText("SERVICE")),
    DIFFERENT_ELEMENTS(By.linkText("DIFFERENT ELEMENTS")),
    //Checkboxes
    WATER_CHECKBOX(By.xpath("//label[contains(.,'Water')]")),
    WIND_CHECKBOX(By.xpath("//label[contains(.,'Wind')]")),
    SELEN_RADIO(By.xpath("//label[contains(.,'Selen')]")),
    //Dropdown
    DROPDOWN_COLORS(By.cssSelector("select.uui-form-element")),
    YELLOW(By.xpath("//option[contains(.,'Yellow')]")),
    //Logs
    LOGS_PANEL(By.xpath("//ul[@class='panel-body-list logs']/li"));


    By locator;

    LocatorsDifElPage(By locator) {
        this.locator = locator;
    }

    public By get() {
        return locator;
    }
}
