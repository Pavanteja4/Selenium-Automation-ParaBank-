package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.UpdateContactPage;

public class UpdateContactSteps {

    UpdateContactPage updatePage = new UpdateContactPage(BaseClass.getDriver());

    @When("user navigates to update contact info page")
    public void user_navigates_to_update_contact_info_page() {
        updatePage.clickUpdateContactInfoLink();
    }

    @Then("update profile page should open")
    public void update_profile_page_should_open() {
        Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains("updateprofile"));
    }

    @And("user enters valid contact details")
    public void user_enters_valid_contact_details() {
        updatePage.enterValidContactDetails();
    }

    @And("user clicks on update profile button")
    public void user_clicks_on_update_profile_button() {
        updatePage.clickUpdateProfileButton();
    }

    @Then("contact information should be updated successfully")
    public void contact_information_should_be_updated_successfully() {
        String msg = updatePage.getSuccessMessage();
        Assert.assertTrue(msg.contains("Profile Updated"), "Success title check failed!");
    }

    @And("user enters invalid contact details")
    public void user_enters_invalid_contact_details() {
        updatePage.enterInvalidContactDetails();
    }

    @Then("update contact error message should be displayed")
    public void update_contact_error_message_should_be_displayed() {
        String error = updatePage.getErrorMessage();
        
        Assert.assertTrue(error.toLowerCase().contains("required"), 
            "Error validation message text mismatch. Received: " + error);
    }

    @Then("updated contact information should be displayed")
    public void updated_contact_information_should_be_displayed() {
        String successMessage = updatePage.getSuccessMessage();
        
        Assert.assertTrue(successMessage.contains("Updated"), 
            "Expected word 'Updated' not found in text: " + successMessage);
    }
}
