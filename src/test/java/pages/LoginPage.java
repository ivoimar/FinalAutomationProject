package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;

public class LoginPage {

        private WebDriver driver;
        private WebDriverWait wait;

        @FindBy(css = ".app-login form")
        private WebElement loginForm;

        @FindBy(id = "defaultLoginFormUsername")
        private WebElement usernameField;

        @FindBy(id = "defaultLoginFormPassword")
        private WebElement passwordField;

        @FindBy(id = "sign-in-button")
        private WebElement signinBtn;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        }

        public void populateUserName(String username) {

            wait.until(ExpectedConditions.visibilityOf(usernameField));
            usernameField.sendKeys(username);
        }

        public void populatePassword(String password) {
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            passwordField.sendKeys(password);

         }
         public void setSigninBtn(WebElement element) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            signinBtn.click();
         }

         public void clickElement(WebElement element){
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        public void clickLoginButton(){
            WebElement logninButton;
            wait.until(ExpectedConditions.elementToBeClickable(logninButton));
            logninButton.click();

    }

        public void verifyLoginFormVisible() {
            wait.until(ExpectedConditions.visibilityOf(loginForm));
            loginForm.isDisplayed();
    }
}
