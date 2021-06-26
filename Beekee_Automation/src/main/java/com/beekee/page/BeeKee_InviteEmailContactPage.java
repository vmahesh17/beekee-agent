package com.beekee.page;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;

public class BeeKee_InviteEmailContactPage extends Actions_Android {

	static String[] WARNING = { "This user is not part of BeeKee system. Please invite him to join BeeKee app" };

	public static void verifyInviteViaEmail_InviteNewUser(String searchuser, String usertype) {
		String emailContact_lname = "Auto";
		// BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
		//BeeKee_InvitePhoneContactPage.verifySendInvitesPage();
		click(IMG_SEND_INVITE_VIA_EMAIL);
		WaitUntilElementVisible(TXT_SEARCHBAR_BEEKEESYSTEM);
		ClearAndTYPE(TXT_SEARCHBAR_BEEKEESYSTEM, searchuser);

		waitUntilElementClickable(LNK_INVITE_NEW_USER);
		click(LNK_INVITE_NEW_USER);
		WaitUntilElementVisible(LBL_INVITEVIAEMAIL_WARNING);
		Assert.assertEquals(getText(LBL_INVITEVIAEMAIL_WARNING), WARNING[0]);
		Assert.assertEquals(getAttribute(TXT_INVITEVIAEMAIL_FIRSTNAME, "class").contains("has-value"), true);
		sendkeys(TXT_INVITEVIAEMAIL_LASTNAME, emailContact_lname);
		sendkeys(TXT_INVITEVIAEMAIL_PHONENUMBER, "9878676789");
		sendkeys(TXT_INVITEVIAEMAIL_EMAIL, searchuser + emailContact_lname + "@yopmail.com");
		waitUntilElementClickable(TXT_INVITEVIAEMAIL_INVITATIONTYPE.replace("usertype", usertype));
		click(TXT_INVITEVIAEMAIL_INVITATIONTYPE.replace("usertype", usertype));
		waitUntilElementClickable(BTN_SEND_INVITE);
		click(BTN_SEND_INVITE);
		waitUntilElementClickable(BTN_OK);
		Assert.assertEquals(getText(LBL_ALERTMSG), "Invitation sent successfully");
		click(BTN_OK);

	}

	
	@Test
	void dd() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, "nagent000010@yopmail.com", "Pass@123");
		BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
		verifyInviteViaEmail_InviteNewUser("Test", "agent");
	}

}
