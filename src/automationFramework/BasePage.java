package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {
	public WebDriver driver;
	public ExtentTest test;
	String parentWindow;

	// default constructor
	public BasePage() {
	}

	// All the other constructors of child classes, will call this constructor
	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public void OpenUrl(String Url) {
		driver.get(Url);
	}

	/*********************************
	 * Utility Functions
	 ********************************/

	/** Managing Input fields and button **/
	public void type(WebElement locatorKey, String data) {
		// test.log(Status.INFO, "Typing in " + locatorKey + ". Data - " +
		// data);
		locatorKey.sendKeys(data);
		// test.log(Status.INFO, "Typed successfully in " + locatorKey);
	}

	/** Managing Links **/
	public void click(WebElement locatorKey) {
		// test.log(Status.INFO, "Clicking on " + locatorKey);
		locatorKey.click();
		// test.log(Status.INFO, "Clicked on " + locatorKey);
	}

	/** Explicit Wait **/
	// wait until a specific element appear on screen
	public void explicitWait(WebElement locatorKey, int time) {
		// test.log(Status.INFO, "Explicitly waiting for " + time
		// + " to appear " + locatorKey + " on screen.");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(locatorKey));
		// test.log(Status.INFO, "Found the element " + locatorKey);
	}

	public void stopTheScript(int timeInMillisec) {
		try {
			Thread.sleep(timeInMillisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void explicitWaitTillElementIsEnabled(WebElement locatorKey, int time) {
		// test.log(Status.INFO, "Explicitly waiting for " + time
		// + " to appear " + locatorKey + " on screen.");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locatorKey));
		// test.log(Status.INFO, "Found the element " + locatorKey);
	}
	/* Drag and Drop */
	public void dragAndDrop(WebElement locatorKey_of_item_to_drag, int xcoordinate, int ycoordinate) {
		// test.log(Status.INFO, "Dragging the " + locatorKey_of_item_to_drag
		// + " to " + xcoordinate + " , " + ycoordinate);
		Actions act = new Actions(driver);
		act.dragAndDropBy(locatorKey_of_item_to_drag, xcoordinate, ycoordinate).build().perform();
		// test.log(Status.INFO, "Droppped the " + locatorKey_of_item_to_drag
		// + " to " + xcoordinate + " , " + ycoordinate);
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		// test.log(Status.INFO, "Dragging the " + source + " to" +
		// destination);
		Actions act = new Actions(driver);
		act.clickAndHold(source).moveToElement(destination).release().build().perform();
		// act.dragAndDrop(source, destination).build().perform();
		// test.log(Status.INFO, "Dragging the " + source + " to" +
		// destination);
	}

}