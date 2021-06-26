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
import org.testng.annotations.Test;

import com.beekee.commonmethods.Constants;
import com.beekee.commonmethods.DriverClass;
import com.google.common.collect.ImmutableMap;

import atu.testng.reports.ATUReports;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class app {
	
	
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

		 

	 
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel_4_XL");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("app", "/Users/infomagnusdevteam/BeeKee_IM/Beekee_Professional/apk/Apr14_PRO_QA_9147.apk");
		cap.setCapability("appPackage", "com.beekee.professionals");
		cap.setCapability("appActivity", "crc6499cf746fc14cc194.MainActivity");
		//cap.setCapability("noReset", true);
		 cap.setCapability("fullReset", false);
//		cap.setCapability("autoWebview", true);
		cap.setCapability("resetKeyboard", false);
		cap.setCapability("autoGrantPermissions", true);
//		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", true));
		cap.setCapability("appWaitForLaunch", true);
//		cap.setCapability("adbExecTimeout", 10000);
		cap.setCapability("appWaitActivity", "com.beekee.professionals.*");

		androiddriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// Reports intialization with driver
//		ATUReports.setWebDriver(androiddriver);
		androiddriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(5000);
		Set<String> contextNames = androiddriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
//		androiddriver.context((String) contextNames.toArray()[1]); // set context to
//		androiddriver.context("WEBVIEW_com.beekee.realestate");
		WebDriverWait wait = new WebDriverWait(androiddriver, 25);
		System.out.println("Waiting to dismiss spinner....");
		// System.out.println("APP_VERSION"+
		// BeeKee_CommonActions.getBeeKeeAppVersion());
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(class,
		// 'ProgressBar')]")));
		// androiddriver.rotate(ScreenOrientation.LANDSCAPE);
	}

	void TT() {
		System.out.println("TEST");
	}


}
