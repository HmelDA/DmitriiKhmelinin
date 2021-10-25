package com.epam.tc.hw2;

import com.epam.tc.hw2.locators.Locators;

import static com.epam.tc.hw2.locators.Locators.*;
import static org.testng.Assert.assertEquals;

import com.epam.tc.hw2.dataprovider.LoginDataProvider;
import com.epam.tc.hw2.locators.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class SameStepsBaseTest {

    public WebDriverWait webDriverWait;
    public WebDriver webDriver;
    public SoftAssert softAssert;
    public WebElement webElement;


    @BeforeMethod
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "sameStepsData")
    public void sameStepsTest(String url, String login, String password, String name) {
        //1. Open test site by URL
        webDriver.navigate().to(url);
/*        new WebDriverWait(webDriver, webDriverWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));*/
        softAssert.assertTrue(webDriver.getTitle().equals(url));
        //2. Assert Browser title
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));
        //3. Perform login
        webDriver.findElement(USER_ICON.id()).click();
        webDriver.findElement(LOGIN_FIELD.id()).sendKeys(login);
        webDriver.findElement(PASSWORD_FIELD.id()).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON.id()).click();
        //4. Assert Username is loggined
        webElement = webDriver.findElement(USER_NAME.id());
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertTrue(webElement.equals(name));
    }

/*    @AfterMethod
    public void clear() {
        webDriver.close();
    }*/
}
