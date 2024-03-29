package com.otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(MainPage.class.getName());

    private String testing = "//div[@class='nav nav_disable nav_colored nav_transparent ']/*/*/*/*[6]";
    private String event = "//div[@class='header2-menu header2-menu_main']/*[2]";
    private String calendarOfEvents = "//div[@class='header2-menu header2-menu_main']/*[2]/*[2]/*[2]";

    /**
     * Переходит на сайт Otus
     */
    public void goToSiteOtus() {
        driver.get("https://otus.ru/");
        logger.info("Зашли на сайт");
    }

    /**
     * Переходит в раздел Тестирование
     */
    public void goToSectionTesting() {
        waitToVisibleElement(testing).click();
        logger.info("Зашли в раздел \"Тестирование\" ");
    }

    /**
     * Переходит в раздел Мероприятия
     */
    public void goToSectionEvent() {
        actions.moveToElement(waitToVisibleElement(event)).build().perform();
        actions.moveToElement(waitToVisibleElement(calendarOfEvents)).click().build().perform();
        logger.info("Перешли на страницу мероприятия");
    }

}
