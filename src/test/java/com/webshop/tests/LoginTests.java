package com.webshop.tests;

import com.webshop.data.UserData;
import com.webshop.models.UserLog;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.getUser().isRegisterPresent()) {
            app.getUser().clickLoginlink();

        }
    }

    ;;

    @Test
    public void loginPositiveTest() {
        app.getUser().clickLoginlink();
        app.getUser().fillLoginData(new UserLog().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickRemember();
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isLogout());
        app.getUser().clickLogOutButton();

    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickLoginlink();
        app.getUser().fillLoginData(new UserLog().setPassword(UserData.PASSWORD));
        app.getUser().clickRemember();
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isUnsuccessfullLogin());

    }




}

