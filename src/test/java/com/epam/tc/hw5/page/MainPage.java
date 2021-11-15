package com.epam.tc.hw5.page;

import com.epam.tc.hw5.util.TextsForComparison;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MainPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(className = "uui-navigation")
    private WebElement headerSection;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;
    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitText;

    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> leftSection;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Step("Check user name is displayed")
    public boolean checkUserNameDisplayed() {
        logger.info("Login performed");
        return userName.isDisplayed();
    }

    @Step("Get user name")
    public String getUserName() {
        logger.info("Username is displayed");
        return userName.getText();
    }

    @Step("Check presence of Header Section")
    public boolean checkHeaderSectionDisplayed() {
        logger.info("Username is checked");
        return headerSection.isDisplayed();
    }

    @Step("Check Header Section text")
    public String getHeaderSectionText() {
        logger.info("Header Section is displayed");
        return headerSection.getText();
    }

    @Step("Check Benefit Icons quantity")
    public int getBenefitIconsQuantity() {
        logger.info("Header Section is checked");
        return benefitIcons.size();
    }

    @Step("Check Benefit Icons presence")
    public Boolean checkThatBenefitIconsPresented() {
        logger.info("Benefit Icons quantity is checked");
        return benefitIcons.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Check Benefit Icons text")
    public List<String> getBenefitIconsText() {
        logger.info("Benefit Icons are presented");
        return benefitText.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Check Iframe Button presence")
    public boolean checkIframeButtonIsDisplayed() {
        logger.info("Benefit Icons text checked");
        return iframe.isDisplayed();
    }

    @Step("Switch to Iframe Button")
    public void switchToFrameButton() {
        logger.info("Iframe Button is presented");
        webDriver.switchTo().frame(iframe);
    }

    @Step("Get Iframe Button text")
    public String getFrameButtonText() {
        logger.info("Switched to the Iframe Button");
        return frameButton.getAttribute(TextsForComparison.FRAME_BUTTON_VALUE);
    }

    @Step("Switch back to original window")
    public void switchBackToOriginalWindow() {
        logger.info("Iframe Button text checked");
        webDriver.switchTo().parentFrame();
    }

    @Step("Get Left Section text")
    public List<String> getLeftSectionText() {
        logger.info("Switched back to original window");
        return leftSection.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void leftSectionConfirmation() {
        logger.info("Left Section text checked");
    }

    public ServiceDifferentElementsPage getServiceDifferentElementsPageInstance() {
        return new ServiceDifferentElementsPage(webDriver);
    }
}
