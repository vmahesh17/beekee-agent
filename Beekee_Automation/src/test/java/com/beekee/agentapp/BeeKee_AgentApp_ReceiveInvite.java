package com.beekee.agentapp;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_ReceiveInvitesPage;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_ReceiveInvite extends Actions_Android {

	@BeforeSuite
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

	@Test(priority = 1, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_ReceiveInvites_ACCEPT() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_ReceiveInvitesPage.navigateToInvites_ReceiveInvites();
			BeeKee_ReceiveInvitesPage.verifyReceivedInvitesAction("Accept");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 2, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_ReceiveInvites_DECLINE() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_ReceiveInvitesPage.navigateToInvites_ReceiveInvites();
			BeeKee_ReceiveInvitesPage.verifyReceivedInvitesAction("Decline");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 3, enabled = true, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_ReceiveInvites_ACCEPTALL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_ReceiveInvitesPage.navigateToInvites_ReceiveInvites();
			BeeKee_ReceiveInvitesPage.verifyReceivedInvitesAction("Accept All");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

}
