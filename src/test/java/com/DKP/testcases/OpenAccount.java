package com.DKP.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.DKP.base.TestBase;
import com.DKP.utilities.DataUtil;

public class OpenAccount extends TestBase {
	static String AccountNumber;
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void openAccountTest(Hashtable<String,String> data) throws InterruptedException {
		
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this test is set as No");
		}
		Assert.assertTrue(isElementPresent("openAccBtn_CSS"),"Open Account TAB is not Present");
		click("openAccBtn_CSS");
		select("customer_CSS",data.get("customer"));
		select("currency_CSS",data.get("currency"));
		click("process_CSS");
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Account created successfully"),"Account not created successfully");
		String AcntOpeningMsg=alert.getText();
		String[] arr= AcntOpeningMsg.split(":");
		//AccountNumber=Integer.parseInt(arr[1]);
		AccountNumber=arr[1];
		System.out.println(AccountNumber);
		alert.accept();
		Thread.sleep(2000);
		//Assert.fail("Open Account Test failed");
	}
}
