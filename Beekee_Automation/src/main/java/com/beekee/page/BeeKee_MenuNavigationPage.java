package com.beekee.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class BeeKee_MenuNavigationPage extends Actions_Android {

	public static void verifyMenuOptionsAvailabilty() {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);
		//Assert.assertEquals(getText(LBL_RIGHTMENU_HELLO).trim(), "Hello " + prop.getProperty("agent.fname"), "Text not matched");
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_SETTINGS), true);
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_MYPROFILE), true);
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_MYGALLERY), true);
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_TERMS_AND_CONDITIONS), true);
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_PRIVACY_POLICY), true);
		Assert.assertEquals(isElementDisplayed(LNK_RIGHTMENU_FAQ), true);
		Assert.assertEquals(isElementDisplayed(BTN_LOGOUT), true);
		System.out.println("App Version " + getText(LBL_APPVERSION));
		System.out.println("Copy rights " + getText(LBL_APP_COPYRIGHTS));
		Assert.assertEquals(getText(LBL_APP_COPYRIGHTS).trim(), "©2021 BeeKee Corp.", "Text not matched");
		androiddriver.pressKeyCode(AndroidKeyCode.BACK);
	}

	public static void navigateTo(String menuOption) {
		waitUntilElementClickable(BTN_RIGHTMENU);
		click(BTN_RIGHTMENU);

		switch (menuOption) {

		case "Settings":
			click(LNK_RIGHTMENU_SETTINGS);
			String settingslbl = ">//app-account-settings/ion-content//ion-grid/ion-row[1]/ion-col";
			Assert.assertEquals(getText(settingslbl).trim(), "Settings", "Text not matched");
			System.out.println("Successfully Navigated to Settings screen");
			break;

		case "My Profile":
			click(LNK_RIGHTMENU_MYPROFILE);
			String myProfilelbl = ">//div[contains(@class,'title')]";
			Assert.assertEquals(getText(myProfilelbl).trim(), "My Profile", "Text not matched");
			System.out.println("Successfully Navigated to My Profile screen");
			break;

		case "My Gallery":
			click(LNK_RIGHTMENU_MYGALLERY);
			String myGallerylbl = ">(//app-photos-and-videos//ion-col/label)[1]";
			Assert.assertEquals(getText(myGallerylbl).trim(), "My Gallery", "Text not matched");
			System.out.println("Successfully Navigated to My Gallery screen");
			break;

		case "Terms and Conditions":
			click(LNK_RIGHTMENU_TERMS_AND_CONDITIONS);
			String termsandconditionslbl = ">//span[@class='caption-style']";
			WaitUntilElementVisible(termsandconditionslbl);
			Assert.assertEquals(getText(termsandconditionslbl).trim(), "Terms and Conditions", "Text not matched");
			System.out.println("Successfully Navigated to Terms and Conditions screen");
			wait("10");
			break;

		case "Privacy Policy":
			click(LNK_RIGHTMENU_PRIVACY_POLICY);
			String privacypolicylbl = ">//app-privacy-policy//span[@class='caption-style']";
			WaitUntilElementVisible(privacypolicylbl);
			Assert.assertEquals(getText(privacypolicylbl).trim(), "Privacy Policy", "Text not matched");
			System.out.println("Successfully Navigated to Privacy Policy screen");
			wait("10");
			break;

		case "FAQ":
			click(LNK_RIGHTMENU_FAQ);
			String faqlbl = ">//app-faq//ion-label";
			WaitUntilElementVisible(faqlbl);
			Assert.assertEquals(getText(faqlbl).trim(), "Frequently Asked Questions", "Text not matched");
			System.out.println("Successfully Navigated to FAQ screen");
			break;

		default:
			System.err.println("NO Options selected");
			break;
		}
		wait("2");
		navigateBack();

	}

	public static void navigateToDashboard() {

		String LBL_DASHBOARD = ">//*[@id='mainContent']//ion-header/app-header-tab-view/ion-row/ion-col[1]";
		waitUntilElementClickable(LBL_DASHBOARD);
		click(LBL_DASHBOARD);
		String LBL_FOOTER_HOME = ">//app-footer-tabs//ion-icon[@name='home-outline']";
		String LBL_HOME_STATISTICS = ">(//ion-grid//ion-row[contains(@class,'padding-header-tab')]//ion-col)[1]";
		System.out.println("Get text" + getText(LBL_DASHBOARD));
		Assert.assertEquals(getAttribute(LBL_DASHBOARD, "class").contains("selected-bottom-Border"), false);
		Assert.assertEquals(getAttribute(LBL_FOOTER_HOME, "class").contains("highlighted"), true);
		Assert.assertEquals(getAttribute(LBL_HOME_STATISTICS, "class").contains("color-white"), true);

	}

	public static void navigateToMyNetwork() {
		String LBL_DASHBOARD = ">(//app-dashboard[not(contains(@class,'hidden'))]//app-header-tab-view//ion-col)[1]";

		String LBL_MYNETWORK = "//app-my-network[not(contains(@class,'hidden'))]//app-header-tab-view//ion-col[contains(@class,'selected-bottom-Border')]";
		waitUntilElementClickable(LBL_MYNETWORK);
		Assert.assertEquals(!getAttribute(LBL_MYNETWORK, "class").contains("selected-bottom-Border"), true);
		click(LBL_MYNETWORK);
		waitUntilElementClickable(LBL_MYNETWORK);
		System.out.println("get" + getAttribute(LBL_MYNETWORK, "class").contains("selected-bottom-Border"));
		// @@ @@ @@
		Assert.assertEquals(getAttribute(LBL_MYNETWORK, "class").contains("selected-bottom-Border"), false);
		Assert.assertEquals(!getAttribute(LBL_DASHBOARD, "class").contains("selected-bottom-Border"), true);
	}

	public static void navigateToPrivacyPolicyFromSignIn() {

		String LNK_PRIVACYPOLICY_SIGNINPAGE = ">//app-login//span[contains(.,'Privacy Policy')]";

		click(LNK_PRIVACYPOLICY_SIGNINPAGE);
		String privacypolicylbl = ">//app-privacy-policy//span[@class='caption-style']";
		WaitUntilElementVisible(privacypolicylbl);
		wait("10");
		List<AndroidElement> list_privacypolicy_pages = androiddriver
				.findElementsByXPath("//pdf-viewer//div[@class='page']");
		for (int i = 0; i < list_privacypolicy_pages.size(); i++) {
			wait("2");
//			System.out.println("Page loaded "
//					+ list_privacypolicy_pages.get(i).getAttribute("data-loaded").equalsIgnoreCase("true"));
		}

		Assert.assertEquals(getText(privacypolicylbl).trim(), "Privacy Policy", "Text not matched");
		System.out.println("Successfully Navigated to Privacy Policy screen");
		click(BTN_BACK);

	}

	public static void navigateToTermsAndConditionsFromSignIn() {
		String LNK_TERMSANDCOND_SIGNINPAGE = ">//app-login//span[contains(.,' Terms and Conditions ')]";

		click(LNK_TERMSANDCOND_SIGNINPAGE);
		String termsandconditionslbl = ">//span[@class='caption-style']";
		WaitUntilElementVisible(termsandconditionslbl);

		List<AndroidElement> list_TC_pages = androiddriver.findElementsByXPath("//pdf-viewer//div[@class='page']");
		for (int i = 0; i < list_TC_pages.size(); i++) {
			//list_TC_pages.get(i).getAttribute("data-loaded").equalsIgnoreCase("true");
			System.out.println("Page loaded " + list_TC_pages.get(i));
		}

		Assert.assertEquals(getText(termsandconditionslbl).trim(), "Terms and Conditions", "Text not matched");
		System.out.println("Successfully Navigated to Terms and Conditions screen");
		wait("10");
		click(BTN_BACK);
	}
	
	@Test
	void TT() throws Exception {
		DriverClass.appLaunch();
		navigateTo("Privacy Policy");
		BeeKee_SignInPage.signOutFromApplication();
		
	}

}

// Assert.assertEquals(isElementDisplayed(IMG_RIGHTMENU_MOONICON), true);
// Assert.assertEquals(isElementDisplayed(LBL_RIGHTMENU_TOGGLE_DARK_THEME),
// true);
// Assert.assertEquals(isElementDisplayed(BTN_RIGHTMENU_TOGGLE), true);
