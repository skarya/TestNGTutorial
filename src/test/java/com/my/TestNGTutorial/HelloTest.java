package com.my.TestNGTutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelloTest {
	
	@BeforeTest
	public void beforetest(){
		System.out.println("HELLOWORLD -> BEFORE TEST");
	}
	@AfterTest
	public void aftertest(){
		System.out.println("HELLOWORLD -> AFTER TEST");
	}
	@BeforeClass
	public void beforeclass(){
		System.out.println("HELLOWORLD -> BEFORE CLASS");
	}
	@AfterClass
	public void afterclass(){
		System.out.println("HELLOWORLD -> AFTER CLASS");
	}
	@BeforeMethod
	public void beforemethod(){
		System.out.println("HELLOWORLD -> BEFORE METHOD");
	}
	@AfterMethod
	public void aftermethod(){
		System.out.println("HELLOWORLD -> AFTER METHOD");
	}
	@BeforeSuite
	public void beforesuite(){
		System.out.println("HELLOWORLD -> BEFORE SUITE");
	}
	@AfterSuite
	public void aftersuite(){
		System.out.println("HELLOWORLD -> AFTER SUITE");
	}
	@Test(priority=3)
	public void testfunction1(){
		System.out.println("HELLOWORLD -> Test Function 1 - Priority 3");
	}
	
	@Test(priority=2)
	public void testfunction2(){
		System.out.println("HELLOWORLD -> Test Function 2 - Priority 2");
	}
	
	@Test(priority=1)
	public void testfunction3(){
		System.out.println("HELLOWORLD -> Test Function 3 - Priority 1");
	}

}