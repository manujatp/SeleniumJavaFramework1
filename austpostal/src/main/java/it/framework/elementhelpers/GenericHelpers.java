package main.java.it.framework.elementhelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class GenericHelpers {

	public static WebDriver driver = null;
	public static ExtentTest _report;

	public GenericHelpers(WebDriver driver,ExtentTest _report){
		GenericHelpers.driver=driver;
		GenericHelpers._report=_report;
	}

	public static void waitForElementToBeClickable(WebElement el) {


		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(el));

	}

	//Definition  for assertEqual()
	public void assertEqual(String actual,String expected){
		Assert.assertEquals(actual,expected);
		System.out.println("The Assertion Statement is executed because"
				+"Expected title is same as Actual ");

	}

	//Definition for assertNotEqual()
	public void assertNotEqual(String actual,String expected,String msg){
		Assert.assertNotEquals(actual,expected,msg);
		System.out.println("The Assertion Statement is executed because"
				+"Expected title is not same as Actual ");

	}

	//Definition for assertNull()
	public void assertNull(WebElement el){
		Assert.assertNull(el);
	}

	//Definition for assertNotNull()
	public void assertNotNull(WebElement el){
		Assert.assertNotNull(el);
	}
}
