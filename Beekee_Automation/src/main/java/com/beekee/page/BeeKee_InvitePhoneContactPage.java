package com.beekee.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import io.appium.java_client.android.AndroidElement;

public class BeeKee_InvitePhoneContactPage extends Actions_Android {

	public static void navigateToInvitesTAB() {
		waitUntilElementClickable(TAB_INVITES);
		click(TAB_INVITES);
		WaitUntilElementInvisible(">//div[contains(@class,'loading-spinner')]");
		// WaitUntilElementVisible(LBL_INVITES_SENT_DEFAULT);
		Assert.assertEquals(getAttribute(TAB_INVITES_SELECTED, "class").contains("selected-color"), true);
		Assert.assertEquals(isElementDisplayed(BTN_ADD_INVITE), true);
		waitUntilElementClickable(BTN_ADD_INVITE);

	}
	
	public static void navigateToSendInvitesScreenFromInvitesTab() {
		waitUntilElementClickable(BTN_ADD_INVITE);
		click(BTN_ADD_INVITE);
		WaitUntilElementVisible(LBL_SEND_INVITE_TITLE);
		Assert.assertEquals(getText(LBL_SEND_INVITE_TITLE), "Send Invite");
	}

	

	public static void invitePhoneContact(String userType) {
//		waitUntilElementClickable(BTN_ADD_INVITE);
//		click(BTN_ADD_INVITE);
		waitUntilElementClickable(IMG_SEND_INVITE_VIA_PHONECONTACT);
		click(IMG_SEND_INVITE_VIA_PHONECONTACT);
		WaitUntilElementVisible(LBL_ALERTHEAD_MSG);
		if (getText(LBL_ALERTHEAD_MSG).equalsIgnoreCase("To proceed BeeKee needs to recognize your phone contacts.")) {
			waitUntilElementClickable(BTN_OK);
			click(BTN_OK);
		}
		WaitUntilElementVisible(LBL_SEND_INVITE_VIA_SMS_TITLE);
		wait("3");
		List<AndroidElement> list_phoneContacts = androiddriver.findElementsByXPath(LST_SEND_INVITE_PHONECONTACTS);

		if (list_phoneContacts.size() > 0) {
			System.out.println("List of phone contacts " + list_phoneContacts.size() + " are availble");
			userSelectionPhoneContact(userType);

		} else {
			Assert.fail("No contacts are available " + list_phoneContacts.size()
					+ " Please create phone contacts to invite users ");

		}
	}

	private static void userSelectionPhoneContact(String userType) {

		String users = "(//app-invite-via-sms//ion-grid//ion-label[contains(.,'Part of your phone contacts')]//following::ion-row[contains(@class,'contact')])//img[contains(@class,'usertype-grey')]";
		if (userType.equalsIgnoreCase("Agent")) {
			List<AndroidElement> list_active_agents = androiddriver
					.findElementsByXPath(users.replace("usertype-grey", "agent-grey"));
			System.out.println("Number of Active Agents  " + list_active_agents.size());
			list_active_agents.get(0).click();
			click(">//ion-icon[@name='checkmark']");
			System.out.println("Successfully selected Agent");

		} else if (userType.equalsIgnoreCase("homeowner")) {
			List<AndroidElement> list_active_homeowner = androiddriver
					.findElementsByXPath(users.replace("usertype-grey", "homeowner-grey"));
			System.out.println("Number of Active HomeOwners  " + list_active_homeowner.size());

			list_active_homeowner.get(0).click();
			click(">//ion-icon[@name='checkmark']");
			System.out.println("Successfully selected HomeOwner");

		} else if (userType.equalsIgnoreCase("professional")) {
			List<AndroidElement> list_active_professional = androiddriver
					.findElementsByXPath(users.replace("usertype-grey", "professional-grey"));
			System.out.println("Number of Active Professional  " + list_active_professional.size());
			list_active_professional.get(0).click();
			click(">//ion-icon[@name='checkmark']");
			System.out.println("Successfully selected Professional");

		}
		waitUntilElementClickable(BTN_SEND_INVITE);
		click(BTN_SEND_INVITE);
		WaitUntilElementVisible(BTN_ADD_INVITE);
	}

	//
	private static void userSelectionEmailContact(String userType) {

		String users = "//app-invite-via-email//ion-grid//img[contains(@class,'user-grey')]";
		if (userType.equalsIgnoreCase("Agent")) {
			List<AndroidElement> list_active_agents = androiddriver
					.findElementsByXPath(users.replace("user-grey", "agent-grey"));
			System.out.println("Number of Active Agents  " + list_active_agents.size());
			list_active_agents.get(0).click();
			System.out.println("Successfully selected Agent");

		} else if (userType.equalsIgnoreCase("homeowner")) {
			List<AndroidElement> list_active_homeowner = androiddriver
					.findElementsByXPath(users.replace("user-grey", "homeowner-grey"));
			System.out.println("Number of Active HomeOwners  " + list_active_homeowner.size());

			list_active_homeowner.get(0).click();
			click(">//ion-icon[@name='checkmark']");
			System.out.println("Successfully selected HomeOwner");

		} else if (userType.equalsIgnoreCase("professional")) {
			List<AndroidElement> list_active_professional = androiddriver
					.findElementsByXPath(users.replace("user-grey", "professional-grey"));
			System.out.println("Number of Active Professional  " + list_active_professional.size());
			list_active_professional.get(0).click();
			click(">//ion-icon[@name='checkmark']");
			System.out.println("Successfully selected Professional");

		}
		waitUntilElementClickable(BTN_SEND_INVITE);
		click(BTN_SEND_INVITE);
		waitUntilElementClickable(BTN_OK);
		Assert.assertEquals(getText(LBL_ALERTMSG), "Invitation sent successfully");
		click(BTN_OK);
		waitUntilElementClickable(BTN_SEND_INVITE);
		navigateBack();
		navigateBack();

	}

	public static void inviteEmailContact(String userType, String searchUser) {
		waitUntilElementClickable(BTN_ADD_INVITE);
		click(BTN_ADD_INVITE);
		waitUntilElementClickable(IMG_SEND_INVITE_VIA_EMAIL);
		click(IMG_SEND_INVITE_VIA_EMAIL);
//		WaitUntilElementVisible(LBL_ALERTHEAD_MSG);
//		if (getText(LBL_ALERTHEAD_MSG).equalsIgnoreCase("To proceed BeeKee needs to recognize your phone contacts.")) {
//			waitUntilElementClickable(BTN_OK);
//			click(BTN_OK);
//		}
		WaitUntilElementVisible(TXT_SEARCHBAR_BEEKEESYSTEM);
		ClearAndTYPE(TXT_SEARCHBAR_BEEKEESYSTEM, searchUser);
		WaitUntilElementInvisible(">//div[contains(@class,'loading-spinner')]");
		String emailcontacts = "//app-invite-via-email//ion-grid//ion-row[contains(@class,'ion-padding-bottom')]//div[1]";
		List<AndroidElement> list_emailContacts = androiddriver.findElementsByXPath(emailcontacts);
		for (AndroidElement userName : list_emailContacts) {
			userName.getText().contains(searchUser);
			System.out.println("Search input match with fetch result");
		}
		if (list_emailContacts.size() > 0) {
			System.out.println("Email contacts " + list_emailContacts.size());
			userSelectionEmailContact(userType);

		} else {
			Assert.fail("No contacts are available " + list_emailContacts.size()
					+ " Please create email contacts to invite users ");

		}

	}

	public static void searchPendingInvites(String searchContactname) {
		waitUntilElementClickable(TXT_SEARCHBAR);
		sendkeys(TXT_SEARCHBAR, searchContactname);
		String pending_invites = "//app-invites-sent//ion-grid[contains(@class,'ion-no-padding')]//ion-label[contains(@class,'semi-bold')]";
		List<AndroidElement> list_emailContacts = androiddriver.findElementsByXPath(pending_invites);
		int pendingInvites_count = Integer
				.parseInt(getText(">//*[contains(.,'Pending Invites:')]/following-sibling::ion-label"));
		Assert.assertEquals(pendingInvites_count, list_emailContacts.size());
		for (AndroidElement userName : list_emailContacts) {
			if (userName.getText().contains(searchContactname)) {
				System.out.println("Search input match with fetch result");
			} else {
				Assert.fail("Search results not match with search input " + userName.getText());
			}
		}
	}

	

	
	void D() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, "newagent0000601@yopmail.com", "Pass@123");
		navigateToInvitesTAB();
		searchPendingInvites("Melisa");

//		
//		inviteEmailContact("agent", "John");
//		inviteEmailContact("homeowner", "John");
//		inviteEmailContact("professional", "John");

//		invitePhoneContact("agent");
//		invitePhoneContact("homeowner");
//		invitePhoneContact("professional");
	}

}

//String agents = "(//app-invite-via-sms//ion-grid//ion-label[contains(.,'Part of your phone contacts')]//following::ion-row[contains(@class,'contact')])["
//		+ i + "]//img[contains(@class,'agent-grey')]";
//System.out.println("agents " + agents);
//List<AndroidElement> list_phonecontact_Activeagents = androiddriver.findElementsByXPath(agents);

//Boolean agentselect = !list_active_agents.get(0).getAttribute("class").contains("grey");
//Assert.assertEquals(agentselect, true, "Not selected");
