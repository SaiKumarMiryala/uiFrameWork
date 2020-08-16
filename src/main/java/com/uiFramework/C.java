package com.uiFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C {
	int i = 1;

	@Test
	public void testLoginC() {
		if (i == 3) {
			Assert.assertTrue(true);
		} else {
			i++;
			Assert.assertTrue(false);
		}
	}
}
