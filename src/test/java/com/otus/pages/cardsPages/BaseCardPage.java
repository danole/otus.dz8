package com.otus.pages.cardsPages;

import com.otus.pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseCardPage extends BasePage {

    public BaseCardPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    private String duration = "//div[@class='course-header2-bottom__content-item " +
            "container__col container__col_4 " +
            "container__col_md-4 container__col_ssm-12']/*[2]/*/*[1]";
    private String courseAbout = "//div[@class='course-about']";
    private String titleOfCourse = "//div[@class='course-header2__info-text js-course-header2-info-text']/*[1]";

    public String getDuration() {
        return duration;
    }

    public String getCourseAbout() {
        return courseAbout;
    }

    public String getTitleOfCourse() {
        return titleOfCourse;
    }

}
