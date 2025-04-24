package com.webshop.tests;

import com.webshop.data.ContactData;
import com.webshop.data.UserData;
import com.webshop.models.User;
import com.webshop.models.UserLog;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    @DataProvider
    public Iterator <Object[]> validRegistrationFromDataProvider() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"gender - male", "FirstName", "LastName", "Email@gmail.net",
                "12523Sdf!"});
        list.add(new Object[]{"gender - female", "FirstName1", "LastName1", "Email1@gmail.net",
                "12523Sdf!"});
        list.add(new Object[]{"gender - female", "FirstName2", "LastNam2e", "Email2@gmail.net",
                "12523Sdf!"});

        return list.iterator();

    }
    @Test(dataProvider = "validRegistrationFromDataProvider")
    public void newRegistrationPositiveFromDataProviderTest(String gender,
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
