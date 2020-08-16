package com.uiFramework.companyName.projectName.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertionHelper {

	private static Logger log = Logger.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifying text :" + s1 + "with" + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("Making script PASS : ");
		Assert.assertTrue(true);
	}

	public static void makeTrueWithMessage(String message) {
		log.info("Making script PASS : " + message);
		Assert.assertTrue(true, message);
	}

	public static void makeFalse() {
		log.info("Making script FAIL : ");
		Assert.assertFalse(false);
	}

	public static void makeFalseWithMessage(String message) {
		log.info("Making script FAIL : " + message);
		Assert.assertFalse(false, message);
	}

	public static void verifyTrueWithStatus(boolean status) {
		Assert.assertTrue(status);
	}

	public static void verifyFlaseWithStatus(boolean status) {
		Assert.assertFalse(status);

	}

	public static void verifyNullObject(String s1) {
		log.info("Verify the object is Null : " + s1);
		Assert.assertNull(s1);

	}

	public static void verifyNotNullObject(String s1) {
		log.info("Verify the object is Not Null : " + s1);
		Assert.assertNotNull(s1);

	}

}
