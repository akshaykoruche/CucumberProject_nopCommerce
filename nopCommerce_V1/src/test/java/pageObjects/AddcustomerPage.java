package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AddcustomerPage {
	public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customersMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customersItem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addCustomer;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(id="Gender_Male")
	WebElement male;
	
	@FindBy(id="Gender_Female")
	WebElement female;
	
	@FindBy(id="DateOfBirth")
	WebElement dateOfBirth;
	
	@FindBy(id="Company")
	WebElement companyName;
	
	@FindBy(id="IsTaxExempt")
	WebElement taxExempt;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement selectNewsletter;
	
	@FindBy(xpath="//li[contains(text(),'Test store 2')]")
	WebElement testStore2;
	
	@FindBy(xpath="//li[contains(text(),'Your store name')]")
	WebElement yourStore;
	
	@FindBy(xpath="//ul[@id='SelectedCustomerRoleIds_taglist']//span[@class='k-select']")
	WebElement clearRole;
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement selectCustomerRole;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement administrators;
	
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
	WebElement forumMod;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement guests;
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement registered;
	
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement vendors;
	
	@FindBy(id="VendorId")
	WebElement selectVendor;
	
	@FindBy(id="Active")
	WebElement isActive;
	
	@FindBy(id="AdminComment")
	WebElement adminComment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement confirmMsg;
	
	public void openCustomersMenu() throws InterruptedException {
		customersMenu.click();
		Thread.sleep(3000);
		customersItem.click();
		Thread.sleep(3000);
	}
	
	public void openCustomersItem() throws InterruptedException {
		customersItem.click();
		Thread.sleep(3000);
	}
	
	public void openAddCustomers() throws InterruptedException {
		addCustomer.click();
		Thread.sleep(3000);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void enterFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void selectGender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			male.click();
		}
		else if (gender.equalsIgnoreCase("female")) {
			female.click();
		}
	}
	
	public void selectDateOfBirth(String dob) {
		dateOfBirth.sendKeys(dob);
	}
	
	public void enterCompanyName(String company) {
		companyName.sendKeys(company);
	}
	
	public void isTaxExempt(String tax) {
		if(tax.equalsIgnoreCase("yes")) {
			taxExempt.click();
		}
	}
	
	public void selectNewsLetter(String newsltr) throws InterruptedException {
		
		selectNewsletter.click();
		Thread.sleep(3000);
		if(newsltr.equals("Your store  name")) {
			yourStore.click();
		}
		else if (newsltr.equals("Test store 2")) {
			testStore2.click();
		}
		Thread.sleep(1000);

	}
	
	public void selectCustomerRoles(String customerrole) throws InterruptedException {
		clearRole.click();
		Thread.sleep(1000);
		selectCustomerRole.click();
		Thread.sleep(2000);
		if(customerrole.equals("Administrators")) {
			administrators.click();
		}
		else if (customerrole.equals("Forum Moderators")) {
			forumMod.click();
		}
		else if (customerrole.equals("Guests")) {
			guests.click();
		}
		else if (customerrole.equals("Registered")) {
			registered.click();
		}
		else if (customerrole.equals("Vendors")) {
			vendors.click();
		}
		Thread.sleep(1000);
	}
	
	public void selectVendorManager(String vendorid) {
		Select vendorId = new Select(selectVendor);
		vendorId.selectByVisibleText(vendorid);
	}
	
	public void isActive(String active) {
		if(active.equalsIgnoreCase("yes")) {
			if(!isActive.isSelected()) {
				isActive.click();
			}
		}
	}
	
	public void enterAdminComment(String admincomment) {
		adminComment.sendKeys(admincomment);
	}
	
	public void save() throws InterruptedException {
		savebtn.click();
		Thread.sleep(3000);
	}
	
	public void confirmation() {
		confirmMsg.isDisplayed();
	}
}
