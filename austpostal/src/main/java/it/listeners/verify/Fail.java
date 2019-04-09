package main.java.it.listeners.verify;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.it.listeners.TestFailureListeners;

public class Fail  {
//	static WebDriver driver;
//	static ExtentTest _report;
	
//	public Fail(WebDriver driver, ExtentTest _report){
//		super(driver,_report);
//	}

	public static String getScreenshot(WebDriver driver, String screenshotname){
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//FailedTestsScreenshots//"+screenshotname+dateName+".png";
		File finalDestination = new File(destination);
		try{
			FileUtils.copyFile(source,finalDestination);
		}
		catch(IOException e){}
		return destination;
	}

}
