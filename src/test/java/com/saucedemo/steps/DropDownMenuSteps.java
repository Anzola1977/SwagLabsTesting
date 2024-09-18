package com.saucedemo.steps;

import com.saucedemo.pages.DropDownMenuPage;
import com.saucedemo.pages.MainPage;
import com.saucedemo.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.saucedemo.context.TestContext.getDriver;
import static com.saucedemo.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DropDownMenuSteps {

    @When("user clicks the burger menu")
    public void userClicksTheBurgerMenu() {
        MainPage mainPage = new MainPage();
        mainPage.sidebarLink.click();
    }

    @And("clicks Logout")
    public void clicksLogout() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenuPage.sidebarLogout));
        dropDownMenuPage.sidebarLogout.click();
    }

    @Then("the user goes to the login page")
    public void theUserGoesToTheLoginPage() {
        assertEquals(ConfigurationReader.get("base_url"), getDriver().getCurrentUrl());
    }

    @And("clicks About")
    public void clicksAbout() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenuPage.sidebarAbout));
        dropDownMenuPage.sidebarAbout.click();
    }

    @Then("the user goes to the SauceLabs page")
    public void theUserGoesToTheSauceLabsPage() {
        assertEquals("https://saucelabs.com/", getDriver().getCurrentUrl());
    }

    @And("clicks Close Menu")
    public void clicksCloseMenu() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenuPage.closeMenu));
        dropDownMenuPage.closeMenu.click();
    }

    @Then("menu closed")
    public void menuClosed() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.invisibilityOf(dropDownMenuPage.sidebarAbout));
        assertFalse(dropDownMenuPage.sidebarAbout.isDisplayed());
    }
}
