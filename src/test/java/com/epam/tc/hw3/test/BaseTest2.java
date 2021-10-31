package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driver.DriverSingleton;
import com.epam.tc.hw3.model.User;
import com.epam.tc.hw3.page.HomePage;
import com.epam.tc.hw3.page.LoginPage;
import com.epam.tc.hw3.service.LoginDataProvider;
import com.epam.tc.hw3.service.UserCreator;
import com.epam.tc.hw3.util.TextsForComparison;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BaseTest2 {

    public SoftAssert softAssert;
    public LoginPage loginPage;
    public HomePage homePage;
    public User testUser;

    @BeforeClass
    public void setupClass() {
        DriverSingleton.getWebDriver();
        softAssert = new SoftAssert();
        testUser = UserCreator.withCredentialsFromProperty();
        //1. Open test site by URL
        loginPage.openPage();
    }

    @Test
    public void sameStepsTest() {

        softAssert.assertEquals(loginPage.getUrl(),
                LoginDataProvider.getLoginData("testSite.url"));
        //2. Assert Browser title
        softAssert.assertTrue(loginPage.getTitle().contains(TextsForComparison.HOME_PAGE));
        //3. Perform login
        homePage = loginPage.login(testUser);
        //4. Assert Username is loggined
        softAssert.assertTrue(homePage.getUserName().isDisplayed());
        softAssert.assertEquals(homePage.getUserName(), testUser.getName());
        softAssert.assertAll();
    }

    @AfterClass
    public void clear() {
        softAssert = null;
        testUser = null;
        DriverSingleton.closeDriver();
    }
}
