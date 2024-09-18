package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownMenuPage extends BasePage {

    public DropDownMenuPage() {
    }

    @FindBy(css = "#inventory_sidebar_link")
    public WebElement sidebarAllItems;

    @FindBy(css = "#about_sidebar_link")
    public WebElement sidebarAbout;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement sidebarLogout;

    @FindBy(css = "#reset_sidebar_link")
    public WebElement sidebarResetAppState;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    public WebElement closeMenu;
}
