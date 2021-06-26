package com.beekee.commonmethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import android.view.KeyEvent;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class Actions_Android extends DriverClass implements BeekeeOR {
	public static String ElementWait = "20";

// ==========================**** ANDROID KEYWORDS *****============================	

	@SuppressWarnings("rawtypes")
	public static void setAndroidDriver(AndroidDriver paramWebDriver) {
		androiddriver = paramWebDriver;
	}

	public static String[] splitXpath(String xpath) {
		String[] a = xpath.split(">");
		return a;
	}

	/**
	 * This Method is used to Click Element.
	 * 
	 * @throws Exception
	 */
	public static void click(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement Androidelement = androiddriver.findElementByXPath(values[1]);
			wait("2");
			Androidelement.click();
			ATUReports.add("CLICK", "Clicked on -" + values[0], "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			
			ATUReports.add("CLICK", "Unable tp Click on -" + values[0], "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Assert.fail();
		}
	}

	/**
	 * This Method is used to Wait and Click Element.
	 * 
	 * @throws Exception
	 */
	public static void waitAndclick(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement Androidelement = androiddriver.findElementByXPath(values[1]);
			waitUntilElementClickable(values[1]);
			Androidelement.click();
			ATUReports.add("CLICK", "Clicked on -" + values[0], "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("CLICK", "Unable tp Click on -" + values[0], "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Assert.fail();
		}
	}

	/**
	 * This Method is used to Click Element By JS.
	 */
	public static void clickjs(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = androiddriver.findElement(By.xpath(values[1]));
			JavascriptExecutor executor = (JavascriptExecutor) androiddriver;
			executor.executeScript("arguments[0].click();", element);
			ATUReports.add("CLICK JS", "Clicked on -" + values[0], "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("CLICK JS", "Unable tp Click on -" + values[0], "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	/**
	 * This Method is used to Send Inputs to fields.
	 */
	public static String sendkeys(String xpath, String keysToSend) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.sendKeys(keysToSend);
			androiddriver.hideKeyboard();
			wait("1");
			ATUReports.add("SENDKEYS " + values[0], "Input Value -" + keysToSend, "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			// Assert.fail();
			ATUReports.add("SENDKEYS " + values[0], "Unable to Input Value -" + keysToSend, "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		return keysToSend;
	}
	// androiddriver.pressKeyCode(AndroidKeyCode.BACK);

	/**
	 * This Method is used to Clear the input values from fields.
	 */
	public static void clear(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			ATUReports.add("CLEAR ", "Clear text from field -" + values[0], "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			// webElement.clear();

		} catch (Exception e) {

			Assert.fail();
			ATUReports.add("CLEAR ", "Unable to Clear text from field -" + values[0], "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	/**
	 * This Method is used to Clear and Type the value to fields.
	 */
	public static String clearAndType(String xpath, String keysToSend) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			webElement.sendKeys(keysToSend);
			androiddriver.hideKeyboard();
			ATUReports.add("CLEAR AND TYPE " + values[0], "Clear and Type -" + keysToSend, "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {

			Assert.fail();
			ATUReports.add("CLEAR AND TYPE " + values[0], "Unable to Clear and Type -" + keysToSend, "", "",
					LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));

		}
		return keysToSend;
	}

	public static void ClearAndTYPE(String xpath, String KeysToSend) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.clear();
			webElement.sendKeys(KeysToSend);
			androiddriver.hideKeyboard();
			ATUReports.add("CLEAR AND TYPE " + values[0], "Clear text from field and Input Value -" + KeysToSend, "",
					"", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("CLEAR AND TYPE " + values[0],
					"Unable to Clear text from field and Input Value -" + KeysToSend, "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	/**
	 * This Method is used to Get text of the Element
	 */
	public static String getText(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			String text = new String(webElement.getText().getBytes("UTF-8"));
			ATUReports.add("GET TEXT" + values[0], "Get text -" + text, "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			return text;

		} catch (Exception e) {
			ATUReports.add("GET TEXT" + values[0], "Unable to Get text", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Assert.fail();
			return null;
		}
	}

	/**
	 * Get Text of the Element
	 * 
	 * @param element
	 */
	public static String getAttribute(String xpath, String sAttribute) {
		String[] values = splitXpath(xpath);
		try {
			AndroidElement webElement = androiddriver.findElement(By.xpath(values[1]));
			String text = new String(webElement.getAttribute(sAttribute).getBytes("UTF-8"));
			wait("2");
			ATUReports.add("GET Attribute - " + values[0], "Get Attribute for " + text, "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			log.info("Get Attribute for element :" + xpath);
			return text;
		} catch (Exception e) {
			// Assert.fail();
			ATUReports.add("GET Attribute - " + values[0], "Get Attribute for ", "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			log.info("Unable to Get Attribute for element :" + xpath);
			return null;
		}
	}

	/**
	 * This Method is used to Verify Element is displayed or not
	 * 
	 * @return
	 */
	public static boolean isElementDisplayed(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.isDisplayed();
			ATUReports.add("IS ELEMENT DISPLAYED", "Element Displayed -" + values[0], " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			return webElement.isDisplayed();
		} catch (Exception e) {
			// Assert.fail();
			ATUReports.add("IS ELEMENT DISPLAYED", "Element not Displayed -" + values[0], " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			return false;
		}

	}

	/**
	 * This Method is used to Verify Element is Selected or not
	 */
	public static boolean isSelected(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			webElement.isSelected();
			ATUReports.add("IS SELECTED", "Element Selected -" + values[0], " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			return webElement.isSelected();
		} catch (Exception e) {
			Assert.fail();
			ATUReports.add("IS SELECTED", "Element not Selected -" + values[0], " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			return false;

		}
	}

	/**
	 * This Method is used to Scroll to End of the screen
	 */
	public static void scrollEnd() {

		try {
			JavascriptExecutor js = (JavascriptExecutor) androiddriver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			// scrollObject.put("", value)
			js.executeScript("mobile: scroll", scrollObject);
			ATUReports.add("SCROLL TO END", "Scroll to End", " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			ATUReports.add("SCROLL TO END", "Unable to Scroll to End", " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	/**
	 * This Method is used to Scroll using Element.
	 */
	public static void scrollJS(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = androiddriver.findElement(By.xpath(values[1]));
			((JavascriptExecutor) androiddriver).executeScript("arguments[0].scrollIntoView();", element);
			ATUReports.add("SCROLL JS", "Scroll to End" + values[0], " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			ATUReports.add("SCROLL JS", "Unable to Scroll to End" + values[0], " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	/**
	 * This Method is used to Swiping from Bottom to Top.
	 */
	public static void swipingBottomToTop() {
		try {
			androiddriver.currentActivity();
			Dimension size = androiddriver.manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.10); // 20
			int startx = size.width / 2;
			androiddriver.swipe(startx, starty, startx, endy, 3000);
			ATUReports.add("SWIPING BOTTOM TO TOP", "Swiping Bottom to Top", " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			Assert.fail();
			ATUReports.add("SWIPING TO BOTTOM TO TOP", "Unable to Swiping Bottom to Top", " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	/**
	 * This Method is used to Swiping from Top to Bottom.
	 */
	public static void swipingTopToBottom() {
		try {
			// Get the size of screen.
			Dimension size = DriverClass.androiddriver.manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.20);
			int startx = size.width / 2;
			androiddriver.swipe(startx, endy, startx, starty, 1000);
			ATUReports.add("SWIPING TOP TO BOTTOM", "Swiping Top to Bottom", " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {

			ATUReports.add("SWIPING TOP TO BOTTOM", "Unable to Swiping Top to Bottom", " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	/**
	 * This Method is used to Swiping from Right to Left.
	 */
	public static void swipingRighttoLeft() {
		try {
			Dimension size = androiddriver.manage().window().getSize();
			System.out.println(size);
			int startx = (int) (size.width * 0.70);
			int endx = (int) (size.width * 0.30);
			int starty = size.height / 2;
			androiddriver.swipe(startx, starty, endx, starty, 3000);
			Thread.sleep(2000);
			ATUReports.add("SWIPING RIGHT TO LEFT", "Swiping Right to Left", " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			Assert.fail();
			ATUReports.add("SWIPING RIGHT TO LEFT", "Unable to Swiping Right to Left", " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	/**
	 * This Method is used to Swiping from Left to Right.
	 */
	public static void swipingLeftToRight() throws InterruptedException {
		try {
			// Get the size of screen.
			Dimension size = DriverClass.androiddriver.manage().window().getSize();
			int startx = (int) (size.width * 0.70);
			int endx = (int) (size.width * 0.30);
			int starty = size.height / 2;
			DriverClass.androiddriver.swipe(endx, starty, startx, starty, 3000);
			Thread.sleep(2000);
			ATUReports.add("SWIPING LEFT TO RIGHT", "Swiping Left to right", " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			Assert.fail();
			ATUReports.add("SWIPING LEFT TO RIGHT", "Unable to Swiping Left to right", " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	/**
	 * This Method is used to Swiping Right using the Element.
	 */
	public static void swipeRightusingElement(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			Dimension size = androiddriver.manage().window().getSize();
			int x1 = (int) (size.width * 0.20);
			// Find x2 point which is at left side of screen.
			int x2 = (int) (size.width * 0.80);

			// Create object of TouchAction class.
			TouchAction action = new TouchAction((MobileDriver) androiddriver);

			WebElement ele2 = (WebElement) androiddriver.findElementByXPath(values[1]);
			// Create swipe action chain and perform horizontal(left to right) swipe.
			// Here swipe to point x2 Is at right side of screen. So It will swipe element
			// from left to right.
			action.longPress(ele2).moveTo(x2, 580).release().perform();
			ATUReports.add("SWIPING RIGHT USING ELEMENT", "Swiping right using element -" + values[0], " ", "",
					LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("SWIPING RIGHT USING ELEMENT", "Unable to Swiping right using element -" + values[0], " ",
					"", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	/**
	 * This Method is used to Swipe and Select From List View using Element.
	 */
	public static void swipeAndSelectFromListView(String xpath) {
		try {
			Dimension size = androiddriver.manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.20);
			int startx = 0;
			TouchAction action = new TouchAction((MobileDriver) androiddriver);
			WebElement webElement = androiddriver.findElement(By.xpath(xpath));
			action.longPress(webElement).moveTo(webElement, startx, 200).release().perform();
		} catch (Exception e) {

			Assert.fail();
		}
	}

	/**
	 * This Method is used to Swiping in List.
	 */
	public static void swipelist(String xpath) {
		List<AndroidElement> list = androiddriver.findElements(By.xpath(xpath));
		if (list != null && !list.isEmpty()) {
			WebElement bottomElement = list.get(list.size() - 1);
			WebElement topElement = list.get(0);
			TouchAction touchAction = new TouchAction(androiddriver).press(bottomElement).moveTo(topElement).release();
			touchAction.perform();
		}
	}

	/**
	 * This Method is used to Toggle Selection (Enable/Disable) using Element.
	 */
	public static void toggleSelection(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement element = androiddriver.findElement(By.xpath(values[1]));
			// Used points class to get x and y coordinates of element.
			Point point = element.getLocation();
			int xcord = point.getX();
			System.out.println("Position of the webelement from left side is " + xcord + " pixels");
			int ycord = point.getY();
			System.out.println("Position of the webelement from top side is " + ycord + " pixels");
			// Using Actions class

			TouchAction action = new TouchAction(androiddriver);
			// clicking on the logo based on x coordinate and y coordinate
			action.longPress(element, xcord, ycord);

			((JavascriptExecutor) androiddriver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
			element.click();
			JavascriptExecutor executor = (JavascriptExecutor) androiddriver;
			executor.executeScript("window.scroll(" + xcord + ", " + ycord + ");");
			executor.executeScript("arguments[0].click();", element);
			wait("2");
			ATUReports.add("TOGGLE SELECTION", "Toggle Selected -" + values[0], " ", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("TOGGLE SELECTION", "Unable to select Toggle -" + values[0], " ", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	/**
	 * This Method is used to Press using the Element.
	 */
	public static void press(String xpath) {
		WebElement webElement = androiddriver.findElement(By.xpath(xpath));
		TouchAction action = new TouchAction(androiddriver);
		action.press(webElement).release().perform();

	}

	/**
	 * This Method is used to Long Press using the Element.
	 */
	public static void longPress(String xpath) {
		WebElement webElement = androiddriver.findElement(By.xpath(xpath));
		TouchAction action = new TouchAction(androiddriver);
		action.longPress(webElement).release().perform();
	}

	/**
	 * This Method is used to Signature draw on the canvas.
	 */
	public static void signatureDrawOnCanvas(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			WebElement webElement = androiddriver.findElement(By.xpath(values[1]));
			TouchAction action = new TouchAction(androiddriver);
			action.longPress(webElement).moveTo(300, 550).release().perform();
			// .moveTo(200, 200)
			ATUReports.add("SIGNATURE ON CANVAS", "Able to draw signature" + values[0], "", "", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("SIGNATURE ON CANVAS", "Unable to draw signature" + values[0], "", "", LogAs.FAILED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	public static void swipeonCanvas() {
		// int startX, int startY, int endX,int endY
		JavascriptExecutor js = (JavascriptExecutor) androiddriver;
		Map<String, Object> params = new HashMap<>();
		params.put("duration", 1.0);
		params.put("fromX", 781);
		params.put("fromY", 360);
		params.put("toX", 1146);
		params.put("toY", 326);
		js.executeScript("mobile: dragFromToForDuration", params);
	}

	/**
	 * This Method is used to Press Tab key to move on fields.
	 */
	public static void pressTabkey() {
		androiddriver.pressKeyCode(KeyEvent.KEYCODE_TAB);
		ATUReports.add("PRESS TAB KEY", "Moved out from field using Tab key", "", "", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.DESKTOP));

	}

	public static void swipeEndofPage_Menu() { // Left side section will scroll end of page
		Dimension dimensions = androiddriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		System.out.println(scrollStart);
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		for (int i = 0; i < dimensions.getHeight(); i++) {
			androiddriver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		}
	}

	public static void swipeWithCoordinates() {
		TouchAction action = new TouchAction(androiddriver);
		action.press(429, 617).moveTo(222, 102).release().perform();
	}
// ==================================****************=====================================

	public static void waitForElement_A(String xpath) {
		try {
			int WaitElementSeconds1 = new Integer(ElementWait);
			WebDriverWait wait = new WebDriverWait(androiddriver, WaitElementSeconds1);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			// visibilityOfElementLocated(
			// By.xpath(values[1])));

		} catch (Exception e) {
			System.out.println("Given element is not loaded in the given time");
			// Assert.fail();

		}
	}

	public static void allowAppPermission(String xpath) {

		while (androiddriver.findElements(MobileBy.xpath(xpath)).size() > 0)

		{
			androiddriver.findElement(MobileBy.xpath(xpath)).click();
		}
	}

	public static void takePhoto() throws IOException {
		androiddriver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		Runtime.getRuntime().exec("cmd /C adb shell input keyevent " + 27);
		wait("5");
		// androiddriver.pressKeyCode(AndroidKeyCode.KEYCODE_);
		// Thread.sleep(3000);
		androiddriver.pressKeyCode(KeyEvent.KEYCODE_CAMERA, KeyEvent.keyCodeFromString("27"));
		System.out.println("Captured a Pic from Camera");
	}

	public static void scrollByResourceIdAndClick(AndroidDriver driver, String resourceID) {
		try {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
					+ ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + resourceID + "\").instance(0));")
					.click();
		} catch (Exception e) {
			// ATUReports.add1("Element is Present", resourceID, LogAs.FAILED,);
			Assert.fail();
		}
	}

	public static boolean tapElementUsingCoordinates(int x, int y) {
		try {
			new TouchAction(androiddriver).tap(x, y).perform();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void scrollByTextAndClick(String text1) {
		try {
			androiddriver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
							+ "(new UiSelector().textContains(\"" + text1 + "\").instance(0));")
					.click();

		} catch (Exception e) {

			Assert.fail();
		}
	}

	public static void scrollByElement(String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			androiddriver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"
							+ "(new UiSelector().textContains(\"" + values[1] + "\").instance(0));"); // \"" + values[1]
																										// + "\"
			ATUReports.add("SCROLL BY ELEMENT", "Scroll By ELEMENT -" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			ATUReports.add("SCROLL BY ELEMENT", "Unable to Scroll By ELEMENT -" + values[0], "", "", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}

	}

	public static void verticalSwipeEndofPage(String element) {

		Dimension dim = androiddriver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		// int x = (int) (width * 0.05);
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		androiddriver.swipe(x, starty, x, endy, 500);
		ATUReports.add("VERTICAL SWIPE", "Swipe vertically", "", "", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.DESKTOP));

	}

	public static void verticalSwipeFromLeft() {

		Dimension dim = androiddriver.manage().window().getSize();
		System.out.println("Dim " + dim);
		int height = dim.getHeight();
		int width = dim.getWidth();
		// int x = width / 2;
		int x = (int) (width * 0.05);
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		androiddriver.swipe(x, starty, x, endy, 500);
		ATUReports.add("VERTICAL SWIPE", "Swipe vertically", "", "", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.DESKTOP));

	}

	public static void verticalSwipeFromRight() {

		Dimension dim = androiddriver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		// int x = width / 2;
		int x = (int) (width * 0.80);
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		androiddriver.swipe(x, starty, x, endy, 200);
		ATUReports.add("VERTICAL SWIPE", "Swipe vertically", "", "", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.DESKTOP));

	}

	public static void verticalSwipeFromMiddle() {

		Dimension dim = androiddriver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		// int x = width / 2;
		int x = (int) (width * 0.50);
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		androiddriver.swipe(x, starty, x, endy, 200);
		ATUReports.add("VERTICAL SWIPE", "Swipe vertically", "", "", LogAs.INFO,
				new CaptureScreen(ScreenshotOf.DESKTOP));

	}

	public static void swipeToggleRightSide(String Elem) {
		String[] values = splitXpath(Elem);
		try {
			Point Ele = androiddriver.findElementByXPath(values[1]).getLocation();
			int X = Ele.getX();
			int Y = Ele.getY();

			System.out.println("Location" + Ele);

			int endX = (int) (X + 100);
			int endY = (int) (Y + 100);
			// int endY = (int) (X+0.20);

			androiddriver.swipe(X, Y, endX, endY, 2000);
			ATUReports.add("SWIPE TOGGLE - RIGHT SIDE ", "Swipe toggle right side" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("SWIPE TOGGLE - RIGHT SIDE ", "Unable to Swipe toggle right side" + values[0], "", "",
					LogAs.WARNING, new CaptureScreen(ScreenshotOf.DESKTOP));

		}
		// 1160, 340, 1260, 440

	}

	public static void scrollListView(String classname, String text) {
		AndroidElement list = (AndroidElement) androiddriver.findElement(By.className("" + classname + ""));
		MobileElement listGroup = list.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
		assertNotNull(listGroup.getLocation());
		listGroup.click();
	}

	public static void scrollListView_A(String classname, String text) {
		AndroidElement list = (AndroidElement) androiddriver.findElement(By.className("" + classname + ""));
		MobileElement listGroup = list.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
		assertNotNull(listGroup.getLocation());
		listGroup.click();
	}

	public static String captureScreenshot(AndroidDriver driver, String screenshotName) {
		try {
			String image_dest = (Constants.CapturedScreenshotPath).concat(screenshotName).concat(".png");
			System.out.println(image_dest);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = image_dest;
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking Screenshot" + e.getMessage());
			return e.getMessage();
		}
	}

	public static void dragAndDrop(String xpath1, String xpath2) throws InterruptedException {
		try {
			WebElement draggable = androiddriver.findElement(By.xpath(xpath1));
			WebElement droppable = androiddriver.findElement(By.xpath(xpath2));
			TouchAction action = new TouchAction(androiddriver);
			action.press(draggable).perform();
			action = new TouchAction(androiddriver);
			action.press(draggable).moveTo(droppable).release().perform();
		} catch (Exception e) {

			Assert.fail();
		}
	}

	public static void keyBoardEvent(int eventNumber) {
		// URL: http://testingalert.com/automate-android-actions-using-appium/
		try {
			Runtime.getRuntime().exec("cmd /C adb shell input keyevent " + eventNumber);
			Thread.sleep(3000);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void clickCamera() {
		keyBoardEvent(27);
		System.out.print("Clicked on Camera ");

	}

	public static void WaitUntilElementVisible(String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebDriverWait wait = new WebDriverWait(androiddriver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(values[1])));
			ATUReports.add("WAIT UNTILL ELEMENT VISIBLE", "Element -" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			ATUReports.add("WAIT UNTILL ELEMENT VISIBLE", "Element not visible within given time -" + values[0], "", "",
					LogAs.WARNING, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

	}

	public static void WaitUntilElementInvisible(String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebDriverWait wait = new WebDriverWait(androiddriver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(values[1])));
			ATUReports.add("WAIT UNTILL ELEMENT INVISIBLE", "Element -" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("WAIT UNTILL ELEMENT INVISIBLE", "Element not invisible within given time -" + values[0], "",
					"", LogAs.WARNING, new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	public static String checkKeyboardVisibility() {
		String output = null;
		try {
			String cmd[] = new String[] { "adb", "shell", "dumpsys", "input_method", "|", "grep", "mInputShown" };
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			output = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	public static void wait(String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time * 1000;
			Thread.sleep(seconds);
			// ATUReports.add("Waited", LogAs.PASSED, true, "Wait");
		} catch (InterruptedException e) {

			Assert.fail();
		}
	}

	public static void waitForElement(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			int WaitElementSeconds1 = new Integer(ElementWait);
			WebDriverWait wait = new WebDriverWait(androiddriver, WaitElementSeconds1);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			ATUReports.add("WAIT FOR ELEMENT", "WAIT FOR ELEMENT -" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (Exception e) {
			ATUReports.add("WAIT FOR ELEMENT", "WAIT FOR ELEMENT -" + values[0], "", "", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	public static void waitUntilElementClickable(String Xpath) {
		String[] values = splitXpath(Xpath);
		try {
			WebDriverWait wait = new WebDriverWait(androiddriver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(values[1])));
			ATUReports.add("WAIT UNTIL ELEMENT CLICK", "WAIT FOR ELEMENT -" + values[0], "", "", LogAs.INFO,
					new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			ATUReports.add("WAIT FOR ELEMENT", "WAIT FOR ELEMENT -" + values[0], "", "", LogAs.WARNING,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		}
	}

	public static void getscreenshot(AppiumDriver<MobileElement> d) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Date date = new Date();
		String fileName = sdf.format(date);
		File des = d.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(des, new File(System.getProperty("user.dir") + "//Screenshots//" + fileName + ".png"));
		System.out.println("Screenshot is captured");
	}

	public static void SelectDatefromDatePickerWheel(String xpath) {
		String[] values = splitXpath(xpath);
		try {
			androiddriver.findElement(By.xpath(values[1])).click();
			List<AndroidElement> Columns = androiddriver
					.findElements(By.xpath("//ion-picker-column[contains(@class,'sc-ion-picker-md md picker-col')]"));
			String FirstColu = Columns.get(0).getText();
			System.out.println("First Colum  " + FirstColu);

			JavascriptExecutor js = (JavascriptExecutor) androiddriver;
			Map<String, Object> params = new HashMap();
			params.put("order", "next");
			params.put("offset", 0.15);
			params.put("element", Columns.get(0));
			for (int i = 0; i < 10; i++) {
				js.executeScript("mobile: selectPickerWheelValue", params);
			}

		} catch (Exception e) {

			// TODO: handle exception
		}
//		Columns.get(1).sendKeys("9");
//		Columns.get(2).sendKeys("30");
//		Columns.get(3).sendKeys("PM");			
	}

	public static void verifyServiceHeaderTxt(String headerText) {
		WaitUntilElementVisible(">//ion-grid[contains(@class,'header-menu')]/ion-row/ion-col[1]");
		String HeaderText = getText(">//ion-grid[contains(@class,'header-menu')]/ion-row/ion-col[1]");
		if (headerText.equalsIgnoreCase(HeaderText)) {
			System.out.println("Loaded successfully for " + headerText);
			assertEquals(headerText, HeaderText, "Service Loaded successfully");
		} else {
			System.err.println("Unable to load the service for " + headerText);
		}
	}

	public static void navigateBack() {
		androiddriver.navigate().back();
	}

	/**
	 * Performs small swipe from the center of screen
	 *
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
//	public void swipeScreenSmall(Direction dir) {
//	    System.out.println("swipeScreenSmall(): dir: '" + dir + "'"); // always log your actions
//
//	    // Animation default time:
//	    //  - Android: 300 ms
//	    //  - iOS: 200 ms
//	    // final value depends on your app and could be greater
//	    final int ANIMATION_TIME = 200; // ms
//
//	    final int PRESS_TIME = 200; // ms
//
//	    PointOption pointOptionStart, pointOptionEnd;
//
//	    // init screen variables
//	    Dimension dims = androiddriver.manage().window().getSize();
//
//	    // init start point = center of screen
//	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
//
//	    // reduce swipe move into multiplier times comparing to swipeScreen move
//	    int mult = 10; // multiplier
//	    switch (dir) {
//	        case DOWN: // center of footer
//	            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) + (dims.height / 2) / mult);
//	            break;
//	        case UP: // center of header
//	            pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - (dims.height / 2) / mult);
//	            break;
//	        case LEFT: // center of left side
//	            pointOptionEnd = PointOption.point((dims.width / 2) - (dims.width / 2) / mult, dims.height / 2);
//	            break;
//	        case RIGHT: // center of right side
//	            pointOptionEnd = PointOption.point((dims.width / 2) + (dims.width / 2) / mult, dims.height / 2);
//	            break;
//	        default:
//	            throw new IllegalArgumentException("swipeScreenSmall(): dir: '" + dir.toString() + "' NOT supported");
//	    }
//
//	    // execute swipe using TouchAction
//	    try {
//	        new TouchAction(androiddriver)
//	                .press(pointOptionStart)
//	                // a bit more reliable when we add small wait
//	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
//	                .moveTo(pointOptionEnd)
//	                .release().perform();
//	    } catch (Exception e) {
//	        System.err.println("swipeScreenSmall(): TouchAction FAILED\n" + e.getMessage());
//	        return;
//	    }
//
//	    // always allow swipe action to complete
//	    try {
//	        Thread.sleep(ANIMATION_TIME);
//	    } catch (InterruptedException e) {
//	        // ignore
//	    }
//	}

}
