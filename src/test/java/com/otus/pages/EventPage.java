package com.otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    private String dodInput = "//div[@class='dod_new-events__header-left']/*[2]/*[1]";
    private String dodButton = "//div[@class='dod_new-events__header-left']/*[2]/*[2]/*[3]";
    private String closeBanner = "//div[@class='sticky-banner__close js-sticky-banner-close']";
    private String typeList = "//div[@class='dod_new-event-content']/*[1]";
    private String dateListXpath = "//div[@class='dod_new-event__time']";
    private String downButton = "//div[@class='footer2__links footer2__links_center']/*[6]/*[1]";

    /**
     * Проматывает страницу вниз до конца, собирает все даты,
     * парсит их в формат Date,
     * ставит в датах нужный нам год(когда месяцы доходят до января делает +1 год к нынешнему)
     *
     * @throws ParseException
     * @throws InterruptedException
     */
    public void compareDates() throws ParseException, InterruptedException {

        Date date = new Date();

        for (int i = 0; i < 30; i++) {
            Thread.sleep(100);
            waitToVisibleElement(downButton).sendKeys(Keys.SPACE);
        }

        List<WebElement> dateList = driver.findElements(By.xpath(dateListXpath));
        Date[] myList = new Date[dateList.size()];

        for (int i = 0; i < dateList.size(); i++) {
            DateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm yyyy", new Locale("ru"));
            Date parseDate = dateFormat.parse(dateList.get(i).getText() + " " + (date.getYear() + 1900) + "г");
            myList[i] = parseDate;

        }

        int generalMonth = date.getMonth();
        int prevMonth = date.getMonth();

        for (int i = 0; i < myList.length; i++) {

            if (myList[i].getMonth() > prevMonth || myList[i].getMonth() < prevMonth) {
                generalMonth++;
            }
            prevMonth = myList[i].getMonth();
            int addYear = generalMonth / 12;
            myList[i].setYear(myList[i].getYear() + addYear);
            Assertions.assertTrue(myList[i].after(date), "Дата уже прошла");
            System.out.println("дата" + i + " : " + myList[i] + " " + "Месяц " + generalMonth);

        }
    }

    /**
     * Сортирует мероприятия по типу ДОД
     */

    public void sortingEventByTypeDod() {
        waitToClickableButton(closeBanner).click();
        waitToClickableButton(dodInput).click();
        waitToClickableButton(dodButton).click();
        logger.info("Отсортировали мероприятия по типу ДОД");
    }

    /**
     * Проматывает страницу вниз до конца, собирает все типы мероприятий и сверяет с нужным нам
     */
    public void checkingEvents() throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            Thread.sleep(100);
            waitToVisibleElement(downButton).sendKeys(Keys.SPACE);
        }

        List<WebElement> type = driver.findElements(By.xpath(typeList));

        for (int i = 0; i < type.size(); i++) {
            Assertions.assertEquals("День открытых дверей", type.get(i).getText(), "Тип мероприятия ДОД не совпадает");
        }

        logger.info("Проверили тип мероприятий");

    }
}
