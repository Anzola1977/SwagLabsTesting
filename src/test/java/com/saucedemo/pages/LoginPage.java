package com.saucedemo.pages;

import com.saucedemo.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage() {
    }

    @FindBy(css = "#user-name")
    public WebElement userName;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "#login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    public WebElement errorMessage;

    public void enteringStandardUserNameAndPassword() {
        userName.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        loginButton.click();
    }
}
