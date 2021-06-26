import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.DriverClass;
import com.beekee.helpers.BeeKee_CommonActions;
import com.beekee.page.BeeKee_SignInPage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestJava extends Actions_Android {

	static void vlogin() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, prop.getProperty("agent.email"),
				prop.getProperty("agent.password"));

		int deviceWidth = androiddriver.manage().window().getSize().getWidth();
		int deviceHeight = androiddriver.manage().window().getSize().getHeight();

		int midX = (deviceWidth / 2);
		int midY = (deviceHeight / 2);

		int bottomEdge = (int) (deviceHeight * 0.85f);

		
	
		androiddriver.swipe(midX, midY, midX, bottomEdge, 20);

	}
	
	
	@Test
	void TT() throws Exception {
		DriverClass.appLaunch();
		BeeKee_SignInPage.signInToApplication(true, "atagent4681439@yopmail.com", "pass@123");
		
		
		BeeKee_CommonActions.verifyToastMessage("ion-toast", "Invalid username / password");
		
		
//		
//		toastMatches("Invalid usernane / password  sdsdsd", false);
//		
//		
//		WebDriverWait wait = new WebDriverWait(androiddriver, 10);
//
//	    
//
//	    wait.until(toastMatches("Invalid usernane / password", false));
		
		
		
		
//		wait("1");
//		// first, find the externally visible element
//		WebElement component = androiddriver.findElement(By.tagName("app-login"));
//
//		// now we can use it to find the shadow root
//		String getShadow = "return arguments[0].shadowRoot;";
//		WebElement shadowRoot = (WebElement) androiddriver.executeScript(getShadow, component);
//		wait("1");
//		WebElement innerElement = shadowRoot.findElement(By.tagName("ion-toast"));
//		
//		System.out.println(innerElement.getText());
		
		
	}
	
	
	
	public static ExpectedCondition<Boolean> toastMatches(String matchText, Boolean isRegexp) {
	    return new ExpectedCondition<Boolean>() {
	        public Boolean apply() {
	            ImmutableMap<String, Object> args = ImmutableMap.of(
	                "text", matchText,
	                "isRegexp", isRegexp
	            );
	            System.out.println("match the toast");
	            return (Boolean) ((JavascriptExecutor)androiddriver).executeScript("mobile: isToastVisible", args);
	        }

	        @Override
	        public String toString() {
	            return "toast to be present";
	        }

			@Override
			public Boolean apply(WebDriver input) {
				// TODO Auto-generated method stub
				return null;
			}
	    };
	}
}
