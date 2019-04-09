package main.java.it.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.ExtentTest;

import main.java.it.framework.base.AUSPOSTPage;
import main.java.it.framework.elementhelpers.ClickNSetHelpers;



public class MyPostBusinessHomePage extends AUSPOSTPage {


	@FindBy(how=How.XPATH,using= "//span[text()= 'Manuja']")
	public WebElement _manujaMenuElement;

	@FindBy(how=How.XPATH,using= "//a[text()='Log out']")
	public WebElement _logoutMenuLinkElement;

	public MyPostBusinessHomePage(WebDriver driver, ExtentTest _report){
		super(driver,_report);
	}

	public MyPostBusinessHomePage clickManujaMenuElement(){
		ClickNSetHelpers.click(_manujaMenuElement,"Manuja");
		return this;
	}

	public PersonalPage clickLogoutMenuLinkElement(){
		ClickNSetHelpers.click(_logoutMenuLinkElement,"Log out");
		return new PersonalPage(driver, _report);
	}
}
