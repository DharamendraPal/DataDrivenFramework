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

public class CustomerAmountDepositTest extends TestBase {

	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void amountDepositTest(Hashtable<String,String> data) throws InterruptedException {	
	public void amountDepositTest(HashMap<String,String> data) throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{
			throw new SkipException("Skipping test case execution as the runmode for this testdata is set as No");
		}	
		
		ValidateSelectAccount();
		
		/*Depositing Amount*/
		Assert.assertTrue(isElementPresent("DepositTab_XPATH"),"Deposit TAB is not Present");
		click("DepositTab_XPATH");
		type("AmountDeposit_XPATH",data.get("TransactionAmount"));
		click("DepositButton_XPATH");
		Thread.sleep(2000);
		String DepositMessage=driver.findElement(By.xpath(OR.getProperty("DepositSuccess_XPATH"))).getText();
		Assert.assertTrue(DepositMessage.contains("Deposit Successful"));
		log.info("Amount "+data.get("TransactionAmount")+ "Deposit Successful");
		ExtentListeners.test.log(Status.INFO, "Amount "+data.get("TransactionAmount")+ "Deposit Successful");
		Thread.sleep(2000);
		
		new CustomerAmountTransactionDetailsTest().amountTransactionDetailsTest(data.get("TransactionAmount").substring(0,3));
	}
	
	public  void ValidateSelectAccount(){
		
		select("AccountNumber_CSS",OpenAccount.AccountNumber);
		String AccountNumberLable=driver.findElement(By.xpath(OR.getProperty("ValidateCusAccountNum_XPATH"))).getText();
		String AccountNumberDropDown=driver.findElement(By.cssSelector(OR.getProperty("AccountNumber_CSS"))).getText();
		Assert.assertEquals(AccountNumberLable, AccountNumberDropDown);
	}
	
	


}
