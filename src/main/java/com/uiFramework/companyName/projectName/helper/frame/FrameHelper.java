package com.uiFramework.companyName.projectName.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

	private Logger log = Logger.getLogger(FrameHelper.class);
	private WebDriver driver;

	public FrameHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void switchToIndex(int FrameIndex) {
		driver.switchTo().frame(FrameIndex);
		log.info("Switched to :" + FrameIndex + "Frame");
	}

	public void switchToName(String FrameName) {
		driver.switchTo().frame(FrameName);
		log.info("Switched to :" + FrameName + "Frame");
	}

	public void switchToElement(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to :" + element.toString() + "Frame");
	}
}
