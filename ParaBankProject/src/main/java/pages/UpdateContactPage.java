package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class UpdateContactPage {

    WebDriver driver;
    WaitUtils wait;

    public UpdateContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath=("//a[normalize-space()='Update Contact Info']")) WebElement updateContactLink;

    @FindBy(xpath=("//input[@id='customer.firstName']")) WebElement firstNameField;

    @FindBy(xpath=("//input[@id='customer.lastName']")) WebElement lastNameField;

    @FindBy(xpath=("//input[@id='customer.address.street']")) WebElement addressField;

    @FindBy(xpath=("//input[@id='customer.address.city']")) WebElement cityField;

    @FindBy(xpath=("//input[@id='customer.address.state']")) WebElement stateField;

    @FindBy(xpath=("//input[@id='customer.address.zipCode']")) WebElement zipCodeField;

    @FindBy(xpath=("//input[@id='customer.phoneNumber']"))WebElement phoneField;

    @FindBy(xpath=("//input[@value='Update Profile']")) WebElement updateProfileButton;

    @FindBy(xpath =("//h1[@class='title' and contains(text(),'Updated')]")) WebElement successMessage;

    @FindBy(xpath =("//span[contains(@class,'error') or contains(text(),'required')]")) WebElement errorMessage;

    
    
    public void clickUpdateContactInfoLink() {
        wait.waitForVisibility(updateContactLink).click();
    }

    // Enter valid details with explicit wait handling
    public void enterValidContactDetails() {
        wait.waitForVisibility(firstNameField).clear();
        firstNameField.sendKeys("veer");

        lastNameField.clear();
        lastNameField.sendKeys("Kumar");

        addressField.clear();
        addressField.sendKeys("Vijayawada");

        cityField.clear();
        cityField.sendKeys("Vijayawada");

        stateField.clear();
        stateField.sendKeys("AP");

        zipCodeField.clear();
        zipCodeField.sendKeys("520001");

        phoneField.clear();
        phoneField.sendKeys("9876543210");
    }

    public void enterInvalidContactDetails() {
        wait.waitForVisibility(firstNameField).clear();
//        lastNameField.clear();
    }

    public void clickUpdateProfileButton() {
        wait.waitForVisibility(updateProfileButton).click();
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMessage).getText();
    }

    public String getErrorMessage() {
        return wait.waitForVisibility(errorMessage).getText();
    }

    public String getUpdatedFirstName() {
        return wait.waitForVisibility(firstNameField).getAttribute("value");
    }
}
