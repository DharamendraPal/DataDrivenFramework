package com.DKP.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestProperties {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		
		
		System.out.println(driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText());
		System.out.println(driver.findElement(By.xpath("//span[@ng-show='noAccount']")).getText());
		
		
	}

}
