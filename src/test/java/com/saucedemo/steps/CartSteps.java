package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPageOneStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.saucedemo.context.TestContext.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps {

    @Then("the user goes to the cart page")
    public void theUserGoesToTheCartPage() {
        CartPage cartPage = new CartPage();
        assertEquals("Your Cart", cartPage.yourCart.getText());
    }

    @When("user clicks the continue shopping button")
    public void userClicksTheContinueShoppingButton() {
        CartPage cartPage = new CartPage();
        cartPage.continueShoppingButtonInCart.click();
    }

    @Then("the user goes to the main page")
    public void theUserGoesToTheMainPage() {
        assertEquals("https://www.saucedemo.com/inventory.html", getDriver().getCurrentUrl());
    }

    @When("user clicks the checkout button")
    public void userClicksTheCheckoutButton() {
        CartPage cartPage = new CartPage();
        cartPage.checkoutButtonInCart.click();
    }

    @Then("the user goes to the checkout page")
    public void theUserGoesToTheCheckoutPage() {
        CheckoutPageOneStep checkoutPageOneStep = new CheckoutPageOneStep();
        assertEquals("Checkout: Your Information", checkoutPageOneStep.checkoutYourInformation.getText());
    }

    @Then("the item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
        assertTrue(new CartPage().cartItems.isEmpty());
    }

    @When("user clicks the remove button from cart page")
    public void userClicksTheRemoveButtonFromCartPage() {
        CartPage cartPage = new CartPage();
        cartPage.removeButtonInCart.click();
    }

    @When("user clicks the name of product link")
    public void userClicksTheNameOfProductLink() {
        CartPage cartPage = new CartPage();
        cartPage.productPageLink.click();
    }

    @Then("the user goes to the product page")
    public void theUserGoesToTheProductPage() {
        assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", getDriver().getCurrentUrl());
    }
}
