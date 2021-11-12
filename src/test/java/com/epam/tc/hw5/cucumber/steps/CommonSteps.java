package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.TestListener;
import com.epam.tc.hw5.util.TextsForComparison;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;

@Feature("Base Test for Main Page and Different Elements Page")
@Story("Set Up class, perform login, clear objects")
@Listeners(TestListener.class)
public class CommonSteps extends AbstractBaseStep {

    @Given("I open JDI GitHub site")
    public void openJDIsite() {
        loginPage.openPage();
    }

    @Then("Test site is opened")
    public void isSiteOpened() {
        assertThat(loginPage.getUrl()).isEqualTo(URL);
        assertThat(loginPage.getTitle()).contains(TextsForComparison.HOME_PAGE);
    }

    @When("I login as user \"Roman Iovlev\"")
    public void login() {
        mainPage = loginPage.login(testUser);
    }

    @Then("\"Roman Iovlev\" is loggined")
    public void isUserLoggedIn() {
        assertThat(mainPage.checkUserNameDisplayed());
        assertThat(mainPage.getUserName()).isEqualTo(testUser.getName());
    }
}
