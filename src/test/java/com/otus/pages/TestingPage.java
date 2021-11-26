package com.otus.pages;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingPage extends BasePage {

    public TestingPage(WebDriver driver, Logger logger, Actions actions) {
        super(driver, logger, actions);
    }

    private String card = "//a[@class='js-stats lessons__new-item lessons__new-item_hovered']";
    private String duration="//div[@class='course-header2-bottom__content-item " +
            "container__col container__col_4 " +
            "container__col_md-4 container__col_ssm-12']/*[2]/*/*[1]";

    public final int NUMBER_OF_CARDS = 11;

    public void checkNumberOfCard() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        Assertions.assertEquals(NUMBER_OF_CARDS,cards.size(),"Количество карточек не совпадает!");
        logger.info("Проверка карточек прошла успешно");
    }

    public void checkingInformation(){
        List<WebElement> cards = driver.findElements(By.xpath(card));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        for (int i=0;i<cards.size();i++){
            if(i==5 || i==10){
                continue;
            }
            WebElement course=cards.get(i);
            course.click();
            String textOfDuration=driver.findElement(By.xpath(duration)).getText();
            System.out.println(textOfDuration);
            driver.navigate().back();
            cards=driver.findElements(By.xpath(card));
        }
    }

}
