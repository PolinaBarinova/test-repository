package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    @Test
    public void testSavingTwoArticles() //Ex5
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Lady Gaga");
        SearchPageObject.clickOnSearchResult("American singer, songwriter, and actress (born 1986)");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String name_of_folder = "New reading list";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Coffee");
        SearchPageObject.clickOnSearchResult("Brewed beverage made from seeds of Coffea genus");
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addNewArticleToMyList();
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openCreateList();
        MyListsPageObject.swipeByArticleToDelete("brewed beverage made from seeds of Coffea genus");
        MyListsPageObject.articleStayInList("American singer, songwriter, and actress (born 1986)");
        MyListsPageObject.clickOnArticleInList("American singer, songwriter, and actress (born 1986)");
        String article_title = ArticlePageObject.getArticleTitle();
        assertEquals(
                "We see title",
                "Lady Gaga   ",
                article_title
        );
    }
}
