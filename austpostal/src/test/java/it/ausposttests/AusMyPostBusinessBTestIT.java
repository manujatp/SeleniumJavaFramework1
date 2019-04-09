package test.java.it.ausposttests;

import org.testng.annotations.Test;

import main.java.it.framework.base.TestBase;
import main.java.it.pageobjects.MyPostBusinessHomePage;
import main.java.it.pageobjects.MyPostBusinessLoginPage;
import main.java.it.pageobjects.PersonalPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

//@Listeners(main.java.it.listeners.TestFailureListeners.class)
public class AusMyPostBusinessBTestIT extends TestBase{



	//Test case for MyPostBusiness with DataProvider reading from Excel file
	@Test( groups = {"auspostgrp", "auspostmypostbusinessgrp","123"}, dataProvider="filldata")
	public void loginToAusPostMyPostBusinessApp1(String user, String pwd)
	{
		System.out.println("manuja test");
		_report= startReport.startTest("AusMyPostBusinessTest");
		PersonalPage _personal = new PersonalPage(driver,_report);
		_personal.clickLoginMenuElement();  

		MyPostBusinessLoginPage _loginMyPostBusiness = new MyPostBusinessLoginPage(driver,_report);

		_loginMyPostBusiness= _personal.clickMyPostBusinessMenuLinkElement();


		_loginMyPostBusiness.clickEmailAddressElement(user);
		_loginMyPostBusiness.clickPasswordElement(pwd);

		MyPostBusinessHomePage _mypostBusinessHome = new MyPostBusinessHomePage(driver,_report);
		_mypostBusinessHome = _loginMyPostBusiness.clickLoginButtonElement();
		_mypostBusinessHome.clickManujaMenuElement();
		_personal = _mypostBusinessHome.clickLogoutMenuLinkElement();
	}

	@Test( groups = {"auspostgrp", "auspostmypostbusinessgrp","123"}, dataProvider="filldata")
	public void loginToAusPostMyPostBusinessApp2(String user, String pwd)
	{
		System.out.println("manuja test");
		_report= startReport.startTest("AusMyPostBusinessTest");
		PersonalPage _personal = new PersonalPage(driver,_report);
		_personal.clickLoginMenuElement();  

		MyPostBusinessLoginPage _loginMyPostBusiness = new MyPostBusinessLoginPage(driver,_report);

		_loginMyPostBusiness= _personal.clickMyPostBusinessMenuLinkElement();


		_loginMyPostBusiness.clickEmailAddressElement(user);
		_loginMyPostBusiness.clickPasswordElement(pwd);

		MyPostBusinessHomePage _mypostBusinessHome = new MyPostBusinessHomePage(driver,_report);
		_mypostBusinessHome = _loginMyPostBusiness.clickLoginButtonElement();
		_mypostBusinessHome.clickManujaMenuElement();
		_personal = _mypostBusinessHome.clickLogoutMenuLinkElement();
	}

	//DataProvider with Excel definition
	@DataProvider(name="filldata")
	public Object[][] getDataFromExternalExcel() throws Exception
	{
		return fetchData("TestDataLogin.xlsx");	
	}

}


