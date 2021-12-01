package com.epam.tc.hw7.test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.service.UserCreator;
import com.epam.tc.hw7.site.JdiTestingSite;
import com.epam.tc.hw7.site.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestInit {
    public static User DEFAULT_USER = UserCreator.withCredentialsFromProperty();

    @BeforeSuite
    static void setUpSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
        initSite(JdiTestingSite.class);
    }

    @BeforeMethod
    static void setUpMethod() {
        JdiTestingSite.openJdiSite();
        HomePage.login(DEFAULT_USER);
        assertThat(HomePage.userName.text())
                .isEqualTo(DEFAULT_USER.getName());
    }

    @AfterMethod(alwaysRun = true)
    static void teardown() {
        HomePage.logout();
    }

    @AfterSuite
    static void driversKill() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
