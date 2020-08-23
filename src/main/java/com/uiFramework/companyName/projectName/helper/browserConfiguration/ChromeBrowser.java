package com.uiFramework.companyName.projectName.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.companyName.projectName.helper.resource.ResourceHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		// Linux
		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return option;
	}

	public WebDriver getChromeDriver(ChromeOptions cap) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers"));
			return new ChromeDriver(cap);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers.exe"));
			return new ChromeDriver(cap);
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chrome");
			return new ChromeDriver(cap);
		}
		return null;

	}
}
