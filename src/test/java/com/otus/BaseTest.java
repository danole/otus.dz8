package com.otus;

import com.otus.webDriverFactory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {

    protected WebDriver driver;
    protected Actions actions;

    /**
     * Запускает перед каждым тестом нужный нам драйвер и создает объект Actions
     */
    @BeforeEach
    protected void startUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.create("chrome", "start-maximized");
        actions = new Actions(driver);
    }

    /**
     * Завершает работу драйвера после каждого теста
     */
    @AfterEach
    protected void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}
