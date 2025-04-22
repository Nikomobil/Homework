package com.webshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementpresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isErrorDisplayed() {
        boolean error = driver.findElement(By.xpath("//li[.='The specified email already exists']")).isDisplayed();
        if (error) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUnsuccessfullLogin() {
        boolean error = driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).isDisplayed();
        if (error) {
            return true;
        } else {
            return false;
        }
    }
}
