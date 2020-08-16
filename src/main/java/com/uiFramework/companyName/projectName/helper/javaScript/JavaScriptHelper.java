package com.uiFramework.companyName.projectName.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	private Logger log = Logger.getLogger(JavaScriptHelper.class);
	private WebDriver driver;

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScriptHelper has been initialized");
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public void scrollToElement(WebElement element) {
		executeScript("window.scrollTo().arguments[0],arguments[1]", element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	public void scrollToViewElement(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);

	}

	public void scrollToViewElementAndClick(WebElement element) {
		scrollToViewElementAndClick(element);
		element.click();
	}

	public void scrollDownVertically() {
		executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public void scrollUpVertically() {
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");

	}

	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBy(0." + pixel + ")");

	}

	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	public void ZoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	public void ZoomInBy60Percentage() {
		executeScript("document.body.style.zomm='60%'");
	}

	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);

	}
}
