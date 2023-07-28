package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;


public class steps extends BaseClass{
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  lp=new LoginPage(driver);
	  addCust = new AddcustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("click on Login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else {
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("User clicks on customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		addCust.openCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	    addCust.openCustomersItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addCust.openAddCustomers();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    addCust.enterEmail(randomstring()+"@gmail.com");
	    addCust.enterPassword("qwertytu");
	    addCust.enterFirstName("Akshay");
	    addCust.enterLastName("Koruche");
	    addCust.selectGender("male");
	    addCust.selectDateOfBirth("11/30/1994");
	    addCust.enterCompanyName("AK Corporation");
	    addCust.isTaxExempt("yes");
	    addCust.selectNewsLetter("Test store 2");
	    addCust.selectCustomerRoles("Guests");
	    addCust.selectVendorManager("Vendor 1");
	    addCust.isActive("yes");
	    addCust.enterAdminComment("NA");
	    Thread.sleep(1000);
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addCust.save();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		addCust.confirmation();
	}
}
