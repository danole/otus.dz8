package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ManualTestingPage extends BasePage {

    public ManualTestingPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(ManualTestingPage.class.getName());

    public String duration = "//div[@class='preparatory-payment-list']/*[1]/*[2]/*[2]";
    private String courseAbout = "//div[@class='preparatory-intro__list']";
    private String titleOfCourse = "//div[@class='preparatory-intro__title']";
    private final int numberCard = 11;

    /**
     * @return xpath Длительность обучения
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @return xpath Описания курса
     */
    public String getCourseAbout() {
        return courseAbout;
    }

    /**
     * @return xpath Названия курса
     */
    public String getTitleOfCourse() {
        return titleOfCourse;
    }

    /**
     * @return Номер карточки
     */
    public int getNumberCard() {
        return numberCard;
    }

}
