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
import pages.NavigationBarPage;

import java.time.Duration;

public class NavigationbarPageTest {

    private WebDriver driver;
    public NavigationBarPage navigationBarPage;
    private String PROFILE_URl;
    private static final String PROFILE_URL = "http://training.skillo-bg.com/users/4959";
    private static final String USERNAME = "imarinov84@yahoo.com";
    private static final String PASSWORD = "imar8899";
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "WebDriverManager.chromedriver().setup();");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        navigationBarPage = new NavigationBarPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testNavigationLinks() {

        driver.get("http://training.skillo-bg.com/posts/all");
        Assert.assertEquals(driver.getCurrentUrl(), "http://training.skillo-bg.com/posts/all");

        System.out.println("Successfully logged in");
        navigationBarPage.goToLogin();
        boolean isLoginSuccess = navigationBarPage.goToLogin();
        Assert.assertTrue(navigationBarPage.goToLogin());


        System.out.println("Verify that the button New post link is visible");
        navigationBarPage.setNewPostLink();
        boolean isNewPostLinkVisible = navigationBarPage.isNewPostLinkVisible();
        Assert.assertTrue(isNewPostLinkVisible, "New post link is not visible");

        System.out.println("Verify that tha search container is clickable");
        WebElement searchContainer = driver.findElement(By.cssSelector(".search-container"));

        System.out.println("Verify that the search link is clickable");
        navigationBarPage.setSearchLink();
        WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-search")));
        searchLink.click();

        System.out.println("Verify that the sign out button is clickable");
        navigationBarPage.setSignOutLink();
        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-sign-out-alt")));
        signOutButton.click();




    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}

