package com.pragya.banking.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pragya.banking.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver driver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        if (System.getenv("CI") == null) {
            driver.manage().window().maximize();
        }

        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}