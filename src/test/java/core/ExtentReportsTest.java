
//We do not have the Main method as we run our script via Allure and ExtentReports


//using Assertions is bad as if one Assertion died others are not being checked at all. 
//if all 4 Assertions did NOT pass we will see Only the first one. 

package core;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	static Properties p = new Properties();
//	static String browser = "chrome";
	static String browser = System.getProperty("browser"); 	// -Dbrowser="firefox"

	//------------------------------------------------------------   SignUpTest  -------------------------------------------------------- //
	
	@Test(priority = 0)

	public void SignUpTest() throws Exception {
		logger = extent.createTest("SignUp Page Validation");
		//In here we start calling method "validate()" in "SignUp" class 
		
		SignUp.validate(logger);
		
		// 01 :: First Name
		//Assertion is checking whether it is true or not
		//we check whether the value from the properties file is the same as on the page
		//and I just compare these two values
		//if these two  values are the same THEN Assertion is going to be True
		
		Assert.assertEquals(p.getProperty("fname_value"), Common.getValue(By.id(p.getProperty("firstName_id"))));
		// 02 :: Last Name
		Assert.assertEquals(p.getProperty("lname_value"), Common.getValue(By.id(p.getProperty("lname_id"))));
		// 03 :: Email
		Assert.assertEquals(p.getProperty("email_value"), Common.getValue(By.id(p.getProperty("email_id"))));
		// 04 :: Phone
		Assert.assertEquals(p.getProperty("phone_value"), Common.getValue(By.id(p.getProperty("phone_id"))));	
		// 05 :: Submit
		Assert.assertEquals(p.getProperty("submit_value"), Common.getValue(By.id(p.getProperty("submit_id"))));
		// 06 :: TimeStamp
		Assert.assertEquals(p.getProperty("timestamp_value"), Common.getValue(By.id(p.getProperty("timestamp_id"))));
		// 07 :: Quotes
		Assert.assertEquals(p.getProperty("quotes_value"), Common.getValue(By.id(p.getProperty("quotes_id"))));
		// 08 :: F_Title
		Assert.assertEquals(p.getProperty("f_title_value"), Common.getValue(By.id(p.getProperty("f_title_id"))));
		// 09 :: Current_Location
		Assert.assertEquals(p.getProperty("current_location_value"), Common.getValue(By.id(p.getProperty("current_location_id"))));	
		// 10 :: Weather_Icon
		Assert.assertEquals(p.getProperty("weather_icon_value"), Common.getValue(By.id(p.getProperty("weather_icon_id"))));
		// 11 :: Temperature
		Assert.assertEquals(Common.getValue(By.id(p.getProperty("temperature_id"))), Common.getValue(By.id(p.getProperty("temperature_id"))));
		// 12 :: F_label_Fn
		Assert.assertEquals(p.getProperty("f_label_fn_value"), Common.getValue(By.id(p.getProperty("f_label_fn_id"))));
		// 13 :: F_label_Ln
		Assert.assertEquals(p.getProperty("f_label_ln_value"), Common.getValue(By.id(p.getProperty("f_label_ln_id"))));
		// 14 :: F_label_Ea
		Assert.assertEquals(p.getProperty("f_label_ea_value"), Common.getValue(By.id(p.getProperty("f_label_ea_id"))));
		// 15 :: F_label_Pn
		Assert.assertEquals(p.getProperty("f_label_pn_value"), Common.getValue(By.xpath(p.getProperty("f_label_pn_xpath"))));
		// 16 :: F_label_S
		Assert.assertEquals(p.getProperty("f_label_s_value"), Common.getValue(By.id(p.getProperty("f_label_s_id"))));
		// 17 :: Fname_Error
		Assert.assertEquals(p.getProperty("fname_error_value"), Common.getValue(By.id(p.getProperty("fname_error_id"))));
		// 18 :: Lname_Error
		Assert.assertEquals(p.getProperty("lname_error_value"), Common.getValue(By.id(p.getProperty("lname_error_id"))));
		// 19 :: Email_Error
		Assert.assertEquals(p.getProperty("email_error_value"), Common.getValue(By.id(p.getProperty("email_error_id"))));
		// 20 :: Phone_Error
		Assert.assertEquals(p.getProperty("phone_error_value"), Common.getValue(By.id(p.getProperty("phone_error_id"))));
		// 21 :: Rb_label_g
		Assert.assertEquals(p.getProperty("rb_label_g_value"), Common.getValue(By.id(p.getProperty("rb_label_g_id"))));
		// 22 :: Rb_label_m
		Assert.assertEquals(p.getProperty("rb_label_m_value"), Common.getValue(By.xpath(p.getProperty("rb_label_m_xpath"))));
		// 23 :: Rb_label_f
		Assert.assertEquals(p.getProperty("rb_label_f_value"), Common.getValue(By.id(p.getProperty("rb_label_f_id"))));
		// 24 :: Cb_label_t
		Assert.assertEquals(p.getProperty("cb_label_t_value"), Common.getValue(By.id(p.getProperty("cb_label_t_id"))));
		// 25 :: ErrorLine
		Assert.assertEquals(p.getProperty("ErrorLine_value"), Common.getValue(By.id(p.getProperty("ErrorLine_id"))));
		// 26 :: Img_flickr
		Assert.assertEquals(p.getProperty("img_flickr_value"), Common.getValue(By.id(p.getProperty("img_flickr_id"))));
		// 27 :: Img_facebook
		Assert.assertEquals(p.getProperty("img_facebook_value"), Common.getValue(By.id(p.getProperty("img_facebook_id"))));
		// 28 :: Img_youtube
		Assert.assertEquals(p.getProperty("img_youtube_value"), Common.getValue(By.xpath(p.getProperty("img_youtube_xpath"))));
		// 29 :: Img_twitter
		Assert.assertEquals(p.getProperty("img_twitter_value"), Common.getValue(By.id(p.getProperty("img_twitter_id"))));
		// 30 :: Link_twitter
		Assert.assertEquals(p.getProperty("link_twitter_value"), Common.getValue(By.id(p.getProperty("link_twitter_id"))));
		// 31 :: Link_facebook
		Assert.assertEquals(p.getProperty("link_facebook_value"), Common.getValue(By.id(p.getProperty("link_facebook_id"))));
		// 32 :: Link_flickr
		Assert.assertEquals(p.getProperty("link_flickr_value"), Common.getValue(By.id(p.getProperty("link_flickr_id"))));
		// 33 :: Link_youtube
		Assert.assertEquals(p.getProperty("link_youtube_value"), Common.getValue(By.xpath(p.getProperty("link_youtube_xpath"))));
		// 34 :: Reset_button
		Assert.assertEquals(p.getProperty("reset_button_value"), Common.getValue(By.xpath(p.getProperty("reset_button_xpath"))));
		// 35 :: Copyright
		Assert.assertEquals(p.getProperty("copyright_value"), Common.getValue(By.xpath(p.getProperty("copyright_xpath"))));
		// 36 :: OS_Browser
		Assert.assertEquals(p.getProperty("os_browser_value"), Common.getValue(By.id(p.getProperty("os_browser_id"))));
		// 37 :: F_Title
		Assert.assertEquals(p.getProperty("f_title_value"), Common.getValue(By.id(p.getProperty("f_title_id"))));
		// 38 :: Gender_male
		Assert.assertEquals(p.getProperty("gender_male_value"), Common.getValue(By.id(p.getProperty("gender_male_id"))));
		// 39 :: Gender_female
		Assert.assertEquals(p.getProperty("gender_female_value"), Common.getValue(By.id(p.getProperty("gender_female_id"))));
		// 40 :: Terms
		Assert.assertEquals(p.getProperty("terms_value"), Common.getValue(By.id(p.getProperty("terms_id"))));
		// 40b :: State
		Assert.assertEquals(p.getProperty("state_value_signUp"), Common.getValue(By.id(p.getProperty("state_id"))));
		
		
	
		
		// Submit	
		Common.submit(By.id(p.getProperty("submit_id")));
	}
	
	//------------------------------------------------------------   ConfirmationTest  -------------------------------------------------------- //

	// after we wrote "dependsOnMethods"
	//means if anything in the Test before will fail
	//the next Test will not start
	//this Next Test will start Only if the "SignUpTest" is going to be Passed
	//where "SignUpTest" is going to be Passed where all the Assertions are going to be Passed/True0
	
	//for each Element we also could make new Test/new Test for every single Element
	//where here we now have One Test for One whole Page
	//in this Report we are going to have just two Tests: 1st and 2d pages/
	
	@Test(dependsOnMethods = { "SignUpTest" }, priority = 1)
	
	public void ConfirmationTest() throws Exception {
		//here we wait till the Title of the page appears
		//using ExplicidWaitTime
		Common.waitTitlePage("Confirmation");
		//it's our report
		logger = extent.createTest("Confirmation Page Validation");
		//here we run Test on "Confirmation" page
		//here we start "Listener" that is going to record all the data
		Confirmation.validate(logger);
		
		//here we use out Assertions
		Assert.assertEquals(p.getProperty("fname_value"), Common.getValue(By.id(p.getProperty("firstName_id"))));
		// Last Name
		Assert.assertEquals(p.getProperty("lname_value"), Common.getValue(By.id(p.getProperty("lname_id"))));
		// Email Name
		Assert.assertEquals(p.getProperty("email_value"), Common.getValue(By.id(p.getProperty("email_id"))));
		// Phone Name
		Assert.assertEquals(p.getProperty("phone_value"), Common.getValue(By.id(p.getProperty("phone_id"))));

		
		
		//add 36 Elements 
	}

	//------------------------------------------------------------   BeforeClass  -------------------------------------------------------- //
	//here we check our browser
	
	@BeforeClass
	public void beforeClass() throws Exception {
		if(browser == null) {System.err.println("Please provide browser: -Dbrowser=firefox");  //and then just Exit!
				  System.exit(0);}
		
		else if(!browser.equalsIgnoreCase("chrome") &&
				   !browser.equalsIgnoreCase("firefox") &&
				   !browser.equalsIgnoreCase("safari") &&
				   !browser.equalsIgnoreCase("edge")) 
				{System.err.println("Framework supports only: Chrome, Firefox, Safari or Edge"); 
				  System.exit(0);
				}
		//if one of the browsers above were detected then go to the next step
		SignUp.open(browser);
		//and we are loadign "./input.properties" file
		p.load(new FileInputStream("./input.properties"));
		}

	//------------------------------------------------------------   AfterClass  -------------------------------------------------------- //
	//we simply quit
	@AfterClass
	public void afterClass() {
		Common.quit();
		}

	//------------------------------------------------------------   BeforeTest  -------------------------------------------------------- //
	//we write this for "ExtentReports"
	//this is what we are going to have before every Test
	@BeforeTest
	public void startReport() {
		//here we put "url" of this report
		//it can be any
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extentreports.html");
		//it's for ExtentReports 
		//we make a Header
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User Name", "Evgeniy Yakush");
		extent.setSystemInfo("Browser", browser);
		htmlReporter.config().setDocumentTitle("Sign Up");
		htmlReporter.config().setReportName("Sign Up Validation");
		htmlReporter.config().setTheme(Theme.STANDARD); // It can be set to the "DARK" mode by simply putting "DARK" instead of "STANDARD"
	}

	//------------------------------------------------------------   AfterMethod  -------------------------------------------------------- //
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		//here we are going to make screenShot after every Test
		String screenshotPath = Common.getScreenShot(result.getName());
		logger.addScreenCaptureFromPath(screenshotPath);
		if (result.getStatus() == ITestResult.FAILURE) {
		//here we can have different colors for it. 
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}
	
	//------------------------------------------------------------   AfterTest  -------------------------------------------------------- //
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}


