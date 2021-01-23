package com.sample.glue;

import com.sample.context.TestContext;
import com.sample.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	public LoginPageSteps(TestContext context) {
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}

	@Given("logn into application")
	public void logn_into_application() {
		
	}

	@Given("user enters the {string} in login")
	public void user_enters_the_in_login(String string) {
		
	}

	@Given("user enter the {string} in login")
	public void user_enter_the_in_login(String string) {
		
	}

	@Given("user clicks on the {string} button")
	public void user_clicks_on_the_button(String string) {
		
	}

	@Given("user inputs the {string} in dashborad")
	public void user_inputs_the_in_dashborad(String string) {
		
	}

	@Then("user validated the {string} in status")
	public void user_validated_the_in_status(String string) {
		
	}
}
