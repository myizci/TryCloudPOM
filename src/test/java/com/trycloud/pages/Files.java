package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Files {

    public Files() {
        PageFactory.initElements(Driver.getDriver(), this);

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

    @FindBy(xpath = "//*[@id='controls']/div[2]/a")
    public WebElement plusButton;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement addFileButton;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement addFolderButton;

    @FindBy(xpath = "//span[contains(.,'New folder')]")
    public WebElement newFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderInput;

    @FindBy(xpath = "//span[@class='innernametext']")
    public WebElement folderList;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderName;

    public static final String expectedDashboardTitle = "Dashboard - Trycloud QA";
    public static final String expectedFilesTitle = "Files - Trycloud QA";
    public  static final String expectedPhotosTitle = "Photos - Trycloud QA";
    public static final String expectedActivityTitle = "Activity - Trycloud QA";
    public static final String expectedCirclesTitle = "Circles - Trycloud QA";
    public static final String expectedTalkTitle = "Talk - Trycloud QA";
    public static final String expectedContactsTitle = "Contacts - Trycloud QA";

    public static final  String expectedCalendarTitle = " - Calendar - Trycloud QA";

    public static final String expectedDeckTitle = "Deck - Trycloud QA";
    public static final String expectedMailTitle = "Mail - Trycloud QA";


   // public static final String mainPageFilesAndFolders = "//span[@class='innernametext']";


    //US3-tc3,4

    public String actionIcon2Xpath = "(//span[@class='icon icon-more'])[2]";
    public String actionIcon1Xpath = "(//a[@class='action action-menu permanent'])[1]";
    public String addToFavoriteXpath = "//a[@class='menuitem action action-favorite permanent']";
    public String removeFromFavoriteXpath = "//span[.='Remove from favorites']";
    public String favoriteSubModuleXpath = "Favorites";
    public String fileAddedToFavoriteXpath = "(//tbody)[3]/tr";
    public String RemoveFromFavoriteXpath = "//span[.='Remove from favorites']";

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
