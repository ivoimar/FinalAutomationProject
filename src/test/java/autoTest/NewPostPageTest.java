package autoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NewPostPage;

import java.time.Duration;

public class NewPostPageTest {

    private WebDriver driver;
    private NewPostPage newPostPage;
    private static final String NEWPOST_URL = "http://training.skillo-bg.com/posts/create";
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "WebDriverManager.chromedriver().setup();");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        newPostPage = new NewPostPage(driver);
    }

    @Test
    public void testNewPostPage() {
        driver.get("http://training.skillo-bg.com/posts/create");
        Assert.assertEquals(driver.getCurrentUrl(), "http://training.skillo-bg.com/posts/create");

        System.out.println("Verify that the button New post link is visible");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.setNewPostLink();
        boolean isNewPostLinkVisible = newPostPage.setNewPostLink();
        Assert.assertTrue(isNewPostLinkVisible, "New post link is not visible");

        System.out.println("Verify that New post link is clickable");
        newPostPage.setNewPostLink();
        WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("nav-link-new-post")));
        searchLink.click();

        System.out.println("Verify that Browse button is clickable");
        newPostPage.setChooseFile();
        WebElement chooseFile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("choose-file")));
        chooseFile.click();

        System.out.println("Verify that drag and drop upload file container is clickable");
        newPostPage.setPostPicture();
        WebElement postPicture = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".uploadfilecontainer")));
        postPicture.click();

        System.out.println("Verify that custom switch button is clickable");
        newPostPage.setCustomSwitch();
        WebElement customSwitch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".span.custom-control-input[formcontrolname=\"postStatus\"]")));
        customSwitch.click();

        System.out.println("Verify that create post submit button is clickable");
        newPostPage.setSubmitBtn();
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(".create-post")));
        submitButton.click();
    }
    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.close();
        }

    }

}

