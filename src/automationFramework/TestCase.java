package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utility.Constant;
import utility.ExcelUtils;

public class TestCase extends BasePage {
	AppPage app;
	HomePage home;
	XSSFCell Cell;

	@BeforeClass(alwaysRun = true)

	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		app = new AppPage(driver, test);
		home = new HomePage(driver, test);
		ExcelUtils.setExcelFile(Constant.Path_TestData, Constant.Sheet);

	}

	@Test(priority = 1)
	public void Openurl() throws InterruptedException {
		app.url();
	}

	@Test(priority = 2, dependsOnMethods = { "Openurl" })
	public void create() throws InterruptedException {

		app.CreateButton();
		explicitWait(home.started, 50);
	}

	@Test(priority = 3, dependsOnMethods = { "create" })
	public void start() throws InterruptedException {

		home.started();

	}

	@Test(priority = 4, dependsOnMethods = { "start" })

	public void createPage() throws Exception {

		home.createNew(ExcelUtils.getCellData(1, 1));

	}

	@Test(priority = 5, dependsOnMethods = { "createPage" })

	public void SMS() throws Exception {
		home.message();
		home.dragnDropMessage();
		explicitWait(home.dragarrow1_SMS, 10);
		stopTheScript(2000);
		dragAndDrop(home.dragDot1_start, home.dragarrow1_SMS);
		home.fillMessageDetails(ExcelUtils.getCellData(2, 1), ExcelUtils.getCellData(3, 1));
	}

	@Test(priority = 6, dependsOnMethods = { "createPage" })
	public void Email() throws Exception {
		home.dragnDropEmail();
		home.fillEmailDetails(ExcelUtils.getCellData(4, 1), ExcelUtils.getCellData(5, 1), ExcelUtils.getCellData(6, 1),
				ExcelUtils.getCellData(7, 1), ExcelUtils.getCellData(8, 1), ExcelUtils.getCellData(9, 1),
				ExcelUtils.getCellData(10, 1), ExcelUtils.getCellData(11, 1));
		dragAndDrop(home.dragDot2_notSentsms, home.dragArrow2_email);
	}

	@Test(priority = 7, dependsOnMethods = { "Email" })
	public void dragExitAppCase() throws Exception {
		click(home.basic);
		explicitWait(home.exit_app, 5000);
		home.dragExitApp();
		dragAndDrop(home.dragDot3_sentsms, home.dragArrow3_exitApp);
		dragAndDrop(home.dragDot4_sentEmail, home.dragArrow4_exitAppEmail);
		dragAndDrop(home.dragDot5_notSentEmail, home.dragArrow5_exitAppEmail);

	}

	@AfterClass(alwaysRun = true)
	public void close() throws Exception {
		driver.close();
	}
}