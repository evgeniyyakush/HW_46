
//We do not have the Main method as we run our script via Allure and ExtentReports
//If I will run "mvn clean" all the history is going to be deleted and I won't see the "TREND" in Allure Report
//which is located in folder "allure-reports" in folder target

package core;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.*;

public class AllureReportTest {
	public WebDriver driver;
	static Properties p = new Properties();
	//	static String browser = "chrome";
	static String browser = System.getProperty("browser"); // -Dbrowser="firefox"
	
	
	//Allure Report works with annotation "@Step"
	@Step("Step [set value] - [{1}]")
	public void setValueTest(By by, String value) {Common.setValue(by, value);};
	
	@Step("Step [validate element] - Expected: {0}/Actual: {1}")
	//it's method
	//with AssertEquals inside of it
	public void assertElement(String expected, String actual) {Assert.assertEquals(expected, actual);};
		
	//------------------------------------------------------------   SignUpTest  -------------------------------------------------------- //
	
	//putting "priority = 1" will ensure us that this Test will start first (yet practically even this won't be working in 100% cases )
	//it's the simplest way to ensure the right order we want
	//first test with "priority = 1", then "priority = 2"... and so on
	
	//"SignUp Page Validating" this will appear in the Allure Report as the description of the Test
	@Test(priority = 1, description="SignUp Page Validating")
	@Description("SignUp Page: Elemets Validation")
	
	
	public void SignUpTest() throws Exception {
		
		// 01 :: First Name
		setValueTest(By.id(p.getProperty("firstName_id")), p.getProperty("fname_value"));
//		Common.setValue(By.id(p.getProperty("fname_id")), p.getProperty("fname_value"));
		assertElement(p.getProperty("fname_value"), 
		Common.getValue(By.id(p.getProperty("firstName_id"))));
//		Assert.assertEquals(p.getProperty("fname_value"), Common.getValue(By.id(p.getProperty("fname_id"))));
		
		// 02 :: Last Name
		setValueTest(By.id(p.getProperty("lname_id")), p.getProperty("lname_value"));
//		Common.setValue(By.id(p.getProperty("lname_id")), p.getProperty("lname_value"));
		assertElement(p.getProperty("lname_value"), 
		Common.getValue(By.id(p.getProperty("lname_id"))));
//		Assert.assertEquals(p.getProperty("lname_value"), Common.getValue(By.id(p.getProperty("lname_id"))));
		
		// 03 :: Email
		setValueTest(By.id(p.getProperty("email_id")), p.getProperty("email_value"));
//		Common.setValue(By.id(p.getProperty("email_id")), p.getProperty("email_value"));
		assertElement(p.getProperty("email_value"), 
		Common.getValue(By.id(p.getProperty("email_id"))));
//		Assert.assertEquals(p.getProperty("email_value"), Common.getValue(By.id(p.getProperty("email_id"))));
		
		// 04 :: Phone
		setValueTest(By.id(p.getProperty("phone_id")), p.getProperty("phone_value"));
//		Common.setValue(By.id(p.getProperty("phone_id")), p.getProperty("phone_value"));
		assertElement(p.getProperty("phone_value"), 
		Common.getValue(By.id(p.getProperty("phone_id"))));
//		Assert.assertEquals(p.getProperty("phone_value"), Common.getValue(By.id(p.getProperty("phone_id"))));
		
		// 05 :: Submit
		assertElement(p.getProperty("submit_value"), 
		Common.getValue(By.id(p.getProperty("submit_id"))));
		
		// 06 :: TimeStamp
		assertElement(p.getProperty("timestamp_value"), 
		Common.getValue(By.id(p.getProperty("timestamp_id"))));
		
		// 07 :: Quotes
		assertElement(p.getProperty("quotes_value"), 
		Common.getValue(By.id(p.getProperty("quotes_id"))));
		
		// 08 :: F_Title
		assertElement(p.getProperty("f_title_value"), 
		Common.getValue(By.id(p.getProperty("f_title_id"))));
		
		// 09 :: Current_Location
		assertElement(p.getProperty("current_location_value"), 
		Common.getValue(By.id(p.getProperty("current_location_id"))));
		
		// 10 :: Weather_Icon
		assertElement(p.getProperty("weather_icon_value"), 
		Common.getValue(By.id(p.getProperty("weather_icon_id"))));
		
		// 11 :: Temperature
		assertElement(Common.getValue(By.id(p.getProperty("temperature_id"))), 
		Common.getValue(By.id(p.getProperty("temperature_id"))));
		
		// 12 :: F_label_Fn
		assertElement(p.getProperty("f_label_fn_value"), 
		Common.getValue(By.id(p.getProperty("f_label_fn_id"))));
		
		// 13 :: F_label_Ln
		assertElement(p.getProperty("f_label_ln_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ln_id"))));
		
		// 14 :: F_label_Ea
		assertElement(p.getProperty("f_label_ea_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ea_id"))));
		
		// 15 :: F_label_Pn
		assertElement(p.getProperty("f_label_pn_value"), 
		Common.getValue(By.xpath(p.getProperty("f_label_pn_xpath"))));
		
		// 16 :: F_label_S
		assertElement(p.getProperty("f_label_s_value"), 
		Common.getValue(By.id(p.getProperty("f_label_s_id"))));
		
		// 17 :: Fname_Error
		assertElement(p.getProperty("fname_error_value"), 
		Common.getValue(By.id(p.getProperty("fname_error_id"))));
		
		// 18 :: Lname_Error
		assertElement(p.getProperty("lname_error_value"), 
		Common.getValue(By.id(p.getProperty("lname_error_id"))));
		
		// 19 :: Email_Error
		assertElement(p.getProperty("email_error_value"), 
		Common.getValue(By.id(p.getProperty("email_error_id"))));
		
		// 20 :: Phone_Error
		assertElement(p.getProperty("phone_error_value"), 
		Common.getValue(By.id(p.getProperty("phone_error_id"))));
		
		// 21 :: Rb_label_g
		assertElement(p.getProperty("rb_label_g_value"), 
		Common.getValue(By.id(p.getProperty("rb_label_g_id"))));
		
		// 22 :: Rb_label_m
		assertElement(p.getProperty("rb_label_m_value"), 
		Common.getValue(By.xpath(p.getProperty("rb_label_m_xpath"))));
		
		// 23 :: Rb_label_f
		assertElement(p.getProperty("rb_label_f_value"), 
		Common.getValue(By.id(p.getProperty("rb_label_f_id"))));
		
		// 24 :: Cb_label_t
		assertElement(p.getProperty("cb_label_t_value"), 
		Common.getValue(By.id(p.getProperty("cb_label_t_id"))));
		
		// 25 :: ErrorLine
		assertElement(p.getProperty("ErrorLine_value"), 
		Common.getValue(By.id(p.getProperty("ErrorLine_id"))));
		
		// 26 :: Img_flickr
		assertElement(p.getProperty("img_flickr_value"), 
		Common.getValue(By.id(p.getProperty("img_flickr_id"))));
		
		// 27 :: Img_facebook
		assertElement(p.getProperty("img_facebook_value"), 
		Common.getValue(By.id(p.getProperty("img_facebook_id"))));
		
		// 28 :: Img_youtube
		assertElement(p.getProperty("img_youtube_value"), 
		Common.getValue(By.xpath(p.getProperty("img_youtube_xpath"))));
		
		// 29 :: Img_twitter
		assertElement(p.getProperty("img_twitter_value"), 
		Common.getValue(By.id(p.getProperty("img_twitter_id"))));
		
		// 30 :: Link_twitter
		assertElement(p.getProperty("link_twitter_value"), 
		Common.getValue(By.id(p.getProperty("link_twitter_id"))));
		
		// 31 :: Link_facebook
		assertElement(p.getProperty("link_facebook_value"), 
		Common.getValue(By.id(p.getProperty("link_facebook_id"))));
		
		// 32 :: Link_flickr
		assertElement(p.getProperty("link_flickr_value"), 
		Common.getValue(By.id(p.getProperty("link_flickr_id"))));
		
		// 33 :: Link_youtube
		assertElement(p.getProperty("link_youtube_value"), 
		Common.getValue(By.xpath(p.getProperty("link_youtube_xpath"))));
		
		// 34 :: Reset_button
		assertElement(p.getProperty("reset_button_value"), 
		Common.getValue(By.xpath(p.getProperty("reset_button_xpath"))));
		
		// 35 :: Copyright
		assertElement(p.getProperty("copyright_value"), 
		Common.getValue(By.xpath(p.getProperty("copyright_xpath"))));
		
		// 36 :: OS_Browser
		assertElement(p.getProperty("os_browser_value"), 
		Common.getValue(By.id(p.getProperty("os_browser_id"))));
		
		// 37 :: F_Title
		assertElement(p.getProperty("f_title_value"), 
		Common.getValue(By.id(p.getProperty("f_title_id"))));
		
		// 38 :: Gender_male
		assertElement(p.getProperty("gender_male_value"), 
		Common.getValue(By.id(p.getProperty("gender_male_id"))));
		
		// 39 :: Gender_female
		assertElement(p.getProperty("gender_female_value"), 
		Common.getValue(By.id(p.getProperty("gender_female_id"))));
		
		// 40 :: Terms
		assertElement(p.getProperty("terms_value"), 
		Common.getValue(By.id(p.getProperty("terms_id"))));
		
		// 40b :: State
		assertElement(p.getProperty("state_value_signUp"), 
		Common.getValue(By.id(p.getProperty("state_id"))));
		
		// Submit
		Common.submit(By.id(p.getProperty("submit_id")));
	}
	
	//------------------------------------------------------------   ConfirmationTest  -------------------------------------------------------- //

	//"dependsOnMethods" will not let the Test to go further if any Assertion in previous Test would fail
	@Test(dependsOnMethods = { "SignUpTest" }, priority = 2, description="Confirmation Page Validating")
	@Description("Confirmation: Elemets Validation")

	public void ConfirmationTest() throws Exception {
		Common.waitTitlePage("Confirmation");
		
		// 41 :: First Name
		assertElement(p.getProperty("fname_value"), Common.getValue(By.id(p.getProperty("firstName_id"))));
		
		// 42 :: Last Name
		assertElement(p.getProperty("lname_value"), Common.getValue(By.id(p.getProperty("lname_id"))));
		
		// 43 :: Email
		assertElement(p.getProperty("email_value"), Common.getValue(By.id(p.getProperty("email_id"))));
		
		// 44 :: Phone
		assertElement(p.getProperty("phone_value"), Common.getValue(By.id(p.getProperty("phone_id"))));	
		
		// 45 :: F_title
		assertElement(p.getProperty("f_title_value_conf"), Common.getValue(By.id(p.getProperty("f_title_id"))));	
		
		// 46 :: F_label_fn
		assertElement(p.getProperty("f_label_fn_value"), Common.getValue(By.id(p.getProperty("f_label_fn_id"))));	
		
		// 47 :: F_label_ln
		assertElement(p.getProperty("f_label_ln_value"), Common.getValue(By.id(p.getProperty("f_label_ln_id"))));	
		
		// 48 :: F_label_ea
		assertElement(p.getProperty("f_label_ea_value"), Common.getValue(By.id(p.getProperty("f_label_ea_id"))));	
		
		// 49 :: F_label_Pn
		assertElement(p.getProperty("f_label_pn_value"), Common.getValue(By.xpath(p.getProperty("f_label_pn_xpath"))));	
		
		// 50 :: Rb_label_g
		assertElement(p.getProperty("rb_label_g_value"), Common.getValue(By.id(p.getProperty("rb_label_g_id"))));	
		
		// 51 :: F_label_s
		assertElement(p.getProperty("f_label_s_value"), Common.getValue(By.id(p.getProperty("f_label_s_id"))));	
		
		// 52 :: Cb_label_t
		assertElement(Common.getValue(By.id(p.getProperty("cb_label_t_id"))), Common.getValue(By.id(p.getProperty("cb_label_t_id"))));	
		
		// 53 :: Back_button
		assertElement(p.getProperty("back_button_value"), Common.getValue(By.id(p.getProperty("back_button_id"))));	
		
		// 54 :: Copyright
		assertElement(Common.getValue(By.xpath(p.getProperty("copyright_xpath"))), Common.getValue(By.xpath(p.getProperty("copyright_xpath"))));	
		
		// 55 :: Gender
		assertElement(Common.getValue(By.xpath(p.getProperty("gender_xpath"))), Common.getValue(By.xpath(p.getProperty("gender_xpath"))));	
		
		// 56 :: State
		assertElement(p.getProperty("state_value_con"), Common.getValue(By.xpath(p.getProperty("state_xpath"))));	
		
		// 57 :: Terms
		assertElement(Common.getValue(By.id(p.getProperty("terms_id"))), Common.getValue(By.id(p.getProperty("terms_id"))));	
		
		
	}

	//------------------------------------------------------------   BeforeClass  -------------------------------------------------------- //
	
	@BeforeClass
	@Step("Step [open browser]")
	public void setUp() throws Exception {
		//checking the presence of the right browser
		if (browser == null) {
			System.err.println("Please provide browser: -Dbrowser=firefox");
			System.exit(0);
		} else if (!browser.equalsIgnoreCase("chrome") && !browser.equalsIgnoreCase("firefox")
				&& !browser.equalsIgnoreCase("safari") && !browser.equalsIgnoreCase("edge")) {
			System.err.println("Framework supports only: Chrome, Firefox, Safari or Edge");
			System.exit(0);
		}
		SignUp.open(browser);
		p.load(new FileInputStream("./input.properties"));
	}

	//------------------------------------------------------------   AfterClass  -------------------------------------------------------- //
	
	@AfterClass
	@Step("Step [close browser]")
	public void tearDown() {
		Common.quit();
	}

}



