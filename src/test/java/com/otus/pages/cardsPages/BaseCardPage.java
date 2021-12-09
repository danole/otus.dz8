package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseCardPage extends BasePage {

    public BaseCardPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(BaseCardPage.class.getName());

    private String duration = "//div[@class='course-header2-bottom__content-item " +
            "container__col container__col_4 " +
            "container__col_md-4 container__col_ssm-12']/*[2]/*/*[1]";
    private String courseAbout = "//div[@class='course-about']";
    private String titleOfCourse = "//div[@class='course-header2__info-text js-course-header2-info-text']/*[1]";

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

}
