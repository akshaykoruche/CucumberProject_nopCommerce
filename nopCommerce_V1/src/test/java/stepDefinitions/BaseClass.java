package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	
	//To generate random string for email
	public static String randomstring() {
		String generatestring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatestring1);
	}
	
	
}
