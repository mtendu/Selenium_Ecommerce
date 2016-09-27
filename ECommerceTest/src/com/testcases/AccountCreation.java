package com.testcases;

import org.testng.annotations.Test;

import com.util.Util;


import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AccountCreation {
	
	 private WebDriver driver;	
	  
  @BeforeTest
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","D:/MadhurvaWindows/Documents/_workspace/geckodriver");
	String exePath ="D://MadhurvaWindows//Documents//_workspace//chromedriver_win32//chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }
		  
		  	
/*  @Test
  public void accountCreationTest() {
	  driver.get(Util.BASE_URL);
	  //Click on MY ACCOUNT Link
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  
	  //Clicks on CREATE AN ACCOUNT button.
	  driver.findElement(By.xpath("//*[@id='login-form']/div/div[1]/div[2]/a")).click();
	  
	  //Fill new user information.
	  driver.findElement(By.id("firstname")).sendKeys("Mary");
	  driver.findElement(By.id("lastname")).sendKeys("Peter");
	  driver.findElement(By.id("email_address")).sendKeys("mary@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("abc123");
	  driver.findElement(By.id("confirmation")).sendKeys("abc123");
	  
	  driver.findElement(By.xpath("//*[@id='form-validate']/div[2]/button/span/span")).click();
	  String expectedGreetings = "Hello, Mary Peter!";
	  String actualGreetings = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/div[2]/p[1]/strong")).getText();
      
	  Assert.assertEquals(actualGreetings, expectedGreetings);
  }*/
   @Test
   public void shareWishListTest(){
	   driver.get(Util.BASE_URL);
	   driver.findElement(By.linkText("TV")).click();
	   // Clicks on 'ADD TO Wishlist
	   driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a")).click();
       
	   // Login in to account
	   driver.findElement(By.id("email")).clear();
	   driver.findElement(By.id("email")).sendKeys("mary@gmail.com");
	   driver.findElement(By.id("pass")).clear();
	   driver.findElement(By.id("pass")).sendKeys("abc123");
	   driver.findElement(By.xpath("//*[@id='send2']")).click();
	   // Clicks on Share WishList button.
	   driver.findElement(By.xpath("//*[@id='wishlist-view-form']/div/div/button[1]/span/span")).click();
       // Enters email address and message 
	   driver.findElement(By.id("email_address")).sendKeys("peter@gmail.com",",", "madhuratendulkar89@gmail.com");
	   driver.findElement(By.id("message")).sendKeys("Check it out");
	   driver.findElement(By.xpath("//*[@id='form-validate']/div[2]/button/span/span")).click();
	   
	   String actualMsg = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	   String expectedMsg = "Your Wishlist has been shared.";
	   
	   Assert.assertEquals(actualMsg, expectedMsg);
   
   }

  @AfterTest
  public void afterTest() {
  }

}
