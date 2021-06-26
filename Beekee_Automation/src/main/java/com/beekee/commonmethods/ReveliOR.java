package com.beekee.commonmethods;

public interface ReveliOR {
	
	String TXT_MENTOR_USERNAME = "//app-mentor-login//input[@type='text']";
	String TXT_MENTOR_PASSWORD = "//app-mentor-login//input[@type='password']";

	String TXT_STUDENT_USERNAME = ">//app-student-login//input[@type='text']";
	String TXT_STUDENT_PASSWORD = ">//app-student-login//input[@type='password']";


	String BTN_LOGIN = ">//ion-button[normalize-space(text())='Login']";
	//Landing page
	String BTN_STUDENT = ">//ion-button[contains(.,'Student')]";
	String BTN_MENTOR = "//ion-button[contains(.,'Mentor')]";

	//Register Page
	String LNK_SGNUP = "//ion-text[@data-qa='sign-up']";
	String TXT_SGNUP_FIRSTNAME = "//input[@placeholder='First Name *']";
	String TXT_SGNUP_LASTNAME = "//input[@placeholder='Last Name *']";
	String TXT_SGNUP_INSTITUTEEMAIL = "//ion-input[@ng-reflect-name='email']";
	String TXT_SGNUP_PHNUMBER = "//input[@id='tel']";
	String TXT_SGNUP_TITLE = "//*[@ng-reflect-name='title']";
	String TXT_SGNUP_PWD = "//ion-input[@ng-reflect-form-control-name='password']";
	String TXT_SGNUP_CNFPWD = "//input[@placeholder='Confirm Password *']";
	String BTN_SGNUP = "//*[@id='login-btnSubmit']";

	//REVELI - LOGIN SCREEN
	String LNK_PRIVACY_POLICY = "//ion-text[contains(text(),'Privacy Policy')]";
	String LNK_TERMS_COND = "//ion-text[contains(text(),'Terms and Conditions')]";
	String LNK_SWITCHUSER = "//ion-text[contains(.,'Not a')]";

	//POST
	String POST_QUESTION = "//ion-button[contains(@class,'compose-button')]";

}
