package com.DKP.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.aventstack.extentreports.Status;

public class CustomerLogoutTest extends TestBase {
	
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void customerLogoutTest(Hashtable<String,String> data) throws InterruptedException
	public void customerLogoutTest(HashMap<String,String> data) throws InterruptedException 
	{		
		SoftAssert softassert = new SoftAssert();
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
