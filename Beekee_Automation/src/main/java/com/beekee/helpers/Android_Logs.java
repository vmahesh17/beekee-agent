package com.beekee.helpers;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.StreamSupport;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;

import com.beekee.commonmethods.Actions_Android;
import com.beekee.commonmethods.Constants;

import io.appium.java_client.AppiumDriver;

public class Android_Logs extends Actions_Android {

	public static void captureLog(AppiumDriver andrdoidriver, String AppName) throws Exception {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		String logPath = Constants.ANDROID_LOGS;
		System.out.println(androiddriver.getSessionId() + ": Saving device log...");
		List<LogEntry> logEntries = androiddriver.manage().logs().get("logcat").filter(Level.ALL);
		File logFile = new File(logPath + AppName + reportDate + "_" + ".txt");
		PrintWriter log_file_writer = new PrintWriter(logFile);
		log_file_writer.println(logEntries);
		log_file_writer.flush();
		System.out.println(androiddriver.getSessionId() + ": Saving device log - Done.");
	}

	public static void captureLogcat() {
		// inspect available log types
		Set<String> logtypes = androiddriver.manage().logs().getAvailableLogTypes();
		System.out.println("suported log types: " + logtypes.toString()); // [logcat, bugreport, server, client]

		// print first and last 10 lines of logs
		LogEntries logs = androiddriver.manage().logs().get("logcat");
		System.out.println("First and last ten lines of log: ");
		StreamSupport.stream(logs.spliterator(), false).limit(10).forEach(System.out::println);
		System.out.println("...");
		StreamSupport.stream(logs.spliterator(), false).skip(logs.getAll().size() - 10).forEach(System.out::println);

		// wait for more logs
		try {
			Thread.sleep(5000);
		} catch (Exception ign) {
		} // pause to allow visual verification

		// demonstrate that each time get logs, we only get new logs
		// which were generated since the last time we got logs
		LogEntries secondCallToLogs = androiddriver.manage().logs().get("logcat");
		System.out.println("\nFirst ten lines of next log call: ");
		StreamSupport.stream(secondCallToLogs.spliterator(), false).limit(10).forEach(System.out::println);
		

		Assert.assertNotEquals(logs.iterator().next(), secondCallToLogs.iterator().next());
	}
}
