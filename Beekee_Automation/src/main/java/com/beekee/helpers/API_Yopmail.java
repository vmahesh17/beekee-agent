package com.beekee.helpers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Yopmail {

	public static String getOTPYopMail(String username) {
		String OTPValue = "";
		RestAssured.baseURI = "http://www.yopmail.com/en/";
		// EMAIL BOX
		RequestSpecification httpRequest = RestAssured.given();
		
		System.out.println("Getting OTP for User >>>"+ username );

		Response response_inbox = httpRequest.get("inbox.php?login=" + username
				+ "&p=r&d=&ctrl=&scrl=&spam=true&yf=115&yp=DZmZkZmLjZmHkZQV4AQLkAwD&yj=BAQL3AwpjBGplAmH4ZwDkBGZ&v=3.1&r_c=&id=");

		if (response_inbox.statusCode() == 200) {

			Document document = Jsoup.parse(response_inbox.asString());

			String ele = document.select("div.m:nth-child(11) div.um > a.lm").attr("href");
			Boolean beekee_mailexist = document.select("#m1 > div > a > span.lmfd > span.lmf").first().text()
					.equalsIgnoreCase("BeeKee Support");

			if (beekee_mailexist) {
				System.out.println("Got mail from BeeKee");
				String mailbox_hrefID = ele.toString();
				System.out.println("Mail - HREF " + mailbox_hrefID);

				// MAIL BODY
				RequestSpecification request_mailbody = RestAssured.given();
				String additionalcookies = "params=0.0; cnl=1; _ga=GA1.2.2026830695.1614664765; _gid=GA1.2.1711984267.1614664765; __gads=ID=47ee4984aa6416e7-22d142c134c60020:T=1614664766:RT=1614664766:S=ALNI_MbI8HWX4qmaUwMt37YA-e60B7ZeHw; PHPSESSID=nf6iqqscecjsqo3pdn8pfur632; compte="
						+ username + "; _gat=1; ys=FZmN1AGD3AwxjZwV3ZGR0ZwL; yc=GAQxjZQxjAQHkZQx0AGp4ZQR".trim();
				Response response_mailbody = request_mailbody.header("Cookie", additionalcookies).get(mailbox_hrefID);

				if (response_mailbody.statusCode() == 200) {

					System.out.println("Response_mailbody  " + response_mailbody.asString());

					Document mailbodyDocument = Jsoup.parse(response_mailbody.asString());

					String beekee_mailbodySubject = mailbodyDocument.select("#mailhaut > div.f16").text();
					// .contains(("Your BeeKee Real Estate Code Has Arrived!"));

					if (beekee_mailbodySubject.contains("Your BeeKee Real Estate Code Has Arrived!")) {
						Elements MAILBODY = mailbodyDocument.select("td.mcnTextContent > p:nth-child(2)");
						OTPValue = MAILBODY.toString().replaceAll("\\D+", "");
						System.out.println("OTP    >>>  " + OTPValue);

					} else if (beekee_mailbodySubject.contains("Your New Password for BeeKee")) {
						// tbody > tr > td > p > br:nth-child(2)
						Elements forgotEmailBody = mailbodyDocument.select("td.mcnTextContent > p:nth-child(2)");
						String forgot1 = forgotEmailBody.toString().replaceAll(username, "");
						String forgot = forgot1.toString().replaceAll("\\D+", "");

						System.out.println("forgot otp" + forgot);
						OTPValue = forgot.toString();
						System.out.println("For got OTP    >>>  " + OTPValue);
					}

					else {
						Assert.fail("Beekee Subject not found");
					}

				} else {
					// System.err.println("Status incorrect, Please check the url" +
					// response_mailbody.getStatusCode());
					Assert.fail("Please check the response code" + response_mailbody.getStatusCode());
				}
			} else {
				Assert.fail("No mail from Beekee, Please reinitiate");
			}
		} else {
			Assert.fail("Please check the response code " + response_inbox.getStatusCode());
		}
		return OTPValue;
	}

	 
	@Test
	void T() {
		System.out.println("OO" + getOTPYopMail("agentat0095"));
	}

}
