package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BillPayPage;

public class BillPaySteps {

    BillPayPage billPayPage =new BillPayPage(BaseClass.getDriver());

    @When("user navigates to bill pay page")
    public void user_navigates_to_bill_pay_page() {

        billPayPage.clickBillPayLink();
    }

    @Then("bill pay page should open")
    public void bill_pay_page_should_open() {

        Assert.assertTrue(BaseClass.driver.getCurrentUrl().contains("billpay"));
    }

    @When("user enters valid bill pay details")
    public void user_enters_valid_bill_pay_details() {

        billPayPage.enterValidBillPayDetails();
    }

    @When("user clicks on send payment button")
    public void user_clicks_on_send_payment_button() {

        billPayPage.clickSendPaymentButton();
    }

    @Then("bill payment should be successful")
    public void bill_payment_should_be_successful() {

        String msg =billPayPage.getSuccessMessage();

        Assert.assertTrue(msg.contains("Bill Payment Complete"));
    }

    @When("user enters invalid bill pay details")
    public void user_enters_invalid_bill_pay_details() {

        billPayPage.enterInvalidBillPayDetails();
    }

    @Then("bill payment error message should be displayed")
    public void bill_payment_error_message_should_be_displayed() {

        String error =billPayPage.getErrorMessage();

        Assert.assertTrue(error.contains("required"));
    }
}