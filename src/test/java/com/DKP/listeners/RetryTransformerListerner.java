package com.DKP.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformerListerner implements IAnnotationTransformer{
	//Retry Analyzer and Retry Manager are used to Execute Failed Test Cases
	public void transform(ITestAnnotation annotation,Class testclass,Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(RetryAnalyzerManager.class);
	}

}
