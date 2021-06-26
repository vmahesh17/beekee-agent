package com.beekee.commonmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//import io.appium.java_client.service.local.AppiumDriverLocalService;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class DriverClass {
	public static Properties prop;
	public static AndroidDriver<AndroidElement> androiddriver = null;
	// <AndroidElement>
	public static AndroidElement androidelement;

	// public static AppiumDriver appiumDriver;
	public static Logger log = LogManager.getLogger(DriverClass.class.getName());

	{
		System.setProperty("atu.reporter.config", System.getProperty("user.dir") + "/atu.properties");

	}

	@Test
	public static void appLaunch() throws Exception {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.PROPERTIES_FILE);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// service = AppiumDriverLocalService.buildDefaultService();
		// service.start();
		File f = new File("apk");
		File fs = new File(f, prop.getProperty("app.appname"));
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", prop.getProperty("app.deviceName"));
		cap.setCapability("platformName", prop.getProperty("app.platformName"));
		cap.setCapability("platformVersion", prop.getProperty("app.platformVersion"));
		cap.setCapability("app", fs.getAbsolutePath());
		cap.setCapability("appPackage", prop.getProperty("app.package"));
		cap.setCapability("appActivity", prop.getProperty("app.activity"));
		cap.setCapability("noReset", true);
		// cap.setCapability("fullReset", true);
		cap.setCapability("autoWebview", false);
		cap.setCapability("resetKeyboard", false);
		cap.setCapability("autoGrantPermissions", true);
		// cap.setCapability("showChromedriverLog", true);
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

		androiddriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// Reports intialization with driver
		ATUReports.setWebDriver(androiddriver);
		androiddriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(5000);
		Set<String> contextNames = androiddriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		androiddriver.context((String) contextNames.toArray()[1]); // set context to
		androiddriver.context("WEBVIEW_com.beekee.realestate");
		WebDriverWait wait = new WebDriverWait(androiddriver, 25);
		System.out.println("Waiting to dismiss spinner....");
		// System.out.println("APP_VERSION"+
		// BeeKee_CommonActions.getBeeKeeAppVersion());
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(class,
		// 'ProgressBar')]")));
		// androiddriver.rotate(ScreenOrientation.LANDSCAPE);
	}

	public static void tearDown() throws Exception {
		try {
			androiddriver.quit();
			log.info(" Driver quit successfully");
		} catch (Exception e) {
			System.err.println("Driver not quit successfully and throwable error message is: " + e);
			log.warn("Driver not quit successfully and throwable error message is: ", e);
		}
	}

}

//Failed to get PID

//Map<String, Object> chromeOptions = new HashMap<String, Object>();
//chromeOptions.put("androidProcess", prop.getProperty("app.package")); 
//cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);