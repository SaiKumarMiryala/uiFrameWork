package com.uiFramework.companyName.projectName.helper.resource;

public class ResourceHelper {

	public static String getResourcePath(String path) {

		String basePath = System.getProperty("user.dir");
		System.out.println("Resource Path:" + basePath + "/" + path);
		return basePath + "/" + path;
	}

	/*
	 * public static void main(String args[]) { String Path =
	 * ResourceHelper.getResourcePath(
	 * "\\src\\main\\resources\\configFile\\log4j.properties");
	 * System.out.println("Print entire Log4j Properties path: " + Path); }
	 */
}