package com.DKP.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.DKP.base.TestBase;

public class ScreenshotUtil extends TestBase {

	
	public static String fileName;
	
	
	public static void captureScreenshot() {

		Date d = new Date();
		
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			//FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\target\\reports\\" + fileName));
			//FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + fileName));
			
			String basePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "reports";
			FileUtils.copyFile(screenshot, new File(basePath + File.separator + fileName));
			
			String basePath1 = System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports"+ File.separator + "html";
			FileUtils.copyFile(screenshot, new File(basePath1 + File.separator + fileName));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void captureElementScreenshot(WebElement element) {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
