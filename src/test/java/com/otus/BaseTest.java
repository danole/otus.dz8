package com.otus;

import com.otus.webDriverFactory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected Logger logger = LogManager.getLogger(OtusTest.class.getName());
    protected WebDriver driver;
    protected Actions actions;

    //Создает WebElement c явным ожиданием на видимость элемента в DOM дереве
    protected WebElement waitToVisibleElement(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    @BeforeEach
    protected void startUp() {
        WebDriverFactory.create("chrome", "start-maximized");
        driver = WebDriverFactory.driver;
        actions = new Actions(driver);
    }

//    @AfterEach
//    protected void end() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
