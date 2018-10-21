package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePackage.PageBase;

public class StarredMailPage extends PageBase{
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Starred')]")
	private WebElement starredMailMenu;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ae4 UI')]//div[contains(@class,'yW')]/span/span")
	private List<WebElement> starredMails;
	
	By starredMailsLocator = By.xpath("//div[contains(@class,'ae4 UI')]//tr");
	
	public StarredMailPage(WebDriver driver){ 
	    super(driver); 
	} 
	
	public boolean checkStarredMail(String starredMailId){
		boolean isStarredMailPresent = false;
		waitAndClick(starredMailMenu);
		try {
			waitForAllElementsToPresent(starredMailsLocator);
			for(WebElement starredMail : starredMails) {
					String mailId = waitAndGetText(starredMail).toLowerCase();
					if(mailId.equals(starredMailId)) {
						isStarredMailPresent = true;
						break;
					}
			}
		}catch(TimeoutException timeoutException) {
			PageFactory.initElements(driver, StarredMailPage.class);
		}
		return isStarredMailPresent;
	}
}
