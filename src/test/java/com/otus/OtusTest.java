package com.otus;

import com.otus.pages.MainPage;
import com.otus.pages.TestingPage;
import com.otus.pages.cardsPages.BaseCardPage;
import com.otus.pages.cardsPages.ManualTestingPage;
import com.otus.pages.cardsPages.QaAutomationEngineerPage;
import org.junit.jupiter.api.Test;

public class OtusTest extends BaseTest {

    @Test
    public void checkingTheNumberOfCourses() {
        MainPage mainPage = new MainPage(driver, logger, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        TestingPage testingPage = new TestingPage(driver, logger, actions);
        testingPage.checkNumberOfCard();
    }

    @Test
    public void checkingInformationOfCourses() {
        MainPage mainPage = new MainPage(driver, logger, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        TestingPage testingPage = new TestingPage(driver, logger, actions);
        BaseCardPage baseCardPage=new BaseCardPage(driver, logger, actions);
        testingPage.checkingInformation(baseCardPage);
        testingPage.goToQaAutomationEngineerPage();
        QaAutomationEngineerPage qaAutomationEngineerPage = new QaAutomationEngineerPage(driver, logger, actions);
        qaAutomationEngineerPage.findInformationOfCard(qaAutomationEngineerPage.getDuration(), qaAutomationEngineerPage.getCourseAbout(),
                qaAutomationEngineerPage.getTitleOfCourse());
        logger.info("Проверили карточку " + qaAutomationEngineerPage.getNumberCard());
        driver.navigate().back();
        testingPage.goToManualTestingPage();
        ManualTestingPage manualTestingPage = new ManualTestingPage(driver, logger, actions);
        manualTestingPage.findInformationOfCard(manualTestingPage.getDuration(), manualTestingPage.getCourseAbout(),
                manualTestingPage.getTitleOfCourse());
        logger.info("Проверили карточку " + manualTestingPage.getNumberCard());
    }

    @Test
    public void checkingDateOfEvent(){
        MainPage mainPage = new MainPage(driver, logger, actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionEvent();
    }



}
