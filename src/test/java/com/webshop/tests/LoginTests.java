package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "savy_s@gmail.com");
        type(By.id("Password"), "12523Sdf!");
        click(By.id("RememberMe"));
        click(By.cssSelector(".button-1.login-button"));
        // logout
        Assert.assertTrue(isElementpresent(By.className("ico-logout")));

    }

}
