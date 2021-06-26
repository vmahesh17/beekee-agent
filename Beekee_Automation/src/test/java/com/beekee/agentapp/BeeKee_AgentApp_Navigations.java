package com.beekee.agentapp;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_MenuNavigationPage;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_Navigations extends Actions_Android {

	@BeforeSuite
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		DriverClass.appLaunch();
	}

	@Test(enabled = true, priority = 1, groups = { "P3" })
	public static void BeeKee_AgentApp_HumbargMenu_VerifyOptions() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.verifyMenuOptionsAvailabilty();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(enabled = true, priority = 2, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToSettings() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("Settings");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,

					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(enabled = true, priority = 3, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToMyProfile() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("My Profile");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(enabled = true, priority = 4, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToMyGallery() {

		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("My Gallery");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = true, priority = 5, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToTermsAndConditions() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("Terms and Conditions");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	@Test(enabled = true, priority = 6, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToPrivacyPolicy() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("Privacy Policy");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(enabled = true, priority = 7, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToFAQ() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateTo("FAQ");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = true, priority = 8, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToDashboard() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateToDashboard();
			BeeKee_SignInPage.signOutFromApplication();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	@AfterSuite
	public static void BeeKee_AgentApp_closeApplication() throws Exception {
		tearDown();
	}

}
