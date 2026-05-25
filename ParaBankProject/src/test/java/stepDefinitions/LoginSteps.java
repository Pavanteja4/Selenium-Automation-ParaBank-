package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(BaseClass.getDriver());

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("the system outcome should be {string}")
    public void the_system_outcome_should_be(String outcome) {
        if (outcome.equalsIgnoreCase("success")) {
            String successMsg = loginPage.successLogin();
            
            
            Assert.assertTrue(successMsg.contains("Welcome"), "Welcome text was missing from the dashboard panel!");
            
            Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains("overview"), "Dashboard URL target path mismatch!");
        } else {
            String actualError = "";
            try {
                actualError = loginPage.getErrorMessage();
            } catch (Exception e) {
                actualError = loginPage.blankErrorMessage();
            }
            
            Assert.assertTrue(actualError.contains("verified") || actualError.contains("enter a username"),
                "The actual page error message failed validation matches. Found: " + actualError);
        }
    }

    @Then("login page UI elements should be displayed")
    public void login_ui_validation() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button not displayed");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field not displayed");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field not displayed");
    }
}
