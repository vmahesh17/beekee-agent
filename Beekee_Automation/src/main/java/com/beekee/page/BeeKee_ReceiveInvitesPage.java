package com.beekee.page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.BeeKee_CommonActions;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_ReceiveInvitesPage extends Actions_Android {

	public static void navigateToInvites_ReceiveInvites() {

		waitUntilElementClickable(LBL_INVITES_RECEIVED);
		click(LBL_INVITES_RECEIVED);
		assertEquals(getAttribute(LBL_INVITES_RECEIVED, "class").contains("color-white"), true);
	}

	public static void verifyReceivedInvitesAction(String action) {
		WaitUntilElementVisible(LBL_PENDINGINVITES_COUNT);
		int pendingInvites_count = Integer.parseInt(getText(LBL_PENDINGINVITES_COUNT));
		if (pendingInvites_count > 0) {
			System.out.println("pending count is " + pendingInvites_count);
			List<AndroidElement> list_acceptbutton = androiddriver.findElementsByXPath(BTN_ACCEPT.split(">")[1]);
			List<AndroidElement> list_declinebutton = androiddriver.findElementsByXPath(BTN_DECLINE.split(">")[1]);
			if (action.equalsIgnoreCase("Accept") && list_acceptbutton.size() > 0) {
				list_acceptbutton.get(0).click();
				System.out.println("Performed HandShake Invitation Accepted");
			} else if (action.equalsIgnoreCase("Decline") && list_declinebutton.size() > 0) {
				list_declinebutton.get(0).click();
				System.out.println("Performed HandShake Invitation Declined");
			} else {
				waitUntilElementClickable(BTN_ACCEPTALL);
				click(BTN_ACCEPTALL);
				System.out.println("Performed Accepted All received invitations ");
			}

		} else {
			Assert.fail("No Pending Received Invites to perform Accept/Decline  " + pendingInvites_count);
		}
	}

	
	public static void fil() throws Exception {

		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, "newagent0000601@yopmail.com", "Pass@123");
		navigateToInvites_ReceiveInvites();
		BeeKee_CommonActions.applyBeeKeeFilter("Agent");
		BeeKee_CommonActions.applyBeeKeeFilter("Homeowner");
		BeeKee_CommonActions.applyBeeKeeFilter("ServiceProviders");

		BeeKee_CommonActions.applyBeeKeeFilter("Today");
		BeeKee_CommonActions.applyBeeKeeFilter("This Week");
		BeeKee_CommonActions.applyBeeKeeFilter("This Month");
		BeeKee_CommonActions.applyBeeKeeFilter("Last 3 Months");
		verifyReceivedInvitesAction("Accept");
	}

}
