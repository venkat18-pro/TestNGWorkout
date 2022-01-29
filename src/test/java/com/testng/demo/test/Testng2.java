package com.testng.demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng2 {
	WebDriver driver;
	
	
	@Test(groups= {"REG"})
	private void test1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("Test1 method REG");
		driver.quit();
	}
	@Test(groups= {"SAN"})
	private void test2() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("test2 method SAN");
		driver.quit();
	}	
	@Test(groups="REG")
	private void test3() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("test3 method REG");
		driver.quit();
	}	
	@Test(groups="SAN")
	private void test4() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("test4 method SAN");
		driver.quit();
	}
	
}
