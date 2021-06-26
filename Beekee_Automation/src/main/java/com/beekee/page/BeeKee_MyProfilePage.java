package com.beekee.page;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_MyProfilePage extends Actions_Android {

	public static void verifyMyProfile() {

	}

	public static void navigateToMyProfile() {
		waitUntilElementClickable(LBL_DASHBOARD_DEFAULT);
		click(TAB_MYPROFILE);
		wait("2");
		// Assert.assertEquals(getAttribute(TAB_MYPROFILE,
		// "class").contains("highlighted"), true);
		System.out.println("Successfully Navigated to My Profile screen");
	}

	public static void getPhoto(String photosource) throws IOException {
		waitUntilElementClickable(BTN_CAMERA);
		click(BTN_CAMERA);

		waitUntilElementClickable(BTN_MYPROFILE_CAMERA_CIRCLE);
		click(BTN_MYPROFILE_CAMERA_CIRCLE);
//		if (getText(LBL_ALERTHEAD_MSG).contains("Let's grow your network!")) {
//			WaitUntilElementVisible(ACTIONSHEET_CAMERA);
//		}

		if (photosource.equalsIgnoreCase("camera")) {
			WaitUntilElementVisible(ACTIONSHEET_CAMERA);
			clickjs(ACTIONSHEET_CAMERA);
			// clickjs(">//*[@id='ion-overlay-4']/div/div/div[1]/button[1]/span"); // WEBV
			androiddriver.pressKeyCode(61); // 61 - TAB
			wait("1");
			androiddriver.pressKeyCode(61);
			wait("1");
			androiddriver.pressKeyCode(66); // 66- ENTER
			wait("1");
			androiddriver.pressKeyCode(61);
			wait("1");
			androiddriver.pressKeyCode(66);
			// androiddriver.pressKeyCode(27);

			androiddriver.pressKeyCode(61); // 61 - TAB
			wait("1");
			androiddriver.pressKeyCode(61);
			wait("1");
			androiddriver.pressKeyCode(61);
			wait("1");
			androiddriver.pressKeyCode(61);
			wait("1");
			androiddriver.pressKeyCode(66);
		} else if (photosource.equalsIgnoreCase("gallery")) {
			WaitUntilElementVisible(ACTIONSHEET_CAMERA);
			clickjs(ACTIONSHEET_CHOOSE_FROM_GALLERY);
			wait("2");
			switchConext("NATIVE_APP");
			List<AndroidElement> list_devicefolders = androiddriver
					.findElementsById("com.google.android.apps.photos:id/title");
			System.out.println("Device folders size " + list_devicefolders.size());
			if (list_devicefolders.size() > 0) {
				System.out.println(
						"Device folders size is greater than ZERO, Number of folders" + list_devicefolders.size());
				list_devicefolders.get(1).click();
				wait("5");
				List<AndroidElement> list_photos = androiddriver.findElementsByClassName("android.view.ViewGroup");
				list_photos.get(1).click();
				switchConext("WEBVIEW_com.beekee.realestate");
				WaitUntilElementVisible(BTN_SAVE);
				System.out.println("Successfully uploaded photo from camera gallery");
				click(BTN_SAVE);
				WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);

			} else {
				Assert.fail("No folders available to upload photos");

			}

		}

	}

	public static void myProfile_updateBusinessInfo() {
		scrollJS(LBL_REFERRALCODE);
		waitUntilElementClickable(BTN_EDIT_BUSINESS_MYPROFILE);
		click(BTN_EDIT_BUSINESS_MYPROFILE);
		WaitUntilElementVisible(TXT_TEXTAREA);
		if (isElementDisplayed(LBL_MYPROFILE_BUSINESS_TITLE)) {
			System.out.println("Navigated to Business screen");
			Assert.assertEquals(getText(LBL_MYPROFILE_BUSINESS_TITLE), "Business");
			clearAndType(TXT_BUSINESS_TXNS_COMPLETED, "100");
			clearAndType(TXT_BUSINESS_ANNUAL_SALES, "50000"); // 50,000
			clearAndType(TXT_BUSINESS_AWARD_ONE, "Auto Award1");
			clearAndType(TXT_BUSINESS_AWARD_TWO, "Auto Award2");
			clearAndType(TXT_BUSINESS_AWARD_THREE, "Auto Award3");
			clearAndType(TXT_TEXTAREA, "Auto experience");
			scrollJS(BTN_NEXT);
			click(BTN_NEXT);
			WaitUntilElementVisible(BTN_DONE);
			click(BTN_MAYBELATER);
			waitUntilElementClickable(BTN_YES);
			click(BTN_YES);
			System.out.println("SUCESSFULLY UPDATED BUSINESS INFO");
		} else {
			Assert.fail("Business screen not displayed");

		}

	}

	@Test
	void pf() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, "nagent00005@yopmail.com", "Pass@123");
		navigateToMyProfile();
		// myProfile_updateBusinessInfo();
		
		getPhoto("gallery");
		
		BeeKee_SignInPage.signOutFromApplication();

	}

	public static void switchConext(String context) {
		Set<String> contextNames = androiddriver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}
		androiddriver.context((String) contextNames.toArray()[1]); // set context to
		androiddriver.context(context);
		//NATIVE_APP
		//WEBVIEW_com.beekee.realestate

	}

}

//androiddriver.pressKeyCode(25); // Capture
//wait("3");
//androiddriver.pressKeyCode(AndroidKeyCode.ENTER);
// Runtime.getRuntime().exec("adb shell input `keyevent` 27");
//	
//waitUntilElementClickable(BTN_CAMERA_SHUTTER);
//click(BTN_CAMERA_SHUTTER);
//waitUntilElementClickable(BTN_CAMERA_SHUTTER_DONE);
//click(BTN_CAMERA_SHUTTER_DONE);
