package com.DKP.rough;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	//Pre conditions annotations --starting with @Before
	@BeforeSuite//1
	public void setup()
	{
		System.out.println("@BeforeSuite----setup system property for chrome");
	}
	
	@BeforeTest//2
	public void launchBrowser()
	{
		System.out.println("@BeforeTest----launchBrowser");
	}
	
	@BeforeClass//3
	public void enterURL()
	{
		System.out.println("@BeforeClass----enter URL");
	}
	
	/*
	 * @BeforeMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -3
	 * @AfterMethod
	 * 
	 */
	
	@BeforeMethod //4
	public void login()
	{
		System.out.println("@BeforeMethod----login to app");
	}
	
	/*
	//test Cases ---starting with @test
	@Test//5
	public void googleTitleTest()
	{
		System.out.println("@Test----Google Title Test");
	}
	
	@Test
	public void searchTest()
	{
		System.out.println("@Test----search test");
	}
	@Test
	public void googleLogoTest()
	{
		System.out.println("@Test----google logo test");
	}
	*/
	
	@Test
	public void LoginintosysAdmin() 
	{
		System.out.println("@Test----LoginintosysAdmin");
		
	}
	
	@Test
	public void LogoutFromsysAdmin() 
	{
		System.out.println("@Test----LogoutFromsysAdmin");
		
	}
	
	//post conditions ---starting with @After
	@AfterMethod //6
	public void logout()
	{
		System.out.println("@AfterMethod----logout from app");
	}
	
	@AfterClass //7
	public void closeBrowser()
	{
		System.out.println("@AfterClass----Close Browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies()
	{
		System.out.println("@AfterTest----deleteAllCookies");
	}
	/*
	@Test(timeOut= 1000)
	public void InfiniteLoop()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
	*/
	
	/*
	@Test(expectedExceptions=NumberFormatException.class)
	public void InfiniteLoop()
	{
		String var="100A";
		Integer.parseInt(var);
		
	}
	*/
	@Test(enabled=false)
	public void googleTitle()
	{
		String Expected="Google";
		Assert.assertEquals(Expected, "Google123","Title not Matched");
	}
	
}
