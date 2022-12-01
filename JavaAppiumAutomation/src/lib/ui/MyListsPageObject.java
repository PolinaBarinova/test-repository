package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    private static final String
    NEW_LIST = "//android.widget.FrameLayout[@resource-id='org.wikipedia:id/item_container']",
    DESCRIPTION_OF_ARTICLE_TPL = "//android.widget.TextView[@text='{DESCRIPTION}']";

    private static String getSavedArticleXpathByDescription(String article_description)
    {
        return DESCRIPTION_OF_ARTICLE_TPL.replace("{DESCRIPTION}", article_description);
    }
    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void openCreateList()
    {
        this.waitForElementAndClick(
                    By.xpath(NEW_LIST), "Cannot find created folder", 5);
    }
    public void swipeByArticleToDelete(String article_description)
    {
        String description_xpath = getSavedArticleXpathByDescription(article_description);
        this.swipeElementToLeft(
                By.xpath(description_xpath), "Cannot find saved article");
    }
    public void articleStayInList(String article_description)
    {
        String description_xpath = getSavedArticleXpathByDescription(article_description);
        this.waitForElementPresent(
                By.xpath(description_xpath), "Cannot find article", 5);
    }
    public void clickOnArticleInList(String article_description)
    {
        String descriotion_xpath = getSavedArticleXpathByDescription(article_description);
        this.waitForElementAndClick(
                By.xpath(descriotion_xpath), "Cannot find article", 5);
    }

}
