package com.otus.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    /**
     * Создает WebElement c явным ожиданием на кликабельностьЫ
     */
    protected WebElement waitToClickableButton(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }

    /**
     * Создает WebElement c явным ожиданием на видимость элемента в DOM дереве
     */
    protected WebElement waitToVisibleElement(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    /**
     * Проверяте начие информации в карточках
     *
     * @param duration      xpath Длительность обучения
     * @param courseAbout   xpath Описания курса
     * @param titleOfCourse xpath Названия курса
     */
    public void findInformationOfCard(String duration, String courseAbout, String titleOfCourse) {
        String textOfDuration = driver.findElement(By.xpath(duration)).getText();
        Assertions.assertNotNull(textOfDuration, "Длительность обучения равна null");
        String textOfCourseAbout = driver.findElement(By.xpath(courseAbout)).getText();
        Assertions.assertNotNull(textOfCourseAbout, "Описание обучения равно null");
        String textOfTitle = driver.findElement(By.xpath(titleOfCourse)).getText();
        Assertions.assertNotNull(textOfTitle, "Название равно null");
    }

}
