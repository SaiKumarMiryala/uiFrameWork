package com.uiFramework.companyName.projectName.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.companyName.projectName.helper.logger.LoggerHelper;

public class WaitHelper {

	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This is for implicit Wait
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(int timeout, TimeUnit unit) {
		log.info("Implicit wait as been set: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);

	}

	/**
	 * This is for Fluent Wait
	 * 
	 * @param TimeOutInSeconds
	 * @param PollingEveryMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int TimeOutInSeconds, int PollingEveryMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(PollingEveryMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		return wait;
	}

	/**
	 * This is for WaitForElementVisibleWithPollingTime
	 * 
	 * @param element
	 * @param TimeOutInSeconds
	 * @param PollingEveryMiliSec
	 */
	public void waitForElementVisibleWithPollingTime(WebElement element, int TimeOutInSeconds,
			int PollingEveryMiliSec) {
		log.info("Waiting for : " + element.toString() + TimeOutInSeconds + "Seconds");
		WebDriverWait wait = getWait(TimeOutInSeconds, PollingEveryMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}

	/**
	 * This is for WaitForElementToBeClickable
	 * 
	 * @param element
	 * @param TimeOutInSeconds
	 */
	public void waitForElementToBeClickable(WebElement element, int TimeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + TimeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is Clicked now");
	}

	/**
	 * This is for WaitForElementNotPresent
	 * 
	 * @param element
	 * @param TimeOutInSeconds
	 * @return
	 */

	public boolean waitForElementNotPresent(WebElement element, long TimeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + TimeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		boolean Status = wait.until(ExpectedConditions.invisibilityOf(element));
		return Status;
	}

	/**
	 * This is for WaitForFrameToBeAvaiableSwitchToIt
	 * 
	 * @param element
	 * @param TimeOutInSeconds
	 */
	public void waitForFrameToBeAvaiableSwitchToIt(WebElement element, long TimeOutInSeconds) {
		log.info("Waiting for : " + element.toString() + TimeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	/**
	 * This is for FluentWait
	 * 
	 * @param TimeOutInSeconds
	 * @param PollingEveryMiliSec
	 * @return
	 */
	private Wait<WebDriver> getFluentWait(int TimeOutInSeconds, int PollingEveryMiliSec) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(TimeOutInSeconds))
				.pollingEvery(Duration.ofMillis(PollingEveryMiliSec)).ignoring(NoSuchElementException.class);
		return wait;
	}

	/**
	 * This is for waiting Web element through fluent wait
	 * 
	 * @param element
	 * @param TimeOutInSeconds
	 * @param PollingEveryMiliSec
	 * @return
	 */
	public WebElement waitForElement(WebElement element, int TimeOutInSeconds, int PollingEveryMiliSec) {

		Wait<WebDriver> wait = getFluentWait(TimeOutInSeconds, PollingEveryMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

	/**
	 * This is for loading the page
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void pageLoadTime(int timeout, TimeUnit unit) {
		log.info("Waiting for page to load : " + unit);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
	}
}