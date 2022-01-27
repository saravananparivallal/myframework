package com.sample.managers;

import com.sample.enums.EnvironmentType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.enums.DriverType;

import java.util.concurrent.TimeUnit;


public class WebDriverManager {
		private WebDriver driver;
		private static DriverType driverType;
		private static EnvironmentType environmentType;
		private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

		public WebDriverManager() {
			driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
			environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		}

		public WebDriver getDriver() {
			if(driver == null) driver = createDriver();
			return driver;
		}

		private WebDriver createDriver() {
			switch (environmentType) {
				case LOCAL : driver = createLocalDriver();
					break;
				case REMOTE : driver = createRemoteDriver();
					break;
			}
			return driver;
		}

		private WebDriver createRemoteDriver() {
			throw new RuntimeException("RemoteWebDriver is not yet implemented");
		}

		private WebDriver createLocalDriver() {
			switch (driverType) {
				case CHROME :
					System.setProperty(CHROME_DRIVER_PROPERTY,
							"C:\\Users\\saravanan.p\\myframework\\driver\\chromedriver.exe");
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
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					break;

				case IE :
					driver = new InternetExplorerDriver();
					break;
			}


			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
			return driver;
		}

		public void closeDriver() {
			driver.close();
			driver.quit();

	}
}
