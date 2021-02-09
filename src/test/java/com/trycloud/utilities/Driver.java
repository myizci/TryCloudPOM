package com.trycloud.utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));


    private Driver(){
// the purpose of this private constructor is that we will create a driver object by mistake
        // we have to use the get() method below.
    }

    public static WebDriver getDriver(){

        return driver;
    }
}
