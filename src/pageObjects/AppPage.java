package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import automationFramework.BasePage;
import utility.Constant;

public class AppPage extends BasePage {
	
	@FindBy(id = "link-create")
	WebElement createButton;
	
public AppPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub {
	super(driver, test);
}


public void url() throws InterruptedException {

   OpenUrl(Constant.URL);
}
public void CreateButton() {
	explicitWaitTillElementIsEnabled(createButton, 50);
	click(createButton);

}
}