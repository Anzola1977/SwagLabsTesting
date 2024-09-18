package com.saucedemo.pages;

import com.saucedemo.context.TestContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(TestContext.getDriver(), this);
    }
}
