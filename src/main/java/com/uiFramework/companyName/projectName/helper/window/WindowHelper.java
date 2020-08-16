package com.uiFramework.companyName.projectName.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
	private Logger log = Logger.getLogger(WindowHelper.class);
	private WebDriver driver;

	public WindowHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void switchToParentWindow() {
		log.info("Switching to Parent Window");
		driver.switchTo().defaultContent();
	}

	public void switchToSelectedChildWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		if (i == index)
			for (String window : windows) {
				log.info("Switching to selected child window :" + index);
				driver.switchTo().window(window);
			}
		i++;
	}

	public void switchToMainWindowByCLosingAllChildWindows() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
			log.info("Switching to Main Window");
			driver.switchTo().window(mainwindow);
		}
	}

	public void navigateBack() {
		log.info("Navigating to Back");
		driver.navigate().back();
	}

	public void navigateForward() {
		log.info("Navigating to Forward ");
		driver.navigate().forward();
	}
}
