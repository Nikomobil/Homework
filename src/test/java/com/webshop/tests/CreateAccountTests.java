package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        clickOnRegisterLink();
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        fillRegisterForm(new User().setGender("gender-male").setFirstName("Mark").setLastName("Twain")
                .setEmail("test" + i + "@test.com").setPassword("12523Sdf!"));
        clickRegisterButton();
        clickContinueButton();
        Assert.assertTrue(isLogout());

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnRegisterLink();
        fillRegisterForm(new User().setGender("gender-male").setFirstName("Mark").setLastName("Twain")
                .setEmail("savy_s@gmail.com").setPassword("12523Sdf!"));
        clickRegisterButton();
        Assert.assertTrue(isErrorDisplayed());

    }


}
