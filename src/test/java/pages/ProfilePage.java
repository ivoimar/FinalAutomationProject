package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameTitle;

    @FindBy(css = ".fa-plus-square")
    WebElement plusSquareButton;

    @FindBy(css = ".edit-profile-pic")
    WebElement editProfilePic;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        ProfilePage profilePage = new ProfilePage(driver);
    }

    public String getUsernameTitle() {
        wait.until(ExpectedConditions.visibilityOf(usernameTitle));
        return usernameTitle.getText();
    }

    public void clickPlusSquareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusSquareButton));
        plusSquareButton.click();
    }

    public void setEditProfilePic() {
        wait.until(ExpectedConditions.elementToBeClickable(editProfilePic));
        editProfilePic.click();
    }

    public boolean setProfilePageButton() {
        return false;
    }

    public boolean setUsernameTitle() {
        return false;
    }

}