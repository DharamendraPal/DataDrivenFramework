package com.DKP.testcases;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.DKP.utilities.DataUtil;

public class AddCustomer extends TestBase {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {	public void addCustomerTest(HashMap<String,String> data) throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this is set as No");
		}
		
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"),"Add Customer TAB is not Present");
		
		click("addCustBtn_CSS");		type("firstName_CSS",data.get("firstName"));
		type("lastName_CSS",data.get("lastName"));
		type("postCode_CSS",data.get("postCode"));
		click("addCustomer_CSS");
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Customer added successfully"),"Customer not added successfully");
		alert.accept();
		Thread.sleep(2000);
		//Assert.fail("Add Customer Test failed");	
	}
	
	

	

}
