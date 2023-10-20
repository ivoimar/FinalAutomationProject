package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;

public class NavigationBarPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "nav-link-home")
    WebElement homeLink;

    @FindBy(id = "nav-link-profile")
    WebElement profileLink;

    @FindBy(id = "nav-link-login")
    WebElement loginLink;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    @FindBy(css = ".search-container")
    WebElement searchContainer;

    @FindBy(css = ".fa-search")
    WebElement searchLink;

    @FindBy(css = ".fa-sign-out-alt")
    WebElement signOutLink;

    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
    }
    public void setNewPostLink() {
        wait.until(ExpectedConditions.visibilityOf(newPostLink));

    }
    public void setSearchContainer(WebElement element) {
        wait.until((ExpectedConditions.elementToBeClickable(searchContainer)));

    }
    public void setSearchLink(){
        wait.until(ExpectedConditions.elementToBeClickable(searchContainer));
        searchContainer.click();
    }
    public void setSignOutLink(){
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        signOutLink.click();
    }
}
