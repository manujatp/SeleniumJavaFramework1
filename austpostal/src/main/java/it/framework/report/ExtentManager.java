package main.java.it.framework.report;


import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager {

	public static ExtentReports extent; 

	public static String  _reportFileName;


	public static ExtentReports getInstance(){

		//extent  =new ExtentReports( System.getProperty("user.dir"+"\\reports\\test-automation.html",true));

		String curDir = System.getProperty("user.dir");
		System.out.println("Working Directory ===> " + curDir);
		String _reportsPathFile ="\\reports\\test-automation.html";   // --->> reports\\test-automation.html
		String repPath =curDir+_reportsPathFile;
		System.out.println("HTML Report PATH ===> " + repPath);


		String reportFileName =repPath;

		_reportFileName=reportFileName;

		if (extent == null) {
			extent = new ExtentReports(reportFileName, true);

			extent.addSystemInfo("Selenium Version", "3.149.59");


		}


		return extent;
	}

}
