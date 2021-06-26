package com.beekee.page;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.API_Yopmail;
import com.beekee.helpers.BeeKee_AccountVerification;

public class BeeKee_ForgotPasswordPage extends Actions_Android {

	public static void verifyForgotPassword(String username, String actionType, String pwd, String cnfpwd) {
		waitUntilElementClickable(LNK_FORGOTPASSWORD);
		click(LNK_FORGOTPASSWORD);
		WaitUntilElementVisible(LBL_RESETPASSWORD_TITLE);
		Assert.assertEquals(getText(LBL_RESETPASSWORD_TITLE), "Reset Password");
		sendkeys(TXT_EMAIL_FORGOTPASSWORD, username + "@yopmail.com");
		waitUntilElementClickable(BTN_SUBMIT);
		click(BTN_SUBMIT);
		WaitUntilElementVisible(LBL_ALERTMSG);
		if (getText(LBL_ALERTMSG).contains("Email not found please check and enter correct email")) {
			System.err.println("Please enter valid username to reset password");
			Assert.assertEquals(getText(LBL_ALERTMSG), "Email not found please check and enter correct email.");
			waitUntilElementClickable(BTN_OK);
			click(BTN_OK);
		} else if (getText(LBL_ALERTMSG).contains("Verification email sent")) {
			System.out.println("Email verified and enter the code");
			waitUntilElementClickable(BTN_OK);
			click(BTN_OK);
			BeeKee_AccountVerification.accountVerification("Forgot Password", actionType, username, pwd, cnfpwd);
		} else {
			click(BTN_OK);
		}
	}

	@Test
	void TT() throws Exception {
		DriverClass.appLaunch();
		verifyForgotPassword(prop.getProperty("agent.newuser"), "Valid", "", "");
	}

}

//String OTP = API_Yopmail.getOTPYopMail(username);
//BeeKee_SignInPage.accountVerification(OTP);
//if (isElementDisplayed(LBL_NEWPASSWORD_TITLE)) {
//	WaitUntilElementVisible(LBL_NEWPASSWORD_TITLE);
//	Assert.assertEquals(getText(LBL_NEWPASSWORD_TITLE), "Please set a new password");
//	sendkeys(TXT_NEWPASSWORD, prop.getProperty("agent.password"));
//	sendkeys(TXT_REENTER_NEWPASSWORD, prop.getProperty("agent.confirmpassword"));
//	click(BTN_CHANGEPASSWORD);
//	WaitUntilElementVisible(LBL_ALERTMSG);
//	if (getText(LBL_ALERTMSG).contains("Password reset successfully. Please login with new password")) {
//		click(BTN_OK);
//		WaitUntilElementVisible(TXT_USERNAME);
//	} else {
//
//	}
