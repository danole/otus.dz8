package com.otus.webDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    public WebDriver driver;

    public WebDriver create(String webDriverName, String options) {

        if (webDriverName.equals(Browsers.CHROME.toString().toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            if (options.equals("")) {
                driver = new ChromeDriver();
            } else {
                ChromeOptions option = new ChromeOptions();
                option.addArguments(options);
                driver = new ChromeDriver(option);
            }
        } else if (webDriverName.equals(Browsers.OPERA.toString().toLowerCase())) {
            WebDriverManager.operadriver().setup();
            if (options.equals("")) {
                driver = new OperaDriver();
            } else {
                OperaOptions option = new OperaOptions();
                option.addArguments(options);
                driver = new OperaDriver(option);
            }
        } else if (webDriverName.equals(Browsers.FIREFOX.toString().toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            if (options.equals("")) {
                driver = new FirefoxDriver();
            } else {
                FirefoxOptions option = new FirefoxOptions();
                option.addArguments(options);
                driver = new FirefoxDriver(option);
            }
        } else {
            System.out.println("Такого браузера нет");
        }

        return driver;
    }


}
