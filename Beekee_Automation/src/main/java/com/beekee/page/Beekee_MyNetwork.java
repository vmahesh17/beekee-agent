package com.beekee.page;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;

import io.appium.java_client.android.AndroidElement;

public class Beekee_MyNetwork extends Actions_Android {
	static String[] usertype = { "Homeowner", "Professional", "Real Estate Agent" };
	static String[] userIcon = { "homeowner", "professional", "agent" };

	public static void navigateToMyNetwork() {
		waitUntilElementClickable(LBL_DASHBOARD_DEFAULT);
		click(TAB_MYNETWORK);
		// assertEquals(getAttribute(TAB_MYNETWORK, "class").contains("active"), true);
		System.out.println("Successfully navigated to MY NETWORK");

	}

	public static void verifyMyNetworkUsers(String userType, String userIcon) {

		WaitUntilElementVisible(IMG_MYNETWORK_USER_EXPAND_STATUS.replace("usertype", userType));
		Boolean usermodule_expand = getAttribute(IMG_MYNETWORK_USER_EXPAND_STATUS.replace("usertype", userType), "name")
				.contains("up");
		if (usermodule_expand) {
			System.out.println("Module expanded default for user " + userType);
		} else {
			System.out.println("Module not expanded default for user " + userType);
			click(IMG_MYNETWORK_USER_EXPAND_STATUS.replace("usertype", userType));
		}
		List<AndroidElement> list_users_mynetwork = androiddriver
				.findElementsByXPath(LBL_LST_MYNETWORK_USERS.replace("usertype", userType).split(">")[1]);
		if (list_users_mynetwork.size() > 0) {
			for (AndroidElement username : list_users_mynetwork) {
				// Javascript executor
				wait("2");
				((JavascriptExecutor) androiddriver).executeScript("arguments[0].scrollIntoView(true);", username);

				System.out.println("Available user " + userType + " --> " + username.getText());

//				Assert.assertEquals(
//						isElementDisplayed(
//								IMG_LST_MYNETWORK_ICON.replace("usertype", userType).replace("userIcon", userIcon)),
//						true);
			}
			scrollJS(IMG_MYNETWORK_USER_EXPAND_STATUS.replace("usertype", userType));
			click(IMG_MYNETWORK_USER_EXPAND_STATUS.replace("usertype", userType));

		} else {
			Assert.fail("No users are available " + list_users_mynetwork.size());
		}
	}

	public static void verifyInvite_From_MyNetwork(String invitationType, String userType) {

		System.out.println("Returning DASHBAOARD " + returnInvitesMustZero());
		navigateToMyNetwork();

		WaitUntilElementVisible(BTN_INVITE);
		if (getText(LBL_ALERTHEAD_MSG).contains("Let's grow your network!")) {
			System.out.println("No users are available, Please click Invite");
			waitUntilElementClickable(BTN_INVITE);
			click(BTN_INVITE);
			if (invitationType.equalsIgnoreCase("phonecontact")) {
				BeeKee_InvitePhoneContactPage.invitePhoneContact(userType);
			} else {
				BeeKee_InviteEmailContactPage.verifyInviteViaEmail_InviteNewUser("Test", userType);
			}

		} else {
			Assert.fail("Please take fresh user to perform ");
		}
	}

	public static Boolean returnInvitesMustZero() {
		WaitUntilElementVisible(LBL_DASHBOARD_DEFAULT);
		List<AndroidElement> list_dashboard_userCount = androiddriver
				.findElementsByXPath("//app-dashboard//div[contains(@class,'padding-top-0')]//ion-item//label");
		
		System.out.println("User list " + list_dashboard_userCount.size());

		Iterator<AndroidElement> eachCount = list_dashboard_userCount.iterator();
		Boolean bFlag = true;

//		while (eachCount.hasNext()) {
//			if()
//			String values = eachCount.next().getText().trim();
//
//			if (values.equals("0")) {
//
//				System.out.println("Count zero");
//				return true;
//			} else {
//				System.out.println(" count not equals to zero");
//				return false;
//			}

//		}
//

		for (int i = 0; i < list_dashboard_userCount.size(); i++) {
			if (bFlag == true) {
				if (Integer.parseInt(list_dashboard_userCount.get(i).getText().trim()) == 0) {

					System.out.println(i);
					if(i==2)
					return true;
				}
			} else {
				bFlag = false;
				return false;
			}

		}

		return false;

	}

	@Test
	void Test() throws Exception {
		DriverClass.appLaunch();
		//BeeKee_SignInPage.signInToApplication(true, "nagent000010@yopmail.com", "Pass@123");
		System.out.println("Dash " + returnInvitesMustZero());
		// verifyInvite_From_MyNetwork("emailcontact", "agent");
		// verifyInvite_From_MyNetwork("emailcontact", "agent");

		// verifyMyNetworkUsers(usertype[0], userIcon[0]);

//		verifyMyNetworkUsers(usertype[1], userIcon[1]);
//		
//		verifyMyNetworkUsers(usertype[2], userIcon[2]);

	}

}

//List<String> lcount_invites = new ArrayList<String>();
//
//for (int i = 0; i < list_dashboard_userCount.size(); i++) {
//	String invitescount = list_dashboard_userCount.get(i).getText().trim();
//	lcount_invites.add(invitescount);
//}
