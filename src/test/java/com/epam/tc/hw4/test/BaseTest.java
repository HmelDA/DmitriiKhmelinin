package com.epam.tc.hw4.test;

import com.epam.tc.hw4.driver.DriverSingleton;
import com.epam.tc.hw4.model.User;
import com.epam.tc.hw4.page.LoginPage;
import com.epam.tc.hw4.page.MainPage;
import com.epam.tc.hw4.page.ServiceDifferentElementsPage;
import com.epam.tc.hw4.service.LoginDataProvider;
import com.epam.tc.hw4.service.UserCreator;
import com.epam.tc.hw4.util.TestListener;
import com.epam.tc.hw4.util.TextsForComparison;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Base Test for Main Page and Different Elements Page")
@Listeners({TestListener.class})
public class BaseTest {

    public WebDriver webDriver;
    public SoftAssert softAssert;
    public LoginPage loginPage;
    public MainPage mainPage;
    public ServiceDifferentElementsPage differentElementsPage;
    public User testUser;

    @Story("Set Up class")
    @BeforeClass
    public void setupClass() {
        webDriver = DriverSingleton.getWebDriver();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(webDriver);
        testUser = UserCreator.withCredentialsFromProperty();
    }

    @Story("Perform login")
    @Test
    public void sameStepsTest() {
        //1. Open test site by URL
        loginPage.openPage();
        softAssert.assertEquals(loginPage.getUrl(),
                LoginDataProvider.getLoginData("testSite.url"));
        //2. Assert Browser title
        softAssert.assertTrue(loginPage.getTitle()
                .contains(TextsForComparison.HOME_PAGE));
        //3. Perform login
        mainPage = loginPage.login(testUser);
        //4. Assert Username is loggined
        softAssert.assertTrue(mainPage.getLocatorUserName().isDisplayed());
        softAssert.assertEquals(mainPage.getUserName(), testUser.getName());
        softAssert.assertAll();
    }

    @Story("Clear objects")
    @AfterClass
    public void clear() {
        softAssert = null;
        testUser = null;
        loginPage = null;
        mainPage = null;
        differentElementsPage = null;
        DriverSingleton.closeDriver();
    }
}
