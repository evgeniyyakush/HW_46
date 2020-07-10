package core;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;

class Common {
	static WebDriver driver;
    static Writer report;
    static Properties p = new Properties();
	static String url;
	static String browser;
    
	static void getWebDriver(String browser){
		//name of the method can be anything
		//it receives this parameter: "-Dbrowser=Firefox" from command down below
		//mvn site -Dbrowser=Firefox -Dtest=ExtentReportsTest
		
		
//		Warnings OFF
		Logger.getLogger("").setLevel(Level.OFF);
//		Driver Path
		String driverPath = "";
		
	
		
/////////////////////////////  Firefox  /////////////////////////////
		//the better prectice is to use IgnoreCase to avoid DifferentCase spelling in command line
		if (browser.equalsIgnoreCase("firefox")) {
			
//			Running on Windows and Mac OS
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))                     driverPath = "/usr/local/bin/firefox";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))   driverPath = "c:\\windows\\geckodriver.exe";
			else throw new IllegalArgumentException("Unknown OS");

//			Driver Path
			System.setProperty("webdriver.gecko.driver", driverPath);
			
//			Driver
			driver = new FirefoxDriver();
			
//			Window size
			driver.manage().window().setSize(new Dimension(1920, 1080));
			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		
		
		
/////////////////////////////  Chrome  /////////////////////////////
		else if (browser.equalsIgnoreCase("chrome")) {

//		Running on Windows and Mac OS
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/chrome";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\chromedriver.exe";
		else throw new IllegalArgumentException("Unknown OS");

//		Driver Path
		System.setProperty("webdriver.chrome.driver", driverPath);

//		Warnings OFF
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		option.addArguments("--disable-notifications");

//		Window size
		driver.manage().window().setSize(new Dimension(1920, 1080));
		//driver.manage().window().maximize();

		//Window size for Windows and Mac OS
		//if (System.getProperty("os.name").toUpperCase().contains("MAC"))							option.addArguments("-start-fullscreen");
		//else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		option.addArguments("--start-maximized");
		//else throw new IllegalArgumentException("Unknown OS");

//		Driver
		driver = new ChromeDriver(option);

//		implicitWaitTime
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

/////////////////////////////  Safari  /////////////////////////////
		else if (browser.equalsIgnoreCase("safari")) {
			
//			Running on Windows and Mac OS
			if (!System.getProperty("os.name").contains("Mac")) {
				throw new IllegalArgumentException("Safari is available only on Mac");
			}
			
//			Driver
			driver = new SafariDriver();
			
//			Window size
			driver.manage().window().setSize(new Dimension(1920, 1080));
			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		
/////////////////////////////  Edge  /////////////////////////////
		else if (browser.equalsIgnoreCase("edge")) {
			
//			Running on Windows and Mac OS
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/edge";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\msedgedriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			
//			Warnings OFF
			System.setProperty("webdriver.edge.driver", driverPath);
			
//			Driver
			driver = new EdgeDriver();
			
//			Window size
			driver.manage().window().setSize(new Dimension(1920, 1080));
			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		}
		
/////////////////////////////  Unknown  WebDriver  /////////////////////////////
		else {throw new WebDriverException("Unknown WebDriver");}
		}
	
	
	//------------------------------------------------------------   Common_Methods  -------------------------------------------------------- //
	
///////////////////////////////////////////////////////////////////////////////
	//openingBrowser
	static void open(String browser, String url){
		//we take browser and pass it to the "getWebDriver()" method
		getWebDriver(browser);
		//and then it take the web page and opends it up
		driver.get(url);
		}
	
///////////////////////////////////////////////////////////////////////////////
	//verifyingPresenceOfElement
	
	//into "By" we enter its locator ("By", it's why which class we are looking for this locator)
	static boolean isElementPresent(By by) throws Exception {
		//we give it ImplicedWaitTime
		//10 seconds of waiting
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//if this Element is Not empty then "highlight & Unhighlight"
		if (!driver.findElements(by).isEmpty()) {
			highlightElement(driver.findElement(by));
			unhighlightElement(driver.findElement(by));
			//if it's present return true
			return true;}
		else return false;}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingSize
	static String getSize(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			// instead of "getSize()" we could used "getRect()" that is more up to date and that take "Size and Location" in HW_45 if get "getSize()" and "getLocation()" do not work.  
			return driver.findElement(by).getSize().toString().replace(", ", "x"); 
		else 
			return "null";}

///////////////////////////////////////////////////////////////////////////////
	//gettingLocation
	static String getLocation(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//getLocation is Bad as it can NOT see Location in Safari
		//that's why in here we have "if if's Safari" then just return "0x0" as "getLocation()" does Not work in Safari
		if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("Safari")) return "(0x0)";
		else {
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
		// instead of "getLocation()" we could used "getRect()" that is more up to date and that take "Size and Location" in HW_45 if get "getSize()" and "getLocation()" do not work.  
		return driver.findElement(by).getLocation().toString().replace(", ", "x"); 
		else return "null";}
		}
	
///////////////////////////////////////////////////////////////////////////////
	//highlightingElement
    public static void highlightElement(WebElement element) throws Exception{
    	((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 3px red');", element);
        Thread.sleep(100);}
    
///////////////////////////////////////////////////////////////////////////////
    //UNhighlightingElement
    public static void unhighlightElement(WebElement element) throws Exception{
    	Thread.sleep(100);
        ((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 0px red');", element);}

///////////////////////////////////////////////////////////////////////////////
    //settingValue
    //method that enters value into the fields we need, name, email and phone number
	static void setValue(By by, String value) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			driver.findElement(by).sendKeys(value);
	}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingValue
	//that take the value we need
	
	//Example for "TimeStamp": when you are getting the value you can ADD 
	//(getting today's date, reformat it and compare with what  we are getting here)
	//the same when we were taking OS and Browser
	//when we did expiration we asked "What date is today",  we can check the validity of the value we are getting from that page
	//in the same way we can check OS and Browser
	//as well we can check the functionality of Error, what's happening when we do not type in some of the values into the fields
	//do it by checking different scenarios 
	
	
	static String getValue(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && 
			 driver.findElement(by).isDisplayed() && driver.findElement(by).getTagName().equalsIgnoreCase("input"))
		return driver.findElement(by).getAttribute("value").toString().trim();

		else if (!driver.findElements(by).isEmpty() && 
				  driver.findElement(by).isDisplayed() && driver.findElement(by).getTagName().equalsIgnoreCase("span"))
			return driver.findElement(by).getText().trim();
		else return "null";}
	
///////////////////////////////////////////////////////////////////////////////
	//Submit
	//simply clicks on the bottom "Submit"
	static void submit(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			driver.findElement(by).submit();}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingBrowser
	//here we get what kind of browser is being used - for the report
	static String getBrowser() {
		String browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toString().trim();
		return browser.replaceFirst(String.valueOf(browser.charAt(0)), String.valueOf(browser.charAt(0)).toUpperCase());
			}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingFileName
	//we get the name of the current web page we are working on right now
	//it automaticly takes the value of that page without typing it in 
	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
			}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingTitleName
	//gets the Title for use if case we need it later on 
	static String getTitleName() {return driver.getTitle().toString().trim();}
	

///////////////////////////////////////////////////////////////////////////////
	//waitingTitlePage
	static void waitTitlePage(String title){
		//we have ExplicidWaitTime in here
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs(title));
		}
	
///////////////////////////////////////////////////////////////////////////////
	//quittingDriver
	//simply quits the driver
	static void quit(){driver.quit();}
	
///////////////////////////////////////////////////////////////////////////////
	//checkingCheckBox
	public static void checkCheckBox(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && 
	    	  driver.findElement(by).isDisplayed() && 
	    	 !driver.findElement(by).isSelected())
	    	 driver.findElement(by).click();}

///////////////////////////////////////////////////////////////////////////////
	//checkingRadioButton
	//checking male or female
	public static void checkRadioButton(By by) {
	     if (!driver.findElements(by).isEmpty() && 
		      driver.findElement(by).isDisplayed() && 
		     !driver.findElement(by).isSelected())
		     driver.findElement(by).click();}
	
///////////////////////////////////////////////////////////////////////////////
	//selectingDropDown
	public static void selectDropDown(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 // new Select(driver.findElement(by)).selectByIndex(5);
	    	 // new Select(driver.findElement(by)).selectByValue(value);  // <option value="CA">
	    	 new Select(driver.findElement(by)).selectByVisibleText(value);
	     	}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingScreenShot
	//we are going to take a screenShot of every picture to have it in the report
	public static String getScreenShot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("_yyyy-MM-dd_HH_mm").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//it's going to be with extension ".png"
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
///////////////////////////////////////////////////////////////////////////////
	//writingInfoLine
	//it's for ExtendReports to print the report
	static void writeInfoLine(String element, String expected, String actual, ExtentTest logger) {
		String info = "Element [" + element + "] - Expected Result [" + expected + "] : Actual Result [" + actual + "]";
		if(expected.equals(actual)) logger.log(Status.INFO, MarkupHelper.createLabel(info, ExtentColor.BLUE));
		else logger.log(Status.INFO, MarkupHelper.createLabel(info, ExtentColor.RED));
		}
	
}
