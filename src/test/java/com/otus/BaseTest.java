package com.otus;

import com.otus.webDriverFactory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {

    protected WebDriver driver;
    protected Actions actions;

    @BeforeEach
    protected void startUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.create("chrome", "start-maximized");
        actions = new Actions(driver);
    }

    @AfterEach
    protected void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}
