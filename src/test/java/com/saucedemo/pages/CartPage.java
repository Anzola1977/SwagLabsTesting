package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage() {
    }

    @FindBy(xpath = "//div[@class='cart_item']")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement productNameInCart;

    @FindBy(css = "#item_4_title_link")
    public WebElement productPageLink;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    public WebElement removeButtonInCart;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    public WebElement continueShoppingButtonInCart;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButtonInCart;

    @FindBy(xpath = "//div/span[@class='title']")
    public WebElement yourCart;
}
