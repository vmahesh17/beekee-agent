package com.beekee.commonmethods;

public interface BeekeeOR {
	// LOGIN
	String TXT_USERNAME = "USERNAME>//app-login//input[@placeholder='Email *']";
	String TXT_PASSWORD = "PASSWORD>//app-login//input[@placeholder='Password *']";
	String BTN_SIGNIN = "SIGNIN>//ion-button[@type='submit']";
	String BTN_EYEICON = "BTN_EYEICON>//ion-icon[contains(@class,'eye-Icon')]";
	String CHK_REMEMBERME = "CHK_REMEMBERME>//span[text()='Remember Me']/preceding::label";
	String LNK_PRIVACYPOLICY = ">//span[contains(.,'Privacy Policy')]";
	String LNK_TERMS_CONDITIONS = "LNK_TERMS_CONDITIONS>//span[contains(.,'Terms and Conditions')]";

	// COMMON
	String LBL_TABHEADER = ">//app-header-tab";
	String LBL_ALERTMSG = ">//ion-alert//div[contains(@class,'alert-message')]";
	String LBL_ALERTHEAD_MSG = ">//ion-alert//div[contains(@class,'alert-head')]";
	String BTN_YES = ">//span[text()='Yes']";
	String BTN_NO = ">//span[text()='No']";
	String BTN_OK = ">//span[contains(.,'OK') or contains(.,'Ok')]";
	String BTN_CLEAR = ">//button[contains(@class,'clear-icon')]";
	String BTN_SAVE = ">//ion-button[contains(.,'Save')]";
	String BTN_BACK = ">//ion-icon[@name='arrow-back-outline']";
	String BTN_INVITE = ">//span[text()='Invite']";
	String TXT_TEXTAREA = ">//textarea";
	String TXT_SEARCHBAR = ">//input[@type='search']";
	String BTN_FILTER = ">//img[@class='img-filter']";
	String LBL_FILTER_TITLE = ">//ion-label[contains(text(),'Filter & Sort')]";
	String LBL_FILTER_USERTYPE = ">//ion-col[contains(text(),'Filter type user ')]//following-sibling::ion-col[contains(.,'usertype')]//ion-label";
	String LBL_FILTER_USERTYPE_SELECTION = ">//ion-col[contains(text(),'Filter type user ')]//following-sibling::ion-col[contains(.,'usertype')]//ion-label/following::ion-icon";

	String LBL_FILTER_FILTERBYTIME = ">//ion-col[contains(text(),'Filter by time sent')]//following-sibling::ion-col[contains(.,'filterby')]//ion-label";
	String LBL_FILTER_FILTERBYTIME_SELECTION = ">//ion-col[contains(text(),'Filter by time sent')]//following-sibling::ion-col[contains(.,'filterby')]//ion-label/following::ion-icon";
	String BTN_FILTER_APPLY = ">//ion-button[text()='Apply']";
	String BTN_FILTER_CLEAR = ">//ion-button[text()='Clear']";
	String BTN_FILTER_CLOSE = ">//ion-icon[@name='close-outline']";
	String BTN_DONE = ">//ion-button[text()='DONE ']";
	String BTN_MAYBELATER = ">//ion-button[text()='MAYBE LATER']";
	String SPINNER_PROCESSING = ">//*[normalize-space(text())='Processing...']";

	// APPLIED

	String LBL_FILTER_APPLIED_USERTYPE = ">//ion-label[contains(.,'User Type:')]/following::ion-col/ion-label[1][contains(.,'usertype')]";
	String LBL_FILTER_APPLIED_INVITED_ON = ">//ion-label[contains(.,'Invited On:')]/following::ion-col/ion-label[1][contains(.,'invitedOn')]";

	// FOOTER
	String TAB_MYPROFILE = ">//app-footer-tabs//ion-icon[@name='person-outline']";

	// PROFILE
	String TXT_MYCOMPANY = ">//input[@placeholder='My Company *']";
	String BTN_CAMERA = ">//ion-icon[@name='camera']";
	String BTN_MYPROFILE_CAMERA_CIRCLE = ">//ion-icon[@name='add-circle']";
	String ACTIONSHEET_CAMERA = ">(//ion-action-sheet//span[contains(.,'Camera')])[1]";
	String ACTIONSHEET_CHOOSE_FROM_GALLERY = ">//ion-action-sheet//span[text()='Choose from Camera Roll']";
	String ACTIONSHEET_CANCEL = ">//ion-action-sheet//span[text()='Cancel']";

	String BTN_EDIT_PERSONAL_MYPROFILE = ">//ion-col[text()=' Personal ']//following-sibling::ion-col[text()='Edit ']";
	String LBL_MYPROFILE_TITLE = ">//div[text()=' My Profile ']";
	String LBL_REFERRALCODE = ">//*[text()=' Referral Code ']";
	String BTN_EDIT_BUSINESS_MYPROFILE = ">//ion-col[text()=' Business ']//following-sibling::ion-col[text()='Edit ']";
	String LBL_MYPROFILE_BUSINESS_TITLE = ">//label[text()='Business']";

	String TXT_BUSINESS_TXNS_COMPLETED = ">//ion-input[@formcontrolname='transactionsCompleted']/input";
	String TXT_BUSINESS_ANNUAL_SALES = ">//input[@formcontrolname='annualSales']";
	String TXT_BUSINESS_AWARD_ONE = ">//ion-input[@formcontrolname='award1']/input";
	String TXT_BUSINESS_AWARD_TWO = ">//ion-input[@formcontrolname='award2']/input";
	String TXT_BUSINESS_AWARD_THREE = ">//ion-input[@formcontrolname='award3']/input";

	String BTN_CAMERA_SHUTTER = ">//*[contains(@resource-id,'Shutter')]";
	String BTN_CAMERA_SHUTTER_DONE = ">//*[contains(@resource-id,'done_button')]";
	String BTN_CAMERA_CROP_DONE = ">//*[@text()='Done']";

	// FORGOT
	String LNK_FORGOTPASSWORD = ">//span[contains(.,'Forgot Password?')]";
	String TXT_EMAIL_FORGOTPASSWORD = ">//app-forgot-password//input";
	String LBL_RESETPASSWORD_TITLE = ">//app-forgot-password//app-header-tab//label";
	String BTN_SUBMIT = ">//ion-button[contains(.,'Submit')]";
	String TXT_NEWPASSWORD = ">(//app-reset-password//input)[1]";
	String TXT_REENTER_NEWPASSWORD = ">(//app-reset-password//input)[2]";
	String LBL_NEWPASSWORD_TITLE = ">(//app-reset-password//ion-label)[1]";
	String BTN_CHANGEPASSWORD = ">//ion-button[contains(.,'Change Password')]";

	// ACCOUNT VERIFICATION
	String LBL_ACCOUNTVERIFICATION_TITLE = ">//app-security-code/ion-content/form/ion-grid/ion-row[1]/ion-col";
	String LST_SECURITYCODE = "//input[contains(@formcontrolname,'securityCode')]";
	String LNK_RESEND = ">//ion-col[text()=' Did not get the code? ']//following::div[contains(.,'Resend')]";
	String LBL_TIMEOUT = ">//span[text()='The code expires in: ']//following::span[contains(.,'00:00')]";
	String BTN_SEND = ">//ion-button[contains(.,'Send')]";

	// SIGN UP
	String BTN_SIGNUP = ">//ion-button[contains(.,'New User Sign Up')]";
	String LBL_SIGNUP_TITLE = ">//*[text()=' Sign Up ']";
	String TXT_FIRSTNAME = ">//app-register//input[@placeholder='First Name *']";
	String TXT_LASTNAME = ">//app-register//input[@placeholder='Last Name *']";
	String TXT_BUSINESS_TITLE = ">//app-register//input[@placeholder='Business Title']";
	String TXT_EMAIL = ">//app-register//input[@placeholder='Email *']";
	String TXT_PHONENUMBER = ">//app-register//ion-item/input[@placeholder='Phone Number *']";
	String TXT_STREETADDRESS = ">//app-register//input[@placeholder='Street Address']";
	String TXT_CITY = ">//app-register//input[@placeholder='City *']";
	String TXT_STATE = ">//app-register//input[@placeholder='State *']";
	String TXT_ZIPCODE = ">//app-register//input[@placeholder='Zip Code *']";
	String TXT_REFERRALCODE = ">//app-register//input[@placeholder='Referral Code']";
	String TXT_PASSWORD_SIGNUP = ">//app-register//input[@placeholder='Password *']";
	String TXT_CONFIRMPASSWORD = ">//app-register//input[@placeholder='Confirm Password *']";
	String ICON_SIGNUP_PASSWORD_SUCCESS = ">//app-register//input[@placeholder='Password *']/following::ion-icon[1][contains(@class,'color-success')]";
	String ICON_SIGNUP_CONFIRMPASSWORD_SUCCESS = ">//app-register//input[@placeholder='Confirm Password *']/following::ion-icon[1][contains(@class,'color-success')]";
	String BTN_NEXT = ">//ion-button[contains(.,'Next') or contains(.,'NEXT')]";

	// HOME
	String LBL_DASHBOARD_DEFAULT = ">//app-header-tab-view//label[contains(@class,'selected') and contains(.,'Dashboard')]";
	String FOOTER_HOME = ">//*[not(contains(@class,'hidden'))]/app-footer-tabs//label[contains(.,'Home')]";

	// RIGHT MENU
	String BTN_RIGHTMENU = ">//*[contains(@style,'z-index') and not (contains(@aria-hidden,'true'))]//*[@menu='rightMenu']";
	String LBL_RIGHTMENU_HELLO = ">(//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-content//ion-item/ion-label)[1]";
	String IMG_RIGHTMENU_MOONICON = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-icon[@name='moon']";
	String LBL_RIGHTMENU_TOGGLE_DARK_THEME = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-icon[@name='moon']/following-sibling::ion-label";
	String BTN_RIGHTMENU_TOGGLE = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-icon[@name='moon']/following-sibling::ion-toggle";
	String LNK_RIGHTMENU_SETTINGS = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'Settings')]";
	String LNK_RIGHTMENU_MYPROFILE = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'My Profile')]";
	String LNK_RIGHTMENU_MYGALLERY = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'My Gallery')]";
	String LNK_RIGHTMENU_TERMS_AND_CONDITIONS = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'Terms and Conditions')]";
	String LNK_RIGHTMENU_PRIVACY_POLICY = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'Privacy Policy')]";
	String LNK_RIGHTMENU_FAQ = ">//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-list//ion-item[contains(.,'FAQ')]";
	String BTN_LOGOUT = ">//ion-menu/ion-content/ion-list/ion-item[contains(.,'Log Out')]";
	String LBL_APPVERSION = ">(//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-grid//ion-label)[1]";
	String LBL_APP_COPYRIGHTS = ">(//app-flyout-menu//ion-menu[@menu-id='rightMenu']//ion-grid//ion-label)[2]";

	// INVITES
	String TAB_INVITES = ">//app-dashboard//app-header-tab-view//ion-img[contains(@class,'Invites')]";
	String TAB_INVITES_SELECTED = ">//app-invites//app-header-tab-view//ion-img[contains(@class,'Invites')]/..//ion-label";
	String LBL_INVITES_SENT_DEFAULT = ">//app-invites/ion-content/ion-grid//ion-col[1][contains(@class,'color-white')]/ion-label";
	String LBL_INVITES_RECEIVED = ">//app-invites/ion-content/ion-grid//ion-col[contains(.,'Received')]";
	String BTN_ADD_INVITE = ">//app-invites-sent//ion-button[contains(@class,'btn-add-invite')]";
	String LBL_SEND_INVITE_TITLE = ">(//app-send-invite//label)[1]";
	String IMG_SEND_INVITE_VIA_PHONECONTACT = ">(//app-send-invite/ion-content/ion-grid//img)[1]";
	String LBL_SEND_INVITE_VIA_PHONECONTACT_MSG = ">(//app-send-invite/ion-content/ion-grid//img)[1]/following::label[1]";
	String LST_SEND_INVITE_PHONECONTACTS = "//app-invite-via-sms//ion-grid//ion-label[contains(.,'Part of your phone contacts')]//following::ion-row[contains(@class,'contact')]";
	String LBL_SEND_INVITE_VIA_SMS_TITLE = ">(//app-invite-via-sms//label)[1]";

	String IMG_SEND_INVITE_VIA_EMAIL = ">(//app-send-invite/ion-content/ion-grid//img)[2]";
	String IMG_SEND_INVITE_VIA_EMAIL_MSG = ">(//app-send-invite/ion-content/ion-grid//img)[2]/following::label[1]";

	String BTN_SEND_INVITE = ">//ion-button[contains(.,'Send Invite')]";
	String TXT_SEARCHBAR_BEEKEESYSTEM = ">//app-invite-via-email//input[@type='search']";
	String LST_SEND_INVITE_EMAILCONTACTS = "";

	String LNK_INVITE_NEW_USER = ">//app-invite-via-email//ion-col[contains(.,'Invite New User')]";
	String LBL_INVITEVIAEMAIL_WARNING = ">//app-invite-via-email//ion-col//label[contains(.,'This user')]";
	String TXT_INVITEVIAEMAIL_FIRSTNAME = ">//app-invite-via-email//ion-input[@formcontrolname='firstName']";
	String TXT_INVITEVIAEMAIL_LASTNAME = ">//app-invite-via-email//input[@placeholder='Last Name *']";
	String TXT_INVITEVIAEMAIL_PHONENUMBER = ">//app-invite-via-email//input[@id='tel']";
	String TXT_INVITEVIAEMAIL_EMAIL = ">//app-invite-via-email//input[@placeholder='Email *']";
	String TXT_INVITEVIAEMAIL_INVITATIONTYPE = ">//app-invite-via-email//label[text()='Invite']/following::img[contains(@class,'usertype-grey')]";

	String LBL_PENDINGINVITES_COUNT = ">//*[contains(.,'Pending Invites:')]/following-sibling::ion-label";
	String BTN_RESENDALL = ">//app-invites-sent//ion-label[text()='Resend All ']";
	String BTN_DELETEALL = ">//app-invites-sent//ion-label[text()='Delete All']";
	String BTN_ACCEPTALL = ">//app-invites-received//ion-label[text()='Accept All ']";
	String BTN_ALERT_RESEND = ">//span[text()='Resend']";
	String BTN_CANCEL = ">//span[text()='Cancel']";
	String BTN_ACCEPT = ">//ion-button[contains(.,'Accept')]";
	String BTN_DECLINE = ">//ion-button[contains(.,'Decline')]";

	// MY NETWORK
	String TAB_MYNETWORK = ">//*[not(contains(@class,'hidden'))]/app-header-tab-view//ion-img[contains(@class,'MyNetwork')]";
	String IMG_MYNETWORK_USER_EXPAND_STATUS = ">//ion-row[contains(.,'usertype')]//following::ion-col[1]/ion-icon";
	String LBL_LST_MYNETWORK_USERS = ">//ion-label[contains(.,'usertype')]/following::ion-row[1]//ion-label[contains(@class,'semi-bold ')]";
	String IMG_LST_MYNETWORK_ICON = ">//ion-label[contains(.,'usertype')]/following::ion-row[1]//ion-label[contains(@class,'semi-bold ')]//following::img[contains(@class,'userIcon')]";

	// HELP
	String TAB_HELP = ">//app-dashboard[not(contains(@class,'hidden'))]//app-footer-tabs//ion-icon[@name='help-circle-outline']";
	String TAB_HELP_ACTIVE = ">//app-help[not(contains(@class,'hidden'))]//app-footer-tabs//ion-icon[@name='help-circle-outline']";
	String LBL_SUPPORT_TITLE = ">(//app-help//ion-label)[1]";

	// MY GALLERY
	// GALLERY
	String BTN_ADD_PHOTOVIDEO = ">//ion-icon[@aria-label='add circle outline']";
	String BTN_TAKE_A_PHOTO = ">//*[normalize-space(text())='Take A Photo']";
	String BTN_SELECT_PHOTO = ">//*[normalize-space(text())='Select Photos']";
	String BTN_SELECT_VIDEOS = ">//*[normalize-space(text())='Select Videos']";
	String BTN_TAKE_A_VIDEO = ">//*[normalize-space(text())='Take A Video']";
 	String ST_VIDEOS = ">//*[contains(@class,'image-list')]/descendant::*[contains(@class,'video-icon')]/preceding-sibling::img";
	String ST_IMAGES = ">//*[contains(@class,'image-list')]/descendant::*[contains(@class,'image-icon')]/preceding-sibling::img";
	String BTN_REMOVE = ">//*[normalize-space(text())='REMOVE']";
 }
