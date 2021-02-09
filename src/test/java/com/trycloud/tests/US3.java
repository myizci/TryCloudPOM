package com.trycloud.tests;

import com.trycloud.pages.Files;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 extends TestBase {

    // Test case 1 is already asserted in US2


    @Test
    public void US3_TC2() {
        Files files = new Files();

        files.files.click();
        files.checkAllcheckbox.click();

        for (WebElement each : files.checkedFilesAndFolders) {
            Assert.assertTrue(each.isSelected());
        }

    }


    @Test
    public void Us3_TC5_TC3_TC4() {
        Files files = new Files();
        files.files.click();
// Make sure your file's path is entered below, also make sure it is not uploaded already
        String path = "/Users/guestaccount/Desktop/XPath+Cheat+Sheet.pdf";

        files.uploadfile(path); // calling the upload method, it is for MAC
        BrowserUtils.sleep(5);
        Driver.getDriver().navigate().refresh(); // refreshing the page to make sure that it is visible

        BrowserUtils.sleep(2);
        boolean flag = false;
        int index = 0; // verifying the new file  TC5_____________________
        for (int i = 0; i < files.filesAndFoldersList.size(); i++) {

            if (files.filesAndFoldersList.get(i).getText().contains("XPath+Cheat+Sheet")) {
                index = i;
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag);

        // using the index, clicking on action button
        for (int i = 0; i < files.actionButtonsList.size(); i++) {
            if (i == index) {
                files.actionButtonsList.get(i).click();
                files.addToFavorite.click();// adding to favorites
            }
        }

        files.favorites.click(); // moving to favorites page
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);
        Assert.assertTrue(files.favoriteFileName.isDisplayed()); //TC3 is asserted___________________



    }
}
