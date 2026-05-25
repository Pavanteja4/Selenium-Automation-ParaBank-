package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class CommonSteps {

    LoginPage loginPage;

    @Given("user launches ParaBank application")
    public void user_launches_parabank_application() {

        loginPage =new LoginPage(BaseClass.driver);
    }

    @Given("user logs into ParaBank application")
    public void user_logs_into_parabank_application() {

        loginPage = new LoginPage(BaseClass.driver);

        loginPage.enterUsername("pavan01");
        loginPage.enterPassword("Teja@123");

        loginPage.clickLogin();
    }
}