package com.testcases;

import org.testng.annotations.Test;

import com.util.Util;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class QuantityTest {
	WebDriver driver;
	
	@BeforeMethod
	  public void setUp() {
		//System.setProperty("webdriver.gecko.driver","/Users/madhuratendulkar/Documents/ws/geckodriver");
		String exePath = "/Users/madhuratendulkar/Documents/ws/ECommerceProject/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
    }

  @Test
  public void quantityTest() throws InterruptedException {
	  // Navigates to http://live.guru99.com/
	  driver.get(Util.BASE_URL);
	  //Clicks on Mobile menu
	  driver.findElement(By.linkText("MOBILE")).click();
	  
	  // Clicks on Add To Cart for Sony Xperia
	  driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();	  
	  
	  //Updates quantity to 1000
	  driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();	    
	  driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");	
	  driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
	   	    
	  String errorMessage = driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText();
	  String expectedErrMsg = "* The maximum quantity allowed for purchase is 500.";
	  try {	    	
	    	Assert.assertEquals(errorMessage, expectedErrMsg);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	  
	  // Clicks on Empty Cart Button.
	  driver.findElement(By.xpath(".//*[@id='empty_cart_button']")).click();
	  
	  String emptyCartMsg = driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1")).getText();
	  String expectedEmptyCartMsg = "SHOPPING CART IS EMPTY";
	  Assert.assertEquals(emptyCartMsg, expectedEmptyCartMsg);
  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  
	  Thread.sleep(1000);
	  driver.quit();
	 
  }



}
