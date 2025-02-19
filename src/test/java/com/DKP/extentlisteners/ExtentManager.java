package com.DKP.extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
/** 
 * @param
 * @author HareKrishna
 * @category
 * @version 1.2
 * @return
 * 
 */
	private static ExtentReports extent;
	    public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Dharmendra Pal");
	        extent.setSystemInfo("Organization", "BPPOr");
	        extent.setSystemInfo("Build no", "JAM-1234");
	        
	        
	        return extent;
	    }

	 

	}
