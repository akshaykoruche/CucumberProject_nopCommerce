package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(id="SearchEmail")
	WebElement searchEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement searchFirstName;
	
	@FindBy(id="SearchLastName")
	WebElement searchLastName;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> rows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> cols;
	
	public void enterEmail(String searchMail) {
		waithelper.WaitForElement(searchEmail, Duration.ofSeconds(30));
		searchEmail.clear();
		searchEmail.sendKeys(searchMail);
	}
	
	public void clickSearch() {
		waithelper.WaitForElement(searchBtn, Duration.ofSeconds(30));
		searchBtn.click();
	}
	
	public int getRowCount() {
		return(rows.size());
	}
	
	public int getColumnCount() {
		return(cols.size());
	}
	
	public boolean verifySearchedEmail(String email) {
		boolean flag = false;
		
		for(int i=1;i<=getRowCount();i++) {
			String mailId = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			if(email.equals(mailId)) {
				flag = true;
			}
		}
		return flag;
	}

}
