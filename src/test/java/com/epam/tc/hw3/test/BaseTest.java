package com.epam.tc.hw3.test;

import com.epam.tc.hw3.dataprovider.LoginDataProvider;
import com.epam.tc.hw3.driver.DriverSingleton;
import com.epam.tc.hw3.util.LocatorsMainPage;
import com.epam.tc.hw3.util.TextsForComparison;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public SoftAssert softAssert;


    @BeforeClass
    public void setupClass() {
        DriverSingleton.getWebDriver();
        softAssert = new SoftAssert();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1. Open test site by URL
        webDriver.navigate().to(TextsForComparison.URL);
    }

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
    public void sameStepsTest(String url, String login, String password, String name) {
        new WebDriverWait(webDriver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), url);

        //2. Assert Browser title
        softAssert.assertTrue(webDriver.getTitle().contains(TextsForComparison.HOME_PAGE));
        //3. Perform login

        webDriver.findElement(LocatorsMainPage.USER_ICON.get()).click();
        webDriver.findElement(LocatorsMainPage.LOGIN_FIELD.get()).sendKeys(login);
        webDriver.findElement(LocatorsMainPage.PASSWORD_FIELD.get()).sendKeys(password);
        webDriver.findElement(LocatorsMainPage.LOGIN_BUTTON.get()).click();
        //4. Assert Username is loggined

        WebElement userName = new WebDriverWait(webDriver, 10).until(
                element -> (webDriver.findElement(LocatorsMainPage.USER_NAME.get())));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), name);
        softAssert.assertAll();
    }

    @AfterClass
    public void clear() {
        softAssert = null;
        DriverSingleton.closeDriver();
    }
}
