package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import basePackage.PageBase;

public class SearchMail extends PageBase{
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchMailBox;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ae4 UI')]//div[@class='Cp']//tr")
	private List<WebElement> searchedMails;
	
	By gmailTitleLocator = By.xpath("//img[@class='gb_Wa']");
	By searchedMailsLocator = By.xpath("//div[contains(@class,'ae4 UI')]//div[@class='Cp']//tr");
	By subjectOfMailLocator = By.xpath("//span[@class='bog']/span");
	
	public SearchMail(WebDriver driver){ 
	    super(driver); 
	}
	
	public boolean searchAnyMailBySubject(String searchSubject) {
		waitUntilElementIsPresent(gmailTitleLocator);
		waitAndType(searchMailBox, searchSubject);
		pressEnterKey(searchMailBox);
		waitForAllElementsToPresent(searchedMailsLocator);
		for(WebElement searchedMail : searchedMails) {
			List<WebElement> mailSubjectList = searchedMail.findElements(subjectOfMailLocator);
			for(WebElement subjectOfMail : mailSubjectList) {
				String currentSubject = subjectOfMail.getText().toLowerCase();
				if(currentSubject.equals(searchSubject) ) {
					return true;
				}
			}
			
		}
		return false;
	}
}
