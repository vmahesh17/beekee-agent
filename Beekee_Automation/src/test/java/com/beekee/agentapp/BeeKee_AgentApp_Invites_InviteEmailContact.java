package com.beekee.agentapp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_InviteEmailContactPage;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_MenuNavigationPage;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_Invites_InviteEmailContact extends Actions_Android {

	@BeforeTest
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
			BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.email"),
					prop.getProperty("agent.password") +10);
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(priority = 1, enabled = true, groups = { "SentInvites_EmailContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InviteEmailContact_AgentUser() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", "agent");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = true, groups = { "SentInvites_EmailContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InviteEmailContact_HomeOwner() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			//BeeKee_MenuNavigationPage.navigateToDashboard();
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", "homeowner");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = true, groups = { "SentInvites_EmailContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InviteEmailContact_Professional() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", "professional");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
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
