package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddgiftCard {
	
	public WebDriver ldriver;
	
	public AddgiftCard(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Sales')]")
	WebElement salesMenu;
	
	@FindBy(xpath="//a[@href='/Admin/GiftCard/List']//p[contains(text(),'Gift cards')]")
	WebElement giftCards;
	
	@FindBy(id="GiftCardTypeId")
	WebElement giftCardType;
	
	@FindBy(xpath="//input[@class='k-formatted-value k-input']")
	WebElement inValue;
	
	@FindBy(id="IsGiftCardActivated")
	WebElement isGiftcardActive;
	
	@FindBy(id="generateCouponCode")
	WebElement generateCode;
	
	@FindBy(id="RecipientName")
	WebElement recptName;
	
	@FindBy(id="RecipientEmail")
	WebElement recptEmail;
	
	@FindBy(id="SenderName")
	WebElement senderName;
	
	@FindBy(id="SenderEmail")
	WebElement senderEmail;
	
	@FindBy(id="Message")
	WebElement mesg;

	public void openSalesMenu() throws InterruptedException {
		salesMenu.click();
		Thread.sleep(3000);
	}
	
	public void openGiftcardsItem() throws InterruptedException {
		giftCards.click();
		Thread.sleep(3000);
	}
	
	public void selectGiftcardType(String gtype) {
		Select giftType = new Select(giftCardType);
		giftType.selectByVisibleText(gtype);
	}
	
	public void enterInitialValue(double d) {
		inValue.sendKeys(Double.toString(d));
	}
	
	public void isgiftCardActivated(String gftAct) {
		if(gftAct.equalsIgnoreCase("yes")) {
			isGiftcardActive.click();
		}
	}
	
	public void generateCode() throws InterruptedException {
		generateCode.click();
		Thread.sleep(1000);
	}
	
	public void enterRecipientName(String reptName) {
		recptName.sendKeys(reptName);
	}
	
	public void enterRecipientEmail(String reptEmail) {
		recptEmail.sendKeys(reptEmail);
	}
	
	public void enterSenderName(String sndName) {
		senderName.sendKeys(sndName);
	}
	
	public void enterSenderEmail(String sndEmail) {
		senderEmail.sendKeys(sndEmail);
	}
	
	public void enterMessage(String msg) {
		mesg.sendKeys(msg);
	}
}
