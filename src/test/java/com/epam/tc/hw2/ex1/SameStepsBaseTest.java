package com.epam.tc.hw2.ex1;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SameStepsBaseTest {

    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String login = "Roman";
    private final String password = "Jdi1234";
    private final String name = "ROMAN IOVLEV";

    public WebDriverWait webDriverWait;
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
    }


    @Test
    public void sameStepsTest() {
        webDriver.navigate().to(url);
        softAssert.assertTrue(webDriver.getTitle().contains("Home Page"));
       /* webElement = webDriver.findElement(By.xpath("//span[text() = 'Home']"));
        webElement.click();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        assertEquals("EPAM | Enterprise Software Development, Design & Consulting",
                webDriver.getTitle());*/
    }

/*    @AfterMethod
    public void clear() {
        webDriver.close();
    }*/
}
