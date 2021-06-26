package com.beekee.helpers;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.HttpHeaders;
import org.json.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class YopmailGetOTP {

	public static String getInbox(String username) throws XPathExpressionException {
		RestAssured.baseURI = "http://www.yopmail.com/en/";

		// EMAIL BOX
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("inbox.php?login=" + username
				+ "&p=r&d=&ctrl=&scrl=&spam=true&yf=115&yp=DZmZkZmLjZmHkZQV4AQLkAwD&yj=BAQL3AwpjBGplAmH4ZwDkBGZ&v=3.1&r_c=&id=");

//		ResponseBody body = response.getBody();

		if (response.statusCode() == 200) {

			Document document = Jsoup.parse(response.asString());

			String ele = document.select("div.m:nth-child(11) div.um > a.lm").attr("href");

			String IDEMAILBOX = ele.toString();
			System.out.println("HREF " + IDEMAILBOX);

			// MAIL BODY
			RequestSpecification mailrequest = RestAssured.given();
			String additionalcookies = "params=0.0; cnl=1; _ga=GA1.2.2026830695.1614664765; _gid=GA1.2.1711984267.1614664765; __gads=ID=47ee4984aa6416e7-22d142c134c60020:T=1614664766:RT=1614664766:S=ALNI_MbI8HWX4qmaUwMt37YA-e60B7ZeHw; PHPSESSID=nf6iqqscecjsqo3pdn8pfur632; compte="
					+ username + "; _gat=1; ys=FZmN1AGD3AwxjZwV3ZGR0ZwL; yc=GAQxjZQxjAQHkZQx0AGp4ZQR".trim();
			Response mailresponse = mailrequest.header("Cookie", additionalcookies).get(IDEMAILBOX);

			if (mailresponse.statusCode() == 200) {

				System.out.println("RES " + mailresponse.asString());

				Document mailbodyDocument = Jsoup.parse(mailresponse.asString());
				if (!mailbodyDocument.getElementsContainingText("Reveli Code").isEmpty()) {
					Element f = mailbodyDocument.getElementsContainingText("Reveli Code").first();
					Elements MAILBODY = f.select("#mailmillieu > div:nth-child(2)");
					// Beekee - table > tbody > tr > td > p:nth-child(2) > b

					// System.out.println("OTP body" + MAILBODY.toString());
					String OTPValue = MAILBODY.toString().replaceAll("\\D+", "");

					System.out.println("OTP    >>>  " + OTPValue);

					return OTPValue;

				} else {
					System.err.println("No Mail from Reveli");
				}
			} else {
				System.err.println("Status incorrect, Please check the url  " + mailresponse.getStatusCode());
				Assert.fail("Please check the response code");
			}
		} else {
			System.err.println("Status incorrect" + response.statusCode());
		}
		return "";
	}
	
	

	 
	void TT() throws XPathExpressionException, Exception {
		for(int i=1;i<=50;i++) {
			System.out.println(getInbox("revelistudent"+i));
		}
	}
	
	
	/**
	 * Update CSV by row and column
	 * 
	 * @param fileToUpdate CSV file path to update e.g. C:\\PC\\test.csv
	 * @param replace Replacement for your cell value
	 * @param row Row for which need to update from 0
	 * @param col Column for which you need to update 
	 * @throws IOException
	 */
//	public static void updateCSV(String fileToUpdate, String replace,
//	    int row, int col) throws IOException {
//
//	File inputFile = new File(fileToUpdate);
//
//	// Read existing file 
//	CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
//	List<String[]> csvBody = reader.readAll();
//	// get CSV row column  and replace with by using row and column
//	csvBody.get(row)[col] = replace;
//	reader.close();
//
//	// Write to CSV file which is open
//	CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
//	writer.writeAll(csvBody);
//	writer.flush();
//	writer.close();
//	}
////	
//	public static void updateCSV(String fileToUpdate) throws IOException {
//        File inputFile = new File(fileToUpdate);
//
//        // Read existing file
//        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
//        List<String[]> csvBody = reader.readAll();
//        // get CSV row column and replace with by using row and column
//        for(int i=0; i<csvBody.size(); i++){
//            String[] strArray = csvBody.get(i);
//            for(int j=0; j<strArray.length; j++){
//                if(strArray[j].equalsIgnoreCase("Update_date")){ //String to be replaced
//                    csvBody.get(i)[j] = "Updated_date"; //Target replacement
//                }
//            }
//        }
//        reader.close();
//
//        // Write to CSV file which is open
//        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
//        writer.writeAll(csvBody);
//        writer.flush();
//        writer.close();
//    }
//
//	void restApi() {
//		String username = "atagent0101";
//		RestAssured.baseURI = "http://www.yopmail.com/en/";
//		RequestSpecification httpRequest = RestAssured.given();
//
//		Response response = httpRequest.get("inbox.php?login=" + username
//				+ "&p=r&d=&ctrl=&scrl=&spam=true&yf=115&yp=DZmZkZmLjZmHkZQV4AQLkAwD&yj=BAQL3AwpjBGplAmH4ZwDkBGZ&v=3.1&r_c=&id=");
//
//		ResponseBody body = response.getBody();
//
//		Document document = Jsoup.parse(response.asString());
//
//		String ele = document.select("div.m:nth-child(11) div.um > a.lm").attr("href");
//
//		String IDEMAILBOX = ele.toString();
//		System.out.println("EMAIL_ID" + ele.toString());
//		System.out.println("cookies" + response.getCookies());
//		// String mailCookies = response.getCookies().toString();
//
//		// GET MAIL CONTENT
//
//		String getmailbody = "http://www.yopmail.com/en/" + IDEMAILBOX + "";
//		RequestSpecification mailbody = RestAssured.given();
//		Response mailres = mailbody.get(getmailbody);
//		mailbody.cookies(response.getCookies());
//		ResponseBody mailcontent = mailres.getBody();
//		System.out.println("MAIL CONTENT" + mailcontent.asString());
//	}

}
