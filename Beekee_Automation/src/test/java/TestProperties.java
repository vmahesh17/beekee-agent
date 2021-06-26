import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.annotations.Test;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.Constants;

public class TestProperties extends Actions_Android {

	public static PropertiesConfiguration conf;

	void test() throws ConfigurationException {
		conf = new PropertiesConfiguration(Constants.BEEKEE_PROPERTIES_FILE);
		conf.setProperty("schedule_date2", "Test1233");
		conf.save();

		System.out.println("after");
		conf.setProperty("schedule_date3", "Test33");
		conf.save();

	}

	
	public static String  getUserName() {
		// String str = "We sent a code to your ar122@yopmail.com & (998) 899-0000.";

		String username="";
		String s = "We sent a code to your ar122@yopmail.com & (998) 899-0000.";
		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(s);
		while (m.find()) {
			System.out.println(m.group());
			username =m.group().split("@")[0];
			
		}
		return username;

	}
	@Test
	void T() {
		System.out.println(""+getUserName());
	}
	
	
}
