package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.saucedemo.context.TestContext.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    @Given("user inputs username {string}")
    public void userInputsUsername(String name) {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(name);
    }

    @And("inputs password {string}")
    public void inputsPassword(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.password.sendKeys(password);
    }

    @When("user clicks the button login")
    public void userClicksTheButtonLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginButton.click();
    }

    @Then("the main page appears")
    public void theMainPageAppears() {
        assertEquals("https://www.saucedemo.com/inventory.html", getDriver().getCurrentUrl());
    }

    @Then("the message appears")
    public void theMessageAppears() {
        LoginPage loginPage = new LoginPage();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.errorMessage.getText());
    }
}
