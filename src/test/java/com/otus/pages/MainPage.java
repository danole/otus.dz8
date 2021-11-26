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

    private String testing = "//div[@class='nav nav_disable nav_colored nav_transparent ']/*/*/*/*[6]";
    private String card="//a[@class='js-stats lessons__new-item lessons__new-item_hovered']";
    public final int NUMBER_OF_CARDS=11;

    public void goToSiteOtus(){
        driver.get("https://otus.ru/");
    }

    public void goToSectionTesting() {
        waitToVisibleElement(testing).click();
    }

    public void checkNumberOfCard(){
        List<WebElement>cards=driver.findElements(By.xpath(card));
        if (NUMBER_OF_CARDS==cards.size()){
            logger.info("Количество карточек совпадает");
        }else {
            logger.error("Количество карточек не совпадает!");
        }
    }
}
