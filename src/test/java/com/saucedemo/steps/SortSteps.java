package com.saucedemo.steps;

import com.saucedemo.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortSteps {

    @When("user selects sorting from low to high")
    public void userSelectsSortingFromLowToHigh() {
        MainPage mainPage = new MainPage();
        WebElement sorting = mainPage.sortOfItems;
        Select select = new Select(sorting);
        select.selectByValue("lohi");
    }

    @Then("the product with the lowest price is displayed first")
    public void theProductWithTheLowestPriceIsDisplayedFirst() {
        MainPage mainPage = new MainPage();
        assertFalse(mainPage.sorting(mainPage.inventoryItemPrice));
    }

    @When("user selects sorting from high to low")
    public void userSelectsSortingFromHighToLow() {
        MainPage mainPage = new MainPage();
        WebElement sorting = mainPage.sortOfItems;
        Select select = new Select(sorting);
        select.selectByValue("hilo");
    }

    @Then("the product with the highest price is displayed first")
    public void theProductWithTheHighestPriceIsDisplayedFirst() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.sorting(mainPage.inventoryItemPrice));
    }
}
