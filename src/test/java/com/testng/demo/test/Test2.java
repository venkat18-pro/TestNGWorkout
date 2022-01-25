package com.testng.demo.test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	WebDriver driver;
	
	@BeforeClass
	private void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println(new Date());
	}
	
	@Test(priority=1)
	private void loginBtnColor() {
		WebElement loginBtn = driver.findElement(By.name("login"));
		String cssValue = loginBtn.getCssValue("background-color");
		String ext = "rgba(24, 119, 242, 1)";
		Assert.assertEquals(cssValue, ext, "Color is macth.");
		System.out.println("pass");
	}
	
	@Test(priority=2)
	private void newAcount() {
		WebElement btn = driver.findElement(By.id("u_0_2_Yn"));
		String cssValue = btn.getCssValue("background-color");
		System.out.println(cssValue);

	}
	
	@AfterMethod
	private void endTime() {
		System.out.println(new Date());
	}
	
	@AfterClass
	private void end() {
		driver.quit();
	}
	
}
