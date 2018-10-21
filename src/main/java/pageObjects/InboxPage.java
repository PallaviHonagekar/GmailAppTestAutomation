package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePackage.PageBase;
import constants.Constant;

public class InboxPage extends PageBase {
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Inbox')]")
	private WebElement inbox;
	
	By inboxMailLocator = By.xpath("//tr[contains(@class,'zA')]");
	
	@FindBy(xpath = "//td[contains(@class,'apU xY')]/span[@title='Not starred']")
	private List<WebElement> notStarredLocatorsList;
	
	@FindBy(xpath = "//span[@title='Not starred']//parent::td/following-sibling::td/div[@class='yW']/span/span")
	private List<WebElement> emailIdList;
	
	
	public InboxPage(WebDriver driver){ 
	    super(driver); 
	} 
	
	public String starAnEmail(){
		String starredMailId = null;
		waitForAllElementsToPresent(inboxMailLocator);
		int i = 0;
		try {
			allinboxMailList:
			for(WebElement notStarredLocator : notStarredLocatorsList) {
					for(WebElement currentMailId : emailIdList) {
						starredMailId = waitAndGetText(currentMailId);
						waitAndClick(notStarredLocator);
						break allinboxMailList;
					}
			}
		}catch(StaleElementReferenceException staleElementException) {
			PageFactory.initElements(driver, InboxPage.class);
		}
		return starredMailId;
	}
}

	
