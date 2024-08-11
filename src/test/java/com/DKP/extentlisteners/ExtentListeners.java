package com.DKP.extentlisteners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.DKP.base.TestBase;
import com.DKP.utilities.DataUtil;
import com.DKP.utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.DKP.extentlisteners.ExtentManager;
import com.DKP.utilities.MonitoringMail;
import com.DKP.utilities.TestConfig;



public class ExtentListeners extends TestBase implements ITestListener,ISuiteListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String messageBody;
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\target\\reports\\"+fileName);
	
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

	
		 test = extent.createTest(result.getTestClass().getName()+"    @TestCase : "+result.getMethod().getMethodName());
		 //Checking the run mode from test Suite
		 if (!(DataUtil.isTestRunnable(result.getMethod().getMethodName(), excel)))
			{
			 	throw new SkipException("Skipping the test "+result.getMethod().getMethodName()+  "   As runmode is set as No");
					
			}
		 
	}

	public void onTestSuccess(ITestResult result) {

	
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		//ReportNG
		
		  ScreenshotUtil.captureScreenshot();
		  System.setProperty("org.uncommons.reportng.escape-output","false");
		  Reporter.log("<a href="+ScreenshotUtil.fileName+" target=\"_blank\">Screenshot link</a>"); 
		  Reporter.log("<br>");
		  Reporter.log("<a href="+ScreenshotUtil.fileName+" target=\"_blank\"><img src="+ScreenshotUtil.fileName+" height=200 width=200></a>");
		 

//////////////////////////////////
		
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(excepionMessage);
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";		
	
		try {
			
			String screenshot = ScreenshotUtil.fileName;
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
		
		

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName.toUpperCase()+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenProject/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

	

}
