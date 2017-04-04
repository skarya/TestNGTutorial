package com.my.TestNGTutorial;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;		
public class NewTest {		
	    @Test				
		public void testEasy() {	
			 System.out.println("beforeTest run");	
			 for(int i=0;i<10;i++){
				 System.out.println( "---------> sandy" + i);
			 }
		}
		
		@Test				
		public void Test1() {	
			 System.out.println("beforeTest run");		
		}
		@BeforeTest
		public void beforeTest() {	
			//System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
		    System.out.println("beforeTest run");
			
		}		
		@AfterTest
		public void afterTest() {
			System.out.println("afterTest run");		
		}		
}