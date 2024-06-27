package com.demoblaze.base;

import java.lang.reflect.Method;
import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoblaze.utilities.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverInstance {
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTestLogger;

	public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger log = LogManager.getLogger(DriverInstance.class);
	
    @BeforeTest
    public void startReporter()
    {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("DemoBlaze");
        extentSparkReporter.config().setReportName("DemoBlaze Automation Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		log.info("-------------------------------");
		if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Utility.fetchPropertyValue("browser_Name").toString().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		log.info("Browser Opened");
		driver.get(Utility.fetchPropertyValue("application_URL").toString());
		log.info("Website Launched");
	}
	
	@AfterMethod
	public void closeDriverInstanceandGetResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTestLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test Case Failed", ExtentColor.RED));
			extentTestLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Failed", ExtentColor.RED));
	       }
	       else if(result.getStatus() == ITestResult.SUCCESS) {
	    	   extentTestLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));
	       }
	       else {
	    	   extentTestLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - Test Case Skipped", ExtentColor.YELLOW));
	       }
		driver.quit();
		log.info("Browser Closed");
	}
	
	@AfterTest
	   public void tearDown() {
	       //to write or update test information to the reporter
	       extentReports.flush();
	   }

}
