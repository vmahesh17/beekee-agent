package com.beekee.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.github.sukgu.*;

public class assertions extends com.beekee.commonmethods.Actions_Android {

	// Returns webelement
	public static String expandRootElement() {
		WebElement ele = (WebElement) ((JavascriptExecutor) androiddriver)
				.executeScript("return arguments[0].shadowRoot", "//ion-toast[contains(@class,'toast-message')]");
		return ele.toString();
	}

	public static void getShadowElem() {
		Shadow shadow = new Shadow(androiddriver);
		WebElement element = shadow.findElement("//ion-toast");
		String text = element.getText();
		System.out.println("Toast Message " + text);
	}

	public static void verifyToastMessage() {
		String toastmsg = expandRootElement().toString();
		System.out.println("Toast Message " + toastmsg);
	}

}
