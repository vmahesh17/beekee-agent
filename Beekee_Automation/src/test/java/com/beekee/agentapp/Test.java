package com.beekee.agentapp;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	
	@org.testng.annotations.Test
	void TT() {
		  
		 String ss = "code 9880";
		if(ss.contains("code")) {
			String[] otp1 = ss.split("code");
			Object[] objArr = {otp1, otp1};
			System.out.println("OTP1"+ otp1.toString());
			
			
			 // Array of String Arrays
			for (Object obj : objArr) {
			    if (obj instanceof String[]) {
			        String[] strArray = (String[]) obj;
			        String otp = "";
			        System.out.println(Arrays.toString(strArray));
			        // System.out.println(obj);
			        break;
			    }
			}
			
		}else {
			String[] otp2 = ss.split("app:");
			System.out.println("OTP2"+ otp2);
		}
	}
}
