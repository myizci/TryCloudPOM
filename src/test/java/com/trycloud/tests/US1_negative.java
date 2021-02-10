package com.trycloud.tests;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1_negative {
    @Test
    public void US1_TC2_negative_login(){

        LoginPage login = new LoginPage();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("wrongUser");
        login.usernameBox.sendKeys(username);
        String password = ConfigurationReader.getProperty("wrongPassword");
        login.passwordBox.sendKeys(password);
        login.loginButton.click();

        String actualErrorMessage = login.wrongLoginMessage.getText();
        String expectedErrorMessage = "Wrong username or password.";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }





}
