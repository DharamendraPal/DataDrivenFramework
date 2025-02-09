package com.DKP.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.aventstack.extentreports.Status;


import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.DKP.utilities.ExcelReader;

public class BankManagerLogin extends TestBase {
	
	
	@Test()
	public void bankmanagerloginTest() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		String BankHeader=driver.findElement(By.cssSelector(OR.getProperty("BankHeader"))).getText();
		Assert.assertTrue(BankHeader.equalsIgnoreCase("Way2Automation Banking App"));
		//Thread.sleep(1000);
		click("bmlBtn_CSS");
		//click("bmlBtn_XPATH");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"),"Bank Mananger is not logged in");	
		
		
	}
}
