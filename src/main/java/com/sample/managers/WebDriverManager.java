package com.sample.managers;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.enums.DriverType;

public class WebDriverManager {
	WebDriver driver;
	private static DriverType driverType;
	private String isHeadlessModeEnabled;
	private static final String CHROME_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		isHeadlessModeEnabled = FileReaderManager.getInstance().getConfigReader().getHeadlessMode();
	}

	public WebDriver getDriver() {
if (driver == null) 
	driver = createDriver();
		return driver;

	}

	private WebDriver createDriver() {
		switch (driverType) {
		case CHROME:
			System.setProperty(CHROME_PROPERTY,
					"C:\\Users\\Owern\\eclipse-workspace\\Saravanan\\driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			options.merge(caps);
			options.addArguments("--test-type");
			options.addArguments("start-maximized");
			options.addArguments("--js-flags=--expose-gc");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-defauls-apps");
			options.addArguments("--enable-automation");
			options.addArguments("disable-extensions");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			options.addArguments("--no-sandbox");
			if (isHeadlessModeEnabled.equalsIgnoreCase("yes")) {
				options.addArguments("--headless");
				options.addArguments("window-sixe=1920,1080");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		}
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
