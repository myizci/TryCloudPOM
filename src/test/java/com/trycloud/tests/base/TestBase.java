package com.trycloud.tests.base;

import com.trycloud.pages.Login;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Login login = new Login();
        String username = ConfigurationReader.getProperty("user1");
        login.usernameBox.sendKeys(username);
        String password = ConfigurationReader.getProperty("password");
        login.passwordBox.sendKeys(password);
        login.loginButton.click();
        // driver.get(ConfigurationReader.getProperty("url2"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(5);
          Driver.getDriver().close();
    }
}
