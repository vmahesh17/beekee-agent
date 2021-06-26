package com.beekee.testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_SignInPage;
import com.beekee.page.Beekee_MyNetwork;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_TestSuite_LoginWithNewUser extends Actions_Android {

	@BeforeMethod
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

	@Test(priority = 1, enabled = true, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InvitePhoneContact_Agent() throws Exception { // New user - which
																								// doesnt have any data
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("phonecontact", "Agent");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InvitePhoneContact_HomeOwner() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("phonecontact", "Homeowner");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InvitePhoneContact_Professionals() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("phonecontact", "Professional");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(priority = 4, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InviteEmailContact_Agent() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("emailcontact", "agent");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 5, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InviteEmailContact_HomeOwner() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("emailcontact", "homeowner");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 6, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_InviteEmailContact_Professionals() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyInvite_From_MyNetwork("emailcontact", "professional");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@AfterMethod
	public static void BeeKee_AgentApp_LogOutApplication() throws Exception {

		try {
			// BeeKee_MenuNavigationPage.navigateToDashboard();
			BeeKee_SignInPage.signOutFromApplication();

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
