package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.AddgiftCard;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class steps extends BaseClass{
	
	@Before
	public void setUp() throws IOException {

		logger = Logger.getLogger("nopCommerce");  //Added Logger
		PropertyConfigurator.configure("log4j.properties");  //Added Logger
		//Reading Properties
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		String br = configProp.getProperty("browser");
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("****Launched Chrome Browser****");
		}
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("****Launched Edge Browser****");
		}
		
	  
	}
	
	@Given("User launch browser")
	public void user_launch_browser() {
		
		lp=new LoginPage(driver);
		addCust = new AddcustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		logger.info("Opened URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUserName(email);
	    logger.info("Entered Email");
	    lp.setPassword(password);
	    logger.info("Entered Password");
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
	    	logger.info("Logged In successfully");
	    }
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	    logger.info("Logged Out successfully");
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		logger.info("****Closed Browser****");
	}
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("User clicks on customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		addCust.openCustomersMenu();
		logger.info("Clicked on customer Menu");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
	    addCust.openCustomersItem();
	    logger.info("Opened customer Item");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addCust.openNew();
	    logger.info("Clicked on add new button");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("Started Entering customer information");
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
	    logger.info("Entered customer information");
	    Thread.sleep(1000);
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addCust.save();
	    logger.info("Clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String conf) {
		addCust.confirmation();
		if(driver.getPageSource().contains(conf)) {
			Assert.assertTrue(true);
			logger.info("Customer added successfully");
		}
		else {
			Assert.assertTrue(false);
	    }
	}
	
	@When("User clicks on sales Menu")
	public void user_clicks_on_sales_menu() throws InterruptedException {
	    addGift = new AddgiftCard(driver);
	    addGift.openSalesMenu();
	    logger.info("Opened Sales Menu");
	}
	
	@When("click on Gift cards Menu Item")
	public void click_on_gift_cards_menu_item() throws InterruptedException {
	   addGift.openGiftcardsItem();
	   logger.info("Opened Gift card Item");
	}
	
	@Then("User can view Add new Gift card page")
	public void user_can_view_add_new_gift_card_page() {
		Assert.assertEquals("Add a new gift card / nopCommerce administration", driver.getTitle());
	}
	
	@When("User enter Gift card info")
	public void user_enter_gift_card_info() throws InterruptedException {
		logger.info("Entering Gift card Information");
		String gtype = "Virtual";
		addGift.selectGiftcardType(gtype);
		addGift.enterInitialValue(83.75);
		addGift.isgiftCardActivated("yes");
		addGift.generateCode();
		addGift.enterRecipientName(randomstring());
		addGift.enterSenderName(randomstring());
		addGift.enterMessage("NA");
		if(gtype.equalsIgnoreCase("virtual")) {
			addGift.enterRecipientEmail(randomstring()+"@gamil.com");
			addGift.enterSenderEmail(randomstring()+"@gamil.com");
		}
		logger.info("Entered Gift card Information");
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() {
	    searchCust = new SearchCustomerPage(driver);
	    logger.info("Started searching customer through email");
	    searchCust.enterEmail("steve_gates@nopCommerce.com");
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}
	@Then("User should find Email in the search table")
	public void user_should_find_email_in_the_search_table() {
	    boolean status = searchCust.verifySearchedEmail("steve_gates@nopCommerce.com");
	    Assert.assertTrue(status);
	    logger.info("Found search result");
	}




}
