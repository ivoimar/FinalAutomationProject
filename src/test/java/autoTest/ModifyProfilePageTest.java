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
import java.util.concurrent.TimeUnit;
public class ModifyProfilePageTest {

    private WebDriver driver;
    private ModifyProfilePage modifyProfilePage;
    private String PROFILE_URl;
    private static final String PROFILE_URL = "http://training.skillo-bg.com/users/4959";
    private static final String USERNAME = "imarinov84@yahoo.com";
    private static final String PASSWORD = "imar8899";

    public ModifyProfilePageTest(WebDriver driver) {

    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PROFILE_URl);
        modifyProfilePage = new ModifyProfilePage(driver);
        PageFactory.initElements(driver, modifyProfilePage);
    }

    @Test
    public void testModifyProfile() {
        driver.get(modifyProfilePage.PROFILE_URl);

        System.out.println("Populate form control name field with 'ivaylo'");
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
