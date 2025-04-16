package com.webshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    public boolean isUnsuccessfullLogin() {
        boolean error = driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).isDisplayed();
        if (error) {
            return true;
        } else {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
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

    public boolean isLogout() {
        return isElementpresent(By.className("ico-logout"));
    }


    public void fillRegisterForm(User user) {
        click(By.id(user.getGender()));
        // enter first name
        type(By.id("FirstName"), user.getFirstName());
        // enter last name
        type(By.id("LastName"), user.getLastName());
        // enter email
        type(By.name("Email"), user.getEmail());
        // enter password
        type(By.id("Password"), user.getPassword());
        // confirm password
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickRegisterButton() {
        click(By.id("register-button"));
    }

    public void clickContinueButton() {
        click(By.cssSelector(".button-1.register-continue-button"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void fillLoginData(UserLog userLog) {
        type(By.id("Email"), userLog.getEmail());
        type(By.id("Password"), userLog.getPassword());
    }

    public void clickLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickRemember() {
        click(By.id("RememberMe"));
    }

    public void clickLoginlink() {
        click(By.cssSelector("[href='/login']"));
    }
}
