package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilesPage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }

    public void uploadfile(String path) {
        FilesPage files = new FilesPage();
        files.plusButton.click();
        files.addFileButton.click();
        BrowserUtils.sleep(1);
        File file = new File(path);

        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

//Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

// Cmd + Tab is needed since it launches a Java app and the browser looses focus

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_TAB);

        robot.delay(1000);

//Open Goto window

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_G);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_META);

        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1000);


    }

    List<WebElement> modules = new ArrayList<>(Arrays.asList());

    @FindBy(xpath = "(//a[@href='/index.php/apps/files/'])[1]")
    public WebElement files;

    @FindBy(xpath = "(//a[@href='/index.php/apps/photos/'])[1]")
    public WebElement photos;

    @FindBy(xpath = "(//a[@href='/index.php/apps/activity/'])[1]")
    public WebElement activity;

    @FindBy(xpath = "(//a[@href='http://qa.trycloud.net/index.php/apps/spreed/'])[1]")
    public WebElement talk;

    @FindBy(xpath = "(//a[@href='/index.php/apps/mail/'])[1]")
    public WebElement mail;

    @FindBy(xpath = "(//li[@data-id='circles'])/a")
    public WebElement circles;

    @FindBy(xpath = "(//a[@href='/index.php/apps/contacts/'])[1]")
    public WebElement contacts;

    @FindBy(xpath = "(//a[@href='/index.php/apps/calendar/'])[1]")
    public WebElement calendar;

    @FindBy(xpath = "//div[@class='datepicker-button-section']//button[2]")
    public WebElement calendarDatePickButton;

    @FindBy(xpath = "(//a[@href='/index.php/apps/deck/'])[1]")
    public WebElement deck;


    @FindBy(xpath = "//input[@class='selectCheckBox checkbox']")
    public List<WebElement> checkedFilesAndFolders;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement checkAllcheckbox;

    @FindBy(xpath = "//*[@id='controls']/div[2]/a")
    public WebElement plusButton;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement addFileButton;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement addFolderButton;

    @FindBy(xpath = "//span[contains(.,'New folder')]")
    public WebElement newFolder;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> filesAndFoldersList;

    @FindBy(xpath = "//input[contains(@id,'input-folder')]")
    public WebElement newFolderName;

    public static final String expectedDashboardTitle = "Dashboard - Trycloud QA";
    public static final String expectedFilesTitle = "Files - Trycloud QA";
    public static final String expectedPhotosTitle = "Photos - Trycloud QA";
    public static final String expectedActivityTitle = "Activity - Trycloud QA";
    public static final String expectedCirclesTitle = "Circles - Trycloud QA";
    public static final String expectedTalkTitle = "Talk - Trycloud QA";
    public static final String expectedContactsTitle = "Contacts - Trycloud QA";
    public static final String expectedCalendarTitle = " - Calendar - Trycloud QA";
    public static final String expectedDeckTitle = "Deck - Trycloud QA";
    public static final String expectedMailTitle = "Mail - Trycloud QA";


    // public static final String mainPageFilesAndFolders = "//span[@class='innernametext']";


    //US3-tc3,4

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionButtonsList;

    @FindBy(xpath = "//span[.='Add to favorites']")
    public WebElement addToFavorite;

    @FindBy(xpath = "//a[.='Favorites']")
    public WebElement favorites;

    @FindBy(xpath ="//td[@class='filename']/a/span/span[1]")
    public List<WebElement> favoriteList;

    @FindBy(xpath = "(//tr[contains(@data-file,'XPath+Cheat+Sheet')])")
    public WebElement favoriteFileName;
    // change the name of this file according to you file

    @FindBy(xpath = "(//tr[contains(@data-file,'XPath+Cheat+Sheet')])[2]/td/a/span[2]/a[2]")
    public WebElement favoriteFileMore;

    @FindBy(xpath = "//span[.='Remove from favorites']")
    public WebElement removeFromFavorites;



    // US7
    // magnifierIcon
    public String magnifierCssSelectorIcon = "svg.material-design-icon__svg";
    // search field:  input.unified-search__form-input
    public String inputSearchFormCssSelector = "input.unified-search__form-input";
    // found search items list:
    public String foundSearchItemsListCssSelector = "div.header-menu__content";


    //US3_7
    public String actionIconXpath = "(//a[@class='action action-menu permanent'])[2]";
    public String detailsXpath = "//span[.='Details']";
    public String commentFolderXpath = "//a[@id='commentsTabView']";
    public String commentBoxXpath = "(//div[@contenteditable='true'])[2]";
    public String submitButtonXpath = "//input[@class='submit icon-confirm has-tooltip']";
    public String folderAndFilesXpath = "//span[@class='innernametext']";


}
