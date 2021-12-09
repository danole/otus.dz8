package com.otus.pages;

import com.otus.pages.cardsPages.BaseCardPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestingPage extends BasePage {

    public TestingPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(TestingPage.class.getName());
    private String closeBanner = "//div[@class='sticky-banner__close js-sticky-banner-close']";
    private String card = "//a[@class='js-stats lessons__new-item lessons__new-item_hovered']";
    public final int NUMBER_OF_CARDS = 11;

    /**
     * Загружает карточки в List и сверяет их количество с нужным нам(константа NUMBER_OF_CARDS)
     */
    public void checkNumberOfCard() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        Assertions.assertEquals(NUMBER_OF_CARDS, cards.size(), "Количество карточек не совпадает!");
        logger.info("Проверка карточек прошла успешно");
    }

    /**
     * Метод, который заходит в карточки поочереди и смотрит там их информацию, кроме 5 и 11 карточки, так как они не являются стандартными
     *
     * @param baseCardPage объект класса baseCardPage, который является базовой страницей карточки в разделе тестирование
     */
    public void checkingInformation(BaseCardPage baseCardPage) {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        waitToClickableButton(closeBanner).click();
        for (int i = 0; i < cards.size(); i++) {
            if (i == 4 || i == 10) {
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

    /**
     * Переход на карточку Qa Automation Engineer
     */
    public void goToQaAutomationEngineerPage() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        WebElement course = cards.get(4);
        course.click();
    }

    /**
     * Переход на карточку Ручное тестирование
     */
    public void goToManualTestingPage() {
        List<WebElement> cards = driver.findElements(By.xpath(card));
        WebElement course = cards.get(10);
        course.click();
    }

}
