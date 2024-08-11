package com.DKP.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DKP.base.TestBase;
import com.aventstack.extentreports.Status;


import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.DKP.utilities.ExcelReader;

public class BankManagerLogin extends TestBase {
	
	@Test()
	public void bankmanagerloginTest() {
		
		String BankHeader=driver.findElement(By.cssSelector(OR.getProperty("BankHeader"))).getText();
		Assert.assertTrue(BankHeader.equalsIgnoreCase("XYZ Bank"));
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"),"Bank Mananger is not logged in");	
	}
}
