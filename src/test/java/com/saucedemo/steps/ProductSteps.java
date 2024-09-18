package com.saucedemo.steps;

import com.saucedemo.context.TestContext;
import com.saucedemo.pages.DropDownMenuPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.saucedemo.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductSteps {
    @When("user clicks the remove button from product page")
    public void userClicksTheRemoveButtonFromProductPage() {
        ProductPage productPage = new ProductPage();
        productPage.removeButton.click();
    }

    @Then("the Add to cart button on the product page appears")
    public void theAddToCartButtonOnTheProductPageAppears() {
        ProductPage productPage = new ProductPage();
        TestContext.getWait().until(ExpectedConditions.visibilityOf(productPage.addToCartButton));
        assertTrue(productPage.addToCartButton.isDisplayed());
    }

    @And("clicks AllItems button")
    public void clicksAllItemsButton() {
        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage();
        getWait().until(ExpectedConditions.visibilityOf(dropDownMenuPage.sidebarAllItems));
        dropDownMenuPage.sidebarAllItems.click();
    }

    @When("user clicks the Back to products link")
    public void userClicksTheBackToProductsLink() {
        ProductPage productPage = new ProductPage();
        productPage.backToProductsLink.click();
    }
}
