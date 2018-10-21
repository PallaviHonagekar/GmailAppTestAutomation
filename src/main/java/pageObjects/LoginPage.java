package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import basePackage.*;

public class LoginPage extends PageBase{

	@FindBy(how = How.ID, using = "identifierId")
	private WebElement emailId;
	
	@FindBy(how = How.ID, using = "identifierNext")
	private WebElement emailIdNext;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement password;
	
	@FindBy(how = How.ID, using = "passwordNext")
	private WebElement passwordNext;
	
	By profileIdLocator = By.xpath("//div[@id='profileIdentifier']");
	
	
	public LoginPage(WebDriver driver){ 
	    super(driver); 
	} 
	
	public void login(String emailIdValue, String passwordValue){
		waitAndType(emailId, emailIdValue);
		waitAndClick(emailIdNext);
 
		waitUntilElementIsPresent(profileIdLocator);
		
		waitAndType(password, passwordValue);
		//getLocationAndClick(passwordNext);
		waitAndClick(passwordNext);
	}
	
	
}
