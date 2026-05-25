package stepDefinitions;

import org.testng.Assert;
import base.BaseClass;
import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utils.WaitUtils;

public class Registerationsteps {

	
	WaitUtils wait = new WaitUtils(BaseClass.getDriver());

	RegistrationPage register = new RegistrationPage(BaseClass.getDriver());

	@When("user navigates to registration page")
	public void user_navigates_to_registration_page() {
		
		register.clickRegisterLink();
	}

	@Then("registration page should open")
	public void registration_page_should_open() {
		Assert.assertTrue(BaseClass.driver.getCurrentUrl().contains("register"));
	}

	@And("user enters valid registration details")
	public void user_enters_valid_details() {
		register.enterRegistrationDetails("teja", "inakoti", "kakinada", "kakinada", "AP", "533291", "9876543210",
				"123245", "pavan01", "Teja@123");
	}

	@And("clicks on Register button")
	public void clicks_register_button() {
		register.clickRegisterButton();
	}

	@Then("user account should be created successfully")
	public void account_created_successfully() {
		String msg = register.getSuccessMessage();
		Assert.assertTrue(msg.contains("Your account was created successfully"));
	}

	@And("user submits empty registration form")
	public void user_submits_empty_registration_form() {
		register.clickRegisterButton();
	}

	@Then("error messages should be displayed")
	public void mandatory_field_error_should_be_displayed() {
		String error = wait.waitForVisibility(register.firstNameError).getText();
		Assert.assertTrue(error.contains("First name is required"));
	}
}
