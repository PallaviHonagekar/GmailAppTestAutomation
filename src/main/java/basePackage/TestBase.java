package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constant;
import pageObjects.ComposeMailPage;
import pageObjects.DraftMailsPage;
import pageObjects.InboxPage;
import pageObjects.LoginPage;
import pageObjects.SearchMail;
import pageObjects.StarredMailPage;

public class TestBase {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected InboxPage inboxPage;
	protected StarredMailPage starredMailPage;
	protected ComposeMailPage composeMailPage;
	protected DraftMailsPage draftsMailPage;
	protected SearchMail searchMail;
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER);
		driver = new FirefoxDriver();
		driver.get(Constant.URL_SIGN_IN);
		driver.manage().window().maximize();	
		context.setAttribute(Constant.DRIVER, driver);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		inboxPage = PageFactory.initElements(driver, InboxPage.class);
		starredMailPage = PageFactory.initElements(driver, StarredMailPage.class);
		composeMailPage = PageFactory.initElements(driver, ComposeMailPage.class);
		draftsMailPage = PageFactory.initElements(driver, DraftMailsPage.class);
		searchMail = PageFactory.initElements(driver, SearchMail.class);
	}
	
//	@AfterMethod
//	public void tearDown() {
//		//driver.quit();
//	}
	
}
