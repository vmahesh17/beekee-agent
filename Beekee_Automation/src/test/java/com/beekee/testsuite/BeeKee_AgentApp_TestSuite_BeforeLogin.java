package com.beekee.testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.Android_Logs;
import com.beekee.helpers.BeeKee_CommonActions;
import com.beekee.page.BeeKee_ForgotPasswordPage;
import com.beekee.page.BeeKee_InviteEmailContactPage;
import com.beekee.page.BeeKee_InvitePhoneContactPage;
import com.beekee.page.BeeKee_MenuNavigationPage;
import com.beekee.page.BeeKee_ReceiveInvitesPage;
import com.beekee.page.BeeKee_SentInvitesPage;
import com.beekee.page.BeeKee_SignInPage;
import com.beekee.page.BeeKee_SignUpPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;;

public class BeeKee_AgentApp_TestSuite_BeforeLogin extends Actions_Android {

	@BeforeMethod
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

	// Login
	@Test(enabled = false, priority = 1, groups = { "SignIn", "P3" })
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
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = false, priority = 2, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Only_Username() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, prop.getProperty("agent.email"), "");
			Assert.assertEquals(getText(LBL_ALERTMSG), BeeKee_SignInPage.WARNING_MESSAGE[3], "Alert text not matched");
			click(BTN_OK);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(enabled = false, priority = 3, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Only_Password() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, "", prop.getProperty("agent.password"));
			Assert.assertEquals(getText(LBL_ALERTMSG), BeeKee_SignInPage.WARNING_MESSAGE[4], "Alert text not matched");
			click(BTN_OK);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(enabled = false, priority = 4, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Invalid_Username_Password() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, "Invalid" + prop.getProperty("agent.email"),
					prop.getProperty("agent.password"));
			click(BTN_OK);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	@Test(enabled = false, priority = 5, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Invalid_Username_Valid_Password() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, "Invalid" + prop.getProperty("agent.email"),
					prop.getProperty("agent.password"));
			click(BTN_OK);
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	@Test(enabled = false, priority = 6, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Valid_Username_InValid_Password() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.email"), "pass@123");
			BeeKee_CommonActions.verifyToastMessage("ion-toast", "Invalid username / password");
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(enabled = false, priority = 7, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_Cancel_EditUsername() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.edit_Cancel_UserName(prop.getProperty("agent.email"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	@Test(enabled = false, priority = 8, groups = { "SignIn", "P3" })
	public static void BeeKee_AgentApp_signIn_ShowHidePassword() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.showHidePassword();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Perform Invalid SignIn", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	@Test(enabled = false, priority = 9, groups = { "SignIn", "P1" })
	public static void BeeKee_AgentApp_signIn_Save_Username_Password() {

		try {
			System.out.println("App launching > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignInPage.signInToApplication(false, prop.getProperty("agent.email").trim(),
					prop.getProperty("agent.password").trim());
			BeeKee_SignInPage.signOutFromApplication();
			BeeKee_SignInPage.verifySaveUserDetails();
		} catch (Exception e) {
			System.err.println("Unable to Save user details" + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignIn", "Unable to Save user details", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	} // End Login

	// SignUp
	@Test(enabled = false, priority = 10, groups = { "SignUp", "P1" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_WithOutReferralCode() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Valid", "New");
			BeeKee_SignInPage.signOutFromApplication();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = false, priority = 11, groups = { "SignUp", "P1" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_WithReferralCode() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, true, "Valid", "New");
			BeeKee_SignInPage.signOutFromApplication();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(enabled = false, priority = 12, groups = { "SignUp", "P2" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_UserAlreadyExists() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Valid", "Old");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 13, enabled = false, groups = { "SignUp", "P3" })
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

	@Test(priority = 14, enabled = false, groups = { "SignUp", "P3" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_ResendAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Resend", "New");
			BeeKee_SignInPage.signOutFromApplication();

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 15, enabled = false, groups = { "SignUp", "P3" })
	public static void BeeKee_AgentApp_SignUpWithValidDetails_CodeExpireAccountVerification() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_SignUpPage.verifySignUp(true, false, "Code Expired", "New");

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("SignUp", "Unable to signup to Application", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 16, enabled = false, groups = { "SignUp", "P2" })
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

	// EndSignUp

	// Forgot password
	@Test(priority = 17, enabled = true, groups = { "Forgot Password", "P1" })
	public static void BeeKee_AgentApp_ForgotPassword_NoUserExists() throws Exception {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_ForgotPasswordPage.verifyForgotPassword("11" + prop.getProperty("agent.newuser"), "Valid",
					prop.getProperty("agent.password"), prop.getProperty("agent.confirmpassword"));
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Forgot Password", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	@Test(priority = 18, enabled = true, groups = { "Forgot Password", "P1" })
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

	@Test(priority = 19, enabled = true, groups = { "Forgot Password", "P1" })
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

	@Test(priority = 20, enabled = true, groups = { "Forgot Password", "P1" })
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

	@Test(priority = 21, enabled = true, groups = { "Forgot Password", "P1" })
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

	@Test(priority = 22, enabled = true, groups = { "Forgot Password", "P1" })
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

	@Test(priority = 23, enabled = true, groups = { "Forgot Password", "P1" })
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

	// End forgot

	// Navigation before lgoin

	@Test(priority = 24, enabled = false, groups = { "Navigation_PrivacyPolicy", "P3" })
	public static void BeeKee_AgentApp_NavigateToPrivacyPolicyFromSignInPage() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateToPrivacyPolicyFromSignIn();

		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("Privacy Policy", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	@Test(priority = 25, enabled = false, groups = { "Navigation_T&C", "P3" })
	public static void BeeKee_AgentApp_NavigateToTermsAndConditionsFromSignInPage() {
		try {
			System.out.println("Started Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			BeeKee_MenuNavigationPage.navigateToTermsAndConditionsFromSignIn();
		} catch (Exception e) {
			System.err.println("Failed Exection for TC > " + new Exception().getStackTrace()[0].getMethodName());
			ATUReports.add("T&C", "Unable to perform forgot pasword action", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	// end navigation before login

	@AfterMethod
	public static void BeeKee_AgentApp_closeApplication() throws Exception {
		try {
			System.out.println("App closing > " + new Exception().getStackTrace()[0].getMethodName());
			tearDown();

		} catch (Exception e) {
			System.err.println("Unable to close application");
			String activity = androiddriver.currentActivity();
			if (!activity.contains(prop.getProperty("app.activity"))) {
				System.err.println("App Crashed " + e);
				Android_Logs.captureLog(androiddriver, "Beekee_AgentApp");
			}
		}
	}
}
