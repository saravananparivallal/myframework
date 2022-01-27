package com.sample.managers;

import org.openqa.selenium.WebDriver;

import com.sample.pages.LoginPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
		
	}
}
