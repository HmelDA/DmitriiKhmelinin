package com.epam.tc.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "uui-navigation")
    private WebElement headerSection;

    @FindBy(className = "benefit-icon")
    private WebElement benefitIcons;

    @FindBy(className = "benefit-txt")
    private WebElement benefitText;


    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getUserName() {
        new WebDriverWait(webDriver, 10).until(
                element -> (userName.isDisplayed()));
        return userName;
    }
    public IFrame goToIframe() {

    }
}
