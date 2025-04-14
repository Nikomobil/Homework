package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        // click on register link
        click(By.cssSelector("[href='/register']"));
        // enter Male
        click(By.id("gender-male"));
        // enter first name
        type(By.id("FirstName"), "Mark");
        // enter last name
        type(By.id("LastName"), "Twain");
        // enter email
        type(By.name("Email"), "test" +i+"@test.com");
        // enter password
        type(By.id("Password"), "12523Sdf!");
        // confirm password
        type(By.id("ConfirmPassword"), "12523Sdf!");
        // register
        click(By.id("register-button"));
        //continue
        click(By.cssSelector(".button-1.register-continue-button"));
        // logout
        Assert.assertTrue(isElementpresent(By.className("ico-logout")));

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        // click on register link
        click(By.cssSelector("[href='/register']"));
        // enter Male
        click(By.id("gender-male"));
        // enter first name
        type(By.id("FirstName"), "Mark");
        // enter last name
        type(By.id("LastName"), "Twain");
        // enter email
        type(By.name("Email"), "savy_s@gmail.com");
        // enter password
        type(By.id("Password"), "12523Sdf!");
        // confirm password
        type(By.id("ConfirmPassword"), "12523Sdf!");
        // register
        click(By.id("register-button"));
        // logout
        Assert.assertTrue(isErrorDisplayed());

   }


}
