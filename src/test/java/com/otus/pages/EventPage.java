package com.otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EventPage extends BasePage {

    public EventPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(EventPage.class.getName());

    private final int THE_CURRENT_YEAR = 2021;
    private String dodInput = "//div[@class='dod_new-events__header-left']/*[2]/*[1]";
    private String dodButton = "//div[@class='dod_new-events__header-left']/*[2]/*[2]/*[3]";
    private String closeBanner = "//div[@class='sticky-banner__close js-sticky-banner-close']";
    private String typeList = "//div[@class='dod_new-event-content']/*[1]";
    private String dateListXpath = "//div[@class='dod_new-event__time']";

    public void compareDates() throws ParseException {

        Date date = new Date();

        List<WebElement> dateList = driver.findElements(By.xpath(dateListXpath));

        for (int i = 0; i < dateList.size(); i++) {
            DateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm yyyy", new Locale("ru"));
            Date parseDate = dateFormat.parse(dateList.get(i).getText() + " " + THE_CURRENT_YEAR + "г");
            System.out.println(dateFormat.format(parseDate));
            Assertions.assertTrue(parseDate.after(date), "Дата уже прошла");
        }
        System.out.println(date.toString());
    }

    public void sortingEventByTypeDod() {
        waitToClickableButton(closeBanner).click();
        waitToClickableButton(dodInput).click();
        waitToClickableButton(dodButton).click();
        logger.info("Отсортировали мероприятия по типу ДОД");
    }

    public void checkingEvents() {

        List<WebElement> type = driver.findElements(By.xpath(typeList));

        for (int i = 0; i < type.size(); i++) {
            Assertions.assertEquals("День открытых дверей", type.get(i).getText(), "Тип мероприятия ДОД не совпадает");
        }

        logger.info("Проверили тип мероприятий");

    }
}
