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
import pages.ProfilePage;

import java.time.Duration;

public class ProfilePageTest {
    private WebDriver driver;
    private ProfilePageTest profilePage;
    private static final String PROFILE_URL = "http://training.skillo-bg.com/users/4959";
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "\\Users\\PC\\.m2\\repository\\org\\seleniumhq\\selenium\\selenium-chrome-driver\\4.13.0\\selenium-chrome-driver-4.13.0.pom");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void testProfilePage() {
        driver.get("http://training.skillo-bg.com/users/4959");
        Assert.assertEquals(driver.getCurrentUrl(),"http://training.skillo-bg.com/users/4959");

        System.out.println("Verify that the button of profile page link is visible");
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageButtonVisible = profilePage.setProfilePageButton();
        Assert.assertTrue(isProfilePageButtonVisible,"Profile page link button is not visible");

        System.out.println("Verify that the Profile button is clickable");
        profilePage.setProfilePageButton();
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("a#nav-link-profile")));
        profileButton.click();

        System.out.println("Visible username title");
        profilePage = new ProfilePage(driver);
        profilePage.getUsernameTitle();
        boolean isUsernameTitleVisible = profilePage.setUsernameTitle();
        Assert.assertTrue(isUsernameTitleVisible, "Username title is not visible");

        System.out.println("Plus square button clickable");
        WebElement plusSquareButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-plus-square")));
        profilePage.clickPlusSquareButton();

        System.out.println("Verify the Edit profile pic is clickable");
        WebElement editProfilePic = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".edit-profile-pic")));
        editProfilePic.click();

    }
    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.close();
        }

    }

    }
