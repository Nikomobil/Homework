package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        // click on register link
        driver.findElement(By.cssSelector("[href='/register']")).click();
        // enter Male
        driver.findElement(By.id("gender-male")).click();
        // enter first name
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Mark");
        // enter last name
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Twain");
        // enter email
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("savy_s@gmail.com");
        // enter password
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("12523Sdf!");
        // confirm password
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("12523Sdf!");
        // register
        driver.findElement(By.id("register-button")).click();
        //continue
        driver.findElement(By.cssSelector(".button-1.register-continue-button")).click();
        // logout
        Assert.assertTrue(isElementpresent(By.className("ico-logout")));

    }
}
