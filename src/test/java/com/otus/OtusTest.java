package com.otus;

import com.otus.pages.EventPage;
import com.otus.pages.MainPage;
import com.otus.pages.TestingPage;
import com.otus.pages.cardsPages.BaseCardPage;
import com.otus.pages.cardsPages.ManualTestingPage;
import com.otus.pages.cardsPages.QaAutomationEngineerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class OtusTest extends BaseTest {

    protected Logger logger = LogManager.getLogger(OtusTest.class.getName());

    @Test
    public void checkingTheNumberOfCoursesTest() {
        MainPage mainPage = new MainPage(driver, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        TestingPage testingPage = new TestingPage(driver, actions);
        testingPage.checkNumberOfCard();
    }

    @Test
    public void checkingInformationOfCoursesTest() {
        MainPage mainPage = new MainPage(driver, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        TestingPage testingPage = new TestingPage(driver, actions);
        BaseCardPage baseCardPage = new BaseCardPage(driver, actions);
        testingPage.checkingInformation(baseCardPage);
        testingPage.goToQaAutomationEngineerPage();
        QaAutomationEngineerPage qaAutomationEngineerPage = new QaAutomationEngineerPage(driver, actions);
        qaAutomationEngineerPage.findInformationOfCard(qaAutomationEngineerPage.getDuration(), qaAutomationEngineerPage.getCourseAbout(),
                qaAutomationEngineerPage.getTitleOfCourse());
        logger.info("Проверили карточку " + qaAutomationEngineerPage.getNumberCard());
        driver.navigate().back();
        testingPage.goToManualTestingPage();
        ManualTestingPage manualTestingPage = new ManualTestingPage(driver, actions);
        manualTestingPage.findInformationOfCard(manualTestingPage.getDuration(), manualTestingPage.getCourseAbout(),
                manualTestingPage.getTitleOfCourse());
        logger.info("Проверили карточку " + manualTestingPage.getNumberCard());
    }

    @Test
    public void checkingDateOfEventTest() throws ParseException {
        MainPage mainPage = new MainPage(driver, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionEvent();
        EventPage eventPage = new EventPage(driver, actions);
        eventPage.compareDates();
        logger.info("Проверили даты");
    }

    @Test
    public void checkingTypeOfEvent() {
        MainPage mainPage = new MainPage(driver, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionEvent();
        EventPage eventPage = new EventPage(driver, actions);
        eventPage.sortingEventByTypeDod();
        eventPage.checkingEvents();
    }


}
