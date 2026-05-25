package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogoutPage;

public class LogoutSteps {

    LogoutPage logoutPage = new LogoutPage(BaseClass.getDriver());

    @When("user clicks on logout link")
    public void user_clicks_on_logout_link() {
        logoutPage.clickLogout();
    }

    @Then("user should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        Assert.assertTrue(logoutPage.isLoginButtonDisplayed(), "Login button is not displayed after logging out!");
    }

    @And("user navigates back via browser history")
    public void user_navigates_back_via_browser_history() {
        
        BaseClass.getDriver().navigate().back();
        
        
        BaseClass.getDriver().navigate().refresh();
    }

    @Then("user session should be terminated")
    public void user_session_should_be_terminated() {
        boolean isLoggedOut = logoutPage.isLoginButtonDisplayed();
        Assert.assertTrue(isLoggedOut, "Session termination failed! The private account data was still visible after navigating back.");
    }
}
