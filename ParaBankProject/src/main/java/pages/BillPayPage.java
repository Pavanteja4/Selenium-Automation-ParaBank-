package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class BillPayPage {

    WebDriver driver;
    WaitUtils wait;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

 
    @FindBy(xpath=("//a[text()='Bill Pay']"))public WebElement billPayLink;

    @FindBy(xpath=("//input[@name='payee.name']"))public WebElement payeeNameField;

    @FindBy(xpath=("//input[@name='payee.address.street']"))public WebElement addressField;

    @FindBy(xpath=("//input[@name='payee.address.city']"))public WebElement cityField;
    @FindBy(xpath=("//input[@name='payee.address.state']"))public WebElement stateField;

    @FindBy(xpath=("//input[@name='payee.address.zipCode']"))public WebElement zipCodeField;

    @FindBy(xpath=("//input[@name='payee.phoneNumber']"))public WebElement phoneField;

    @FindBy(xpath=("//input[@name='payee.accountNumber']")) public WebElement accountField;

    @FindBy(xpath=("//input[@name='verifyAccount']"))public WebElement verifyAccountField;

    @FindBy(xpath=("//input[@name='amount']"))public WebElement amountField;

    @FindBy(xpath=("//input[@value='Send Payment']"))public WebElement sendPaymentButton;

    @FindBy(xpath = "//h1[text()='Bill Payment Complete']")public WebElement successMessage;

    @FindBy(xpath = "//span[contains(text(),'required')]")public WebElement errorMessage;

    
    public void clickBillPayLink() {
        wait.waitForVisibility(billPayLink).click();
    }

    
    public void enterValidBillPayDetails() {
        wait.waitForVisibility(payeeNameField).sendKeys("Teja");
        addressField.sendKeys("Vijayawada");
        cityField.sendKeys("Vijayawada");
        stateField.sendKeys("AP");
        zipCodeField.sendKeys("520001");
        phoneField.sendKeys("9876543210");
        accountField.sendKeys("12345");
        verifyAccountField.sendKeys("12345");
        amountField.sendKeys("500");
    }

    public void enterInvalidBillPayDetails() {
        wait.waitForVisibility(payeeNameField).clear();
        payeeNameField.sendKeys("");
        amountField.clear();
        amountField.sendKeys("");
    }

    public void clickSendPaymentButton() {
        wait.waitForVisibility(sendPaymentButton).click();
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMessage).getText();
    }

    public String getErrorMessage() {
        return wait.waitForVisibility(errorMessage).getText();
    }
}
