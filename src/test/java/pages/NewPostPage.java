package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPostPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "choose-file")
        WebElement chooseFile;

    @FindBy(css = ".uploadfilecontainer")
    WebElement postPicture;

    @FindBy(css = ".span.custom-control-input[formcontrolname=\"postStatus\"]")
    WebElement customSwitch;

    @FindBy(id = ".create-post")
    WebElement submitBtn;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void setChooseFile(){
        wait.until(ExpectedConditions.elementToBeClickable(chooseFile));
        chooseFile.click();
    }
    public void setPostPicture(){
        wait.until(ExpectedConditions.visibilityOf(postPicture));
        postPicture.isDisplayed();
    }
    public void setCustomSwitch(){
        wait.until(ExpectedConditions.elementToBeClickable(customSwitch));
        customSwitch.click();
    }
    public void setSubmitBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }

    public boolean setNewPostLink() {
        return false;
    }
}
