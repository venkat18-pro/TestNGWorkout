package com.testng.demo.test;

import java.util.Date;

import org.testng.annotations.*;

public class Testng1 {

	@BeforeClass
	private void start() {
		System.out.println("Start");
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println(new Date());
	}
	
	@Test
	private void test1() {
		System.out.println("First test case.");
	}
	
	@AfterMethod
	private void endTime() {
		System.out.println(new Date());
	}
	
	@AfterClass
	private void end() {
		System.out.println("end");
	}
}




