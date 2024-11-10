package com.DKP.testcases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.aventstack.extentreports.Status;

public class CustomerAmountTransactionDetailsTest extends TestBase {	
	

	
	public void amountTransactionDetailsTest(String TransactionAmount) throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(2000);
		Assert.assertTrue(isElementPresent("TransactionsTAB_XPATH"),"Transactions TAB is not Present");
		
		click("TransactionsTAB_XPATH");
		Thread.sleep(2000);	
		/*Write Code to See transaction details */ 
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("TransactionTable_XPATH"))));
		 List<WebElement> Tnxrecords=driver.findElements(By.xpath(OR.getProperty("TransactionTable_XPATH")));
		 boolean isTransactionFound = false;
		 for(int row=1 ; row<=Tnxrecords.size();row++ )
		 {
			String TransactionDetails=driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+row+"]/td[2]")).getText();
			if(TransactionDetails.equals(TransactionAmount))
			 {
				log.info("Transaction Amount "+TransactionAmount+" record is present under Transaction Table as per expected Transaction Amount ");
				ExtentListeners.test.log(Status.INFO, "Transaction Amount "+TransactionAmount+" record is present under Transaction Table as per expected Transaction Amount ");
				isTransactionFound = true;
			    break; // Break out of the inner loop once a match is found
			  }
			 	Thread.sleep(2000);
		 }
		 if (!isTransactionFound) 
		 {
		        log.info("Transaction Record from Test Data Sheet not present under Transaction Table");
		        ExtentListeners.test.log(Status.INFO, "Transaction Record from Test Data Sheet not present under Transaction Table");
		  }
		 
		 //ResetTransaction();
		 BackTransaction();

	}
	public void BackTransaction() throws InterruptedException 
	{	
		if(isElementPresent("BackButton_XPATH"))
		{
			click("BackButton_XPATH");
			Thread.sleep(2000);
			if(isElementPresent("TransactionsTAB_XPATH"))
			 {
				 log.info("Transaction Tab is Present.Control has return on Welcome Page");
				 ExtentListeners.test.log(Status.INFO, "Transaction Tab is Present.Control has retunr on Welcome Page"); 
			 }
			 else
			 {
				 log.error("Transaction Tab is not Present.Control has not return on Welcome Page");
				 ExtentListeners.test.log(Status.ERROR, "Transaction Tab is not Present.Control has not return on Welcome Page");
			 }
		}
		else
		{
			log.info("Back button is not Present on Transaction Page");
			ExtentListeners.test.log(Status.INFO, "Back button is not Present on Transaction Page");
		}
	}
	
	public void ResetTransaction() 
	{	
		if(isElementPresent("ResetButton_XPATH"))
		{
			 click("ResetButton_XPATH"); 
			
			 List<WebElement> TransactionRecord=driver.findElements(By.xpath(OR.getProperty("TransactionTable_XPATH")));
			 if(TransactionRecord.size()==1) 
			 {
				 log.info("Transaction Table has been Reset.There is no row within this transaction table");
				 ExtentListeners.test.log(Status.INFO, "Transaction Table has been Reset.There is no row within this transaction table");
			 }
			 else
			 {
				 log.error("Transaction Table has not been Reset.There are still rows within this transaction table");
				 ExtentListeners.test.log(Status.ERROR, "Transaction Table has not been Reset.There are still rows within this transaction table");
			 }
		}
		else
		{
			log.info("Transaction Reset button is not Present");
			ExtentListeners.test.log(Status.INFO, "Transaction Reset button is not Present");
		}
	}


}
