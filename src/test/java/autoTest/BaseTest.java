package autoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    public static final String SCREENSHOT_DIR = "screenshots";
    public static final String REPORTS_DIR = "src\\test\\java\\resources\\reports\\";
    @BeforeMethod
    public void setup() throws IOException {
        cleanDirectory(SCREENSHOT_DIR);
        cleanDirectory(REPORTS_DIR);
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3).toMillis(), TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5).toMillis(), TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    public void cleanDirectory(String filepath) throws IOException {
        File directory = new File(filepath);
        FileUtils.cleanDirectory(directory);
    }

    public void takeScreeshot(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName();
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOT_DIR.concat(testName).concat(".jpeg")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @AfterMethod
    public void cleanup(ITestResult testResult) {
        takeScreeshot(testResult);
        driver.close();
    }
}
