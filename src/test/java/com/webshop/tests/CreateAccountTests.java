package com.webshop.tests;

import com.webshop.data.ContactData;
import com.webshop.data.UserData;
import com.webshop.models.User;
import com.webshop.models.UserLog;
import com.webshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.getUser().isRegisterPresent()) {
            app.getUser().clickOnRegisterLink();

        }
        ;

    }

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegisterForm(new User()
                .setGender(ContactData.Gender)
                .setFirstName(ContactData.FirstName)
                .setLastName(ContactData.LastName)
                .setEmail(ContactData.Email)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickRegisterButton();
        app.getUser().clickContinueButton();
        Assert.assertTrue(app.getUser().isLogout());

    }



    @Test(dataProvider = "validRegistrationFromDataProviderCsvFile",dataProviderClass = DataProviders.class)
    public void newRegistrationPositiveFromDataProviderTest(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickRegisterButton();
        app.getUser().clickContinueButton();
        Assert.assertTrue(app.getUser().isLogout());

    }
    @Test(dataProvider = "validRegistrationFromDataProvider", dataProviderClass = DataProviders.class)
    public void newRegistrPositiveFromDataProviderCsvFileTest(String gender,
                                                            String firstName,
                                                            String lastName,
                                                            String email,
                                                            String password) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setGender(gender)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getUser().clickRegisterButton();
        app.getUser().clickContinueButton();
        Assert.assertTrue(app.getUser().isLogout());
        app.getUser().clickLogOutButton();

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setGender(ContactData.Gender)
                .setFirstName(ContactData.FirstName)
                .setLastName(ContactData.LastName)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickRegisterButton();
        softAssert.assertTrue(app.getUser().isErrorDisplayed());
        softAssert.assertTrue(app.getUser().isEmailExists());

    }


}
