package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
    SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
    SEARCH_INPUT = "org.wikipedia:id/search_src_text",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
    LIST_SEARCH_RESULT = "org.wikipedia:id/view_list_card_list",
    SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
    SEARCH_EMPTY_INPUT = "org.wikipedia:id/search_empty_message",
    TEXT_SEARCH_INPUT = "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /*TEMPLATES METHODS*/

    public void initSearchInput()
    {
        this.waitForElementPresent(By.id(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring, 5);
    }
    public void listOfSearchResults()
    {
        this.waitForElementPresent(By.id(LIST_SEARCH_RESULT), "Cannot find article list", 10);
    }
    public void cancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find X to cancel search", 5);
        this.waitForElementPresent(By.id(SEARCH_EMPTY_INPUT), "Cannot find empty message", 5);
    }
    public void clickOnSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring, 10);
    }
    public void elementHasText()
    {
        this.assertElementHasText( TEXT_SEARCH_INPUT, "Cannot find 'Search Wikipedia'", 5);
    }
}
