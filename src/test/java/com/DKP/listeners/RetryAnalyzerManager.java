package com.DKP.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerManager implements IRetryAnalyzer {
	
	int counter =0;
	int retrylimit=3;
	
	//Retry Analyzer and Retry Manager are used to Execute Failed Test Cases
	public boolean retry(ITestResult result)
	{
		if(counter <retrylimit)
		{
			counter ++;
			return true;
		}	
		return false;
		
	}
			

}
