package com.trycloud.tests;

import com.trycloud.pages.FilesPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US2 extends TestBase {
    @Test
    public void US2_TC1() {

        FilesPage files = new FilesPage();
        List<WebElement> modules = new ArrayList<>(Arrays.asList());
        modules.addAll(Arrays.asList(
                files.files,
                files.photos,
                files.activity,
                files.talk,
                files.mail,
                files.contacts,
                files.circles,
                files.deck
        ));

        List<String> titles = new ArrayList<>(Arrays.asList(
                FilesPage.expectedFilesTitle,
                FilesPage.expectedPhotosTitle,
                FilesPage.expectedActivityTitle,
                FilesPage.expectedTalkTitle,
                FilesPage.expectedMailTitle,
                FilesPage.expectedContactsTitle,
                FilesPage.expectedCirclesTitle,
                FilesPage.expectedDeckTitle
                ));

        for(int i=0; i<modules.size(); i++){
            modules.get(i).click();
            Assert.assertTrue(Driver.getDriver().getTitle().equals(titles.get(i)));
        }

        files.calendar.click();
        String currentDate = files.calendarDatePickButton.getText();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(currentDate +  FilesPage.expectedCalendarTitle));



//        files.files.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedFilesTitle));
//
//        files.photos.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedPhotosTitle));
//
//        files.activity.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedActivityTitle));
//
//        files.talk.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedTalkTitle));
//
//        files.mail.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedMailTitle));
//
//        files.contacts.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedContactsTitle));
//
//        files.circles.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedCirclesTitle));
//

//
//        files.deck.click();
//        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedDeckTitle));

    }
}
