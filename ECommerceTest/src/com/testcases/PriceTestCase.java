package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.Util;

public class PriceTestCase {
	WebDriver driver;
	public int scc = 0;
	
	@BeforeMethod
	  public void setUp() {
		//System.setProperty("webdriver.gecko.driver","/Users/madhuratendulkar/Documents/ws/geckodriver");
		String exePath = "/Users/madhuratendulkar/Documents/ws/ECommerceProject/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
    }

  @Test
  public void priceTest() throws InterruptedException {
	  driver.get(Util.BASE_URL);
	  driver.findElement(By.linkText("MOBILE")).click();
	  String price = driver.findElement(By.xpath
			  ("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[1]/span/span")).getText();
	  System.out.println(price);
	  
	  driver.findElement(By.linkText("SONY XPERIA")).click();
      System.out.println(driver.getCurrentUrl());
	  String price1 = driver.findElement(By.className("price")).getText();
	  
	  System.out.println("Actual" + price1);
	  Assert.assertEquals(price, price1);
  }
  

  @AfterMethod
  public void afterMethod() {
	 
  }

}
