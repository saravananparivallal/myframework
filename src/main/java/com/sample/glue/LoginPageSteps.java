package com.sample.glue;

import com.sample.base.BasePage;
import com.sample.context.TestContext;
import com.sample.managers.PageObjectManager;
import com.sample.managers.WebDriverManager;
import com.sample.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageSteps {
	TestContext testContext;
	LoginPage loginPage;
	BasePage basePage;

	public LoginPageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	@Before
	public void BeforeSteps() {
		testContext.getWebDriverManager().getDriver();
	}

	@Given("user login into the application")
	public void user_login_into_the_application() {
		loginPage.loginIntoApp();
		basePage.implicitWait(8);

	}

	@Then("user enters {string} and {string} in login page")
	public void user_enters_and_in_login_page(String string, String string2) {
		loginPage.inputUsernameAndPassword(string,string2);
	}

	@Then("user click on {string} button")
	public void user_click_on_button(String string) {
		loginPage.clickLoginBtn();
	}

	@Then("user verify the successful login and checks user lands to homepage")
	public void user_verify_the_successful_login_and_checks_user_lands_to_homepage() {

	}

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}

}
