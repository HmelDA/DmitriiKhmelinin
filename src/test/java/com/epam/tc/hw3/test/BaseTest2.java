package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driver.DriverSingleton;
import com.epam.tc.hw3.model.User;
import com.epam.tc.hw3.page.LoginPage;
import com.epam.tc.hw3.page.MainPage;
import com.epam.tc.hw3.page.ServiceDifferentElementsPage;
import com.epam.tc.hw3.service.LoginDataProvider;
import com.epam.tc.hw3.service.UserCreator;
import com.epam.tc.hw3.util.TextsForComparison;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BaseTest2 {

    public WebDriver webDriver;
    public SoftAssert softAssert;
    public LoginPage loginPage;
    public MainPage mainPage;
    public ServiceDifferentElementsPage differentElementsPage;
    public User testUser;

    @BeforeClass
    public void setupClass() {
        webDriver = DriverSingleton.getWebDriver();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(webDriver);
        testUser = UserCreator.withCredentialsFromProperty();
        //1. Open test site by URL
        loginPage.openPage();
    }

    @Test
    public void sameStepsTest() {
        softAssert.assertEquals(loginPage.getUrl(),
                LoginDataProvider.getLoginData("testSite.url"));
        //2. Assert Browser title
        softAssert.assertTrue(loginPage.getTitle()
                .contains(TextsForComparison.HOME_PAGE));
        //3. Perform login
        mainPage = loginPage.login(testUser);
        //4. Assert Username is loggined
        softAssert.assertTrue(mainPage.locatorUserName().isDisplayed());
        softAssert.assertEquals(mainPage.getUserName(), testUser.getName());
        softAssert.assertAll();
    }

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
