package main.java.it.framework.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import main.java.it.framework.report.ExtentManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class TestBase {

	// Logger TEST_LOG = Logger.getLogger(TestBase.class);

	public ExtentReports startReport = ExtentManager.getInstance();
	public static ExtentTest _report;

	public WebDriver driver ;
	public String appURL;
	public String browserType = "",br="";
	public Properties properties;
	final String propertyFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\it\\config.properties";

	@BeforeMethod
	public void configFileReader(){
		try{
			FileReader	fR = new FileReader(propertyFilePath);//InputStream file = new FileInputStream(propertyFilePath);
			BufferedReader	bR = new BufferedReader(fR);//properties.load(file);
			properties = new Properties();
			try{
				properties.load(bR);
				bR.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found");
		}

		if(properties.getProperty("browserType")!=null){
			br = properties.getProperty("browserType");	
			browserType = br.toLowerCase();
		}
		else{

			System.out.println("No browser type provided");
			_report.log(LogStatus.ERROR,"No browser type provided");
			Assert.assertTrue(false);
		}
		if(properties.getProperty("appURL")!=null){
			appURL = properties.getProperty("appURL");
		}
		else{
			System.out.println("No application url provided");
			_report.log(LogStatus.ERROR,"No application url provided");
			Assert.assertTrue(false);

		}
		initBrowser(browserType,appURL);

	}

	private void initBrowser(String browserType, String appURL){

		//choosing browser type
		switch(browserType)
		{
		case "chrome": driver = initChromeBrowser(appURL);
		break;

		case "ff"   : driver = initFirefoxBrowser(appURL); 
		break;

		case "edge"   : driver = initEdgeBrowser(appURL);  
		break;
		case "ie"   : driver = initIEBrowser(appURL);  
		break;

		default     : System.out.println("browser : " + browserType
				+ " is invalid, Launching Chrome..");
		driver = initChromeBrowser(appURL);
		}


	}

	private  WebDriver initChromeBrowser(String appURL){
		System.out.println("Launching google chrome");
		//	TEST_LOG.info("Launching google chrome with new profile..");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("-incognito");
		options.addArguments("chrome.switches","--disable-extensions");

		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver(options);


		System.out.println("Navigate to url..");
		//	TEST_LOG.info("Navigate to url..");

		driver.navigate().to(appURL);
		driver.manage().window().maximize();
		return driver;
	}


	private  WebDriver initFirefoxBrowser(String appURL){
		System.out.println("Launching firefox browser");
		//	TEST_LOG.info("Launching firefox browser with new profile..");
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		DesiredCapabilities dc = new DesiredCapabilities();
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		dc = DesiredCapabilities.firefox();         
		dc.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

		System.out.println("Navigate to url..");
		//	TEST_LOG.info("Navigate to url..");
		driver.navigate().to(appURL);
		driver.manage().window().maximize();

		return driver;
	}

	private WebDriver initEdgeBrowser(String appURL){
		System.out.println("Launching EDGE Browser");
		//	TEST_LOG.info("Launching EDGE browser with new profile..");
		System.setProperty("webdriver.edge.driver", "src/resources/drivers/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();

		System.out.println("Navigate to url..");
		//	TEST_LOG.info("Navigate to url..");
		driver.navigate().to(appURL);	
		driver.manage().window().maximize();

		return driver;
	}

	private WebDriver initIEBrowser(String appURL){
		System.out.println("Launching IE Browser");
		//	TEST_LOG.info("Launching IE browser with new profile..");
		System.setProperty("webdriver.ie.driver" , "src/resources/drivers/IEDriverServer.exe");

		driver = new InternetExplorerDriver();

		System.out.println("Navigate to url..");
		//	TEST_LOG.info("Navigate to url..");
		driver.navigate().to(appURL);	
		driver.manage().window().maximize(); 

		return driver;

	}

	// Reading from Excel file
	protected Object[][] fetchData(String fileName) throws IOException {


		File file = new File("src/resources/data/"+fileName);
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();

		int lastRowNum = sheet.getLastRowNum() ;
		int lastCellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][lastCellNum];


		for (int i = 0; i < lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for (int j = 0; j < lastCellNum; j++) 
			{

				if(row==null)
					obj[i][j]= "";
				else
				{
					XSSFCell cell= row.getCell(j);
					if(cell==null)
						obj[i][j]= ""; //if it get Null value it pass no data 
					else
					{

						obj[i][j]= cell.toString(); 
					}
				}
			}//end of inner for loop
		}//end of outer for loop

		return obj;
	}

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


	@AfterMethod (alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {

		if(result.getStatus()==ITestResult.FAILURE){
			_report.log(LogStatus.FAIL, "Test case failed is "+result.getName());
			_report.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
			String screenshotPath= TestBase.getScreenshot(driver,result.getName());
			_report.log(LogStatus.FAIL, _report.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP){
			_report.log(LogStatus.SKIP, "Test case skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			_report.log(LogStatus.PASS, "Test case passed is "+result.getName());
		}
		
		_report.log(LogStatus.INFO, "logging out");		


		_report.log(LogStatus.INFO, "closing the browser");	
	
		if(	driver!=null)
			driver.close(); /***control the browser close / open after every test***/



		startReport.endTest(_report);

		startReport.flush();
		//startReport.close();


	}
}

