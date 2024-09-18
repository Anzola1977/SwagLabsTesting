package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageTwoStep extends BasePage {

    public CheckoutPageTwoStep() {
    }

    @FindBy(css = "#cancel")
    public WebElement cancelButtonInCheckoutTwoStep;

    @FindBy(css = "#finish")
    public WebElement finishButton;
}
