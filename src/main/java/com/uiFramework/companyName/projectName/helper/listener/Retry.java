package com.uiFramework.companyName.projectName.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private Logger log = Logger.getLogger(Retry.class);
	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult arg0) {
		if (retryCount < maxRetryCount) {
			log.info("Retrying Test" + arg0.getName() + "for the" + getResultStatusName(arg0.getStatus())
					+ (retryCount + 1) + "times");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = "Null";
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

}