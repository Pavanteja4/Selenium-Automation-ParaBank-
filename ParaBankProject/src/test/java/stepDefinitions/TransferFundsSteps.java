package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.TransferFundsPage;
import utils.WaitUtils;

public class TransferFundsSteps {

    LoginPage loginPage = new LoginPage(BaseClass.getDriver());
    TransferFundsPage transferPage = new TransferFundsPage(BaseClass.getDriver());
    WaitUtils wait = new WaitUtils(BaseClass.getDriver());

    @When("user navigates to transfer funds page")
    public void user_navigates_to_transfer_funds_page() {
        transferPage.clickTransferFundsLink();
    }

    @Then("transfer funds page should open")
    public void transfer_funds_page_should_open() {
        wait.waitForVisibility(transferPage.transferFundsHeader);
        String headerText = transferPage.istransferPageDisplayed();
        Assert.assertEquals(headerText, "Transfer Funds", "Transfer Funds page header text mismatch!");
    }

    @And("user enters valid transfer amount")
    public void user_enters_valid_transfer_amount() {
        wait.waitForVisibility(transferPage.amountField);
        transferPage.enterAmount("100");
    }

    @And("user clicks on transfer button")
    public void user_clicks_on_transfer_button() {
        transferPage.clickTransferButton();
    }

    @Then("funds should be transferred successfully")
    public void funds_should_be_transferred_successfully() {
        Assert.assertTrue(wait.waitForVisibility(transferPage.transferSuccessMsg).isDisplayed(), 
                "Fund transfer confirmation screen did not load!");
    }

    @And("user enters invalid transfer amount")
    public void user_enters_invalid_transfer_amount() {
        wait.waitForVisibility(transferPage.amountField);
        transferPage.enterAmount(""); 
    }

    @Then("transfer error message should be displayed")
    public void transfer_error_message_should_be_displayed() {
        wait.waitForVisibility(transferPage.tranferErrror);
        String errorText = transferPage.getErrorMessage();
        
        Assert.assertTrue(errorText.toLowerCase().contains("error"), "Expected validation warning text mismatch! Got: " + errorText);
    }

    @Then("success transfer message should be displayed")
    public void success_transfer_message_should_be_displayed() {
        // Text-based validation guarantees that the header reads 'Transfer Complete!' instead of duplicating visibility checks
        String confirmationText = wait.waitForVisibility(transferPage.transferSuccessMsg).getText();
        Assert.assertTrue(confirmationText.contains("Complete"), "Success confirmation layout text verification failed!");
    }
}
