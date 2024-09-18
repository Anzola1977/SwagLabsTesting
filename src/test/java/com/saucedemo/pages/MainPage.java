package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage() {
    }

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public WebElement numberOfProductsCartBadge;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement backpackAddToCartButton;

    @FindBy(css = "#item_4_title_link")
    public WebElement itemBackpackLink;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement sortOfItems;

    @FindBy(css = "#react-burger-menu-btn")
    public WebElement sidebarLink;

    @FindBy(css = "#remove-sauce-labs-backpack")
    public WebElement removeButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> inventoryItemPrice;

    public boolean sorting(List<WebElement> inventoryItemPrice) {
        String firstElement = inventoryItemPrice.getFirst().getText().substring(1);
        double firstElementPrice = Double.parseDouble(firstElement);
        String lastElement = inventoryItemPrice.getLast().getText().substring(1);
        double lastElementPrice = Double.parseDouble(lastElement);
        return firstElementPrice > lastElementPrice;
    }
}