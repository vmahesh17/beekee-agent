package com.beekee.helpers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TimeBombSkipException;

import com.beekee.commonmethods.Actions_Android;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_AccountVerification extends Actions_Android {
	static String TITLE[] = { "Account Verification", "Sign Up" };

	public static void accountVerification(String action, String actionType, String username, String pwd,
			String cnfpwd) {

		WaitUntilElementVisible(LBL_ACCOUNTVERIFICATION_TITLE);
		Assert.assertEquals(getText(LBL_ACCOUNTVERIFICATION_TITLE).trim(), TITLE[0], "Title text not matched");
		List<AndroidElement> list_securityCode = androiddriver.findElementsByXPath(LST_SECURITYCODE);

		if (action.equalsIgnoreCase("SignUp")) {

			if (actionType.equalsIgnoreCase("Valid")) {
				System.out.println("Verifying valid OTP");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				waitUntilElementClickable(TXT_MYCOMPANY);
				if (isElementDisplayed(">//div[contains(@class,'title')]")) {
					System.out.println("Completed successfully, congratulations!");
					isElementDisplayed(">//div[contains(@class,'title')]");
					waitUntilElementClickable(TXT_MYCOMPANY);
					sendkeys(TXT_MYCOMPANY, "Auto Test");
					click(BTN_SAVE);
					WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);
					System.out.println("Successfully completed and navigated to Dashboard");

				} else {
					Assert.fail("Unable to Complete SignUp");
				}

			} else if (actionType.equalsIgnoreCase("Invalid")) {
				System.out.println("Verifying Invalid OTP");
				String[] requiredOTP = random4DigitIntegerValue().split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				wait("3");

			} else if (actionType.equalsIgnoreCase("Resend")) {
				System.out.println("Verifying Resend OTP");
				WaitUntilElementVisible(LNK_RESEND);
				click(LNK_RESEND);
				waitUntilElementClickable(BTN_SEND);
				Assert.assertEquals(
						getAttribute(">//ion-input[@formcontrolname='email']", "class").contains("has-value"), true);
				Assert.assertEquals(
						getAttribute(">//ion-input[@formcontrolname='phoneNumber']", "class").contains("has-value"),
						true);
				click(BTN_SEND);
				WaitUntilElementVisible(LBL_ALERTMSG);
				Assert.assertEquals(getText(LBL_ALERTMSG),
						"We have sent you a new code! Please check your email or SMS and enter the new code before it expires");
				click(BTN_OK);
				wait("5");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				waitUntilElementClickable(TXT_MYCOMPANY);
				if (isElementDisplayed(">//div[contains(@class,'title')]")) {
					System.out.println("Completed successfully, congratulations!");
					isElementDisplayed(">//div[contains(@class,'title')]");
					sendkeys(TXT_MYCOMPANY, "Auto Test");
					click(BTN_SAVE);
					WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);
					System.out.println("Successfully completed and navigated to Dashboard");

				} else {
					Assert.fail("Unable to Complete SignUp");
				}

			} else if (actionType.equalsIgnoreCase("Code Expired")) {
				System.out.println("Verifying Code expire OTP");
				androiddriver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

				WaitUntilElementVisible(LBL_TIMEOUT);
				Assert.assertEquals(getText(LBL_TIMEOUT), "00:00");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				waitUntilElementClickable(LBL_ALERTMSG);
				System.out.println("Code Expired alert " + getText(LBL_ALERTMSG));
				Assert.assertEquals(getText(LBL_ALERTMSG).contains("expire"), true);
				click(BTN_OK);

			}

		} else if (action.equalsIgnoreCase("Forgot Password")) {

			if (actionType.equalsIgnoreCase("Valid")) {
				System.out.println("Verifying valid OTP");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				WaitUntilElementVisible(TXT_NEWPASSWORD);
				if (isElementDisplayed(LBL_NEWPASSWORD_TITLE)) {
					WaitUntilElementVisible(LBL_NEWPASSWORD_TITLE);
					Assert.assertEquals(getText(LBL_NEWPASSWORD_TITLE), "Please set a new password");
					sendkeys(TXT_NEWPASSWORD, pwd);
					sendkeys(TXT_REENTER_NEWPASSWORD, cnfpwd);
					click(BTN_CHANGEPASSWORD);
					WaitUntilElementVisible(LBL_ALERTMSG);
					if (getText(LBL_ALERTMSG).contains("Password reset successfully. Please login with new password")) {
						click(BTN_OK);
						WaitUntilElementVisible(TXT_USERNAME);
						System.out.println("Password reset successfully");
					} else {
						System.err.println("Unable to reset password");
						waitAndclick(BTN_OK);
						Assert.fail("Unable to reset password, Please correct the password");

					}
				}

			} else if (actionType.equalsIgnoreCase("Invalid")) {
				System.out.println("Verifying Invalid OTP");
				String[] requiredOTP = random4DigitIntegerValue().split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				waitUntilElementClickable(BTN_OK);
				Assert.assertEquals(getText(LBL_ALERTMSG).contains("invalid code"), true);
				click(BTN_OK);

			} else if (actionType.equalsIgnoreCase("Resend")) {
				System.out.println("Verifying Resend OTP");
				WaitUntilElementVisible(LNK_RESEND);
				click(LNK_RESEND);
				waitUntilElementClickable(BTN_SEND);
				Assert.assertEquals(
						getAttribute(">//ion-input[@formcontrolname='email']", "class").contains("has-value"), true);
				Assert.assertEquals(
						getAttribute(">//ion-input[@formcontrolname='phoneNumber']", "class").contains("has-value"),
						true);
				click(BTN_SEND);
				WaitUntilElementVisible(LBL_ALERTMSG);
				Assert.assertEquals(getText(LBL_ALERTMSG),
						"We have sent you a new code! Please check your email or SMS and enter the new code before it expires");
				click(BTN_OK);
				wait("5");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				WaitUntilElementVisible(TXT_NEWPASSWORD);
				if (isElementDisplayed(LBL_NEWPASSWORD_TITLE)) {
					WaitUntilElementVisible(LBL_NEWPASSWORD_TITLE);
					Assert.assertEquals(getText(LBL_NEWPASSWORD_TITLE), "Please set a new password");
					sendkeys(TXT_NEWPASSWORD, pwd);
					sendkeys(TXT_REENTER_NEWPASSWORD, cnfpwd);
					click(BTN_CHANGEPASSWORD);
					WaitUntilElementVisible(LBL_ALERTMSG);
					if (getText(LBL_ALERTMSG).contains("Password reset successfully. Please login with new password")) {
						click(BTN_OK);
						WaitUntilElementVisible(TXT_USERNAME);
						System.out.println("Password reset successfully");
					} else {
						System.err.println("Unable to reset password");
						Assert.fail("Unable to reset password");

					}
				}

			} else if (actionType.equalsIgnoreCase("Code Expired")) {
				System.out.println("Verifying Code expire OTP");
				androiddriver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

				WaitUntilElementVisible(LBL_TIMEOUT);
				Assert.assertEquals(getText(LBL_TIMEOUT), "00:00");
				String OTP = API_Yopmail.getOTPYopMail(username);
				String[] requiredOTP = OTP.split("");
				for (int i = 0; i < list_securityCode.size(); i++) {
					list_securityCode.get(i).sendKeys(requiredOTP[i]);
				}
				waitUntilElementClickable(LBL_ALERTMSG);
				System.out.println("Code Expired alert " + getText(LBL_ALERTMSG));
				Assert.assertEquals(getText(LBL_ALERTMSG).contains("expire"), true);
				click(BTN_OK);

			}

		}

	}

	public static String random4DigitIntegerValue() {
		Random random = new Random();
		int randomOTP = random.nextInt(5243);
		return "" + randomOTP;

	}

	protected static String[] getOTPValue() {
		String OTP = API_Yopmail.getOTPYopMail(prop.getProperty("agent.username"));
		String[] requiredOTP = OTP.split("");
		return requiredOTP;

	}

	// Code Expired alert Your code has expired. Please check your email and enter
	// the new code before it expires

}
