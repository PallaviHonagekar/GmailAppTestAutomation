package listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestListener implements ITestListener{
	
	//WebDriver driver=null;
	
	public void onTestFailure(ITestResult result) {
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        System.out.println(result.getAttribute("driver"));
        WebDriver driver = (WebDriver)context.getAttribute("driver");
    	takeScreenShot(methodName, driver);
	}
	
	public void takeScreenShot(String methodName, WebDriver driver) {
   	 File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	 File destinationFile = new File("D:\\"+methodName+".png");
           try {
				FileUtils.copyFile(sourceFile, destinationFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
   }

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
