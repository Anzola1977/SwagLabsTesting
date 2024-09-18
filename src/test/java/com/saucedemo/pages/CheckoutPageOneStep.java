package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageOneStep extends BasePage {

    public CheckoutPageOneStep() {
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement checkoutYourInformation;

    @FindBy(css = "#first-name")
    public WebElement firstName;

    @FindBy(css = "#last-name")
    public WebElement lastName;

    @FindBy(css = "#postal-code")
    public WebElement postalCode;

    @FindBy(css = "#cancel")
    public WebElement cancelButtonInCheckoutOneStep;

    @FindBy(css = "#continue")
    public WebElement continueButton;
}
