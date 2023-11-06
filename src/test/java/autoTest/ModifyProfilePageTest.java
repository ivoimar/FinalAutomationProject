package autoTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.ModifyProfilePage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class ModifyProfilePageTest {

    private WebDriver driver;
    private ModifyProfilePage modifyProfilePage;
    private static final String HOME_URL = "http://training.skillo-bg.com/posts/all";
    private static final String PROFILE_URL = HOME_URL + "/users/4959";
    private static final String USERNAME = "imarinov84@yahoo.com";
    private static final String PASSWORD = "imar8899";

    public ModifyProfilePageTest() {

    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PROFILE_URL);

        modifyProfilePage = new ModifyProfilePage(driver);
        PageFactory.initElements(driver, modifyProfilePage);
    }

    @Test
    public void testModifyProfile() {

        System.out.println("Opening profile URL: " + PROFILE_URL);
        driver.get(PROFILE_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='username']")));


        System.out.println("Populate form control name field with 'ivaylo'");
        WebElement formControlName = driver.findElement(By.cssSelector("input[formcontrolname='username']"));
        modifyProfilePage.editUsername("ivaylo");

        System.out.println("Populate form control email field 'imarinov84@yahoo.com'");
        modifyProfilePage.editEmail("imarinov84@yahoo.com");

        System.out.println("Populate form control password field 'imar8899'");
        modifyProfilePage.setFormControlPass("imar8899");

        System.out.println("Populate form control confirm password field with 'imar8899'");
        modifyProfilePage.setFormConfirmPass("imar8899");

        System.out.println("Populate form control public info field");
        WebElement formPublicInfo = driver.findElement(By.cssSelector("input[formcontrolname='publicInfo']"));
        formPublicInfo.sendKeys();

        System.out.println("Press the Save button");
        modifyProfilePage.clickSaveBtn();


    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
