package com.otus.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    private String testing="//div[@class='nav nav_disable nav_colored nav_transparent ']/*/*/*/*[6]";

    public void goToSectionTesting() {
        waitToVisibleElement(testing).click();
    }



}
