package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LogoutPage {

    WebDriver driver;
    WaitUtils wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=("//a[normalize-space()='Log Out']"))public WebElement logoutLink;

    @FindBy(xpath =("//input[@value='Log In']"))public WebElement loginButton;

    @FindBy(linkText = "Accounts Overview")public WebElement accountOverviewLink;

    public void clickLogout() {
        wait.waitForVisibility(logoutLink).click();
    }

    public boolean isLoginButtonDisplayed() {
        return wait.waitForVisibility(loginButton).isDisplayed();
    }

    public void clickAccountOverview() {
        wait.waitForVisibility(accountOverviewLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
