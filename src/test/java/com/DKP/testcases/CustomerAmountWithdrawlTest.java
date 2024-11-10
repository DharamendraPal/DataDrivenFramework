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

public class CustomerAmountWithdrawlTest extends TestBase {
	
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void amountwithdrawlTest(Hashtable<String,String> data) throws InterruptedException 
	public void amountwithdrawlTest(HashMap<String,String> data) throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		
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
		type("AmountWithdrawl_XPATH",data.get("TransactionAmount"));
		Thread.sleep(2000);
		click("WithdrawButton_XPATH");
		
		String WithdrawlTransactionMessage=driver.findElement(By.xpath(OR.getProperty("WithDrawSuccess_XPATH"))).getText();
		Assert.assertTrue(WithdrawlTransactionMessage.contains("Transaction successful"));
		log.info("Amount "+data.get("TransactionAmount")+ "Withdrawn successfully");
		ExtentListeners.test.log(Status.INFO, "Amount "+data.get("TransactionAmount")+ "withdrawn Successfully");
		Thread.sleep(2000);
		new CustomerAmountTransactionDetailsTest().amountTransactionDetailsTest(data.get("TransactionAmount").substring(0,3));
		
	}
	
}
