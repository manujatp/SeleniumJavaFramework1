package main.java.it.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.it.framework.base.AUSPOSTPage;
import main.java.it.framework.elementhelpers.ClickNSetHelpers;



public class MyPostLoginPage extends AUSPOSTPage {


	@FindBy(how=How.ID,using= "email-address")
	public WebElement _emailAddressElement;

	@FindBy(how=How.ID,using= "password")
	public WebElement _passwordElement;

	@FindBy(how=How.ID,using= "login-btn")
	public WebElement _loginButtonElement;

	public MyPostLoginPage(WebDriver driver, ExtentTest _report){
		super(driver,_report);	
	}

	public MyPostLoginPage clickEmailAddressElement(String user){
		ClickNSetHelpers.set(_emailAddressElement, user,"Email Address");
		return this;
	}

	public MyPostLoginPage clickPasswordElement(String pwd){
		ClickNSetHelpers.set(_passwordElement, pwd,"Password");
		return this;
	}

	public MyPostHomePage clickLoginButtonElement(){
		ClickNSetHelpers.click(_loginButtonElement,"Log in");
		return new MyPostHomePage(driver,_report);
	}
}
