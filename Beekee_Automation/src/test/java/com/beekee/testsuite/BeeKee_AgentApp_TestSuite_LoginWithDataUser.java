package com.beekee.testsuite;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.helpers.BeeKee_CommonActions;
import com.beekee.page.BeeKee_InviteEmailContactPage;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_MenuNavigationPage;
import com.beekee.page.BeeKee_MyProfilePage;
import com.beekee.page.BeeKee_ReceiveInvitesPage;
import com.beekee.page.BeeKee_SentInvitesPage;
import com.beekee.page.BeeKee_SignInPage;
import com.beekee.page.BeeKee_SupportPage;
import com.beekee.page.Beekee_MyNetwork;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BeeKee_AgentApp_TestSuite_LoginWithDataUser extends Actions_Android {

	@BeforeMethod
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
			BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.datauser"),
					prop.getProperty("agent.password"));
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Applicatino", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	// NAVIGATIONS

	@Test(enabled = false, priority = 1, groups = { "Menu_Navigations", "P3" })
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

	@Test(enabled = false, priority = 2, groups = { "Menu_Navigations", "P3" })
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

	@Test(enabled = false, priority = 3, groups = { "Menu_Navigations", "P3" })
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

	@Test(enabled = false, priority = 4, groups = { "Menu_Navigations", "P3" })
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

	@Test(enabled = false, priority = 5, groups = { "Menu_Navigations", "P3" })
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

	@Test(enabled = false, priority = 6, groups = { "P3" })
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

	@Test(enabled = false, priority = 7, groups = { "P3" })
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

	@Test(enabled = false, priority = 8, groups = { "P3" })
	public static void BeeKee_AgentApp_NavigateToDashboard() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateToDashboard();

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Navigations", "Unable to navigate", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	// MY NETWORK
	@Test(priority = 9, enabled = false, groups = { "My Network", "P1" })
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

	@Test(priority = 10, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_ProfessionalUserList() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.navigateToMyNetwork();
			Beekee_MyNetwork.verifyMyNetworkUsers("Professional", "");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 11, enabled = false, groups = { "My Network", "P1" })
	public static void BeeKee_AgentApp_MyNetWork_AgentUserList() throws Exception { // existing with data - DATA
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			Beekee_MyNetwork.navigateToMyNetwork();
			Beekee_MyNetwork.verifyMyNetworkUsers("Real Estate Agent", "");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyNetwork-Users", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	// INVITE VIA EMAIL CONTACT

	@Test(priority = 12, enabled = false, groups = { "SentInvites_EmailContact", "P1" })
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

	@Test(priority = 13, enabled = false, groups = { "SentInvites_EmailContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InviteEmailContact_HomeOwner() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			// BeeKee_MenuNavigationPage.navigateToDashboard();
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", "homeowner");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 14, enabled = false, groups = { "SentInvites_EmailContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InviteEmailContact_Professional() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", "professional");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	// INVITE VIA PHONE CONTACT

	@Test(priority = 15, enabled = false, groups = { "SentInvites_PhoneContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InvitePhoneContact_AgentUser() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InvitePhoneContactPage.invitePhoneContact("Agent");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 16, enabled = false, groups = { "SentInvites_PhoneContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InvitePhoneContact_HomeOwner() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InvitePhoneContactPage.invitePhoneContact("Homeowner");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 17, enabled = false, groups = { "SentInvites_PhoneContact", "P1" })
	public static void BeeKee_AgentApp_Invites_InvitePhoneContact_Professional() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_InvitePhoneContactPage.navigateToSendInvitesScreenFromInvitesTab();
			BeeKee_InvitePhoneContactPage.invitePhoneContact("Professional");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Receive Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	// SEND INVITES
	@Test(priority = 18, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESEND() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend", false);

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 19, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESENDALL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend All", false);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 20, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_RESENDALL_CANCEL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Resend All", false);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 21, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_DELETE() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Delete", false);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 22, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_DELETEALL_CANCEL() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_SentInvitesPage.verifySendInviteAction("Delete Al", false);

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 23, enabled = false, groups = { "Invites_SentInvites", "P1" })
	public static void BeeKee_AgentApp_Invites_SentInvites_VerifyPage() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
 			BeeKee_SentInvitesPage.verifySendInvitesPage();

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sent Invites", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(priority = 24, enabled = false, groups = { "Invites_SentInvites", "P1" })
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

	@Test(priority = 25, enabled = false, groups = { "Send Invites", "P2" })
	public static void BeeKee_AgentApp_SendInvites_FilterPendingInvites_FilterByUser() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());

			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_CommonActions.applyBeeKeeFilter("Agent");
			BeeKee_CommonActions.applyBeeKeeFilter("Homeowner");
			BeeKee_CommonActions.applyBeeKeeFilter("ServiceProviders");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Send Invites", "Unable to Delete All invite", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(priority = 26, enabled = false, groups = { "Send Invites", "P2" })
	public static void BeeKee_AgentApp_SendInvites_FilterPendingInvites_FilterByTimeSent() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_CommonActions.applyBeeKeeFilter("Today");
			BeeKee_CommonActions.applyBeeKeeFilter("This Week");
			BeeKee_CommonActions.applyBeeKeeFilter("This Month");
			BeeKee_CommonActions.applyBeeKeeFilter("Last 3 Months");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Send Invites", "Unable to Delete All invite", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	// RECEIVE INVITES

	@Test(priority = 27, enabled = false, groups = { "Invites_ReceiveInvites", "P1" })
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

	@Test(priority = 28, enabled = false, groups = { "Invites_ReceiveInvites", "P1" })
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

	@Test(priority = 29, enabled = false, groups = { "Invites_ReceiveInvites", "P1" })
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

	@Test(priority = 30, enabled = false, groups = { "Received Invites", "P2" })
	public static void BeeKee_AgentApp_ReceivedInvites_FilterPendingInvites_FilterByUser() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_ReceiveInvitesPage.navigateToInvites_ReceiveInvites();
			BeeKee_CommonActions.applyBeeKeeFilter("Agent");
			BeeKee_CommonActions.applyBeeKeeFilter("Homeowner");
			BeeKee_CommonActions.applyBeeKeeFilter("ServiceProviders");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Received Invites", "Unable to Delete All invite", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(priority = 31, enabled = false, groups = { "Received Invites", "P2" })
	public static void BeeKee_AgentApp_ReceivedInvites_FilterPendingInvites_FilterByTimeSent() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
			BeeKee_ReceiveInvitesPage.navigateToInvites_ReceiveInvites();
			BeeKee_CommonActions.applyBeeKeeFilter("Today");
			BeeKee_CommonActions.applyBeeKeeFilter("This Week");
			BeeKee_CommonActions.applyBeeKeeFilter("This Month");
			BeeKee_CommonActions.applyBeeKeeFilter("Last 3 Months");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Received Invites", "Unable to Delete All invite", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	// MY PROFILE

	@Test(priority = 32, enabled = true, groups = { "My Profile", "P1" })
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

	@Test(priority = 33, enabled = true, groups = { "My Profile", "P1" })
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

	@Test(priority = 34, enabled = false, groups = { "My Profile", "P1" })
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

	
	@Test(priority = 35, enabled = false, groups = { "My Profile", "P1" })
	public static void BeeKee_AgentApp_MyProfile_verifySavedBusinessInfo() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MyProfilePage.navigateToMyProfile();
			 
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("MyProfile", "Unable to perform sent invites", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
	
	// SUPPORT

	@Test(priority =36, enabled = false, groups = { "Support", "P1" })
	public static void BeeKee_AgentApp_VerifySupport_WithoutInput() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());

			BeeKee_SupportPage.suppportWithOutInput();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Support", "Unable to submit question to support team", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 37, enabled = false, groups = { "Support", "P1" })
	public static void BeeKee_AgentApp_VerifySupport_PostQuestion() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SupportPage.verifySupport();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Support", "Unable to submit question to support team", "", "", LogAs.FAILED,
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
