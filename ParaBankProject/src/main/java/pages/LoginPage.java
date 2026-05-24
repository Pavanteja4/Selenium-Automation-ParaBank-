package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']") 
    WebElement userName;
    
    @FindBy(xpath = "//input[@name='password']") 
    WebElement password;
    
    @FindBy(xpath = "//input[@value='Log In']") 
    WebElement loginBtn;
    
    @FindBy(xpath = "//p[@class='smallText'][//b[contains(text(),'Welcome')]]") 
    WebElement loginSuccessMsg;
    
    @FindBy(xpath =("//p[text()='The username and password could not be verified.']")) 
    WebElement errorMsg;

    @FindBy(xpath =("//p[text()='Please enter a username and password.']"))
    WebElement blankError;

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
    
    public String successLogin() {
        return wait.until(ExpectedConditions.visibilityOf(loginSuccessMsg)).getText();
    }
    
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }
    
    public String blankErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(blankError)).getText();
    }
    
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(loginBtn)).isDisplayed();
    }

    public boolean isUsernameFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userName)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(password)).isDisplayed();
    }
}
