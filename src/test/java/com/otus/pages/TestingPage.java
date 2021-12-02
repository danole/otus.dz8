package com.otus.pages;

import com.otus.pages.cardsPages.BaseCardPage;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
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
    public final int NUMBER_OF_CARDS = 11;

    public void checkNumberOfCard() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        Assertions.assertEquals(NUMBER_OF_CARDS, cards.size(), "Количество карточек не совпадает!");
        logger.info("Проверка карточек прошла успешно");
    }

    public void checkingInformation(BaseCardPage baseCardPage) {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        for (int i = 0; i < cards.size(); i++) {
            if (i == 5 || i == 10) {
                continue;
            }
            WebElement course = cards.get(i);
            course.click();
            baseCardPage.findInformationOfCard(baseCardPage.getDuration(), baseCardPage.getCourseAbout(),
                    baseCardPage.getTitleOfCourse());
            logger.info("Проверили карточку " + (i + 1));
            driver.navigate().back();
            cards = driver.findElements(By.xpath(card));
        }
    }

    public void goToQaAutomationEngineerPage() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        WebElement course = cards.get(5);
        course.click();
    }

    public void goToManualTestingPage() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        WebElement course = cards.get(10);
        course.click();
    }

}
