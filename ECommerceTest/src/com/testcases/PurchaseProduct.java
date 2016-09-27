package com.testcases;

import org.testng.annotations.Test;

import com.util.Util;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class PurchaseProduct {
	private WebDriver driver;	
	  
 @BeforeTest
 public void setUp() throws Exception {
   System.setProperty("webdriver.gecko.driver","D:/MadhurvaWindows/Documents/_workspace/geckodriver");
   String exePath ="D://MadhurvaWindows//Documents//_workspace//chromedriver_win32//chromedriver.exe";
   System.setProperty("webdriver.chrome.driver", exePath);
   driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
			
  @Test
  public void purchaseTest() {
	  driver.get(Util.BASE_URL);
	  // Click on MY ACCOUNT Link
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  
	  //Login to account
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("email")).sendKeys("mary@gmail.com");
	  driver.findElement(By.id("pass")).clear();
	  driver.findElement(By.id("pass")).sendKeys("abc123");
	  driver.findElement(By.xpath("//*[@id='send2']")).click();
	  
	  //Click on MY WISHLIST Link
	  driver.findElement(By.linkText("MY WISHLIST")).click();
	  
	  
	  // Clicks on ADD TO CART
	  driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	  // Clicks on Proceed To Checkout
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[1]/ul/li/button")).click();
	  
	  //Enters Billing info
	  driver.findElement(By.id("billing:street1")).clear();
	  driver.findElement(By.id("billing:street1")).sendKeys("ABC");
	  driver.findElement(By.id("billing:city")).clear();
	  driver.findElement(By.id("billing:city")).sendKeys("New York");
	  new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']"))).selectByValue("New York");
	  driver.findElement(By.id("billing:postcode")).clear();
	  driver.findElement(By.id("billing:postcode")).sendKeys("542896");
	  driver.findElement(By.id("billing:telephone")).clear();
	  driver.findElement(By.id("billing:telephone")).sendKeys("1234567890");
	  
	  driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button/span/span")).click();
	  
	  

	  
	  
	   
	   
  }
  

  @AfterTest
  public void afterTest() {
  }

}
