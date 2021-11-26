package com.otus.pages;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TestingPage extends BasePage {

    public TestingPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    private String card = "//a[@class='js-stats lessons__new-item lessons__new-item_hovered']";
    public final int NUMBER_OF_CARDS = 11;

    public void checkNumberOfCard() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        Assertions.assertEquals(NUMBER_OF_CARDS,cards.size(),"Количество карточек не совпадает!");
        logger.info("Проверка карточек прошла успешно");
    }

}
