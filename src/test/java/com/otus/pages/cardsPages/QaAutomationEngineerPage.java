package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class QaAutomationEngineerPage extends BasePage {

    public QaAutomationEngineerPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(QaAutomationEngineerPage.class.getName());

    private String duration = "//div[@field='tn_text_1613568879568']";
    private String courseAbout = "//div[@id='rec330678591']";
    private String titleOfCourse = "//img[@imgfield='tn_img_1618313079427']";
    private final int numberCard = 5;

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
