package com.beekee.testsuite;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Beekee_AgentApp_Gallery extends Actions_Android {

	@BeforeTest
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		DriverClass.appLaunch();
		signInToApplication(true, "testbeekee01@yopmail.com", "Pass@123");

	}

	@Test(enabled = true, priority = 0, groups = { "P1" })
	public static void Beekee_AgentApp_MaybeLater() throws Exception {
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		click(BTN_MAYBELATER);
		click(BTN_YES);
		waitUntilElementClickable(LBL_DASHBOARD_DEFAULT);
	}

	@Test(enabled = true, priority = 1, groups = { "P1" })
	public static void BeeKee_AgentApp_Camera() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
		Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
		System.out.println("Successfully Navigated to My Gallery screen");
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_TAKE_A_PHOTO);
		clickjs(BTN_TAKE_A_PHOTO);
		switchConext();
		if (androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").size() > 0) {
			androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").get(0).click();
		}
		androiddriver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter_button')]").click();
		Thread.sleep(1000);
		androiddriver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'done_button')]").click();
		Thread.sleep(1000);
		androiddriver.findElementByXPath("//android.widget.Button[contains(@resource-id,'save_button')]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), phbefore + 1);
	}

	@Test(enabled = true, priority = 2, groups = { "P1" })
	public static void BeeKee_AgentApp_Gallery() throws Exception {
		takePhoto(30);
		androiddriver.closeApp();
		DriverClass.appLaunch();
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
		Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
		System.out.println("Successfully Navigated to My Gallery screen");
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_SELECT_PHOTO);
		clickjs(BTN_SELECT_PHOTO);
		Thread.sleep(3000);
		switchConext();
		for (int i = 1; i <= 30 - phbefore; i++) {
			if (i <= 15) {
				androiddriver
						.findElementByXPath(
								"(//android.widget.ImageView[contains(@resource-id,'media_image')])[" + i + "]")
						.click();
			} else {
				if (i == 16) {
					androiddriver.findElementByXPath("(//android.widget.Button[contains(@resource-id,'done')])[1]")
							.click();
					switchDefaultConext();
					waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
					click(BTN_ADD_PHOTOVIDEO);
					waitUntilElementClickable(BTN_SELECT_PHOTO);
					clickjs(BTN_SELECT_PHOTO);
					Thread.sleep(3000);
					switchConext();
				}
				List<AndroidElement> a = androiddriver
						.findElementsByXPath("//android.widget.ImageView[contains(@resource-id,'media_image')]");
				System.out.println("a----------- " + a);
				a.get(0 + (i - 16)).click();
			}
		}
		androiddriver.findElementByXPath("(//android.widget.Button[contains(@resource-id,'done')])[1]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phAfter:---" + androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), 30);
	}
	
	@Test(enabled = true, priority = 3, groups = { "P1" })
	public static void BeeKee_AgentApp_GalleryExceedPhotoLimit() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
		Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
		System.out.println("Successfully Navigated to My Gallery screen");
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_SELECT_PHOTO);
		clickjs(BTN_SELECT_PHOTO);
		Thread.sleep(1000);
		System.out.println(androiddriver.findElementByXPath("//*[@class='toast-message']").getText());
	}
	

	@Test(enabled = true, priority = 4, groups = { "P1" })
	public static void BeeKee_AgentApp_RemovePhotos() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		List<AndroidElement> imgs = androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]);
		for (int i = 0; i < imgs.size(); i++) {
			Actions act = new Actions(androiddriver);
			act.clickAndHold(imgs.get(i)).perform();
		}
		click(BTN_REMOVE);
		waitUntilElementClickable(BTN_YES);
		click(BTN_YES);
		Assert.assertEquals(0, androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), "Deleting All imgs");
	}


	@Test(enabled = true, priority = 5, groups = { "P1" })
	public static void BeeKee_AgentApp_VideosminTime() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
		Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
		System.out.println("Successfully Navigated to My Gallery screen");
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_TAKE_A_VIDEO);
		clickjs(BTN_TAKE_A_VIDEO);
		Thread.sleep(1000);
		switchConext();
		if (androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").size() > 0) {
			androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").get(0).click();
		}
		androiddriver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter_button')]").click();
		Thread.sleep(4000);
		androiddriver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter_button')]").click();
		Thread.sleep(1000);
		androiddriver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'done_button')]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phbefore:---" + androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size(), phbefore + 1,
				"Verifying the vidoe upload");
	}

	@Test(enabled = true, priority = 6, groups = { "P1" })
	public static void BeeKee_AgentApp_VideosMaxTime() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
		Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
		System.out.println("Successfully Navigated to My Gallery screen");
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_TAKE_A_VIDEO);
		clickjs(BTN_TAKE_A_VIDEO);
		Thread.sleep(1000);
		switchConext();
		if (androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").size() > 0) {
			androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").get(0).click();
		}
		androiddriver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter_button')]").click();
		Thread.sleep(30000);
		waitUntilElementClickable(">//android.widget.ImageButton[contains(@resource-id,'done_button')]");
		androiddriver.findElementByXPath("//android.widget.ImageButton[contains(@resource-id,'done_button')]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phbefore:---" + androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size(), phbefore + 1,
				"Verifying the vidoe upload");
	}
	
	@Test(enabled = true, priority = 7, groups = { "P1" })
	public static void BeeKee_AgentApp_GalleryMorethanMaxVideo() throws Exception {
		takeVideo(31);
		androiddriver.closeApp();
		DriverClass.appLaunch();
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_SELECT_VIDEOS);
		clickjs(BTN_SELECT_VIDEOS);
		Thread.sleep(1000);
		switchConext();
		androiddriver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id,'media_image')])[1]")
				.click();
		androiddriver.findElementByXPath("(//android.widget.Button[contains(@resource-id,'done')])[1]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phAfter:---" + androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), phbefore);
	}

	@Test(enabled = true, priority = 8, groups = { "P1" })
	public static void BeeKee_AgentApp_GalleryVideos() throws Exception {
		takeVideo(5);
		takeVideo(5);
		DriverClass.appLaunch();
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_SELECT_VIDEOS);
		clickjs(BTN_SELECT_VIDEOS);
		Thread.sleep(1000);
		switchConext();
		for (int i = 1; i <= 5 - phbefore; i++) {
			androiddriver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id,'media_image')])[" + i + "]").click();
		}
		androiddriver.findElementByXPath("(//android.widget.Button[contains(@resource-id,'done')])[1]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phAfter:---" + androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), 5);
	}

	@Test(enabled = true, priority = 9, groups = { "P1" })
	public static void BeeKee_AgentApp_GalleryMaxLengthVideo() throws Exception {
		takeVideo(30);
		androiddriver.closeApp();
		DriverClass.appLaunch();
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		int phbefore = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size();
		System.out.println("phbefore:---" + phbefore);
		waitUntilElementClickable(BTN_ADD_PHOTOVIDEO);
		click(BTN_ADD_PHOTOVIDEO);
		waitUntilElementClickable(BTN_SELECT_VIDEOS);
		clickjs(BTN_SELECT_VIDEOS);
		Thread.sleep(1000);
		switchConext();
			androiddriver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id,'media_image')])[1]").click();
		androiddriver.findElementByXPath("(//android.widget.Button[contains(@resource-id,'done')])[1]").click();
		switchDefaultConext();
		waitUntilElementClickable(BTN_DONE);
		click(BTN_DONE);
		waitUntilElementClickable(BTN_OK);
		click(BTN_OK);
		Thread.sleep(1000);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		System.out.println("phAfter:---" + androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size());
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_IMAGES.split(">")[1]).size(), phbefore+1);
	}
	
	@Test(enabled = true, priority = 10, groups = { "P1" })
	public static void BeeKee_AgentApp_RemoveVideos() throws Exception {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		click(LNK_RIGHTMENU_MYGALLERY);
		List<AndroidElement> imgs = androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]);
		for (int i = 0; i < imgs.size(); i++) {
			Actions act = new Actions(androiddriver);
			act.clickAndHold(imgs.get(i)).perform();
			Thread.sleep(1000);
		}
		click(BTN_REMOVE);
		waitUntilElementClickable(BTN_YES);
		click(BTN_YES);
		Thread.sleep(2000);
		Assert.assertEquals(androiddriver.findElementsByXPath(ST_VIDEOS.split(">")[1]).size(),0,
				"Deleting All Videos");
	}
	

	public static void switchConext() {
		Set<String> contextNames = androiddriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		androiddriver.context((String) contextNames.toArray()[0]); // set context to
		androiddriver.context("NATIVE_APP");
	}

	public static void switchDefaultConext() {
		Set<String> contextNames = androiddriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		androiddriver.context((String) contextNames.toArray()[1]); // set context to
		androiddriver.context("WEBVIEW_com.beekee.realestate");
	}

	public static void takePhoto(int nphotos) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("appPackage", "com.android.camera2");
		cap.setCapability("appActivity", "com.android.camera.CameraLauncher");
		cap.setCapability("autoGrantPermissions", true);
		androiddriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// Reports intialization with driver
		ATUReports.setWebDriver(androiddriver);
		androiddriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").size() > 0) {
			androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").get(0).click();
		}
		for (int i = 0; i <= nphotos; i++) {
			androiddriver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'shutter_button')]")
					.click();
			Thread.sleep(1000);
		}
	}

	public static void takeVideo(int nsec) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("appPackage", "com.android.camera2");
		cap.setCapability("appActivity", "com.android.camera.VideoCamera");
		cap.setCapability("autoGrantPermissions", true);
		androiddriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// Reports intialization with driver
		ATUReports.setWebDriver(androiddriver);
		androiddriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").size() > 0) {
			androiddriver.findElementsByXPath("//android.widget.Button[normalize-space(@text)='NEXT']").get(0).click();
		}
		Actions_Android act = new Actions_Android();
		act.swipingLeftToRight();
		androiddriver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Video')]")).click();
		Thread.sleep(1000);
		androiddriver.pressKeyCode(27);
		for (int i = 1; i <= nsec; i++) {
			Thread.sleep(1000);
			if (i == nsec) {
				androiddriver.findElementById("com.android.camera2:id/shutter_button").click();
				Thread.sleep(1000);
			}
		}
	}

	public static void signInToApplication(boolean isValid, String email, String password) {
		if (isValid) {
			if(androiddriver.findElementsByXPath(LBL_DASHBOARD_DEFAULT.split(">")[1]).size()==0) {
			waitUntilElementClickable(TXT_USERNAME);
			clearAndType(TXT_USERNAME, email);
			clearAndType(TXT_PASSWORD, password);
			//Assert.assertEquals(getAttribute(BTN_EYEICON, "aria-label").equalsIgnoreCase("eye-off"), true);
			BeeKee_SignInPage.verifyRememberMeChk();
			click(BTN_SIGNIN);
			WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);
			System.out.println("Successfully logged in");
			}else {
				System.out.println("Already logged in");
			}
		} else {
			waitUntilElementClickable(TXT_USERNAME);
			clearAndType(TXT_USERNAME, email);
			clearAndType(TXT_PASSWORD, password);
			BeeKee_SignInPage.verifyRememberMeChk();
			click(BTN_SIGNIN);
			wait("2");
			System.err.println("Unable to login application, Invalid email / password");
		}

	}
	
	@AfterClass
	public static void BeeKee_AgentApp_closeApplication() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signOutFromApplication();
		tearDown();
	}

}
