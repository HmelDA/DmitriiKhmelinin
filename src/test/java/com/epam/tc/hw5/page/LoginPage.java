package com.epam.tc.hw5.page;

import com.epam.tc.hw5.model.User;
import com.epam.tc.hw5.service.LoginDataProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private static final String URL = LoginDataProvider.getLoginData("testSite.url");

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Step("Open the page")
    public LoginPage openPage() {
        webDriver.navigate().to(URL);
        new WebDriverWait(webDriver, WAIT * 2).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
        return this;
    }

    @Step("Get the url of page")
    public String getUrl() {
        logger.info("Login page opened");
        return webDriver.getCurrentUrl();
    }

    @Step("Get the title of page")
    public String getTitle() {
        logger.info("Got url");
        return webDriver.getTitle();
    }

    @Step("Perform login")
    public MainPage login(User user) {
        logger.info("Title checked");
        userIcon.click();
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Performing login...");
        return new MainPage(webDriver);
    }
}
