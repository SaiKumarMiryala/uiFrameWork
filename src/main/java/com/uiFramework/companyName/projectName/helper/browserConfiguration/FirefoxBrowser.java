package com.uiFramework.companyName.projectName.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class FirefoxBrowser {

	public FirefoxOptions getfFirefoxOptions() {

		DesiredCapabilities firefox = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAcceptUntrustedCertificates(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("Marionette", true);

		FirefoxOptions firefoxoptions = new FirefoxOptions(firefox);

		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			firefoxoptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return firefoxoptions;
	}

	public WebDriver getfFirefoxOptions(FirefoxOptions cap) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.gecko.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers.exe"));
			return new FirefoxDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.gecko.driver", "/usr/bin/chrome");
			return new FirefoxDriver(cap);
		}
		return null;

	}
}
