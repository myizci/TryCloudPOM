package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 extends TestBase {

    // Test case 1 is already asserted in US2


    @Test
    public void US3_TC2() {
        FilesPage filesPage = new FilesPage();

        filesPage.files.click();
        filesPage.checkAllcheckbox.click();

        for (WebElement each : filesPage.checkedFilesAndFolders) {
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

        Assert.assertTrue(flag);//TC5 is asserted________________________

        // using the index, clicking on action button
        for (int i = 0; i < files.actionButtonsList.size(); i++) {
            if (i == index) {
                files.actionButtonsList.get(i).click();
                files.addToFavorite.click();// adding to favorites
            }
        }

        files.favorites.click(); // moving to favorites page
        BrowserUtils.sleep(2);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(2);
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
        for (WebElement each : files.favoriteList) {
            System.out.println(each.getText());
            if (each.getText().contains("XPath+Cheat+Sheet")) {

                flag = true;
                break;
            }
        }

        Assert.assertFalse(flag);

    }

    @Test
    public void US3_TC6_TC7() {

        FilesPage filesPage = new FilesPage();
        filesPage.files.click();
        filesPage.plusButton.click();
        filesPage.newFolder.click();
        Faker faker = new Faker();
        String name = faker.name().firstName();
        filesPage.newFolderName.sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);

        boolean flag=false;
        for(WebElement each: filesPage.filesAndFoldersList){
            if(each.getText().equals(name)){
                each.click();
                flag=true;
            }

        }

        Assert.assertTrue(flag);



        String path = "/Users/guestaccount/Desktop/XPath+Cheat+Sheet.pdf";

        filesPage.uploadfile(path); // calling the upload method, it is for MAC
        BrowserUtils.sleep(5);
        Driver.getDriver().navigate().refresh(); // refreshing the page to make sure that it is visible

        BrowserUtils.sleep(2);
        boolean flag2 = false;
        int index = 0; // verifying the new file  TC5_____________________
        for (int i = 0; i < filesPage.filesAndFoldersList.size(); i++) {

            if (filesPage.filesAndFoldersList.get(i).getText().contains("XPath+Cheat+Sheet")) {
                index = i;
                flag2 = true;
                break;
            }
        }

        Assert.assertTrue(flag);//TC5 is asserted________________________
    }


    @Test
    public void US3_TC8() {
        FilesPage filesPage = new FilesPage();
        filesPage.files.click();
        filesPage.plusButton.click();
        filesPage.newFolder.click();
        Faker faker = new Faker();
        String name = faker.name().firstName();
        filesPage.newFolderName.sendKeys(name + Keys.ENTER);
        BrowserUtils.sleep(1);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1);


        for(WebElement each: filesPage.filesAndFoldersList){
            if(each.getText().equals(name)){
                Driver.getDriver().findElement(By.xpath("//tr[@data-file='"+name+"']/td/label")).click();

            }

        }
boolean flag=false;
        filesPage.selectedActionsList.click(); // clicks on icon ...Actions
        filesPage.deleteInActions.click();
        BrowserUtils.sleep(2);
        filesPage.trashBin.click();
        BrowserUtils.sleep(1);
        filesPage.sortButton.click();// we have to click on sort to make all the elements visible
        BrowserUtils.sleep(1);
        filesPage.sortButton.click();
        BrowserUtils.sleep(1);



             for(WebElement each: filesPage.filesAndFoldersList2){

            System.out.println(each.getText());
            if(each.getText().contains(name)){
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }
}
