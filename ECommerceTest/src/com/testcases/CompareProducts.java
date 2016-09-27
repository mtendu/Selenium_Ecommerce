/*Test Steps:
1. Goto http://live.guru99.com/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/

package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.util.Util;

import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareProducts {
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
	  public void testTestCase4() throws Exception {
		
		// 1. Go to http://live.guru99.com
	    driver.get(Util.BASE_URL); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();
	    Thread.sleep(1000);
	    
	    // 3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Iphone & Sony Xperia)
	    
	    //note: store the title of the 2 mobiles for comparison for verification later when popup page comes up
	 
	    //Clicks on "Add To Compare" for Sony Xperia
	  
	    String firstMobile = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/h2/a")).getText();
	    driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	    System.out.println("First mobile :" + firstMobile);
	   
	    //Adds IPhone to compare
	    String secondMobile = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")).getText();
	    driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();	  
	    System.out.println("Second Mobile : " + secondMobile);  
	    
	    //Clicks on compare button.
	    driver.findElement(By.xpath("//button[@title='Compare']")).click();	    
	    Thread.sleep(1000);
	    
	    //switch to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    String popUpExpectedTitle = "COMPARE PRODUCTS";
	    String popUpActualTitle = driver.findElement(By.xpath("//*[@id='top']/body/div/div[1]/h1")).getText();
	    System.out.println(popUpActualTitle);
	    
	    String popupFirstMobile = driver.findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[1]/h2/a")).getText();
	    String popupSecondMobile = driver.findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a")).getText();
	  
	    System.out.println("popupMobile1 = "+popupFirstMobile);
	    System.out.println("popupMobile2 = "+popupSecondMobile);
	    Thread.sleep(1000);
	    // to check the popup heading/title
	    try {	    	
	    	Assert.assertEquals(popUpActualTitle, popUpExpectedTitle);;
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the popup - this is tp check the IPhone
	    try {	    	
	    	Assert.assertEquals(firstMobile, popupFirstMobile);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the popup - this is to check Sony X
	    try {	    	
	    	Assert.assertEquals(secondMobile, popupSecondMobile);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    // 6. Close the Popup Windows
	    driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    driver.switchTo().window(handle);
	    }	  
	  
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	  }
	
	}
