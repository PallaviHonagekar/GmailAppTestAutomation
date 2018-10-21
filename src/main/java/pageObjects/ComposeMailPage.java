package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import basePackage.PageBase;

public class ComposeMailPage extends PageBase {
	
	@FindBy(how = How.XPATH, using = "//div[@class='z0']/div")
	private WebElement composeMailButton;
	
	@FindBy(how = How.NAME, using = "to")
	private WebElement addressTextBox;
	
	@FindBy(how = How.NAME, using = "subjectbox")
	private WebElement subjectTextBox;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'editable')]")
	private WebElement mailBodyTextArea;
	
	@FindBy(how = How.XPATH, using = "//img[@class='Ha']")
	private WebElement closeButton;
	
	public ComposeMailPage(WebDriver driver){ 
	    super(driver); 
	}
	
	public void composeAndCancelMail(String sendToAddress, String subject, String message) {
		waitAndClick(composeMailButton);
		waitAndType(addressTextBox, sendToAddress);
		waitAndType(subjectTextBox, subject);
		waitAndType(mailBodyTextArea, message);
		waitAndClick(closeButton);
	}
}
