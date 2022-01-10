package com.testng.demo.test;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng1 {

	ChromeDriver driver;
	
	@BeforeClass
	private void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println(new Date());
	}
	
	@Test(priority=1)
	private void loginPage() {
		WebElement userTxt = driver.findElement(By.id("email"));
		Assert.assertTrue(userTxt.isDisplayed(), "User input field is displayed or not.");
		WebElement passTxt = driver.findElement(By.id("pass"));
		Assert.assertTrue(passTxt.isDisplayed(), "password input field is displayed or not.");
		WebElement btnLogin = driver.findElement(By.name("login"));
		Assert.assertTrue(btnLogin.isEnabled(), "Login Button is clickable or not.");	
	}
	
	
	@Test(priority=2)
	private void storage() {
		LocalStorage ls = driver.getLocalStorage();	
		System.out.println("size : "+ls.size());
		System.out.println(ls.getItem("hb_timestamp"));
		SessionStorage sl = driver.getSessionStorage();
		System.out.println("size: "+sl.size());
		System.out.println(sl.getItem("sp_pi"));
		
	}
	
	@Test(priority=3)
	private void cookieTest() {

		Cookie cookieNamed = driver.manage().getCookieNamed("fr");
		String domain = cookieNamed.getDomain();
		Assert.assertTrue(domain.contains("facebook"), "Verify the domain name equals a facebook.");
		
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




