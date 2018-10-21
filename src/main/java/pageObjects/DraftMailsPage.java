package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import basePackage.PageBase;

public class DraftMailsPage extends PageBase{
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Drafts')]")
	private WebElement darfts;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@role,'main')]//tr")
	private List<WebElement> draftMails;
	
	By mailSubjectLocator = By.xpath("//div[@class='y6']//span/span");
	By draftMailsListLocator = By.xpath("//div[contains(@role,'main')]//tr");
	public DraftMailsPage(WebDriver driver){ 
	    super(driver); 
	} 
	
	public boolean checkDrafts(String cancelledMailSubject){
		waitAndClick(darfts);
		waitForAllElementsToPresent(draftMailsListLocator);
		List<WebElement> draftMailsList = driver.findElements(draftMailsListLocator);
		for(WebElement draftMail : draftMailsList) {
			List<WebElement> mailSubjectList = draftMail.findElements(mailSubjectLocator);
			for(WebElement mailSubject : mailSubjectList) {
				String currentMailSubject =  mailSubject.getText();
				if(currentMailSubject.equals(cancelledMailSubject)) {
					return true;
				}
			}
			
		}
		return false;
	}
}
