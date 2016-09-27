package com.testcases;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.util.Util;

public class TestCase1 {
	WebDriver driver;
	public int scc = 0;
	  
	private StringBuffer verificationErrors = new StringBuffer();
	@BeforeMethod
	  public void setUp() {
		System.setProperty("webdriver.gecko.driver","D:/MadhurvaWindows/Documents/_workspace/geckodriver");
		String exePath ="D://MadhurvaWindows//Documents//_workspace//chromedriver_win32//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	
    }

	
  @Test
  public void testCase1() throws IOException {
	  driver.get(Util.BASE_URL);
	  // Go to "http://live.guru99.com/index.php/" HomePage of website
	  String expectedTitle = driver.getTitle();
	  // Compares Title of HomePage
	  try{
	  Assert.assertEquals("THIS IS A DEMO SITE", expectedTitle);
	  }
	  catch(Error e){
	  verificationErrors.append(e.toString());
	  }
	  
	  // Clicks on mobile link
	  driver.findElement(By.linkText("MOBILE")).click();
	  // Verify title of Mobile page.
	  String title = driver.getTitle();
	  try{
		  Assert.assertEquals("MOBILE", title);
	  }
	  catch(Error e){
		  verificationErrors.append(e.toString());
		  }
	  // Selects Sort by drop down.
	  Select select =new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
	  select.selectByVisibleText("Name");
	  
	  /*scc = (scc+1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("/Users/madhuratendulkar/Documents/FileStudy"+ scc + ".png");
		FileUtils.copyFile(scrFile, new File(png));*/
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
