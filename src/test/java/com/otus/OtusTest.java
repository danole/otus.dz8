package com.otus;

import com.otus.pages.MainPage;
import org.junit.jupiter.api.Test;

public class OtusTest extends BaseTest{

    @Test
    public void checkingTheNumberOfCourses(){
        driver.get("https://otus.ru/");
        MainPage mainPage=new MainPage(driver,logger,actions);
        mainPage.goToSectionTesting();
    }

}
