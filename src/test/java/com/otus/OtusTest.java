package com.otus;

import com.otus.pages.MainPage;
import com.otus.pages.TestingPage;
import org.junit.jupiter.api.Test;

public class OtusTest extends BaseTest{

    @Test
    public void checkingTheNumberOfCourses(){
        MainPage mainPage=new MainPage(driver,logger,actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        TestingPage testingPage=new TestingPage(driver,logger,actions);
        testingPage.checkNumberOfCard();
    }

    @Test
    public void checkingInformationOfCourses(){

    }

}
