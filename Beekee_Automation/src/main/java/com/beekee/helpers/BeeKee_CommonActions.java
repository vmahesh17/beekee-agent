package com.beekee.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.beekee.commonmethods.Actions_Android;

import io.appium.java_client.android.AndroidElement;

public class BeeKee_CommonActions extends Actions_Android {
	public static String getBeeKeeAppVersion() {
		String appVersion = "";
		String cmd = "adb shell dumpsys package com.beekee.realestate |grep versionName";
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmd);
			appVersion = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
			// System.out.println("appVersion = " + appVersion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appVersion;
	}

	public static void applyBeeKeeFilter(String filters) {
		waitUntilElementClickable(BTN_FILTER);
		click(BTN_FILTER);
		Assert.assertEquals(getText(LBL_FILTER_TITLE), "Filter & Sort");	
		click(BTN_FILTER_CLEAR);
		if (filters.equalsIgnoreCase("Agent")) {
			click(LBL_FILTER_USERTYPE.replace("usertype", "Agent"));
			Assert.assertEquals(getAttribute(LBL_FILTER_USERTYPE_SELECTION.replace("usertype", "Agent"), "name")
					.contains("checkmark"), true, "Agent Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("Agent Filter applied");
			waitUntilElementClickable(BTN_FILTER);
			Assert.assertEquals(getText(LBL_FILTER_APPLIED_USERTYPE.replace("usertype", "Agent")).trim(), "Real Estate Agents");
			

		} else if (filters.equalsIgnoreCase("Homeowner")) {
			click(LBL_FILTER_USERTYPE.replace("usertype", "Homeowner"));
			Assert.assertEquals(getAttribute(LBL_FILTER_USERTYPE_SELECTION.replace("usertype", "Homeowner"), "name")
					.contains("checkmark"), true, "Homeowner Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("Homeowner Filter applied");
		}

		else if (filters.equalsIgnoreCase("ServiceProviders")) {
			click(LBL_FILTER_USERTYPE.replace("usertype", "Providers"));
			Assert.assertEquals(getAttribute(LBL_FILTER_USERTYPE_SELECTION.replace("usertype", "Providers"), "name")
					.contains("checkmark"), true, "Providers Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("Providers Filter applied");
		}

		else if (filters.equalsIgnoreCase("Today")) {
			click(LBL_FILTER_FILTERBYTIME.replace("filterby", "Today"));
			Assert.assertEquals(getAttribute(LBL_FILTER_FILTERBYTIME_SELECTION.replace("filterby", "Today"), "name")
					.contains("checkmark"), true, "Today Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("Today Filter applied");
		}

		else if (filters.equalsIgnoreCase("This Week")) {
			click(LBL_FILTER_FILTERBYTIME.replace("filterby", "This Week"));
			Assert.assertEquals(getAttribute(LBL_FILTER_FILTERBYTIME_SELECTION.replace("filterby", "This Week"), "name")
					.contains("checkmark"), true, "This Week Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("This Week Filter applied");
		} else if (filters.equalsIgnoreCase("This Month")) {
			click(LBL_FILTER_FILTERBYTIME.replace("filterby", "This Month"));
			Assert.assertEquals(
					getAttribute(LBL_FILTER_FILTERBYTIME_SELECTION.replace("filterby", "This Month"), "name")
							.contains("checkmark"),
					true, "This Month Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("This Month Filter applied");
		} else if (filters.equalsIgnoreCase("Last 3 Months")) {
			click(LBL_FILTER_FILTERBYTIME.replace("filterby", "Last 3 Months"));
			Assert.assertEquals(
					getAttribute(LBL_FILTER_FILTERBYTIME_SELECTION.replace("filterby", "Last 3 Months"), "name")
							.contains("checkmark"),
					true, "Last 3 Months Filter not applied");
			waitUntilElementClickable(BTN_FILTER_APPLY);
			click(BTN_FILTER_APPLY);
			System.out.println("Last 3 Months Filter applied");
		}

	}
	
	public static String  getUserName() {
		// String str = "We sent a code to your ar122@yopmail.com & (998) 899-0000.";
		waitUntilElementClickable(LBL_ALERTMSG);
		String username="";
		//String s = "We sent a code to your ar122@yopmail.com & (998) 899-0000.";
		String email = getText(LBL_ALERTMSG);
		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(email);
		while (m.find()) {
			System.out.println(m.group());
			username =m.group().split("@")[0];
			
		}
		System.out.println("fetching username " + username);
		return username;

	}
	
	public static String verifyToastMessage(String sParentTagName, String textmsg) throws Exception {
        AndroidElement ele=androiddriver.findElementByTagName(sParentTagName);//"ion-toast"
        JavascriptExecutor js= (JavascriptExecutor)androiddriver;
        WebElement shadowDom=(WebElement)js.executeScript("return arguments[0].shadowRoot",ele);
        String toastmsg=shadowDom.findElement(By.cssSelector(".toast-message")).getText();
        Assert.assertEquals(toastmsg, textmsg);
        System.out.println(toastmsg);
		return toastmsg;
    }

}
