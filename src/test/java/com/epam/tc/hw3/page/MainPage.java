package com.epam.tc.hw3.page;

import com.epam.tc.hw3.util.TextsForComparison;
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

    public String getUserName() {
        return userName.getText();
    }

    public WebElement locatorUserName() {
        return userName;
    }

    public int benefitIconsQuantity() {
        return benefitIcons.size();
    }

    public List<String> benefitIconsText() {
        return benefitText.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Boolean benefitIconsPresented() {
        return benefitIcons.stream().allMatch(WebElement::isDisplayed);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void switchToFrameButton() {
        webDriver.switchTo().frame(iframe);
    }

    public String frameButtonText() {
        return frameButton.getAttribute(TextsForComparison.FRAME_BUTTON_VALUE);
    }

    public void toParentPage() {
        webDriver.switchTo().parentFrame();
    }

    public WebElement getHeaderSection() {
        return headerSection;
    }

    public String headerSectionText() {
        return headerSection.getText();
    }

    public List<String> leftSectionText() {
        return leftSection.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public ServiceDifferentElementsPage toDifElPage() {
        return new ServiceDifferentElementsPage(webDriver);
    }
}
