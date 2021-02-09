package com.trycloud.tests;

import com.trycloud.pages.Files;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2 extends TestBase {
    @Test
    public void US2_TC1() {

       Files files = new Files();

       files.files.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedFilesTitle));

        files.photos.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedPhotosTitle));

        files.activity.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedActivityTitle));

        files.talk.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(Files.expectedTalkTitle));

    }
}
