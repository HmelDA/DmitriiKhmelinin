package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ServiceDifferentElementsPage extends AbstractPage {

    @FindBy(linkText = "SERVICE")
    private WebElement service;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    @FindBy(xpath = "//label[contains(.,'Water')]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(.,'Wind')]")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[contains(.,'Selen')]")
    private WebElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColors;

    @FindBy(xpath = "//option[contains(.,'Yellow')]")
    private WebElement yellow;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logsPanel;

    public ServiceDifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public void toService() {
        service.click();
    }

    public void toDifferentElements() {
        differentElements.click();
        new WebDriverWait(webDriver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public String differentElementsURL() {
        return webDriver.getCurrentUrl();
    }

    public void selectWaterCheckbox() {
        waterCheckbox.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(waterCheckbox, true)));
    }

    public void selectWindCheckbox() {
        windCheckbox.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(windCheckbox, true)));
    }

    public void selectSelenRadio() {
        selenRadio.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(selenRadio, true)));
    }

    public void clickDropdownColors() {
        dropdownColors.click();
    }

    public void selectYellow() {
        yellow.click();
        new WebDriverWait(webDriver, 5).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(yellow, true)));
    }

    public List<String> getLogsPanelText() {
        return logsPanel.stream().map(logMessage -> logMessage.getText()
                        .substring(logMessage.getText().indexOf(" ") + 1))
                .collect(Collectors.toList());
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
