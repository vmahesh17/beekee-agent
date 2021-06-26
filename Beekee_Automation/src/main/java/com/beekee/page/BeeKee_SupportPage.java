package com.beekee.page;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;

public class BeeKee_SupportPage extends Actions_Android {
	static String supportSuccess_msg = "Thank you for sharing your comments, we will get back to you soon.";

	public static void verifySupport() {
		navigateToHelp();
		sendkeys(TXT_TEXTAREA, "Test Auto Support");
		click(BTN_SUBMIT);
		waitUntilElementClickable(BTN_OK);
		Assert.assertEquals(getText(LBL_ALERTMSG).equals(supportSuccess_msg), true, "Success msg not match");
		click(BTN_OK);
		Assert.assertEquals(getText(LBL_SUPPORT_TITLE), "Support", "Title not match");
		System.out.println("Successfully submitted question to support team");
	}

	public static void suppportWithOutInput() {
		navigateToHelp();
		sendkeys(TXT_TEXTAREA, "");
		click(BTN_SUBMIT);
		waitUntilElementClickable(BTN_OK);
		Assert.assertEquals(getText(LBL_ALERTMSG), "Question is required");
		click(BTN_OK);
	}

	public static void navigateToHelp() {
		waitUntilElementClickable(TAB_HELP);
		click(TAB_HELP);
		Assert.assertEquals(getAttribute(TAB_HELP_ACTIVE, "class").contains("highlighted"), true, "Tab not active");
		Assert.assertEquals(getText(LBL_SUPPORT_TITLE), "Support", "Title not match");
	}

	@Test
	void TT() throws Exception {
		DriverClass.appLaunch();
		 
		 suppportWithOutInput();
	}
}
