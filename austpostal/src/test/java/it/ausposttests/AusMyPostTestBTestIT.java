//package test.java.it.ausposttests;
//
//import org.testng.annotations.Test;
//
//import main.java.it.framework.base.TestBase;
//
//import main.java.it.pageobjects.MyPostHomePage;
//import main.java.it.pageobjects.MyPostLoginPage;
//import main.java.it.pageobjects.PersonalPage;
//
//import org.testng.annotations.DataProvider;
//
//public class AusMyPostTestBTestIT extends TestBase{
//
//	//Test case for MyPost with DataProvider 
//	@Test( groups = {"auspostgrp", "auspostmypostgrp"}, dataProvider="logindata")
//	public void loginToAusPostMyPostApp(String user, String pwd)
//	{
//		_report= startReport.startTest("AusMyPostTest");
//		System.out.println("started loginToAusPostMyPostApp");
//		PersonalPage _personal = new PersonalPage(driver,_report);
//		_personal.clickLoginMenuElement();
//
//		MyPostLoginPage _loginMyPost = new MyPostLoginPage(driver,_report);
//
//		_loginMyPost= _personal.clickMyPostMenuLinkElement();
//
//
//		_loginMyPost.clickEmailAddressElement(user);
//		_loginMyPost.clickPasswordElement(pwd);
//
//		MyPostHomePage _mypostHome = new MyPostHomePage(driver,_report);
//		_mypostHome = _loginMyPost.clickLoginButtonElement();
//		_mypostHome.clickManujaMenuElement();
//		_personal = _mypostHome.clickLogoutMenuLinkElement();
//
//	}
//
//
//
//	//DataProvider definition
//	@DataProvider(name="logindata")
//	public Object[][] getDataFromDataprovider(){
//		return new Object[][] 
//				{
//			{ "phmanuja@gmail.com", "Karunyam16#" },
//			//{ "sdfsdfsdf@sdf.com", "sdfsdfsfd" },
//			//{ "sdfsdfsd@dsaf", "hyftg" }
//				};
//
//	}
//
//	//DataProvider with Excel definition
//	@DataProvider(name="filldata")
//	public Object[][] getDataFromExternalExcel() throws Exception
//	{
//		return fetchData("TestDataLogin.xlsx");	
//	}
//
//}
//
//
