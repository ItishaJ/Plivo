package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import automationFramework.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub {
		super(driver, test);
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/button[1]")
	public WebElement started;

	@FindBy(id = "add-page")
	public WebElement add_page;

	@FindBy(xpath = "//form[@class='unsubmittable']//input[@name='name']")
	public WebElement name;

	@FindBy(xpath = "/html/body/div[20]/div[3]/button[1]")
	public WebElement create;

	@FindBy(xpath = "//*[@id='accordion']/h3[4]")
	public WebElement messaging;

	@FindBy(xpath = "//*[@id='accordion']/div[4]/ul/li[3]")
	public WebElement sendSMS;

	@FindBy(xpath = "(//div[@class='mod-rail mod-south']/div)[position()=2]")
	public WebElement dragDot1_start;

	@FindBy(xpath = "//div[@class='mod-rail mod-north']/div")
	public WebElement dragarrow1_SMS;

	@FindBy(xpath = "//textarea[@name='phone_constant']")
	public WebElement phoneNumber;

	@FindBy(xpath = "//tbody//div[@class='syn-selectappvar-wrap']//textarea[@name='message_phrase[]']")
	public WebElement text;

	@FindBy(xpath = "//div[@id='accordion']/div[4]/ul[1]/li[2]")
	public WebElement sendEmail;

	@FindBy(xpath = "(//div[@class='panel-nodes-attached inner']/div[2])[position()=1]")
	public WebElement dragDot2_notSentsms;

	@FindBy(xpath = "(//div[@class='mod-rail mod-north']/div)[position()=2]")
	public WebElement dragArrow2_email;

	@FindBy(name = "smtp_url")
	public WebElement smtp;

	@FindBy(name = "port")
	public WebElement port;

	@FindBy(name = "username")
	public WebElement username;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(name = "from_constant")
	public WebElement from_text;

	@FindBy(name = "to_constant")
	public WebElement to_text;

	@FindBy(name = "subject_constant")
	public WebElement subject_text;

	@FindBy(xpath = "(//div[@class='syn-selectappvar-wrap']/textarea[1])[position()=8]")
	public WebElement message_text;

	@FindBy(xpath = "//a[contains(text(),'Basic')]")
	public WebElement basic;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/ul/li[1]")
	public WebElement exit_app;

	@FindBy(xpath = "(//div[@class='panel-nodes-attached inner']/div[1])[position()=1]")
	public WebElement dragDot3_sentsms;

	@FindBy(xpath = "(//div[@class='mod-rail mod-north']/div)[position()=3]")
	public WebElement dragArrow3_exitApp;

	@FindBy(xpath = "(//div[@class='panel-nodes-attached inner']/div[1])[position()=2]")
	public WebElement dragDot4_sentEmail;

	@FindBy(xpath = "(//div[@class='panel-nodes-attached inner']/div[2])[position()=2]")
	public WebElement dragDot5_notSentEmail;

	@FindBy(xpath = "(//div[@class='mod-rail mod-north']/div)[position()=4]")
	public WebElement dragArrow4_exitAppEmail;

	@FindBy(xpath = "(//div[@class='mod-rail mod-north']/div)[position()=5]")
	public WebElement dragArrow5_exitAppEmail;

	public void started() {
		click(started);
		stopTheScript(1000);
	}

	public void createNew(String pageName) {
		click(add_page);
		type(name, pageName);
		click(create);
	}

	public void message() throws InterruptedException {
		click(messaging);
		stopTheScript(2000);

	}

	public void dragnDropMessage() {

		dragAndDrop(sendSMS, dragDot1_start.getLocation().getX() -100, dragDot1_start.getLocation().getY() - 150);
	}

	public void fillMessageDetails(String number, String mess) {

		type(phoneNumber, number);
		type(text, mess);
	}
	
    public void dragnDropEmail() {
	
		dragAndDrop(sendEmail, dragDot2_notSentsms.getLocation().getX()+170, dragDot2_notSentsms.getLocation().getY()-250);
	}
    
    public void fillEmailDetails(String smtphost, String Port, String username, String pass, String from , String to , 
    		String subject, String text1) {
    	type(smtp,smtphost);
    	type (port, Port);
    	type (this.username,username);
    	type(password, pass);
    	type(from_text, from);
    	type(to_text, to);
    	type(subject_text, subject);
    	type(message_text, text1);
    	
    }
    

public void dragExitApp() {
	
	dragAndDrop(exit_app, dragDot3_sentsms.getLocation().getX()-100, dragDot3_sentsms.getLocation().getY() );
	dragAndDrop(exit_app, dragDot3_sentsms.getLocation().getX()+100, dragDot3_sentsms.getLocation().getY()+100);
	dragAndDrop(exit_app, dragDot5_notSentEmail.getLocation().getX(), dragDot5_notSentEmail.getLocation().getY());
}

}