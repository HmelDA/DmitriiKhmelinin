package com.epam.tc.hw5.page;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Step("Click to Service button")
    public void clickToServiceButton() {
        service.click();
    }

    @Step("Click to Different Elements button")
    public void clickToDifferentElementsButton() {
        differentElements.click();
        new WebDriverWait(webDriver, WAIT * 2).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Step("Check Different Elements url")
    public String getDifferentElementsURL() {
        return webDriver.getCurrentUrl();
    }

    @Step("Select Water Checkbox")
    public void selectWaterCheckbox() {
        waterCheckbox.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(waterCheckbox, true)));
    }

    public void isWaterCheckboxSelected() {
        assertThat(waterCheckbox.isSelected())
                .withFailMessage("Checkbox is not selected");
    }

    @Step("Select Wind Checkbox")
    public void selectWindCheckbox() {
        windCheckbox.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(windCheckbox, true)));
    }

    public void isWindCheckboxSelected() {
        assertThat(windCheckbox.isSelected())
                .withFailMessage("Checkbox is not selected");
    }

    @Step("Select Selen Radio")
    public void selectSelenRadio() {
        selenRadio.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(selenRadio, true)));
    }

    public void isSelenRadioSelected() {
        assertThat(selenRadio.isSelected())
                .withFailMessage("Radio is not selected");
    }

    @Step("Click to Dropdown Colors")
    public void clickDropdownColors() {
        dropdownColors.click();
    }

    @Step("Select Yellow")
    public void selectYellow() {
        yellow.click();
        new WebDriverWait(webDriver, WAIT).until(
                element -> (ExpectedConditions
                        .elementSelectionStateToBe(yellow, true)));
    }

    public void isYellowSelected() {
        assertThat(yellow.isSelected())
                .withFailMessage("Color is not selected");
    }

    @Step("Get Logs Panel text")
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
