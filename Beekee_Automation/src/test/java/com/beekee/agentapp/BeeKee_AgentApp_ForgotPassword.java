package com.beekee.agentapp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_ForgotPasswordPage;
import com.beekee.page.BeeKee_SignInPage;
import com.beekee.page.BeeKee_SupportPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_ForgotPassword extends Actions_Android {

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

	@Test(priority = 1, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_NoUserExists() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword("11" + prop.getProperty("agent.username"), "Valid",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
			androiddriver.navigate().back();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_InvalidAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Invalid",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_ResendAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Resend",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 4, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_CodeExpiredAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Code Expired",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 5, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_ValidAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Valid",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 6, enabled = false, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_SamePasswordInput() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Valid",
					prop.getProperty("agent.password") + 10, prop.getProperty("agent.confirmpassword") + 10);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 7, enabled = true, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_DifferentPasswordInput() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword(prop.getProperty("agent.newuser"), "Valid",
					prop.getProperty("agent.password") + 11, prop.getProperty("agent.confirmpassword") + 10);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@AfterSuite
	public static void BeeKee_AgentApp_closeApplication() throws Exception {
		try {
			//BeeKee_SignInPage.signOutFromApplication();
//			androiddriver.resetApp();
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
