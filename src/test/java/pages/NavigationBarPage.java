package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);

    }
    public boolean goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        loginLink.click();
        return isLoggedIn();

    }

    private boolean isLoggedIn() {
        return true;
    }

    public void setNewPostLink() {
        wait.until(ExpectedConditions.visibilityOf(newPostLink));

    }
    public void setSearchContainer(WebElement element) {
        wait.until((ExpectedConditions.elementToBeClickable(searchContainer)));
        searchContainer.click();

    }
    public void setSearchLink(){
        wait.until(ExpectedConditions.elementToBeClickable(searchLink));
        searchLink.click();
    }
    public void setSignOutLink(){
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink));
        signOutLink.click();
    }

    public Boolean isNewPostLinkVisible() {
        return null;
    }
}
