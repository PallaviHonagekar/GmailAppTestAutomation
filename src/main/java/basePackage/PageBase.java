package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageBase(WebDriver driver){ 
	    this.driver = driver; 
	    wait = new WebDriverWait(driver,60);
	} 
	
	public void validateText(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public String waitAndGetText(WebElement  element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public void waitAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void waitAndType(WebElement element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}
	
	public void pressEnterKey(WebElement element) {
		element.sendKeys(Keys.RETURN);
	}
	
	
	public void waitUntilElementIsPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementsToPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public void getLocationAndClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Point elementPoint = element.getLocation();
		Actions action = new Actions(driver);
		action.moveByOffset(elementPoint.x, elementPoint.y).click().build().perform();
	}
	
	public void click(WebElement element) {
		element.click();
	}
}
