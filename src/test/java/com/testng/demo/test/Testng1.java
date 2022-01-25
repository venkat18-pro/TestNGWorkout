package com.testng.demo.test;

import java.util.Date;
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
		driver.manage().window().maximize();
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
		System.out.println("All assert is Passed.");
	}
	
	@Parameters({"userId", "pass"})
	@Test(priority=2, enabled=false)
	private void loginPassValue(String name, String pass) {
		WebElement inputTxt = driver.findElement(By.id("email"));
		inputTxt.sendKeys(name);
		WebElement passTxt = driver.findElement(By.id("pass"));
		passTxt.sendKeys(pass);
		
		inputTxt.clear();
		passTxt.clear();
	}
	
	@Test(priority=5, dataProvider="input", groups="MUL")
	private void loginMultipleValuePassing(String name, String pass) {
		WebElement usertxt = driver.findElement(By.id("email"));
		usertxt.sendKeys(name);
		
		WebElement userPass = driver.findElement(By.id("pass"));
		userPass.sendKeys(pass);
		
		usertxt.clear();
		userPass.clear();

	}
	
	@DataProvider(name="input")
	private Object[][] multipleValue() {
		return new Object[][] {{"venkat", "venkat18"}, {"vicky", "vicky18"}, {"hello", "hello18"}};
	}
	
	@Test(priority=4, enabled=false)
	private void storage() {
		LocalStorage lStroage = driver.getLocalStorage();	
		lStroage.size();
		lStroage.getItem("hb_timestamp");
		SessionStorage sStroage = driver.getSessionStorage();
		sStroage.size();
	}
	
	@Test(priority=3, enabled=false)
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




