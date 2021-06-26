package com.beekee.testsuite;
import org.testng.annotations.Test;

public class grouping {
	
	@Test(groups = {"P1,P2"})
	void T1() {
		System.out.println("T1");
	}

	@Test(groups = {"P1"})
	void T2() {
		System.out.println("T2");
	}
	@Test(groups = {"P1,P2"})
	void T3() {
		System.out.println("T3");
	}
	@Test(groups = {"P2"})
	void T4() {
		System.out.println("T4");
	}
	
	
	
}
