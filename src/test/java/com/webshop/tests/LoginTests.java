package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickLoginlink();
        fillLoginData(new UserLog().setEmail("savy_s@gmail.com").setPassword( "12523Sdf!"));
        clickRemember();
        clickLoginButton();
        Assert.assertTrue(isLogout());

    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickLoginlink();
        fillLoginData(new UserLog().setPassword("12523Sdf!"));
        clickRemember();
        clickLoginButton();
        Assert.assertTrue(isUnsuccessfullLogin());

    }

}
