package com.my.TestNGTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://google.com");  
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("Google")); 		
		}
		
		@Test				
		public void Test1() {	
			driver.get("http://google.com");  
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("Google")); 		
		}
		@BeforeTest
		public void beforeTest() {	
			//System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
		    System.out.println("beforeTest run");
			driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}