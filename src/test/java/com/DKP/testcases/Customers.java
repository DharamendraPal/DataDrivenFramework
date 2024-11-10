package com.DKP.testcases;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.DKP.base.TestBase;
import com.DKP.extentlisteners.ExtentListeners;
import com.DKP.utilities.DataUtil;
import com.aventstack.extentreports.Status;

public class Customers extends TestBase{
	
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	//public void Validatecustomers(Hashtable<String,String> data) throws InterruptedException {
	public void Validatecustomers(HashMap<String,String> data) throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		if(!(data.get("runmode").equalsIgnoreCase("Y")))
		{	
			throw new SkipException("Skipping test case execution as the runmode for this testcase is set as No");
		}
		Assert.assertTrue(isElementPresent("customersBtn_CSS"),"Customers TAB is not Present");
		click("customersBtn_CSS");
		Thread.sleep(2000);
		SearchCustomer(data.get("firstName"));
		List<WebElement> WTable=driver.findElements(By.xpath(OR.getProperty("Table_XPATH")));		
		for(int row=1 ; row<=WTable.size();row++ )
		{
			for(int col=1; col<=3;col++)
			{		
				String CustomerDetails=driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr["+row+"]/td["+col+"]")).getText();
				if(CustomerDetails.equals(data.get("firstName")))
				{
					log.info("FirstName "+data.get("firstName")+"is as per expected firstName from ExcelSheet");
					ExtentListeners.test.log(Status.INFO, "FirstName "+data.get("firstName")+" is as per expected firstName from ExcelSheet");
				}else if(CustomerDetails.equals(data.get("lastName"))){
					log.info("lastName "+data.get("lastName")+"is as per expected lastName from ExcelSheet");
					ExtentListeners.test.log(Status.INFO, "lastName "+data.get("lastName")+" is as per expected lastName from ExcelSheet");
				}else if(CustomerDetails.equals(data.get("postCode"))){
					log.info("postCode "+data.get("postCode")+"is as per expected postCode from ExcelSheet");
					ExtentListeners.test.log(Status.INFO, "postCode "+data.get("postCode")+" is as per expected postCode from ExcelSheet");
				}else{
					log.info("Customer Data From Test Data Sheet not present under Customer Data Table");
					ExtentListeners.test.log(Status.INFO, "Customer Data From Test Data Sheet not present under Customer Data Table");
				}
			}
		}
		DeleteCustomer(data.get("firstName"));
		
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
	
	public void SearchCustomer(String data) {
		if(isElementPresent("searchcustomer_XPATH"))
		{
			type("searchcustomer_XPATH",data);
			log.info("Search Customer Textbox  is Editable");
			ExtentListeners.test.log(Status.INFO, "Search Customer Textbox  is Editable");
		}
		else
		{
			log.info("Search Customer Textbox  is not Present");
			ExtentListeners.test.log(Status.INFO, "Search Customer Textbox  is not Present");
		}	
	}
	
	public void DeleteCustomer(String string) {
		if(isElementPresent("DeleteBtn_CSS"))
		{
			click("DeleteBtn_CSS");
			log.info("Customer Delete button is Present");
			ExtentListeners.test.log(Status.INFO, "Customer Delete button is Present");
		}
		else
		{
			log.info("Customer Delete button is not Present");
			ExtentListeners.test.log(Status.INFO, "Customer Delete button is not Present");
		}
	}
}
