package com.uiFramework.companyName.projectName.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

	private Logger log = Logger.getLogger(AlertHelper.class);

	private WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}

	public Alert getAlert() {
		log.info("Get the Alert:" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
		log.info("Alert is Accepted..");
	}

	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Alert is dismissed...");
	}

	public String getAlertText() {
		String text = getAlert().getText();
		log.info("Alert text:" + text);
		return text;

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present :");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}

	}

	public void acceptAlertIsPresent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else {
			log.info("alert is not present");
		}
	}

	public void dismissAlertIsPresent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else {
			log.info("alert is not present");
		}
	}

	public void acceptPrompt(String text) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text is " + text);

		}
	}
}