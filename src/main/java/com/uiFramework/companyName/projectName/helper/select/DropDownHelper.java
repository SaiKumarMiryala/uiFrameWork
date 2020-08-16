package com.uiFramework.companyName.projectName.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	private Logger log = Logger.getLogger(DropDownHelper.class);
	private WebDriver driver;

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("SelectUsingValue and value is:" + value);
		select.selectByValue(value);
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("SelectUsingIndex and index is:" + index);
		select.selectByIndex(index);
	}

	public void selectUsingVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		log.info("selectUsingVisibleText and text is:" + visibletext);
		select.selectByVisibleText(visibletext);
	}

	public void deselectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("deSelectUsingValue and value is:" + value);
		select.deselectByValue(value);
	}

	public void deselectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("deSelectUsingIndex and index is:" + index);
		select.deselectByIndex(index);
	}

	public void deselectUsingVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		log.info("selectUsingVisibleText and text is:" + visibletext);
		select.deselectByVisibleText(visibletext);
	}

	public LinkedList<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementlist = select.getOptions();
		LinkedList<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementlist) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
}
