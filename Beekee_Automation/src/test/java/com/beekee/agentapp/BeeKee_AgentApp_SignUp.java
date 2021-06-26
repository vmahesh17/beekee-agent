package com.beekee.agentapp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_SignUpPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_SignUp extends Actions_Android {

	@BeforeSuite
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(priority = 10, enabled = false, groups = { "SignUp", "P1" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_WithOutReferralCode() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Valid", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 11, enabled = false, groups = { "SignUp", "P1" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_WithReferralCode() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, true, "Valid", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	@Test(priority = 13, enabled = false, groups = { "SignUp", "P2" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_UserAlreadyExists() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(false, false, "Valid", "Old");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}


	@Test(priority = 11, enabled = true, groups = { "SignUp", "P3" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_InValidAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "InValid", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 11, enabled = false, groups = { "SignUp", "P3" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_ResendAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Resend", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 11, enabled = false, groups = { "SignUp", "P3" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_CodeExpireAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Resend", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 12, enabled = false, groups = { "SignUp", "P2" })
	public static void BeeKee_AgentApp_SignUpWithInValidDetails() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(false, false, "Valid", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	
	@AfterSuite
	public static void BeeKee_AgentApp_closeApplication() throws Exception {
		try {

		} catch (Exception e) {
			System.err.println("Unable to close application");
			String activity = androiddriver.currentActivity();
			if (!activity.contains(prop.getProperty("app.activity"))) {
				System.err.println("App Crashed " + e);
				Android_Logs.captureLog(androiddriver, "Beekee_AgentApp");
			}
		} finally {
			System.out.println("App closing > " + new Exception().getStackTrace()[0].getMethodName());
			tearDown();
		}
	}

}
