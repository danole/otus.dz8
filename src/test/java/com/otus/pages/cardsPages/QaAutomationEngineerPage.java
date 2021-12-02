package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class QaAutomationEngineerPage extends BasePage {

    public QaAutomationEngineerPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    private String duration = "//div[@field='tn_text_1613568879568']";
    private String courseAbout = "//div[@id='rec330678591']";
    private String titleOfCourse = "//img[@imgfield='tn_img_1618313079427']";
    private final int numberCard = 6;

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