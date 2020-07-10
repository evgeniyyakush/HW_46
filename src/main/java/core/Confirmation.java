package core;

import java.io.FileInputStream;
import java.io.Writer;
import java.util.Properties;
import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;

class Confirmation {

	static Properties p = new Properties();
	static Writer report;

	static void validate(ExtentTest logger) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		
		// 41 :: First Name
		//here we just get values that were set on "SignUp" page 
		Common.writeInfoLine("First Name", p.getProperty("fname_value"), 
		Common.getValue(By.id(p.getProperty("firstName_id"))), logger);
		
		// 42 :: Last Name
		Common.writeInfoLine("Last Name", p.getProperty("lname_value"), 
		Common.getValue(By.id(p.getProperty("lname_id"))), logger);
		
		// 43 :: Email
		Common.writeInfoLine("Email", p.getProperty("email_value"), 
		Common.getValue(By.id(p.getProperty("email_id"))), logger);
		
		// 44 :: Phone
		Common.writeInfoLine("Phone", p.getProperty("phone_value"), 
		Common.getValue(By.id(p.getProperty("phone_id"))), logger);
		
		// 45 :: F_title
		//here we just get values that were set on "SignUp" page 
		Common.writeInfoLine("F_title", Common.getValue(By.id(p.getProperty("f_title_id"))), 
		Common.getValue(By.id(p.getProperty("f_title_id"))), logger);
		
		// 46 :: F_label_fn
		Common.writeInfoLine("F_label_fn", p.getProperty("f_label_fn_value"), 
		Common.getValue(By.id(p.getProperty("f_label_fn_id"))), logger);
		
		// 47 :: F_label_ln
		Common.writeInfoLine("F_label_fn", p.getProperty("f_label_ln_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ln_id"))), logger);
		
		// 48 :: F_label_ea
		Common.writeInfoLine("F_label_ea", p.getProperty("f_label_ea_value"), 
		Common.getValue(By.id(p.getProperty("f_label_ea_id"))), logger);
		
		// 49 :: F_label_Pn
		Common.writeInfoLine("F_label_Pn", p.getProperty("f_label_pn_value"), 
		Common.getValue(By.xpath(p.getProperty("f_label_pn_xpath"))), logger);
		
		// 50 :: Rb_label_g
		//here we just get values that were set on "SignUp" page 
		Common.writeInfoLine("Rb_label_g", p.getProperty("rb_label_g_value"), 
		Common.getValue(By.id(p.getProperty("rb_label_g_id"))), logger);
		
		// 51 :: F_label_s
		Common.writeInfoLine("F_label_s", p.getProperty("f_label_s_value"), 
		Common.getValue(By.id(p.getProperty("f_label_s_id"))), logger);
		
		// 52 :: Cb_label_t
		Common.writeInfoLine("Cb_label_t", Common.getValue(By.id(p.getProperty("cb_label_t_id"))), 
		Common.getValue(By.id(p.getProperty("cb_label_t_id"))), logger);
		
		// 53 :: Back_button
		Common.writeInfoLine("Back_button", p.getProperty("back_button_value"), 
		Common.getValue(By.id(p.getProperty("back_button_id"))), logger);
		
		// 54 :: Copyright
		//here we just get values that were set on "SignUp" page 
		Common.writeInfoLine("Copyright", p.getProperty("copyright_value"), 
		Common.getValue(By.xpath(p.getProperty("copyright_xpath"))), logger);
		
		// 55 :: Gender
		Common.writeInfoLine("Gender", Common.getValue(By.xpath(p.getProperty("gender_xpath"))), 
		Common.getValue(By.xpath(p.getProperty("gender_xpath"))), logger);
		
		// 56 :: State
		Common.writeInfoLine("State", Common.getValue(By.xpath(p.getProperty("state_xpath"))), 
		Common.getValue(By.xpath(p.getProperty("state_xpath"))), logger);
		
		// 56 :: Terms
		Common.writeInfoLine("Terms", Common.getValue(By.id(p.getProperty("terms_id"))), 
		Common.getValue(By.id(p.getProperty("terms_id"))), logger);
		
		
	}
}
