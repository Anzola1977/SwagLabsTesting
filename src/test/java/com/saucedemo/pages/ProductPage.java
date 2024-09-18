package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage() {
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement cartLink;

    @FindBy(css = "#back-to-products")
    public WebElement backToProductsLink;

    @FindBy(css = "#add-to-cart")
    public WebElement addToCartButton;

    @FindBy(css = "#remove")
    public WebElement removeButton;
}
