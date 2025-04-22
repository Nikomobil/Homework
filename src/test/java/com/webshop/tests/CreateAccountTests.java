package com.webshop.tests;

import com.webshop.models.User;
import com.webshop.models.UserLog;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if(!app.getUser().isRegisterPresent()){
            app.getUser().clickOnRegisterLink();

        };

    }

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegisterLink();
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getUser().fillRegisterForm(new User().setGender("gender-male").setFirstName("Mark").setLastName("Twain")
                .setEmail("test" + i + "@test.com").setPassword("12523Sdf!"));
        app.getUser().clickRegisterButton();
        app.getUser().clickContinueButton();
        Assert.assertTrue(app.getUser().isLogout());

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User().setGender("gender-male").setFirstName("Mark").setLastName("Twain")
                .setEmail("savy_s@gmail.com").setPassword("12523Sdf!"));
        app.getUser().clickRegisterButton();
        softAssert.assertTrue(app.getUser().isErrorDisplayed());
        softAssert.assertTrue(app.getUser().isEmailExists());

    }


}
