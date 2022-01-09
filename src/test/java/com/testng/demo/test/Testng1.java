package com.testng.demo.test;

import org.testng.annotations.*;

public class Testng1 {

	@BeforeClass
	private void start() {
		System.out.println("Start");
	}
	
	@Test
	private void test1() {
		System.out.println("First test case.");
	}
	
	@AfterClass
	private void end() {
		System.out.println("end");
	}
}




