package com.epam.tc.hw4.page;

import io.qameta.allure.Step;
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

    @Step("Clicking to Service button")
    public void toService() {
        service.click();
    }

    @Step("Clicking to Different Elements button")
    public void toDifferentElements() {
        logger.info("Service button clicked");
        differentElements.click();
        new WebDriverWait(webDriver, WAIT * 2).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Step("Checking Different Elements url")
    public String getDifferentElementsURL() {
        logger.info("Different Elements button clicked");
        return webDriver.getCurrentUrl();
    }

    @Step("Selecting Water Checkbox")
    public void selectWaterCheckbox() {
        logger.info("Different Elements url clicked");
        waterCheckbox.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(waterCheckbox, true)));
    }

    @Step("Selecting Wind Checkbox")
    public void selectWindCheckbox() {
        logger.info("Water Checkbox Selected");
        windCheckbox.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(windCheckbox, true)));
    }

    @Step("Selecting Selen Radio")
    public void selectSelenRadio() {
        logger.info("Wind Checkbox Selected");
        selenRadio.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(selenRadio, true)));
    }

    @Step("Clicking to Dropdown Colors")
    public void clickDropdownColors() {
        logger.info("Selen Radio Selected");
        dropdownColors.click();
    }

    @Step("Selecting Yellow")
    public void selectYellow() {
        logger.info("Dropdown Colors opened");
        yellow.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(yellow, true)));
    }

    @Step("Getting Logs Panel text")
    public List<String> getLogsPanelText() {
        logger.info("Yellow Selected");
        return logsPanel.stream().map(logMessage -> logMessage.getText()
                        .substring(logMessage.getText().indexOf(" ") + 1))
                .collect(Collectors.toList());
    }

    public void logsConfirmation() {
        logger.info("Logs are checked");
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
