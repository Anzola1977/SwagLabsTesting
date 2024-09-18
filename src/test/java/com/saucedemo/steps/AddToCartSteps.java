package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.DropDownMenuPage;
import com.saucedemo.pages.MainPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.saucedemo.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.*;

public class AddToCartSteps {

    @When("user clicks the addToCart button")
    public void userClicksTheAddToCartButton() {
        MainPage mainPage = new MainPage();
        mainPage.backpackAddToCartButton.click();
    }

    @Then("an icon for the number of items added to the cart appears")
    public void anIconForTheNumberOfItemsAddedToTheCartAppears() {
        MainPage mainPage = new MainPage();
        assertEquals("1", mainPage.numberOfProductsCartBadge.getText());
    }

    @And("clicks the name of product link")
    public void clicksTheNameOfProductLink() {
        MainPage mainPage = new MainPage();
        mainPage.itemBackpackLink.click();
    }

    @When("user clicks the addToCart button from product page")
    public void userClicksTheAddToCartButtonFromProductPage() {
        ProductPage productPage = new ProductPage();
        productPage.addToCartButton.click();
    }

    @And("clicks the cart badge")
    public void clicksTheCartBadge() {
        ProductPage productPage = new ProductPage();
        productPage.cartLink.click();
    }

    @Then("In the cart we see the name of added product")
    public void inTheCartWeSeeTheNameOfAddedProduct() {
        CartPage cartPage = new CartPage();
        getWait().until(ExpectedConditions.visibilityOf(cartPage.productNameInCart));
        assertTrue(cartPage.productNameInCart.getText().contains("Sauce Labs Backpack"));
    }

    @And("clicks Reset App State button")
    public void clicksResetAppStateButton() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenuPage.sidebarResetAppState));
        dropDownMenuPage.sidebarResetAppState.click();
    }

    @Then("the icon for the number of items added to the cart disappears")
    public void theIconForTheNumberOfItemsAddedToTheCartDisappears() {
        MainPage mainPage = new MainPage();
        assertFalse(mainPage.numberOfProductsCartBadge.isDisplayed());
    }

    @Then("a button to remove an item appears")
    public void aButtonToRemoveAnItemAppears() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.removeButton.isDisplayed());
    }

    @And("user clicks the remove button from main page")
    public void userClicksTheRemoveButtonFromMainPage() {
        MainPage mainPage = new MainPage();
        getWait().until(ExpectedConditions.visibilityOf(mainPage.removeButton));
        mainPage.removeButton.click();
    }

    @Then("the Add to cart button appears")
    public void theAddToCartButtonAppears() {
        MainPage mainPage = new MainPage();
        getWait().until(ExpectedConditions.visibilityOf(mainPage.backpackAddToCartButton));
        assertTrue(mainPage.backpackAddToCartButton.isDisplayed());
    }
}
