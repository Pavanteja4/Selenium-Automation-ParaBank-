package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Accounts Overview']") 
    WebElement accountOverview;
    
    @FindBy(xpath = "//th[text()='Account']") 
    WebElement account;
    
    @FindBy(xpath = "//th[text()='Balance*']") 
    WebElement balance;
    
    @FindBy(xpath = "//table[@id='accountTable']") 
    WebElement accountTable;

    public boolean isAccountTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(accountTable)).isDisplayed();
    }

    public void clickAccountOverview() {
        wait.until(ExpectedConditions.elementToBeClickable(accountOverview)).click();
    }
    
    public boolean isAccountDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(account)).isDisplayed();
    }

    public boolean isBalanceDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(balance)).isDisplayed();
    }
}
