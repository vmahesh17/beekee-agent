package com.beekee.commonmethods;

public interface MobileOR {

	// ---------- Login Screen-----------------------------
	String Username = "Email>//input[@name='email']";
	String Password = "Password>//input[@name='password']";
	String Login = "Login>//ion-button[text()='Log in']";

	String spinnerdismiss = "Spinner dismiss>//*[contains(.,'Please wait while downloading data...!') or contains(.,'loading')]";
	String channelName = ">//a/ion-label";
	String channelHeader = ">//ion-title";
	String list_channelNames = ">//h3/following::ion-list[@class='md list-md hydrated']/ion-item/ion-label";
	String list_SelectChannelName = ">//h3/following::ion-list[@class='md list-md hydrated']/ion-item/ion-label[text()='SelectEnvironment']";
	String Error_popup = "//span[contains(text(),'CLOSE')]";
	String EnterValidUsernameandPassword = "//div[contains(text(), 'Please enter a valid Email/Username')]";
	String ForgotPassword = "//*[@class='a-href' and contains(text(),'Forgot')]";
	// Logout

	/**
	 * Schedules
	 */
	String scheduleItemExpander = "Schedule Expander>//div[contains(@class,'collapse-panel')]//h5[normalize-space(.)='sDate']";

	String Logout = "LogOut>//ion-button/i[contains(@class,'logout')]";
	String Logout_popup = ">//button[@type='button']//span[text()='Yes']";

	String Store_Start = "//*[contains(text(),'Start')]";

	String End_time = ">/html/body/app-root/ion-app/ion-router-outlet/app-field/ion-app/ion-split-pane/ion-router-outlet/app-shift-completion/ion-content/app-collapse-expand/ion-card/div/ion-card-content/div/ion-card-content[1]/form/ion-grid/ion-row[2]/ion-col[2]/span/ion-datetime";
	String Star_Selection = ">/html/body/app-root/ion-app/ion-router-outlet/app-field/ion-app/ion-split-pane/ion-router-outlet/app-shift-completion/ion-content/app-collapse-expand/ion-card/div/ion-card-content/div/ion-card-content[1]/form/ion-grid/ion-row[4]/ion-col[2]/ngb-rating/span[6]/span";
	String Save = "//*[contains(text(),'Save')]";
	String DoneButton = "Done>//button[contains(.,'Done')]";

	// TC_01
	String Email_Required = "//div[contains(text(),\"Email/Username is required\")]";
	String Password_Required = "//div[contains(text(),\" Password is required\")]";

	String Invalid_Username_Password = "//div[contains(text(),\"Invalid Username / Password\")]";

	String LoadingSpinner = ">//ion-spinner[@class='sc-ion-loading-md md spinner-crescent hydrated']";

	String getbuildNumber = "Build Number>//*[@id=\"login-card\"]/form/ion-list/div[4]/a[2]";
	String uploadPhoto = "Upload>//span[text()='UPLOAD PHOTO']";
	String CaptureImageButton = "Image Capture>//div[@class='capture-image']//ion-button";
	String UsePhotoButton = "Use photo>//ion-button[text()=' Use Photo ']";
	String UsePhotoButton_QualityCheck = "Use Photo>//ion-title[text()=' Photo Alert ']//following::ion-button[text()='Use Photo']";

//---------- Login Screen-----------------------------	

	// --------------- SCHEDULE / DASHBOARD / Common Xpaths

	String Menu = "Menu>//ion-icon[@name='menu'][@class='md hydrated']";
	String Dismiss_Alert = "//*[contains(text(),'Cancel')]";

	// NAME will change
	String scheduleSelection = "//h5[contains(.,'2019-11-03')]";
	// Store and Date value will change
	String StoreSection = "//h5[contains(.,'2019-11-03')]/..//h6[contains(.,'Store #7194')]";

	String InprocessBtn = "//*[contains(text(),'In Progress')]";
	// Start Button Based on Cycle name
	String StartBtn = "//ion-label[contains(.,'BVTCheck')]//following::ion-button[contains(.,'Start')]";
	String StartTime = "Start Time>//ion-label[contains(.,'Start time')]//following::strong";
	String InprogressBtn = "//ion-label[contains(.,'BVTCheck')]//following::*[contains(.,'In Progress')]";

	String CompletedIcon = "Completed Icon>//span[@class='flaticon-check ng-star-inserted']";
	String Comment = "Comment Icon>//*[@class='icon-comment font-size-18']";
	String CommentInputBox = "Comment Input>//textarea[@class='native-textarea sc-ion-textarea-md']";
	String CommentConfirmBtn = "Comment Confirm>//ion-button[@type='submit' and contains(.,'Confirm')]";
	String TakePhotoBtn = "Take Photo>//span[contains(.,'PHOTO')]";
// ----------------------------------- TABS  --------------------------------------------------
	String PromoAudit = "Promo Audit Tab>//ion-menu-toggle/li[contains(.,'PROMO-AUDIT')]";
	String Planogram = "PlanoGram Tab>//ion-menu-toggle/li[contains(.,'PLANOGRAM-COMPLIANCE')]";
	String Nici = "NICI Tab>//ion-menu-toggle/li[contains(.,'NICI')]";
	String DistributionVoid = "Distribution Void Tab>//ion-menu-toggle/li[contains(.,'DISTRIBUTION-VOID')]";
	String ItemAudit = "Item Audit Tab>//ion-menu-toggle/li[contains(.,'ITEM-AUDIT')]";
	String Survey = "Survey Tab>//ion-menu-toggle/li[contains(.,'SURVEY')]";
	String CategoryReset = "Category Reset Tab>//ion-menu-toggle/li[contains(.,'CATEGORY-RESET')]";
	String HotLine = "HotLine Tab>//ion-menu-toggle/li[contains(.,'HOTLINE')]";
	String Continuity = "Continuity Tab>//ion-menu-toggle/li[contains(.,'CONTINUITY')]";
	String StoreVisitSummary = "Visit Summary Tab>//ion-menu-toggle/li[contains(.,'STORE-VISIT-SUMMARY')]";
	String ShiftCompletion = "Shift Completion Tab>//ion-menu-toggle/li[contains(.,'SHIFT-COMPLETION')]";
	String CloseX = "Close >//ion-icon[@name='close']";
	String ContinueBtn = "Continue Button>//*[starts-with(text(),'CONTINUE')]";
// ------------------------------------------------------------------------------------------------

// -------------------------- PROMO AUDIT---------------
	String PromoAudit_VendorName = "Vendor Name>//ion-row[contains(.,'Vendor 1')]";
	String PromoAudit_Y_Radiobtn = "YES>//ion-radio[@ng-reflect-value='yes']";
	String PromoAudit_N_Radiobtn = "NO>//ion-radio[@ng-reflect-value='no']";
	String PromoAudit_Uploadphoto = "Upload Photo>//span[contains(.,'UPLOAD PHOTO')]";

// ---------------------- -PLANOGRAM---------------------
	String PlanO_Category = "Planogram Category>//ion-col[contains(text(),' Cosmetics ')]";
	String PlanO_ToggleON = "Toggle>//ion-toggle[@name='new_pog_issue']";

// ---------------------- NICI -------------------------
	String Nici_itemDesc = "Item Description>//ion-col/ion-label[contains(.,'Test Automation')]";

	String NiciItemTagged_None = "Item Tagged -NONE>//ion-col/span[contains(.,'Item Tagged')]/following::a[1]";
	String NiciItemTagged_Enable = "Item Tagged -Enable>//app-switch-toggle[@ng-reflect-name='item_tagged']/div//label[3]";
	String NiciItemTagged_Disable = "Item Tagged -Disable>//app-switch-toggle[@ng-reflect-name='item_tagged']/div//label[1]";

	String NiciOnshelf_None = "OnShelf - NONE>//ion-col/span[text()='On Shelf']/following::label[2]";
	String NiciOnshelf_Enable = "OnShelf - Enable>//ion-col/span[text()='On Shelf']/following::label[3]";
	String NiciOnshelf_Disable = "OnShelf - Disable>//ion-col/span[text()='On Shelf']/following::label[1]";

	// ---------------------- Distribution Void---------------
	// ON / OFF pgm values will change
	String DV_IncompleteIcon = "Incomplete Icon>//span[contains(@class, 'flaticon-caution7')]";
	String DV_Upc = "UPC>//ion-col[contains(.,'23436')]";
	String DV_CategoryName = "Category Name>//ion-label[text()='Category']//following::ion-col[contains(.,' Corn Meal - Flour - Grits ')]";

	String DV_BeforeSection = "Before Section>//div[text()='BEFORE']";
	String DV_BeforeItemsON = "Before Items ON>//ion-card-title[contains(.,'BEFORE')]//following::div[2]/label[3]";
	String DV_BeforeOnshelfON = "Before Onshelf ON>//ion-card-title[contains(.,'BEFORE')]//following::label[3]//following::label[3]";

	String DV_AfterSection = "After Section>//div[text()='AFTER']";
	String DV_AfterItemsON = "After Items ON>//ion-card-title[contains(.,'AFTER')]//following::div[2]/label[3]";
	String DV_AfterOnshelfON = "After Onshelf ON>//ion-card-title[contains(.,'AFTER')]//..//span[contains(.,'On Shelf')]//following::label[3]";

	// ******************************* Item Audit *******************************
	String ItemAudit_CategoryRevlon = "Category -Revlon>//ion-card-title/div/div/div[contains(.,'Revlon')]";
	String ItemAudit_UPC = "UPC>//ion-row/ion-col[contains(.,'7781')]";
	String ItemAudit_editIcon = "Edit Icon>//ion-label/span/i[@class='flaticon-edit45 font-size-16']";
	String ItemAudit_RetailQ = "RetailQ>//ion-label[contains(.,'Retail Qty')]//following::input[1]";
	String ItemAudit_Save = "Save>//ion-button[text()='Save']";

	// ******************************* Survey *******************************
	String Survey_Name = "Survey Name>//ion-col[text()=' Survey Name ']//following::ion-col[text()=' Auto Survey ']";
	String Survey_StartORRetake = "Survey Start>//ion-button[text()=' Start' or text()=' Retake Survey']";
	String Survey_Retake = "Survey Retake>//ion-button[contains(., 'Retake')]";
	// String Survey_StartORRetake = "Start OR Retake>//ion-button[contains(.,
	// 'Start') | contains(.,'Retake')]";
	String Survey_Qinput = "Question Input>//textarea[@class='native-textarea sc-ion-textarea-md']";
	String Survey_ProceedBtn = "Proceed>//ion-button[contains(.,'Proceed')]";
	String Survey_RadioYES = "Survey Radio YES>//ion-radio[@value='yes']";
	String Survey_Radio_Option1 = "Option 1>//ion-radio[@ng-reflect-value='radio_Option_1']";
	String Survey_CheckBox_Option1 = "Checkbox option1>//ion-row[1]//ion-checkbox";
	String Survey_CheckBox_Option2 = "Checkbox option2>//ion-row[2]//ion-checkbox";
	String Survey_DateTime_Minimum = "Date Minimum>//ion-row[contains(.,'Minimum')]/ion-col//ion-datetime";
	String Survey_DateTime_Maximum = "Date Maximum>//ion-row[contains(.,'Maximum')]/ion-col//ion-datetime";

	String Survey_DropDown = "DropDown>//ion-select[@placeholder='Select One']";
	String Survey_DropDown_Option1 = "Option 1>//ion-radio-group//ion-item[contains(.,'DD_Option_1')]//ion-radio";

	String Survey_Grid_Row1Col1_Input = "Row1-Col1 Value>//ion-row[2]/ion-col[2]//input";
	String Survey_Grid_Row1Col2_Input = "Row1-Col2 Value>//ion-row[2]/ion-col[3]//input";

	String Survey_Grid_Row2Col1_Input = "Row2-Col1 Value>//ion-row[3]/ion-col[2]//input";
	String Survey_Grid_Row2Col2_Input = "Row2-Col2 Value>//ion-row[3]/ion-col[3]//input";

// ******************************* Category Reset ********************************************

	String CR_Incomplete = "In Complete>//ion-text[@ng-reflect-color='warning']";
	String CR_StatusEnable = "Status Enable>//ion-col[contains(.,'Status')]//following::div[1]//label[3]";
	String CR_ExpandIcon = "Expand Icon>//div[@class='basic-collapse']";
	String CR_CategoryName = "Category Name>//ion-col[contains(text(),'Corn Meal - Flour - Grits')]";
	String CR_AssignTo = "Assign To>//ion-icon[@name='person-add']";
	String CR_SelectMember = "Select Member>//ion-select[@placeholder='Select Member']";
	// Member change
	String CR_MemberSelectionRadioBtn = "Member Selection>//div/button/div[contains(.,'Eddie Murillo')]//preceding::div[@class='alert-radio-icon sc-ion-alert-md']";
	String CR_OKBtn = "OK>//button/span[text()='OK']";
	String CR_AddBtn = "Add>//ion-button[text()='Add']";
	String CR_TimeEntry = "Time Entry>//ion-input/input[@name='act_size_numerator' and @placeholder='eg: 2h 3m']";

//******************************** CONTINUITY **********************************************
	String Continuity_IncompleteIcon = "Incomplete Icon>//ion-icon[@ng-reflect-color='medium']";
	String Continuity_CompleteIcon = "Complete Icon>//ion-icon[@ng-reflect-color='success']";

	String Continuity_SummaryView = "Summary View>//ion-button[contains(.,'Summary View')]";
	String Continuity_ListView = "List View>//ion-button[contains(.,'List View')]";
	String CategoryOpen0of1 = "//ion-label/span[@class='gray-curve']";
	String Continuity_CategoryName = "Category Name>//ion-label[text()='Vitamins ']";
	String Continuity_ActionTypeHeader = "Action Type Header>//h5[text()='Action Type']";
	String Continuity_Audit = "Client Audit>//div[text()=' Audit ']";
	String Continuity_ClientAudit = "Client Audit>//div[text()=' Client Audit ']";
	String Continuity_DisplayFeature = "Display Feature>//div[text()=' Display Feature ']";
	String Continuity_FreshnessAudit = "Freshness Audit>//div[text()=' Freshness Audit ']";
	String Continuity_GlutenFreeFlagPlacement = "Gluten Free>//div[text()=' Gluten Free Flag Placement ']";
	String Continuity_NewItemCutIn = "NICI>//div[text()=' New Item Cut-in ']";
	String Continuity_NewItemFlagPlacement = "NIFP>//div[text()=' New Item Flag Placement ']";
	String Continuity_OSCA = "OSCA>//div[text()=' OSCA ']";
	String Continuity_PackOut = "PackOut>//div[text()=' Pack Out ']";
	String Continuity_POP_Placement = "POP>//div[text()=' POP Placement ']";
	String Continuity_POS_Placement = "POS>//div[text()=' POS Placement ']";
	String Continuity_RollBackPlacement = "RollBack Placement>//div[text()=' Rollback Placement ']";
	String Continuity_SellingBuyerApproved = "Selling Buyer Approved>//div[text()=' Selling Buyer Approved ']";
	String Continuity_SellingLAG = "Selling LAG>//div[text()=' Selling LAG ']";
	String Continuity_WICTagPlacement = "WIC Tag Placement>//div[text()=' WIC Tag Placement ']";

	String Continuity_ToggleON = "Toggle ON>//app-switch-toggle/div[@class='switch-toggle none']//label[3]";
	String Continuity_ToggleOFF = "Toggle ON>//app-switch-toggle/div[@class='switch-toggle none']//label[1]";
	String Continuity_ActionTakenDropDown = "Action Taken>//ng-select[@ng-reflect-placeholder='Select']";
	String Continuity_BuiltOption = "Built Option>//ng-select[@ng-reflect-placeholder='Select']//div[@role='option'][2]";
	String Continuity_Quantity = "Quantity>//ion-input/input[@type='number']";
	String Continuity_QuantityLabel = "Qty Label>//ion-col/ion-text[contains(.,'Display UP:')]";
	String Continuity_UOM = "UOM>//ng-select[@ng-reflect-placeholder='UOM']";
	String Continuity_UOM_Units = "UOM Units>//ng-select[@ng-reflect-placeholder='UOM']//div[@role='option'][2]";
	String Continuity_DateField = "Date Field>//ion-datetime";

	String Continuity_ItemTagged_ToggleON = "Item Tagged Toggle ON>//app-switch-toggle[@ng-reflect-name='item_tagged']//label[3]";
	String Continuity_OnShelf_ToggleON = "On Shelf Toggle ON> //app-switch-toggle[@ng-reflect-name='on_shelf']//label[3]";

	// OSCA
	String Continuity_OSCA_EntryStatus = "Entry Status>//ng-select[@ng-reflect-name='entry_status']";
	String Continuity_DropDown_SelectOption2 = "Select option 3>//ng-dropdown-panel/div/div/div[@role='option'][2]";

	String Continuity_DropDown_SelectOption3 = "Select option 3>//ng-dropdown-panel/div/div/div[@role='option'][3]";
	String Continuity_OSCA_Action = "Action//ng-select[@ng-reflect-name='action']";
	String Continuity_OSCA_AdditionalOrders_Checkbox = "Check box>//ion-checkbox[@role='checkbox']";
	String Continuity_OSCA_AdditionalOrders_Qunatity = "Quantity>//ion-input[@ng-reflect-name='additional_quantity']/input";
	String Continuity_OSCA_AdditionalOrders_UOM = "UOM>//ng-select[@ng-reflect-name='additional_uom']";
	// Packout
	String Continuity_PackOut_Type = "Type>//ng-select[@ng-reflect-name='type']";
	String Continuity_PackOut_Qty = "Qty>//ion-input[@ng-reflect-name='cases_stocked_quantity']/input";

	// RollBack
	String Continuity_RollBack_TagPlacement_ToggleON = "Tag Placement Toggle ON>//app-switch-toggle[@ng-reflect-name='tag_complete']//label[3]";
	String Continuity_RollBack_TagPlacement_Qty = "Tag Placement Qty>//ion-input[@ng-reflect-name='tag_quantity_placed']/input";
	String Continuity_RollBack_FlagPlacement_ToggleON = "Flag Placement Toggle ON>//app-switch-toggle[@ng-reflect-name='flag_complete']//label[3]";
	String Continuity_RollBack_FlagPlacement_Qty = "Flag Placement Qty>//ion-input[@ng-reflect-name='flag_quantity_placed']/input";

	// SellingBuyer
	String Continuity_SellingBuyerApproved_ApproverName = "Approver Name>//ion-input[@ng-reflect-name='approver_name']/input";
	String Continuity_SellingBuyerApproved_ApproverTitle = "Approver Title>//ion-input[@ng-reflect-name='approver_title']/input";
	String Continuity_SellingBuyerApproved_CanvasPad = "//app-signature-pad//canvas";
	String Continuity_SellingBuyerApproved_EditSignature = "Edit Signature>//ion-button[contains(.,'Edit Signature')]";
	String Continuity_SellingBuyerApproved_SaveSignature = "Save Signature>//ion-button[contains(.,'Save Signature')]";

	String Continuity_SellingBuyerApproved_Exception = "Exception>//ng-select[@ng-reflect-name='exception']";

//****************************** HOTLINE *******************************************
	String NewHotlinesIcon = "New HotLine>//*[contains(@class,'flaticon-plus')]";
	String AddHotline = "Add HotLine Title>//ion-title['Add Hotline']";
	String Title = "Title Input>//ion-input[@formcontrolname='title']//input[@type='text']";
	String Client = "Client>//*[@id='client']";
	String ClientSelection = "Client Selection>//*[@ng-reflect-result='Walmart Syndicated']";
	String HotLineType = "Hotline Type>//*[@formcontrolname='hotline_type']";
	String SubType = "SubType>//*[@formcontrolname='sub_type']";
	// Type - Client Audit
	String SelectType = "Select Type - Audit>//ion-label[contains(.,'Audit')]/..//ion-radio[@role='radio']";
	// SubType - Completed
	String SelectSubType = "Select subType - subtype1>//ion-label[contains(.,'subtype1')]/..//ion-radio[@role='radio']";
	String Note = "Note>//textarea[contains(@name,'ion-input')]";
	String SaveBtn = "Save>//ion-button[contains(.,'Save')]";

// ******************************* Store Visit ******************************* 
	String StoreVisit_Rate = "Good>//ion-card-content/div/label/span[contains(.,'Good')]";
	String StoreVisit_AdditionalComments = "Comments>//textarea[@placeholder='Additional Comments']";
	String StoreVisit_AddStoreManagerBtn = "Add Store Manager>//ion-button[text()='Add Store Manager']";
	String StoreVisit_ManagerName = "Manager Name>//ion-label[contains(.,'Manager Name')]//following::ion-input[1]";
	String StoreVisit_ManagerEmail = "Manager Email>//ion-label[contains(.,'Manager Email')]//following::ion-input[1]";
	String StoreVisit_ManagerPhone = "Manager Phone>//ion-label[contains(.,'Phone')]//following::ion-input[1]";
	String StoreVisit_AddBtn = "Add >//ion-button[text()='Add']";
	String StoreVisit_ManagerSelectionDD = "Manager Selection>//ion-select[@ng-reflect-name='manager']";
	String StoreVisit_ManagerRadiobtn = "Manger radio button>//div[@class='alert-radio-label sc-ion-alert-md'][contains(.,'Auto')]";
	String StoreVisit_ManagerOKBtn = "Ok>//button/span[contains(.,'OK')]";

	String StoreVisit_Signature = "Canvas>//app-signature-pad/div/canvas";
	String StoreVisit_Chkbox = "Checkbox>//ion-checkbox[@role='checkbox' and @ng-reflect-name='is_manager_accepted']";
	String StoreVisit_Save = "Save and continue>//*[text() ='SAVE & CONTINUE TO SHIFT-COMPLETE']";

//******************************* Shift Completion ******************************* 

	String StoreVisit_EndTime = "End Time>//ion-datetime[@ng-reflect-name='actual_end_time']";
	// Rate = 3 Stars
	String StoreVisit_RatingSTAR = "Star>//ion-col[contains(.,'Visit Rating')]//following::span[8]";
	String StoreVisit_ShiftSave = "Shift Save>//ion-button[text()='Save']";
	String StoreVisit_Totalhours = "Total hours>//ion-col[contains(.,'Work Hours')]//following::ion-col/span[1]";
	String StoreVisit_Ok = "Ok>//span[contains(.,'Ok')]";
	String StoreVisit_Feedback = "Feedback>//textarea[@placeholder='Please provide feedback from store visit']";
	String StoreVisit_ShiftCompleteBtn = "Shift Complete Button>//ion-button[@type='submit' and contains(.,'Complete')]";
//******************************* ******************************* ******************************* 

	/**
	 * Latest Xpath
	 */
	String confirmBtn = ">//button[contains(.,'Confirm')]";
	String syncBtn = ">//ion-button/i[contains(@class,'reload')]";
	String buttonText = ">//ion-row[contains(@class,'ng-star-inserted')]//following::ion-col/ion-button[not(contains(@class,'button-disabled'))][1]";
	String confirmBtnDisable = ">//ion-row[contains(@class,'ng-star-inserted')]//following::ion-col/ion-button[contains(@class,'button-disabled')][1]";
	
	String confirmBtn_Visit = ">//ion-button[contains(.,'Confirm') and @type='submit']";
	String textarea = ">//textarea";
	String submitBtn = ">//ion-button[contains(.,'Submit')]";

}
