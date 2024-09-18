package com.saucedemo;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com.saucedemo")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.saucedemo")
@ExcludeTags("ignored")
@IncludeTags({"login", "checkout", "addToCart", "cart", "dropDownMenu", "sort", "product", "E2E"})
public class RunCucumberTest {
}