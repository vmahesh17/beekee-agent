package com.beekee.agentapp;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_SignInPage;
import com.beekee.page.Beekee_MyNetwork;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_MyNetwork extends Actions_Android {

	@BeforeTest
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
			BeeKee_SignInPage.signInToApplication(true, "nagent00005@yopmail.com", "Pass@123");	
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(priority = 1, enabled = true, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_HomeownerUserList() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.navigateToMyNetwork();
			Beekee_MyNetwork.verifyMyNetworkUsers("Homeowner", "");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = true, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_ProfessionalUserList() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyMyNetworkUsers("Professional", "");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = true, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_AgentUserList() throws Exception { // existing with data - DATA
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.verifyMyNetworkUsers("Real Estate Agent", "");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

		
	@AfterTest
	public static void BeeKee_AgentApp_LogOutApplication() throws Exception {
		
		try {
			//BeeKee_MenuNavigationPage.navigateToDashboard();
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
