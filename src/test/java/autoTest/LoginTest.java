package autoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;



public class LoginTest {

    @Test(groups = "loginTests")
    public void testLoginWithValidCredentials() {

    }

    private WebDriver driver;
    private static final String LOGIN_URL = "http://training.skillo-bg.com/posts/all";
    private static final String USERNAME = "imarinov84@yahoo.com";
    private static final String PASSWORD = "imar8899";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = "loginTests")
    public void testLogin() {
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        Assert.assertTrue(isLoggedIn(), "Login was not successful.");

        System.out.println(" Verify that the login form has appeared");
        loginPage.verifyLoginFormVisible();
        Assert.assertTrue(loginPage.verifyLoginFormVisible(), "Login form is not visible.");


        System.out.println(" Click Sing in button");
        WebElement signInBtn = driver.findElement(By.id("sign-in-button"));
        signInBtn.click();

        System.out.println("Click on Home page link");
        WebElement homeLink = driver.findElement(By.id("nav-link-home"));
        homeLink.click();

        System.out.println("CLick on Profile link");
        WebElement profileLnik = driver.findElement(By.id("nav-link-profile"));
        profileLnik.click();

        System.out.println("Click on Plus Square Button");
        WebElement plusSquareButton = driver.findElement(By.id("plus-square-button"));
        plusSquareButton.click();

        System.out.println("Click on user edit button");
        WebElement userEditButton = driver.findElement(By.cssSelector(".fa-user-edit"));
        userEditButton.click();

        System.out.println("Verify that container edit button is visible");
        WebElement userEditForm = driver.findElement(By.cssSelector(".fa-user-edit"));
        Assert.assertTrue(userEditForm.isDisplayed());

        System.out.println("Populate form control name field with 'ivaylo'");
        WebElement formControlName = driver.findElement(By.cssSelector("input[formcontrolname='username']"));
        formControlName.getTagName();

        System.out.println("Populate form control name field 'imarinov84@yahoo.com'");
        WebElement formControlEmail = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
        formControlEmail.sendKeys();

        System.out.println("Populate form control name field 'imar8899'");
        WebElement formControlPass = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
        formControlPass.sendKeys();

        System.out.println("Populate form control name confirm password field with 'imar8899'");
        WebElement formConfirmPass = driver.findElement(By.cssSelector("input[formcontrolname='confirmPassword']"));
        formConfirmPass.sendKeys();

        System.out.println("Populate form control name field public info");
        WebElement formPublicInfo = driver.findElement(By.cssSelector("input[formcontrolname='publicInfo']"));
        formPublicInfo.sendKeys();

        System.out.println("Press the form control name Save button");
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn.btn-primary[type='submit']"));
        loginPage.clickSaveBtn();


    }

    private boolean isLoggedIn() {
        WebElement logoutButton = driver.findElement(By.id("logout-button")); // Примерен селектор за бутона за излизане от системата
        return logoutButton.isDisplayed();
    }

    @AfterClass
        public void close() {
            if (driver != null) {
                driver.close();
            }
        }
    }

