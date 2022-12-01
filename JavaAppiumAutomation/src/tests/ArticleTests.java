package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testAssertTitle() //Ex6
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Lady Gaga");
        SearchPageObject.clickOnSearchResult("American singer, songwriter, and actress (born 1986)");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.titleElementAssert();
    }
}
