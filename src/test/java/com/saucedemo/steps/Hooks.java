package com.saucedemo.steps;

import com.saucedemo.context.TestContext;
import com.saucedemo.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.saucedemo.context.TestContext.getDriver;
import static com.saucedemo.context.TestContext.removeDriver;

public class Hooks {

    @Before
    public static void set(Scenario scenario) throws URISyntaxException, MalformedURLException {
        String browser = ConfigurationReader.get("browser");
        WebDriver driver;
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--lang=en-en");
                }
                if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                    chromeOptions.addArguments("start-maximized");
                }
                if (ConfigurationReader.get("remote_server").toLowerCase().contains("true")) {
                    chromeOptions.setCapability("platformName", ConfigurationReader.get("remote_server_platform"));
                    chromeOptions.setCapability("se:name", scenario.getName());
                    driver = new RemoteWebDriver(new URI(ConfigurationReader.get("remote_server_url")).toURL(), chromeOptions);
                } else {
                    driver = new ChromeDriver(chromeOptions);
                }
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-infobars");
                    edgeOptions.addArguments("--disable-popup-blocking");
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--lang=en-en");
                }
                if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                    edgeOptions.addArguments("start-maximized");
                }
                if (ConfigurationReader.get("remote_server").toLowerCase().contains("true")) {
                    edgeOptions.setCapability("platformName", ConfigurationReader.get("remote_server_platform"));
                    edgeOptions.setCapability("se:name", scenario.getName());
                    driver = new RemoteWebDriver(new URI(ConfigurationReader.get("remote_server_url")).toURL(), edgeOptions);
                } else {
                    driver = new EdgeDriver(edgeOptions);
                }
                break;
            case "firefox":
                if (!System.getProperty("os.name").toLowerCase().contains("firefox")) {
                    throw new WebDriverException("Your operating system does not support running the Firefox browser");
                }
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new WebDriverException("WebDriver is not selected in the configuration.properties file");
        }
        TestContext.setDriver(driver);
        driver.get(ConfigurationReader.get("base_url"));
        TestContext.scenario = scenario;
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = getDriver();
            if (driver != null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            }
        }
        closeDriver();
    }

    @BeforeStep
    public void beforeEveryStep(Scenario scenario) {
        WebDriver driver = getDriver();
        if (driver != null) {
            scenario.log("Current URL: " + driver.getCurrentUrl());
        }
    }

    private void closeDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            removeDriver();
        }
    }
}
