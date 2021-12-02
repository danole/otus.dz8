package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ManualTestingPage extends BasePage {

    public ManualTestingPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    public String duration = "//div[@class='preparatory-payment-list']/*[1]/*[2]/*[2]";
    private String courseAbout = "//div[@class='preparatory-intro__list']";
    private String titleOfCourse = "//div[@class='preparatory-intro__title']";
    private final int numberCard = 11;

    public String getDuration() {
        return duration;
    }

    public String getCourseAbout() {
        return courseAbout;
    }

    public String getTitleOfCourse() {
        return titleOfCourse;
    }

    public int getNumberCard() {
        return numberCard;
    }

}
