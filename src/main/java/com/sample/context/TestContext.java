package com.sample.context;

import com.sample.managers.PageObjectManager;
import com.sample.managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriver;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	public TestContext() {
		webDriver = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriver.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public WebDriverManager getWebDriverManager() {
		return webDriver;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;

	}

}
