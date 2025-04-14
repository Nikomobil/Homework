package com.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
    public boolean isElementpresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isErrorDisplayed() {
        boolean error =driver.findElement(By.xpath("//li[.='The specified email already exists']")).isDisplayed();
        if (error) {
            return true;
        }else {
            return false;
        }
    }
}
