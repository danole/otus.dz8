package com.otus.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected Logger logger;
    protected Actions actions;

    public BasePage(WebDriver driver, Logger logger, Actions actions) {
        this.driver = driver;
        this.logger = logger;
        this.actions = actions;
    }

    //Создает WebElement c явным ожиданием на кликабельность
    protected WebElement waitToClickableButton(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }

    //Создает WebElement c явным ожиданием на видимость элемента в DOM дереве
    protected WebElement waitToVisibleElement(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

}
