package com.saucedemo.steps;

import com.saucedemo.pages.CheckoutPageOneStep;
import com.saucedemo.pages.CheckoutPageTwoStep;
import com.saucedemo.pages.CheckoutSuccessPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.saucedemo.context.TestContext.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutSteps {

    @When("user input first name, last name and postal code")
    public void userInputFirstNameLastNameAndPostalCode() {
        CheckoutPageOneStep checkoutPageOneStep = new CheckoutPageOneStep();
        checkoutPageOneStep.firstName.sendKeys("Axel");
        checkoutPageOneStep.lastName.sendKeys("Foley");
        checkoutPageOneStep.postalCode.sendKeys("04668");
    }

    @And("clicks continue button")
    public void clicksContinueButton() {
        new CheckoutPageOneStep().continueButton.click();
    }

    @Then("the user goes to the checkout page two")
    public void theUserGoesToTheCheckoutPageTwo() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", getDriver().getCurrentUrl());
    }

    @When("user clicks the cancel button")
    public void userClicksTheCancelButton() {
        new CheckoutPageOneStep().cancelButtonInCheckoutOneStep.click();
    }

    @When("user clicks the cancel button on the second page of the checkout")
    public void userClicksTheCancelButtonOnTheSecondPageOfTheCheckout() {
        new CheckoutPageTwoStep().cancelButtonInCheckoutTwoStep.click();
    }

    @When("user clicks the finish button")
    public void userClicksTheFinishButton() {
        CheckoutPageTwoStep checkoutPageTwoStep = new CheckoutPageTwoStep();
        checkoutPageTwoStep.finishButton.click();
    }

    @Then("the success message appears")
    public void theSuccessMessageAppears() {
        assertTrue(new CheckoutSuccessPage().checkoutComplete.getText().contains("Thank you for your order!"));
    }

    @When("user clicks the back home button")
    public void userClicksTheBackHomeButton() {
        new CheckoutSuccessPage().backHomeButton.click();
    }
}
