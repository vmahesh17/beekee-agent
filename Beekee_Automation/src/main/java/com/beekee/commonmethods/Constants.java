package com.beekee.commonmethods;

public class Constants {

	static String currentDir = System.getProperty("user.dir");

	public static final String ANDROID_LOGS = currentDir + "/Beekee_Automation/logs";

	public static final String PROPERTIES_FILE = currentDir + "/src/main/java/com/beekee/properties/properties";
	
	public static final String BEEKEE_PROPERTIES_FILE = currentDir + "/src/main/java/com/beekee/properties/beekeedata.properties";
	
	public static final String TESTDATA = currentDir + "/Data/TestDataSheet.xlsx";

	public static final String TestConfigurationDatafile = currentDir + "/Data/TestConfiguration.xlsx";

	public static final String pathChromeDriver = currentDir + "/drivers/chromedriver.exe";

	public static final String CapturedScreenshotPath = currentDir + "\\target";

}