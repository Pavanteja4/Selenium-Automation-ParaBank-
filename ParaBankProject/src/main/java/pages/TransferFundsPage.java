package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransferFundsPage {

    WebDriver driver;
    WebDriverWait wait;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[text()='Transfer Funds']") 
    WebElement transferFunds;

    @FindBy(xpath = "//h1[normalize-space()='Transfer Funds']") 
    public WebElement transferFundsHeader;

    @FindBy(xpath = "//input[@id='amount']") 
    public WebElement amountField;
    
    @FindBy(xpath = "//input[@value='Transfer']") 
    WebElement transferBtn;

    @FindBy(xpath =("//*[contains(text(),'Transfer Complete')]"))
    public WebElement transferSuccessMsg;
    
    @FindBy(xpath = "//p[normalize-space()='An internal error has occurred and has been logged.']") 
    public WebElement tranferErrror;

    public void clickTransferFundsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(transferFunds)).click();
    }
    
    public String istransferPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(transferFundsHeader)).getText();
    }

    public void enterAmount(String amount) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(amountField));
        element.clear();
        element.sendKeys(amount);
    }

    public void clickTransferButton() {
        wait.until(ExpectedConditions.elementToBeClickable(transferBtn)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(tranferErrror)).getText();
    }
}
