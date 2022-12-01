package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testElementHasText() //Ex2
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.elementHasText();
    }
    @Test
    public void testCancelSearch() //Ex3
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Lady Gaga");
        SearchPageObject.listOfSearchResults();
        SearchPageObject.cancelSearch();
    }
    @Test
    public void testSearchWordCheck() //Ex4
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JAVA");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitleInList();
        assertEquals(
                "We see unexpected title",
                "JAVA",
                article_title
        );
    }
}
