package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModifyProfilePage {
    public final String HOME_URL = "http://training.skillo-bg.com/posts/all";
    public final String PROFILE_URL = HOME_URL + "/users/4959";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".fa-user-edit")
    private WebElement userEditButton;

    @FindBy(css = ".container profile-edit")
    private WebElement profileEdit;

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement formControlName;

    @FindBy(css = "input[formcontrolname='email']")
    private WebElement formControlEmail;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement formControlPass;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    private WebElement formConfirmPass;

    @FindBy(css = "input[formcontrolname='publicInfo']")
    private WebElement formPublicInfo;

    @FindBy(css = "button.btn.btn-primary[type='submit']")
    private WebElement saveBtn;

    public ModifyProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void editUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(formControlName));
        formControlName.sendKeys(username);
    }
    public void editEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(formControlName));
        formControlEmail.sendKeys(email);
    }

    public void setFormControlPass(String password) {
        wait.until(ExpectedConditions.visibilityOf(formControlPass));
        formControlPass.sendKeys(password);
    }
    public void setFormConfirmPass(String confirmPass) {
        wait.until(ExpectedConditions.visibilityOf(formConfirmPass));
        formConfirmPass.sendKeys(confirmPass);
    }
    public void clickSaveBtn() {

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        saveBtn.click();
    }


}
