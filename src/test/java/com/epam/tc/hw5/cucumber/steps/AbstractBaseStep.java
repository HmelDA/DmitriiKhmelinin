package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.driver.DriverSingleton;
import com.epam.tc.hw5.model.User;
import com.epam.tc.hw5.page.LoginPage;
import com.epam.tc.hw5.page.MainPage;
import com.epam.tc.hw5.page.ServiceDifferentElementsPage;
import com.epam.tc.hw5.service.LoginDataProvider;
import com.epam.tc.hw5.service.UserCreator;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {

    public static final String URL = LoginDataProvider.getLoginData("testSite.url");
    public WebDriver webDriver;
    public LoginPage loginPage;
    public MainPage mainPage;
    public ServiceDifferentElementsPage differentElementsPage;
    public User testUser;

    public AbstractBaseStep() {
        webDriver = DriverSingleton.getWebDriver();
        testUser = UserCreator.withCredentialsFromProperty();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        differentElementsPage = new ServiceDifferentElementsPage(webDriver);
    }
}
