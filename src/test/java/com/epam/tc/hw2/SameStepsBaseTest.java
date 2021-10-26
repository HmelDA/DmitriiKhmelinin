package com.epam.tc.hw2;

import static com.epam.tc.hw2.locators.Locators.*;

import com.epam.tc.hw2.dataprovider.LoginDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SameStepsBaseTest {

    public WebDriver webDriver;
    public SoftAssert softAssert;
    public WebElement webElement;


    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }


    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "sameStepsData")
    public void sameStepsTest(String url, String login, String password, String name) {
        new WebDriverWait(webDriver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), url);
        //2. Assert Browser title
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));
        //3. Perform login
        webDriver.findElement(USER_ICON.id()).click();
        webDriver.findElement(LOGIN_FIELD.id()).sendKeys(login);
        webDriver.findElement(PASSWORD_FIELD.id()).sendKeys(password);
        webDriver.findElement(LOGIN_BUTTON.id()).click();
        //4. Assert Username is loggined
        webElement = new WebDriverWait(webDriver, 10).until(
                element -> (webDriver.findElement(USER_NAME.id())));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), name);
        softAssert.assertAll();

    }
}
