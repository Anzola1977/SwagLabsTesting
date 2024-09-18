package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccessPage extends BasePage {

    public CheckoutSuccessPage() {
    }

    @FindBy(css = "#checkout_complete_container")
    public WebElement checkoutComplete;

    @FindBy(css = "#back-to-products")
    public WebElement backHomeButton;
}
