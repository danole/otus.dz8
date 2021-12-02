package com.otus.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import java.util.List;

public class EventPage extends BasePage {

    public EventPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }


    List<WebElement> dateList = driver.findElements(By.xpath("//div[@class='dod_new-event__time']"));

    Date date = new Date();

    public void compareDates() {

        for (int i = 0; i < dateList.size(); i++) {
            System.out.println(dateList.get(i).getText());
        }
        System.out.println(date.toString());
    }

}
