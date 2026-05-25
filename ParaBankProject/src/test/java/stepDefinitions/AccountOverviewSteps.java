package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.AccountOverviewPage;

public class AccountOverviewSteps {

    LoginPage loginPage = new LoginPage(BaseClass.getDriver());
    AccountOverviewPage overviewPage = new AccountOverviewPage(BaseClass.getDriver());
    

    @And("click account overview")
    public void click_account_overview() {
		overviewPage.clickAccountOverview();

    }
    @Then("account overview page should be displayed")
    public void account_overview_page_should_be_displayed() {
       
    		Assert.assertTrue(overviewPage.isAccountTableDisplayed(), "Account Overview page layout is not displayed!");
    }

    @Then("account details and balances should be displayed")
    public void account_details_and_balances_should_be_displayed() {

        Assert.assertTrue(overviewPage.isAccountDisplayed(), "Account column header is missing!");
        Assert.assertTrue(overviewPage.isBalanceDisplayed(), "Balance column header is missing!");
    }
}
