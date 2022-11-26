import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/alex/Desktop/Polina/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void secondTest() //Ex2
    {
      assertElementHasText(
               "//*[@resource-id='org.wikipedia:id/search_container']//*[@text='Search Wikipedia']",
               "Cannot find 'Search Wikipedia'",
               5
      );
    }
    private WebElement assertElementHasText(String xpath, String error_message, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    @Test
    public void thirdTest() //Ex3
    {
        waitForElementPresent(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_container"),
                "Lady Gaga",
                "Cannot find search input",
                5
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_list_card_list"),
                "Cannot find list card",
                15
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                5
        );
//        waitForElementNotPresent(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "X is still present on the page",
//                5
//        );
        waitForElementPresent(
                By.id("org.wikipedia:id/search_empty_message"),
                "Cannot find empty message",
                5

        );
    }
    @Test
    public void fourthTest() //Ex4
    {
        waitForElementPresent(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_container"),
                "JAVA",
                "Cannot find search input",
                5
        );
        WebElement title_element = waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find item title",
                15
        );
        String article_title = title_element.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "JAVA",
                article_title
        );
    }

    @Test
    public void fifthTest() //Ex5
    {
        waitForElementPresent(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_container"),
                "Lady Gaga",
                "Cannot find search input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='American singer, songwriter, and actress (born 1986)']"),
                "Cannot find description",
                10
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"),
                "Cannot find option to add article to reading list",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                5
        );
        String name_of_folder = "New reading list";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_container"),
                "Coffee",
                "Cannot find search input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Brewed beverage made from seeds of Coffea genus']"),
                "Cannot find description",
                10
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"),
                "Cannot find option to add article to reading list",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/list_of_lists"),
                "Cannot find reading list",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My list",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@resource-id='org.wikipedia:id/item_container']"),
                "Cannot find created folder",
                5
        );
        swipeElementToLeft(
                By.xpath("//android.widget.TextView[@text='brewed beverage made from seeds of Coffea genus']"),
                "Cannot find saved article"
        );
        waitForElementPresent(
                By.xpath("//android.widget.TextView[@text='American singer, songwriter, and actress (born 1986)']"),
                "Cannot find article",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='American singer, songwriter, and actress (born 1986)']"),
                "Cannot find article",
                5
        );
        WebElement title_element = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find title",
                15
        );
        String article_title = title_element.getAttribute("text");
        Assert.assertEquals(
                "We see title",
                "Lady Gaga   ",
                article_title
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, 5);
        element.click();
        return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    }
    private boolean waitForElementNotPresent(By by, String error_massege,long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_massege + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }
    protected void swipeUpQuick()
    {
        swipeUp(200);
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle_y)
                .waitAction(300)
                .moveTo(left_x,middle_y)
                .release()
                .perform();
    }


}
