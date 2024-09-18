package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;

public class CommonSteps {

    @Given("user is on the main page")
    public void userIsOnTheMainPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.enteringStandardUserNameAndPassword();
    }
}
