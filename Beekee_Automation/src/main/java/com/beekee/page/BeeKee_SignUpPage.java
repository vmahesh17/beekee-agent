package com.beekee.page;

import org.apache.commons.lang.RandomStringUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.Constants;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.API_Yopmail;
import com.beekee.helpers.BeeKee_AccountVerification;
import com.beekee.helpers.BeeKee_CommonActions;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class BeeKee_SignUpPage extends Actions_Android {
	public static PropertiesConfiguration conf;

	static String randomNumbers = RandomStringUtils.randomNumeric(2);
	static String randomPhoneNumber = RandomStringUtils.randomNumeric(10);

	public static void verifySignUp(Boolean isValid, Boolean required_referralCode, String accountVerificationType,
			String userType) throws ConfigurationException {
		String randomuser = prop.getProperty("agent.username") + randomNumbers;
		System.out.println("Created random user " + randomuser);
		conf = new PropertiesConfiguration(Constants.PROPERTIES_FILE);
		conf.setProperty("agent.username", randomuser);
		conf.setProperty("agent.phNumber", randomPhoneNumber);
		conf.save();

		if (isValid) {
			signUpFieldsInput(prop.getProperty("agent.fname"), prop.getProperty("agent.lname"),
					prop.getProperty("agent.title"), prop.getProperty("agent.username") + "@yopmail.com",
					prop.getProperty("agent.phNumber"), prop.getProperty("agent.streetAddess"),
					prop.getProperty("agent.city"), prop.getProperty("agent.state"), prop.getProperty("agent.zip"),
					prop.getProperty("agent.referralCode"), required_referralCode, prop.getProperty("agent.password"),
					prop.getProperty("agent.confirmpassword"), accountVerificationType, userType);

		} else {
			signUpFieldsInput("123" + prop.getProperty("agent.fname"), "123" + prop.getProperty("agent.lname"),
					prop.getProperty("agent.title"), prop.getProperty("agent.username") + "@yopmail.com",
					prop.getProperty("agent.phNumber"), prop.getProperty("agent.streetAddess"),
					prop.getProperty("agent.city"), prop.getProperty("agent.state"),
					"123" + prop.getProperty("agent.zip"), "123" + prop.getProperty("agent.referralCode"),
					required_referralCode, prop.getProperty("agent.password"),
					prop.getProperty("agent.confirmpassword"), accountVerificationType, userType);

		}

	}

	public static void signUpFieldsInput(String fname, String lname, String title, String email, String phNumber,
			String streetAddess, String city, String stateCode, String zip, String referralCode,
			Boolean required_referralCode, String password, String confirmpassword, String accountVerificationType,
			String userType) throws ConfigurationException {
		waitUntilElementClickable(BTN_SIGNUP);
		click(BTN_SIGNUP);
		WaitUntilElementVisible(LBL_SIGNUP_TITLE);
		Assert.assertEquals(getText(LBL_SIGNUP_TITLE), BeeKee_SignInPage.TITLE[1].trim(), "Title text not matched");
		sendkeys(TXT_FIRSTNAME, fname);
		sendkeys(TXT_LASTNAME, lname);
		sendkeys(TXT_BUSINESS_TITLE, title);
		if (userType.equals("New")) {
			sendkeys(TXT_EMAIL, conf.getProperty("agent.username") + "@yopmail.com");
		} else {
			sendkeys(TXT_EMAIL, conf.getProperty("agent.newuser") + "@yopmail.com");
		}

		sendkeys(TXT_PHONENUMBER, phNumber);
		sendkeys(TXT_STREETADDRESS, streetAddess);
		sendkeys(TXT_CITY, city);
		getStateList(stateCode);
		waitUntilElementClickable(TXT_ZIPCODE);
		sendkeys(TXT_ZIPCODE, zip);

		if (required_referralCode == true) {
			sendkeys(TXT_REFERRALCODE, prop.getProperty("agent.referralCode"));
		} else {
			sendkeys(TXT_REFERRALCODE, "");
		}

		wait("2");
		androiddriver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
		click(TXT_PASSWORD_SIGNUP);
		sendkeys(TXT_PASSWORD_SIGNUP, password);
		Assert.assertEquals(isElementDisplayed(ICON_SIGNUP_PASSWORD_SUCCESS), true);
		wait("2");
		click(TXT_CONFIRMPASSWORD);
		sendkeys(TXT_CONFIRMPASSWORD, confirmpassword);
		Assert.assertEquals(isElementDisplayed(ICON_SIGNUP_CONFIRMPASSWORD_SUCCESS), true);
		click(BTN_NEXT);
		WaitUntilElementVisible(LBL_ALERTMSG);
		if (getText(LBL_ALERTMSG).contains("Your OTP code has been sent to")
				|| getText(LBL_ALERTMSG).contains("We sent a code to your")) {
			System.out.println("Successfully input the fields and navigated to Account verification");
			System.out.println("Alert Text " + getText(LBL_ALERTMSG));

			String signup_username = BeeKee_CommonActions.getUserName();
			conf.setProperty("agent.username", signup_username);
			conf.save();
			waitUntilElementClickable(BTN_OK);
			click(BTN_OK);
			System.out.println(conf.getProperty("agent.username"));
			BeeKee_AccountVerification.accountVerification("SignUp", accountVerificationType,
					""+conf.getProperty("agent.username"), ""+conf.getProperty("agent.password"),
					""+conf.getProperty("agent.confirmpassword"));

		} else if (getText(LBL_ALERTMSG).contains("User already exists")) {
			System.out.println("User already exists");
			Assert.assertEquals(getText(LBL_ALERTMSG), "User already exists", "Alert not matched");
			waitAndclick(BTN_OK);

		} else {
			System.err.println("Errored out please correct the input values " + getText(LBL_ALERTMSG));
			waitAndclick(BTN_OK);
			// Assert.fail("Please correct " + getText(LBL_ALERTMSG));
		}

	}

	public static void getStateList(String selectState) {
		String state = ">//app-register//ion-select[@formcontrolname='state']";
		waitUntilElementClickable(state);
		click(state);
		waitUntilElementClickable(BTN_OK);
		List<AndroidElement> list_state = androiddriver
				.findElementsByXPath("//button[@role='radio']//div[contains(@class,'alert-radio-label')]");
		if (list_state.size() > 0) {
			for (AndroidElement states : list_state) {
				System.out.println("list of states are " + states.getText());
				if (states.getText().equalsIgnoreCase(selectState)) {
					states.click();
					System.out.println("Selected state " + states.getText());
					waitAndclick(BTN_OK);
					break;
				}
			}

		}
	}

	@Test
	public static void signup() throws Exception {
		DriverClass.appLaunch();
		verifySignUp(true, false, "Valid", "New");
	}

}
