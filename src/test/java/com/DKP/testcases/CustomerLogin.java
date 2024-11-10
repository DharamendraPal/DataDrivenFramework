package com.DKP.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.DKP.utilities.DataUtil;

public class CustomerLogin extends TestBase {
	
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void customerloginTest(Hashtable<String,String> data) throws InterruptedException {
	public void customerloginTest(HashMap<String,String> data) throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this testdata is set as No");
		}	
		
		click("CusLogBtn_XPATH");
		String BankHeader=driver.findElement(By.cssSelector(OR.getProperty("BankHeader"))).getText();
		Assert.assertTrue(BankHeader.equalsIgnoreCase("XYZ Bank"));
		select("customer_CSS",data.get("customer"));
		click("CusLoginBtn_XPATH");
		Thread.sleep(2000);
		String CustomerName=driver.findElement(By.xpath(OR.getProperty("CusWelcome_XPATH"))).getText();
		Assert.assertEquals(data.get("customer"), CustomerName);
		String AccountNumber=driver.findElement(By.xpath(OR.getProperty("ValidateCusAccountNum_XPATH"))).getText();
		Assert.assertEquals(OpenAccount.AccountNumber, AccountNumber);
		//Assert.assertTrue(isElementPresent("CusWelcome_XPATH"),"Customer not logged in");
		//Assert.fail("Customer  Login Test failed");
	}
	
	


}
