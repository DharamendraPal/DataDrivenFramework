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

public class CustomerAmountWithdrawlTest extends TestBase {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void amountwithdrawlTest(Hashtable<String,String> data) throws InterruptedException 
	{
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this test is set as No");
		}	
		
		//Validate Selected Account Number before Withdrawl  
		new CustomerAmountDepositTest().ValidateSelectAccount();
		
		/*WithDrawing  Amount*/
		Assert.assertTrue(isElementPresent("WithdrawlTab_XPATH"),"Withdrawl TAB is not Present");
		click("WithdrawlTab_XPATH");
		Thread.sleep(2000);
		type("AmountWithdrawl_XPATH",data.get("WithDrawlAmount"));
		Thread.sleep(2000);
		click("WithdrawButton_XPATH");
		
		String WithdrawlTransactionMessage=driver.findElement(By.xpath(OR.getProperty("WithDrawSuccess_XPATH"))).getText();
		Assert.assertTrue(WithdrawlTransactionMessage.contains("Transaction successful"));
		log.info("Amount "+data.get("WithDrawlAmount")+ "Withdrawn successfully");
		ExtentListeners.test.log(Status.INFO, "Amount "+data.get("WithDrawlAmount")+ "withdrawn Successfully");
		Thread.sleep(2000);
	}
}
