package com.DKP.testcases;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DKP.base.TestBase;
import com.aventstack.extentreports.Status;


import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.DKP.utilities.ExcelReader;

public class CustomerLogoutTest extends TestBase {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void customerLogoutTest(Hashtable<String,String> data) throws InterruptedException 
	{		
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this testcase is set as No");
		}	
		
		Assert.assertTrue(isElementPresent("CusLogoutBtn_XPATH"),"Logout Button is not Present");
		click("CusLogoutBtn_XPATH");
		
		String CustomerLabel=driver.findElement(By.xpath(OR.getProperty("CusLabelName_XPATH"))).getText();
		Assert.assertTrue(CustomerLabel.equalsIgnoreCase("Your Name :"));
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent("HomePage_XPATH"),"Home Button is not Present");
		click("HomePage_XPATH");
		
		if(isElementPresent("CusLogBtn_XPATH")&& isElementPresent("bmlBtn_CSS"))
		{
			log.info("Control has return on Home Page");
			ExtentListeners.test.log(Status.INFO, "Control has return on Home Page"); 
		}
		else
		{
			log.info("Control has not return on Home Page");
			ExtentListeners.test.log(Status.INFO, "Control has not return on Home Page"); 
		}
	}
}
