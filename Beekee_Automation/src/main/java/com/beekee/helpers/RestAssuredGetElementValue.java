package com.beekee.helpers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;


import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGetElementValue {

	public static List<Object> getElementfromJSON(String ImageUrl) {
		String imageUrl = "url=https://i.imgur.com/hx6DceD.png";

		String apiurl = "https://api.ocr.space/parse/imageurl?apikey=90a70c64d288957" + "&" + imageUrl
				+ "&language=eng&OCREngine=2&isOverlayRequired=true";
		RestAssured.baseURI = "https://api.ocr.space";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/parse/imageurl?apikey=90a70c64d288957" + "&" + ImageUrl
				+ "&language=eng&OCREngine=2&isOverlayRequired=true");

		ResponseBody body = response.getBody();
		List<Object> ImageTT = body.jsonPath().getList("ParsedResults.ParsedText");
		System.out.println("Text returned " + ImageTT);
		String bodyStringValue = body.asString();
		// System.out.println(bodyStringValue);
		return ImageTT;

//		Assert.assertTrue(bodyStringValue.contains("LineText"));

	}

	public static String getElementValueUsingPOSTMethod(String CaptchaPath) {
		// String CaptchaPath1 = "C:\\Users\\Mahesh
		// Vemula\\eclipse-workspace\\SASRetail_FieldApp_Mobile\\TGS_Automation\\target\\captcha.png";

		String ImageText = given().param("apikey", "90a70c64d288957").param("language", "eng").param("OCREngine", "2")
				.param("isOverlayRequired", "true").multiPart("file", new File(CaptchaPath)).accept(ContentType.JSON)
				.when().post("https://api.ocr.space/parse/image").then().statusCode(200).extract().body().jsonPath()
				.getString("ParsedResults.ParsedText"); // "ParsedResults.ParsedText"
		return ImageText;
	}

	public static String getOTPValueUsingGETMethod() throws InterruptedException {
		String Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtb2JubyI6Ijc4OTMxNDI0MjQiLCJmcm9tZGF0ZSI6IjIwMTkvMTIvMDEiLCJ0b2RhdGUiOiIyMDE5LzEyLzMxIiwiZXhwIjoxNTc2OTI3MTA0LCJpc3MiOiJteXNjaG9vbGNoaWxkcmVuLmluIiwiYXVkIjoibXlzY2hvb2xjaGlsZHJlbi5pbiJ9.aUw2KmDDurAKrWu5Z8ak7jCVGnzQdybyJavIjyEQF-c";
		String OTP = given().header("Authorization", "Bearer " + Token).param("t", "7893142424").param("v", "0")
				.accept(ContentType.JSON).when().get("https://app.servemycall.com/api/GetOTP").then().statusCode(200)
				.extract().body().jsonPath().getString("otpMessage"); // "ParsedResults.ParsedText"
		System.out.println("OTP Value    " + OTP);
		Thread.sleep(5000);

		return OTP;
	}

	public static String getOTP() {
//		Map<String, String> parameters = new HashMap<String, String>();
//		 parameters.put("username", "John");
//		 parameters.put("token", "1234");
//		 given().parameters(parameters).then().expect().body(equalTo("username, token")).when().get("/cookie");

//		login:ATAgent0101
//		p:r
//		d:
//		ctrl:
//		scrl:
//		spam:true
//		yf:115
//		yp:XZmt0ZQD3AmZlZGD5AGt1AwV
//		yj:ZZwp4ZGZ0ZGxkZwVlAQt5Zmx
//		v:3.1
//		r_c:
//		id:
//		
		String baseURI = "http://www.yopmail.com/en/inbox.php";

		String res = given()
				.params("login", "ATAgent0101", "p", "r", "d", "", "ctrl", "", "scrl", "", "spam", "true", "yf", "115",
						"yp", "XZmt0ZQD3AmZlZGD5AGt1AwV", "yj", "ZZwp4ZGZ0ZGxkZwVlAQt5Zmx", "v", "3.1", "r_c", "", "id",
						"")
				.accept(ContentType.JSON).when().get(baseURI).then().statusCode(200).extract().body().jsonPath()
				.toString();
		return res;
	}

	 
	void getootp() throws JSONException {

		String url = "http://www.yopmail.com/en/inbox.php?login=ATAgent0101&p=r&d=&ctrl=&scrl=&spam=true&yf=115&yp=XZmt0ZQD3AmZlZGD5AGt1AwV&yj=ZZwp4ZGZ0ZGxkZwVlAQt5Zmx&v=3.1&r_c=&id=";
		final String HTML = "";

		String body = given().accept(ContentType.HTML).when().get(url).then().statusCode(200).extract().body()
				.asString();

		Document document = Jsoup.parse(body);

		String ele = document.select("div.m:nth-child(11) div.um > a.lm").attr("href");

		System.out.println("TT        " + ele);

	}
}

 