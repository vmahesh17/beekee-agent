package com.beekee.page;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.BeeKee_CommonActions;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_SentInvitesPage extends Actions_Android {
	static String invitationSendstatus = ">//app-invites-sent//ion-row[contains(@class,'ion-padding-bottom')][rowNo+1]//ion-img[not(contains(@class,'grey'))]//following::ion-label[1]";
	static String invitationSendDate = ">//app-invites-sent//ion-row[contains(@class,'ion-padding-bottom')][rowNo+1]//ion-img[not(contains(@class,'grey'))]//following::ion-col[@class='md hydrated'][1]//div[2]";

	@Test
	public static void verifyPendingInvites() throws Exception {

		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.email"), "Pass@123");
		BeeKee_InvitePhoneContactPage.navigateToInvitesTAB();
		//BeeKee_CommonActions.applyBeeKeeFilter("Agent");
		
		verifySendInviteAction("Resend All", true);

	}

	public static void verifySendInviteAction(String actionType, Boolean bflag) {
		
		int pendingInvites_count = Integer.parseInt(getText(LBL_PENDINGINVITES_COUNT));
		System.out.println("Invites count " + pendingInvites_count);
		if (pendingInvites_count > 0) {
			switch (actionType) {
			case "Resend":
				System.out.println("Performing Resend Action from Send Invites");
				waitAndclick(invitationSendstatus.replace("rowNo", "1"));
				waitUntilElementClickable(BTN_OK);
				Assert.assertEquals(getText(LBL_ALERTMSG), "Invitation sent successfully");
				click(BTN_OK);
				System.out.println("Successfully Resend Invitation");
				WaitUntilElementVisible(invitationSendDate.replace("rowNo", "1"));
				Assert.assertEquals(getText(invitationSendDate.replace("rowNo", "1")), getCurrentTimeAndDate(),
						"Invitation sent Time and Date not updated properly");
				break;
			case "Resend All":
				System.out.println("Performing Resend All Action from Send Invites");
				resendAllPendingInvites(bflag);
				break;
			case "Delete":
				System.out.println("Performing Delete Action from Send Invites");

				break;
			case "Delete All":
				System.out.println("Performing Delete All Action from Send Invites");
				deleteAllPendingInvites(bflag);
				break;

			default:
				System.err.println("NO Options selected");
				break;
			}

		}

		else {
			Assert.fail("No Pending Invites found for user " + pendingInvites_count);
		}
	}

	private static void resendAllPendingInvites(Boolean bflag) {
		int pendingInvites_count = Integer.parseInt(getText(LBL_PENDINGINVITES_COUNT));
		waitUntilElementClickable(BTN_RESENDALL);
		click(BTN_RESENDALL);
		WaitUntilElementVisible(LBL_ALERTMSG);
		Assert.assertEquals(getText(LBL_ALERTMSG), "Do you want to resend all the invitations?");
		if (bflag == true) {
			waitUntilElementClickable(BTN_ALERT_RESEND);
			click(BTN_ALERT_RESEND);
			WaitUntilElementVisible(BTN_OK);
			click(BTN_OK);
			waitUntilElementClickable(BTN_RESENDALL);
			

			for (int i = 1; i < pendingInvites_count; i++) {
				WaitUntilElementVisible(invitationSendDate.replace("rowNo", "" + i));
				AndroidElement l = androiddriver
						.findElement(By.xpath(invitationSendDate.split(">")[1].replace("rowNo", "" + i)));
				// Javascript executor
				((JavascriptExecutor) androiddriver).executeScript("arguments[0].scrollIntoView(true);", l);
				System.out.println(" invitess " + getText(invitationSendDate.replace("rowNo", "" + i)));
				Assert.assertEquals(getText(invitationSendDate.replace("rowNo", "" + i)), getCurrentTimeAndDate(),
						"Invitation sent Time and Date not updated properly");
			}

		} else {
			waitUntilElementClickable(BTN_ALERT_RESEND);
			click(BTN_CANCEL);
			System.out.println("Canceling the RESEND");
		}

	}

	private static void deleteAllPendingInvites(Boolean bflag) {
		waitUntilElementClickable(BTN_DELETEALL);
		click(BTN_DELETEALL);
		WaitUntilElementVisible(LBL_ALERTMSG);
		Assert.assertEquals(getText(LBL_ALERTMSG), "Do you want to delete all pending invitations?");
		if (bflag) {
			click(BTN_YES);
			System.out.println("Deleted all pending invitations from system");
		} else {
			click(BTN_NO);
			System.out.println("Canceling Deleted all ");

		}

	}

	public static Map<String, String> getPendingInvite() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("contactname", getText(""));
		map.put("invitationSendDate", getText(invitationSendDate));

		return map;

	}
	
	
	public static void verifySendInvitesPage() {
		waitUntilElementClickable(TAB_INVITES);
		click(TAB_INVITES);
		WaitUntilElementVisible(LBL_INVITES_SENT_DEFAULT);
		Assert.assertEquals(getAttribute(TAB_INVITES_SELECTED, "class").contains("selected-color"), true);
		Assert.assertEquals(isElementDisplayed(BTN_ADD_INVITE), true);
		waitUntilElementClickable(BTN_ADD_INVITE);
		click(BTN_ADD_INVITE);
		WaitUntilElementVisible(LBL_SEND_INVITE_TITLE);
		Assert.assertEquals(getText(LBL_SEND_INVITE_TITLE), "Send Invite");
		Assert.assertEquals(isElementDisplayed(IMG_SEND_INVITE_VIA_PHONECONTACT), true);
		Assert.assertEquals(getAttribute(IMG_SEND_INVITE_VIA_PHONECONTACT, "class").contains("img-invite-phone"), true);
		Assert.assertEquals(getText(LBL_SEND_INVITE_VIA_PHONECONTACT_MSG), "Invite your phone contacts");

		Assert.assertEquals(isElementDisplayed(IMG_SEND_INVITE_VIA_EMAIL), true);
		Assert.assertEquals(getAttribute(IMG_SEND_INVITE_VIA_EMAIL, "class").contains("img-invite-email"), true);
		Assert.assertEquals(getText(IMG_SEND_INVITE_VIA_EMAIL_MSG), "Invite people outside your phone contacts");

	}

	public static String getCurrentTimeAndDate() {
		Date date = new Date();
		// Pattern
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
		LocalDateTime now = LocalDateTime.now();

		String appdate = sdf.format(date).toLowerCase() + " • " + dtf.format(now);

		return appdate;

		// 08:10 pm • 03/16/21
	}

}
