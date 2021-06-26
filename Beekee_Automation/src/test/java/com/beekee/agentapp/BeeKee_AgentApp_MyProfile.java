package com.beekee.agentapp;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.DriverClass;
import com.beekee.page.BeeKee_MyProfilePage;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_MyProfile {

	@BeforeSuite
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
			BeeKee_SignInPage.signInToApplication(true, "nagent000010@yopmail.com", "Pass@123");
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(priority = 1, enabled = false, groups = { "My Profile", "P1" })
	public static void BeeKee_AgentApp_MyProfile_UploadProfilePicUsingCamera() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MyProfilePage.navigateToMyProfile();
			BeeKee_MyProfilePage.getPhoto("camera");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyProfile", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = false, groups = { "My Profile", "P1" })
	public static void BeeKee_AgentApp_MyProfile_UploadProfilePicUsingGallery() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MyProfilePage.navigateToMyProfile();
			BeeKee_MyProfilePage.getPhoto("gallery");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyProfile", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = true, groups = { "My Profile", "P1" })
	public static void BeeKee_AgentApp_MyProfile_UpdateBusinessInfo() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MyProfilePage.navigateToMyProfile();
			BeeKee_MyProfilePage.myProfile_updateBusinessInfo();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyProfile", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

}
