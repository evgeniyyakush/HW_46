package core;

import java.io.FileInputStream;
import java.io.Writer;
import java.util.Properties;
import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;

class SignUp {

	static Properties p = new Properties();
	static Writer report;

	static void open(String browser) throws Exception {
		//we load "input" file as we are going to get all of our credentials from it
		p.load(new FileInputStream("./input.properties"));
		//now we open the "browser" and "url" from Common class method open() with "browser" and "url" as its parameters from "./input.properties" file
		//these methods are calling each other
		Common.open(browser, p.getProperty("url"));
	}
	
	// in here we put method for "ExtentReports"
	// "logger" is needed for "ExtentReports"
	static void validate(ExtentTest logger) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		
		// 01 :: First Name
		//we set value
		Common.setValue(By.id(p.getProperty("firstName_id")), p.getProperty("fname_value"));	
		//it's for writing in "ExtentReports"
		Common.writeInfoLine("First Name", p.getProperty("fname_value"), 
		//we check the value we've just set
		// "logger" is needed for "ExtentReports"
		Common.getValue(By.id(p.getProperty("firstName_id"))), logger);
		
		// 02 :: Last Name
		Common.setValue(By.id(p.getProperty("lname_id")), p.getProperty("lname_value"));
		Common.writeInfoLine("Last Name", p.getProperty("lname_value"), 
		Common.getValue(By.id(p.getProperty("lname_id"))), logger);
		
		// 03 :: Email Name
		Common.setValue(By.id(p.getProperty("email_id")), p.getProperty("email_value"));
		Common.writeInfoLine("Email", p.getProperty("email_value"), 
		Common.getValue(By.id(p.getProperty("email_id"))), logger);
		
		// 04 :: Phone Name
		Common.setValue(By.id(p.getProperty("phone_id")), p.getProperty("phone_value"));
		Common.writeInfoLine("Phone", p.getProperty("phone_value"), 
		Common.getValue(By.id(p.getProperty("phone_id"))), logger);
		
		// 05 :: Submit
		Common.writeInfoLine("Submit", p.getProperty("submit_value"), 
		Common.getValue(By.id(p.getProperty("submit_id"))), logger);
		
		// 06 :: TimeStamp
		Common.writeInfoLine("TimeStamp", p.getProperty("timestamp_value"), 
		Common.getValue(By.id(p.getProperty("timestamp_id"))), logger);
				
		// 07 :: Quotes
		Common.writeInfoLine("Quotes", p.getProperty("quotes_value"), 
		Common.getValue(By.id(p.getProperty("quotes_id"))), logger);
				
		// 08 :: F_Title
		Common.writeInfoLine("F_Title", p.getProperty("f_title_value"), 
		Common.getValue(By.id(p.getProperty("f_title_id"))), logger);
				
		// 09 :: Current_Location
		Common.writeInfoLine("Current_Location", p.getProperty("current_location_value"), 
		Common.getValue(By.id(p.getProperty("current_location_id"))), logger);
				
		// 10 :: Weather_Icon
		Common.writeInfoLine("Weather_Icon", p.getProperty("weather_icon_value"), 
		Common.getValue(By.id(p.getProperty("weather_icon_id"))), logger);
		
		// 11 :: Temperature
		Common.writeInfoLine("Temperature", Common.getValue(By.id(p.getProperty("temperature_id"))), 
		Common.getValue(By.id(p.getProperty("temperature_id"))), logger);
				
		// 12 :: F_label_Fn
		Common.writeInfoLine("F_label_Fn", p.getProperty("f_label_fn_value"),
		Common.getValue(By.id(p.getProperty("f_label_fn_id"))), logger);
				
		// 13 :: F_label_Ln
		Common.writeInfoLine("F_label_Ln", p.getProperty("f_label_ln_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ln_id"))), logger);
				
		// 14 :: F_label_Ea
		Common.writeInfoLine("F_label_Ea", p.getProperty("f_label_ea_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ea_id"))), logger);
				
		// 15 :: F_label_Pn
		Common.writeInfoLine("F_label_Pn", p.getProperty("f_label_pn_value"), 
		Common.getValue(By.xpath(p.getProperty("f_label_pn_xpath"))), logger);
				
		// 16 :: F_label_S
		Common.writeInfoLine("F_label_S", p.getProperty("f_label_s_value"), 
		Common.getValue(By.id(p.getProperty("f_label_s_id"))), logger);
				
		// 17 :: Fname_Error
		Common.writeInfoLine("Fname_Error", p.getProperty("fname_error_value"), 
		Common.getValue(By.id(p.getProperty("fname_error_id"))), logger);
				
		// 18 :: Lname_Error
		Common.writeInfoLine("Lname_Error", p.getProperty("lname_error_value"), 
		Common.getValue(By.id(p.getProperty("lname_error_id"))), logger);
				
		// 19 :: Email_Error
		Common.writeInfoLine("Email_Error", p.getProperty("email_error_value"), 
		Common.getValue(By.id(p.getProperty("email_error_id"))), logger);
				
		// 20 :: Phone_Error
		Common.writeInfoLine("Phone_Error", p.getProperty("phone_error_value"), 
		Common.getValue(By.id(p.getProperty("phone_error_id"))), logger);
				
		// 21 :: Rb_label_g
		Common.writeInfoLine("Rb_label_g", p.getProperty("rb_label_g_value"), 
		Common.getValue(By.id(p.getProperty("rb_label_g_id"))), logger);
				
		// 22 :: Rb_label_m
		Common.writeInfoLine("Rb_label_m", p.getProperty("rb_label_m_value"), 
		Common.getValue(By.xpath(p.getProperty("rb_label_m_xpath"))), logger);
				
		// 23 :: Rb_label_f
		Common.writeInfoLine("Rb_label_f", p.getProperty("rb_label_f_value"), 
		Common.getValue(By.id(p.getProperty("rb_label_f_id"))), logger);
				
		// 24 :: Cb_label_t
		Common.writeInfoLine("Cb_label_t", p.getProperty("cb_label_t_value"), 
		Common.getValue(By.id(p.getProperty("cb_label_t_id"))), logger);
				
		// 25 :: ErrorLine
		Common.writeInfoLine("ErrorLine", p.getProperty("ErrorLine_value"), 
		Common.getValue(By.id(p.getProperty("ErrorLine_id"))), logger);
				
		// 26 :: Img_flickr
		Common.writeInfoLine("Img_flickr", p.getProperty("img_flickr_value"), 
		Common.getValue(By.id(p.getProperty("img_flickr_id"))), logger);
				
		// 27 :: Img_facebook
		Common.writeInfoLine("Img_facebook", p.getProperty("img_facebook_value"), 
		Common.getValue(By.id(p.getProperty("img_facebook_id"))), logger);
				
		// 28 :: Img_youtube
		Common.writeInfoLine("Img_youtube", p.getProperty("img_youtube_value"), 
		Common.getValue(By.xpath(p.getProperty("img_youtube_xpath"))), logger);
				
		// 29 :: Img_twitter
		Common.writeInfoLine("Img_twitter", p.getProperty("img_twitter_value"), 
		Common.getValue(By.id(p.getProperty("img_twitter_id"))), logger);
				
		// 30 :: Link_twitter
		Common.writeInfoLine("Link_twitter", p.getProperty("link_twitter_value"), 
		Common.getValue(By.id(p.getProperty("link_twitter_id"))), logger);
				
		// 31 :: Link_facebook
		Common.writeInfoLine("Link_facebook", p.getProperty("link_facebook_value"), 
		Common.getValue(By.id(p.getProperty("link_facebook_id"))), logger);
				
		// 32 :: Link_flickr
		Common.writeInfoLine("Link_flickr", p.getProperty("link_flickr_value"), 
		Common.getValue(By.id(p.getProperty("link_flickr_id"))), logger);
				
		// 33 :: Link_youtube
		Common.writeInfoLine("Link_youtube", p.getProperty("link_youtube_value"), 
		Common.getValue(By.xpath(p.getProperty("link_youtube_xpath"))), logger);
				
		// 34 :: Reset_button
		Common.writeInfoLine("Reset_button", p.getProperty("reset_button_value"), 
		Common.getValue(By.xpath(p.getProperty("reset_button_xpath"))), logger);
				
		// 35 :: Copyright
		Common.writeInfoLine("Copyright", p.getProperty("copyright_value"), 
		Common.getValue(By.xpath(p.getProperty("copyright_xpath"))), logger);
				
		// 36 :: OS_Browser
		Common.writeInfoLine("OS_Browser", p.getProperty("os_browser_value"), 
		Common.getValue(By.id(p.getProperty("os_browser_id"))), logger);
				
		// 37 :: F_Title
		Common.writeInfoLine("F_Title", p.getProperty("f_title_value"), 
		Common.getValue(By.id(p.getProperty("f_title_id"))), logger);
				
		// 38 :: Gender_male
		Common.writeInfoLine("Gender_male", p.getProperty("gender_male_value"), 
		Common.getValue(By.id(p.getProperty("gender_male_id"))), logger);
				
		// 39 :: Gender_female
		Common.writeInfoLine("Gender_female", p.getProperty("gender_female_value"), 
		Common.getValue(By.id(p.getProperty("gender_female_id"))), logger);
				
		// 40 :: Terms
		Common.writeInfoLine("Terms", p.getProperty("terms_value"), 
		Common.getValue(By.id(p.getProperty("terms_id"))), logger);
				
		// 40b :: State
		Common.writeInfoLine("State", p.getProperty("submit_value"), 
		Common.getValue(By.id(p.getProperty("submit_id"))), logger);

	}
	
	
	
	
	
}