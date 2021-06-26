package com.beekee.agentapp;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_SentInvitesPage;
import com.beekee.page.BeeKee_SignUpPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.beekee.page.BeeKee_InvitePhoneContactPage;

public class BeeKee_AgentApp_SendInvite extends Actions_Android {

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


	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESEND() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend", true);
			
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESENDALL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend All", true);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESENDALL_CANCEL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend All", false);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_DELETE() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SentInvitesPage.verifySendInviteAction("Delete", true);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_DELETEALL_CANCEL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SentInvitesPage.verifySendInviteAction("Delete Al", false);

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	
	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_VerifyPage() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInvitesPage();
			
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		
	
		}
	}	
	@Test(priority = 0, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_SearchPendingInviteUser() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.searchPendingInvites("Test");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void BeeKee_AgentApp_SendInvite_PhoneContact_Agent() {

		BeeKee_InvitePhoneContactPage.invitePhoneContact("agent");

	}

	public static void BeeKee_AgentApp_SendInvite_PhoneContact_HomeOwner() {

		BeeKee_InvitePhoneContactPage.invitePhoneContact("homeowner");

	}

	public static void BeeKee_AgentApp_SendInvite_PhoneContact_Professional() {

		BeeKee_InvitePhoneContactPage.invitePhoneContact("professional");

	}

	public static void BeeKee_AgentApp_SendInvite_EmailContact_Agent() {

		BeeKee_InvitePhoneContactPage.inviteEmailContact("agent", "");

	}

	public static void BeeKee_AgentApp_SendInvite_EmailContact_HomeOwner() {

		BeeKee_InvitePhoneContactPage.inviteEmailContact("homeowner", "");

	}

	public static void BeeKee_AgentApp_SendInvite_EmailContact_Professional() {

		BeeKee_InvitePhoneContactPage.inviteEmailContact("homeowner", "");

	}

	public static void BeeKee_AgentApp_SendInvite_Search_PendingInvite() {

		BeeKee_InvitePhoneContactPage.searchPendingInvites("");

	}

	public static void BeeKee_AgentApp_verifySendInvitesPage() {

 
	}

}
