package com.testng.demo.test;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng1 {

	ChromeDriver driver;
	
	@BeforeClass
	private void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://facebook.com/");
	}
	
	@BeforeMethod
	private void startTime() {
		System.out.println(new Date());
	}
	
	@Test
	private void storage() {
		LocalStorage ls = driver.getLocalStorage();	
		System.out.println("size : "+ls.size());
		System.out.println(ls.getItem("hb_timestamp"));
		SessionStorage sl = driver.getSessionStorage();
		System.out.println("size: "+sl.size());
		System.out.println(sl.getItem("sp_pi"));
		
	}
	
	@Test
	private void cookieTest() {

		Cookie cookieNamed = driver.manage().getCookieNamed("fr");
		System.out.println("Cookie Name: "+cookieNamed.getDomain());
		
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("Name : "+cookie.getName());
			System.out.println("Domain: "+cookie.getDomain());
		}
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




