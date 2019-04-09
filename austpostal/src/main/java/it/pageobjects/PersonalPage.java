package main.java.it.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import main.java.it.framework.base.AUSPOSTPage;
import main.java.it.framework.elementhelpers.ClickNSetHelpers;



public class PersonalPage extends AUSPOSTPage{

	@FindBy(how=How.XPATH,using= "//span[text()='Log in']")
	public WebElement _loginMenuElement;

	@FindBy(how=How.XPATH,using= "//span[text()='MyPost']")
	public WebElement _myPostMenuLinkElement;

	@FindBy(how=How.XPATH,using= "//span[text()='MyPost Business']")
	public WebElement _myPostBusinessMenuLinkElement;

	public PersonalPage(WebDriver driver, ExtentTest _report){
		super(driver,_report);	
	}


	public PersonalPage clickLoginMenuElement(){
		System.out.println("started clickLoginMenuElement");
		_report.log(LogStatus.INFO,"Clicking on login menu element");
		ClickNSetHelpers.click(_loginMenuElement,"Log in");
		return this;
	}

	public MyPostLoginPage clickMyPostMenuLinkElement(){
		_report.log(LogStatus.INFO,"Clicking on mypost menu element");
		ClickNSetHelpers.click(_myPostMenuLinkElement,"MyPost");
		return new MyPostLoginPage(driver,_report);
	}

	public MyPostBusinessLoginPage clickMyPostBusinessMenuLinkElement(){
		_report.log(LogStatus.INFO,"Clicking on mypost business menu element");
		ClickNSetHelpers.click(_myPostBusinessMenuLinkElement,"MyPost Business");
		return new MyPostBusinessLoginPage(driver,_report);
	}
}