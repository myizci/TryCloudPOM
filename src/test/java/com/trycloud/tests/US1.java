package com.trycloud.tests;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.testng.annotations.Test;

public class US1 {

    @Test
    public void US1_TC1_verifyLogin() {
        LoginPage login = new LoginPage();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("user1");
        login.usernameBox.sendKeys(username);
        String password = ConfigurationReader.getProperty("password");
        login.passwordBox.sendKeys(password);
        login.loginButton.click();
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(FilesPage.expectedDashboardTitle));
    }
}
