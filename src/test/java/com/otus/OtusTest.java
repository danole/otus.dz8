package com.otus;

import com.otus.pages.MainPage;
import org.junit.jupiter.api.Test;

public class OtusTest extends BaseTest{

    @Test
    public void checkingTheNumberOfCourses(){
        MainPage mainPage=new MainPage(driver,logger,actions);
        mainPage.goToSiteOtus();
        mainPage.goToSectionTesting();
        mainPage.checkNumberOfCard();
    }

}
