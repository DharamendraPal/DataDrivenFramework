package com.DKP.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.DKP.extentlisteners.ExtentListeners;
//import extentlisteners.ExtentListeners;
//import io.github.bonigarcia.wdm.WebDriverManager;
import com.DKP.utilities.DbManager;
import com.DKP.utilities.ExcelReader;
import com.aventstack.extentreports.Status;

public class TestBase {
	/*
	 * WebDriver 
	 * properties 
	 * Logs ------log4j jar,.log,log4j.properties,Logger--Application log file will have manual log and Selenium log file would have auto generated log
	 * ExtentReports 
	 * DB 
	 * Excel 
	 * Mail
	 * ReportNG,ExtentReports
	 * Jenkins
	 */

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	//public static ExcelReader excel= new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	public static ExcelReader excel= new ExcelReader(Paths.get("src", "test", "resources", "excel", "testdata.xlsx").toString());
	public static WebDriverWait wait;
	static WebElement dropdown;
	public static String browser;

	public static void click(String key) {

		if (key.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} else if (key.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(key))).click();
		} else if (key.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}

		log.info("Clicking on an Element: " + key);
		ExtentListeners.test.log(Status.INFO, "Clicking on an Element: " + key);
	}

	public static void select(String key, String value) {

		if (key.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(key)));
		} else if (key.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(key)));
		} else if (key.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(key)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.info("Selecting the value from dropdown " + key + "  selected value as : " + value);
		ExtentListeners.test.log(Status.INFO, "Selecting the value from dropdown " +key+" selected value as : "+value);
	}

	public static boolean isElementPresent(String key) {

		try {
			if (key.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(key)));
			} else if (key.endsWith("_ID")) {

				driver.findElement(By.id(OR.getProperty(key)));
			} else if (key.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(key)));
			}
			log.info("Finding an Element: " + key);
			ExtentListeners.test.log(Status.INFO, "Finding an Element: " + key);

			return true;
		} catch (Throwable t) {
			log.error("Error while finding an Element: " + key + "--Error log is :" + t.getMessage());
			ExtentListeners.test.log(Status.ERROR, "Error while finding an Element: " +key+"--Error log is :"+t.getMessage());

			return false;
		}
	}

	public static void type(String key, String value) {

		if (key.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			;
		} else if (key.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}

		log.info("Typing in an Element: " + key + " entered the value as : " + value);
		ExtentListeners.test.log(Status.INFO, "Typing in an Element: " + key+"entered the value as : "+value);

	}

	/*
	 * public static void verifyEquals(String expected, String actual) {
	 * 
	 * if (Assert.assertEquals(actual, expected)) { // Extent Reports
	 * ExtentListeners.test.log(Status.PASS, " Two String Comparison Passed  : " );
	 * } else { // Extent Reports ExtentListeners.test.log(Status.FAIL,
	 * " Two String Comparison failed  : " ); } }
	 */
	
	
//	public List<WebElement> GetRowsCount(String key) {
//
//		if (key.endsWith("_XPATH")) {
//
//			driver.findElement(By.xpath(OR.getProperty(key)));
//		} else if (key.endsWith("_ID")) {
//
//			driver.findElement(By.id(OR.getProperty(key)));
//		} else if (key.endsWith("_CSS")) {
//
//			List<WebElement> rows=driver.findElements(By.cssSelector(OR.getProperty(key)));
//			//return List<WebElement> ;
//		}
//
//		//log.info("Number of Rows is given Table  " + key");
//		ExtentListeners.test.log(Status.INFO, "Typing in an Element: " + key+" entered the value as : ");
//	}

	public List<WebElement> getRowList(String locatorKey) {
		List<WebElement> elements = null;
		try {
		if (locatorKey.endsWith("_ID")) {
			elements=driver.findElements(By.id(OR.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_XPATH")) {
			elements=driver.findElements(By.xpath(OR.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_CSS")) {
			elements=driver.findElements(By.cssSelector(OR.getProperty(locatorKey)));
		}
		log.info("Getting list of Table WebElement " + locatorKey);
		ExtentListeners.test.info("Getting list of Table WebElement" + locatorKey);
		}catch(Throwable t) {
			ExtentListeners.test.fail("Failed in Getting list of Table WebElement: "+locatorKey);
			//Assert.fail(t.getMessage());
		}
		return  elements;
	}	
	
	@BeforeSuite
	public void setUp() throws MalformedURLException {
		if (driver == null) {

			//PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
			 String log4jPath = Paths.get("src", "test", "resources", "properties", "log4j.properties").toString();
	         PropertyConfigurator.configure(log4jPath);

			try {
				//fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
				String orPropertiesPath = Paths.get("src", "test", "resources", "properties", "OR.properties").toString();
	            fis = new FileInputStream(orPropertiesPath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("OR Properties loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				//fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
				 String configPropertiesPath = Paths.get("src", "test", "resources", "properties", "Config.properties").toString();
		         fis = new FileInputStream(configPropertiesPath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Config Properties loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			/*below Part of Start for Send Execution Report as An email  */
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
				
				browser=System.getenv("browser");
				
			}else {
				browser=Config.getProperty("browser");
			}
				
			Config.setProperty("browser", browser);
			/*Sending Email Part End here */
			
			if (Config.getProperty("browser").equals("chrome")) {

				// WebDriverManager.chromedriver().setup();---in selenium 4 this step not required
				// Create ChromeOptions instance
		        ChromeOptions options = new ChromeOptions();
				// Add arguments to disable the default browser check
				//options.addArguments("--no-default-browser-check");
		        //options.addArguments("--disable-default-apps");
		        //options.addArguments("--no-first-run");
		        //options.addArguments("--disable-popup-blocking");
		        //options.addArguments("--disable-infobars");
		        //options.addArguments("--disable-notifications");
		        //options.addArguments("--disable-extensions");
		        //options.addArguments("--disable-component-extensions-with-background-pages");
		        //options.addArguments("--disable-background-networking");
		        //options.addArguments("--disable-sync");
		        //options.addArguments("--disable-translate");
		        //options.addArguments("--disable-default-browser-check");
		        options.addArguments("--disable-search-engine-choice-screen");
		        
		        // Path to your user profile
		        //String userProfile = "C:\\Users\\HareKrishna\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
		       //options.addArguments("user-data-dir=" + userProfile);
		        // Initialize ChromeDriver with the options
				driver = new ChromeDriver(options);
				log.info("Chrome Browser Launched !!!");
			} else if (Config.getProperty("browser").equals("firefox")) {

				// WebDriverManager.firefoxdriver().setup();---in selenium 4 this step not required
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched !!!");
			} else if ((Config.getProperty("browser").equals("Edge"))){
				
				
				driver  = new EdgeDriver();
				log.info("Edge Browser Launched !!!");
			}
			
			/*Code for execution on Remote Machine*/
			ChromeOptions opt = new ChromeOptions();
			//FirefoxOptions opt=new FirefoxOptions();
			
			//driver = new RemoteWebDriver(new URL("http://localhost:4444"),opt);		
			//driver = new RemoteWebDriver(new URL("http://13.233.238.228:4444"),opt);
			driver = new RemoteWebDriver(new URL("http://13.127.249.234:4444"),opt);
			
			driver.get(Config.getProperty("testsiteurl"));
			log.info("Navigating to the URL : " + Config.getProperty("testsiteurl"));
			DbManager.setMysqlDbConnection();
			log.info("Database connection established");
			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicit.wait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicit.wait"))));

		}

	}

	@AfterSuite
	public void tearDown() {
		if(driver!=null)
		{
			driver.quit();
		}
		
		log.info("Test Execution completed !!!");

	}

}
