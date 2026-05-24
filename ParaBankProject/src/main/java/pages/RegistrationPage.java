package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class RegistrationPage {
    WebDriver driver;
    WaitUtils wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerLink;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    public WebElement address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@id='customer.username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='customer.password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerBtn;

    @FindBy(xpath = "//span[@id='customer.firstName.errors']")
    public WebElement firstNameError;

    // Fixed the broken complex path to point safely to the container paragraph
    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully')]")
    public WebElement successMsg;

    public void clickRegisterLink() {
        wait.waitForVisibility(registerLink).click();
    }

    public void enterRegistrationDetails(
            String fName, String lName, String addr, String cityName,
            String stateName, String zip, String mobile, String social,
            String user, String pass) {
        
        wait.waitForVisibility(firstName).sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(addr);
        city.sendKeys(cityName);
        state.sendKeys(stateName);
        zipcode.sendKeys(zip);
        phone.sendKeys(mobile);
        ssn.sendKeys(social);
        userName.sendKeys(user);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
    }

    public void clickRegisterButton() {
        wait.waitForVisibility(registerBtn).click();
    }

    public String getFirstNameErrorMessage() {
        return wait.waitForVisibility(firstNameError).getText();
    }

    public String getSuccessMessage() {
        return wait.waitForVisibility(successMsg).getText();
    }
}
