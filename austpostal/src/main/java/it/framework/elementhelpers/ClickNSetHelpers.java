package main.java.it.framework.elementhelpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.relevantcodes.extentreports.ExtentTest;




public class ClickNSetHelpers extends GenericHelpers {
	public ClickNSetHelpers(WebDriver driver,ExtentTest _report){
		super(driver,_report);
	}
		
	public static void click(WebElement el, String fieldName){
	//		_report.log(LogStatus.INFO,"Clicking on "+fieldName);
//		waitForElementToBeClickable(el);
		el.click();
	}
	
	public static void set(WebElement el, String testdata, String fieldName)
	{
	//	_report.log(LogStatus.INFO,"Entering value on "+fieldName);
	//	waitForElementToBeClickable(el);
		el.click();
		el.clear();
		el.sendKeys(testdata);
		el.sendKeys(Keys.TAB);
		
	}
	
	
}

	

