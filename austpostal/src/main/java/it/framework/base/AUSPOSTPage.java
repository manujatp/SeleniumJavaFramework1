package main.java.it.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AUSPOSTPage {



	public static ExtentTest _report; 
	public static WebDriver driver;


	public AUSPOSTPage(WebDriver driver,  ExtentTest _report)
	{	


		AUSPOSTPage.driver = driver;
		AUSPOSTPage._report=_report;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

				

	}

	public void reportMessage(String messageToBeDisplayedInHTMLLog)
	{
		_report.log(LogStatus.INFO, "HTML", "<b><span style='color:rgb(8,185,40)';' font size=\"16\">-------------"+messageToBeDisplayedInHTMLLog+"-------------<span style='color:rgb(8,185,40)';'></b>");	

		//<b><span style="color:rgb(7,193,110)" ;'="" font size="9">Login success<span style="color:rgb(7,193,110)" ;'=""></span></span></b>
	}
}
