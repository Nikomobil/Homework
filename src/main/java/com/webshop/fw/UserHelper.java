package com.webshop.fw;

import com.webshop.models.User;
import com.webshop.models.UserLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void clickLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public boolean isEmailExists() {
        return isErrorDisplayed();
    }

    public void clickLoginlink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isLogout() {
        return isElementpresent(By.className("ico-logout"));
    }

    public void fillLoginData(UserLog userLog) {
        type(By.id("Email"), userLog.getEmail());
        type(By.id("Password"), userLog.getPassword());
    }

    public void clickRemember() {
        click(By.id("RememberMe"));
    }

    public boolean isHomeImgPresent() {
        return isElementpresent(By.xpath("(//h1[normalize-space()='Welcome, Please Sign In!'])[1]"));
    }


    public boolean isRegisterPresent() {
        return isElementpresent(By.cssSelector("div[class='page-title'] h1"));
    }

    public void clickLogOutButton() {
        click(By.className("ico-logout"));
    }
}
