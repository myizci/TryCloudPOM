package com.trycloud.tests;

import com.trycloud.pages.FilesPage;
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
        FilesPage files = new FilesPage();

        files.files.click();
        files.checkAllcheckbox.click();

        for (WebElement each : files.checkedFilesAndFolders) {
            Assert.assertTrue(each.isSelected());
        }

    }


    @Test
    public void Us3_TC5_TC3() {
        FilesPage files = new FilesPage();
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


    @Test
    public void US3_TC4() {

        // This test  depends on the previous test
        // The XPath+Cheat+Sheet.pdf should be loaded.
        // The same file will be removed
        FilesPage files = new FilesPage();
        files.files.click();
        files.favorites.click(); // moving to favorites page

        files.favoriteFileMore.click();
        files.removeFromFavorites.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);
        boolean flag = false;
        for (WebElement each: files.favoriteList) {
            System.out.println(each.getText());
            if (each.getText().contains("XPath+Cheat+Sheet")) {

                flag = true;
                break;
            }
        }

        Assert.assertFalse(flag);

    }
}
