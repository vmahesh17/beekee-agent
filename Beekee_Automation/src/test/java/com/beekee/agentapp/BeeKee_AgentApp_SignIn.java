package com.beekee.agentapp;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.page.BeeKee_SignInPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BeeKee_AgentApp_SignIn extends Actions_Android {

	@BeforeSuite
	public static void BeeKee_AgentApp_launchApplication() throws Exception {
		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			DriverClass.appLaunch();
		} catch (Exception e) {
			System.err.println("Unable to launch application" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("App Launch", "Unable to Launch Applicatino", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(enabled = false, priority = 1, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Empty_Username_Password() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, "", "");
			String alertText = getText(LBL_ALERTMSG).replace("\n", " ");
			System.out.println("Alert Text  " + alertText);
			Assert.assertEquals(alertText, BeeKee_SignInPage.WARNING_MESSAGE[2], "Alert text not matched");
			click(BTN_OK);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Sign", "Unable to SignIn", "", "", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = false, priority = 2, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Only_Username() {
		BeeKee_SignInPage.signInToApplication(false, "newagent0000601@yopmail.com", "");
		Assert.assertEquals(getText(LBL_ALERTMSG), BeeKee_SignInPage.WARNING_MESSAGE[3], "Alert text not matched");
		click(BTN_OK);
	}

	@Test(enabled = false, priority = 3, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Only_Password() {
		BeeKee_SignInPage.signInToApplication(false, "", "Pass@123");
		Assert.assertEquals(getText(LBL_ALERTMSG), BeeKee_SignInPage.WARNING_MESSAGE[4], "Alert text not matched");
		click(BTN_OK);

	}

	@Test(enabled = false, priority = 4, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Invalid_Username_Password() {
		BeeKee_SignInPage.signInToApplication(false, "Invalid" + "newagent0000601@yopmail.com", "pass@123");
		click(BTN_OK);
	}

	@Test(enabled = false, priority = 5, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Invalid_Username_Valid_Password() {
		BeeKee_SignInPage.signInToApplication(false, "Invalid" + "newagent0000601@yopmail.com", "Pass@123");
		click(BTN_OK);
	}

	@Test(enabled = false, priority = 6, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Valid_Username_InValid_Password() {
		BeeKee_SignInPage.signInToApplication(false, "newagent0000601@yopmail.com", "pass@123");

	}

	@Test(enabled = false, priority = 7, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_Cancel_EditUsername() {
		BeeKee_SignInPage.edit_Cancel_UserName("newagent0000601@yopmail.com");
	}

	@Test(enabled = false, priority = 8, groups = { "P3" })
	public static void BeeKee_AgentApp_signIn_ShowHidePassword() {
		WaitUntilElementVisible(TXT_USERNAME);
		Assert.assertEquals(getAttribute(BTN_EYEICON, "ng-reflect-name").equalsIgnoreCase("eye-off"), true);
		System.out.println("Password show icon -> eye -off default");
		click(BTN_EYEICON);
		Assert.assertEquals(getAttribute(BTN_EYEICON, "ng-reflect-name").equalsIgnoreCase("eye"), true);
		System.out.println("Password show icon -> eye to show password");

	}

	@Test(enabled = true, priority = 9, groups = { "P1" })
	public static void BeeKee_AgentApp_signIn_Save_Username_Password() {

		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.email").trim(),
					prop.getProperty("agent.password").trim());
			BeeKee_SignInPage.signOutFromApplication();
			BeeKee_SignInPage.verifySaveUserDetails();
		} catch (Exception e) {
			System.err.println("Unable to Save user details" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Save user details", "", "", LogAs.FAILED,
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
