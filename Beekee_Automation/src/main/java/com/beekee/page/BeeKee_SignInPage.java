package com.beekee.page;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.API_Yopmail;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_SignInPage extends Actions_Android {

	public static String WARNING_MESSAGE[] = { "Are you sure you want to logout?",
			"Verification email sent. Please check your email and enter the code to reset your password.",
			"Invalid Email Password is required", "Password is required", "Invalid Email" };
	static String TITLE[] = { "Account Verification", "Sign Up" };

	public static void signInToApplication(boolean isValid, String email, String password) {
		if (isValid) {
			waitUntilElementClickable(TXT_USERNAME);
			clearAndType(TXT_USERNAME, email);
			clearAndType(TXT_PASSWORD, password);
			// Assert.assertEquals(getAttribute(BTN_EYEICON,
			// "aria-label").equalsIgnoreCase("eye-off"), true);
			// verifyRememberMeChk();
			click(BTN_SIGNIN);
			WaitUntilElementInvisible(SPINNER_PROCESSING);
			//WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);
			System.out.println("Successfully logged in");
		} else {
			waitUntilElementClickable(TXT_USERNAME);
			clearAndType(TXT_USERNAME, email);
			clearAndType(TXT_PASSWORD, password);
			verifyRememberMeChk();
			click(BTN_SIGNIN);
			WaitUntilElementInvisible(SPINNER_PROCESSING);
			System.err.println("Unable to login application, Invalid email / password");
		}

	}

	public static void signOutFromApplication() {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		waitUntilElementClickable(BTN_LOGOUT);
		click(BTN_LOGOUT);
		waitUntilElementClickable(BTN_YES);
		Assert.assertEquals(getText(LBL_ALERTMSG), WARNING_MESSAGE[0], "Alert text not matched");
		click(BTN_YES);
		WaitUntilElementVisible(TXT_USERNAME);
		System.out.println("Successfully logged from application");
	}

	public static Boolean verifyRememberMeChk() {

		Boolean rememberMeChkbox_status = getAttribute(CHK_REMEMBERME, "class").endsWith("check");
		if (rememberMeChkbox_status) {
			System.out.println("Remember me selected default");
		} else {
			System.err.println("Remember me not selected default");
			click(CHK_REMEMBERME);
		}

		return getAttribute(CHK_REMEMBERME, "class").endsWith("check");
	}

	public static void verifyForgorPassword(String emailforgot) {
		waitUntilElementClickable(LNK_FORGOTPASSWORD);
		click(LNK_FORGOTPASSWORD);
		if (getAttribute(LBL_TABHEADER, "ng-reflect-header-text").equalsIgnoreCase("Reset Password")) {
			System.out.println("Navigated to Reset Password screen");
			sendkeys(TXT_EMAIL_FORGOTPASSWORD, emailforgot);
			Assert.assertEquals(getText(LBL_ALERTMSG), WARNING_MESSAGE[1], "Alert text not matched");
			click(BTN_SUBMIT);

		} else {
			System.err.println("Unable to navigate to Reset Password screen");
		}
	}

	public static void accountVerification(String actionType) {

		WaitUntilElementVisible(LBL_ACCOUNTVERIFICATION_TITLE);
		Assert.assertEquals(getText(LBL_ACCOUNTVERIFICATION_TITLE).trim(), TITLE[0], "Title text not matched");
		List<AndroidElement> list_securityCode = androiddriver.findElementsByXPath(LST_SECURITYCODE);
		if (actionType.equalsIgnoreCase("Valid")) {
			System.out.println("Verifying valid OTP");
			String OTP = API_Yopmail.getOTPYopMail(prop.getProperty("agent.username"));
			String[] requiredOTP = OTP.split("");
			for (int i = 0; i < list_securityCode.size(); i++) {
				list_securityCode.get(i).sendKeys(requiredOTP[i]);
			}
		} else if (actionType.equalsIgnoreCase("Invalid")) {
			System.out.println("Verifying Invalid OTP");
			String[] requiredOTP = random4DigitIntegerValue().split("");
			for (int i = 0; i < list_securityCode.size(); i++) {
				list_securityCode.get(i).sendKeys(requiredOTP[i]);
			}

		} else if (actionType.equalsIgnoreCase("Resend")) {
			System.out.println("Verifying Resend OTP");
			WaitUntilElementVisible(LNK_RESEND);
			click(LNK_RESEND);
			waitUntilElementClickable(BTN_SEND);
			Assert.assertEquals(getAttribute(">//ion-input[@formcontrolname='email']", "class").contains("has-value"),
					true);
			Assert.assertEquals(
					getAttribute(">//ion-input[@formcontrolname='phoneNumber']", "class").contains("has-value"), true);
			click(BTN_SEND);
			WaitUntilElementVisible(LBL_ALERTMSG);
			Assert.assertEquals(getText(LBL_ALERTMSG),
					"We have sent you a new code! Please check your email or SMS and enter the new code before it expires");
			click(BTN_OK);
			String OTP = API_Yopmail.getOTPYopMail(prop.getProperty("agent.username"));
			String[] requiredOTP = OTP.split("");
			for (int i = 0; i < list_securityCode.size(); i++) {
				list_securityCode.get(i).sendKeys(requiredOTP[i]);
			}

		} else if (actionType.equalsIgnoreCase("Code Expired")) {
			System.out.println("Verifying Code expire OTP");
			wait("5");
			WaitUntilElementVisible(LBL_TIMEOUT);
			Assert.assertEquals(getText(LBL_TIMEOUT), "00:00");
			String OTP = API_Yopmail.getOTPYopMail(prop.getProperty("agent.username"));
			String[] requiredOTP = OTP.split("");
			for (int i = 0; i < list_securityCode.size(); i++) {
				list_securityCode.get(i).sendKeys(requiredOTP[i]);
			}
		}

	}

	public static String random4DigitIntegerValue() {
		Random random = new Random();
		int randomOTP = random.nextInt(5243);
		return "" + randomOTP;

	}

	public static void edit_Cancel_UserName(String email) {
		waitUntilElementClickable(TXT_USERNAME);
		clearAndType(TXT_USERNAME, email);
		waitUntilElementClickable(BTN_CLEAR);
		click(BTN_CLEAR);
		Assert.assertEquals(!getAttribute(TXT_USERNAME, "class").contains("has-value"), true);
		System.out.println("Verified edit and cancel username field");
	}

	public static void verifySaveUserDetails() {
		String usname = ">//ion-input[@formcontrolname='username']";
		String pasword = ">//ion-input[@formcontrolname='password']";
		// UserName should be prefilled
		Assert.assertEquals(getAttribute(usname, "class").contains("has-value"), true);
		Assert.assertEquals(getAttribute(pasword, "class").contains("has-value"), true);
		Assert.assertEquals(getAttribute(CHK_REMEMBERME, "class").endsWith("check"), true);
		System.out.println("User details saved successfully");

	}

	public static void showHidePassword() {
		WaitUntilElementVisible(TXT_USERNAME);
		Assert.assertEquals(getAttribute(BTN_EYEICON, "aria-label").equalsIgnoreCase("eye off"), true);
		System.out.println("Password show icon -> eye -off default");
		click(BTN_EYEICON);
		Assert.assertEquals(getAttribute(BTN_EYEICON, "aria-label").equalsIgnoreCase("eye off"), true);
		System.out.println("Password show icon -> eye to show password");
	}

	@Test
	void TT() throws Exception {
		DriverClass.appLaunch();
		edit_Cancel_UserName(prop.getProperty("agent.email"));
	}

}
