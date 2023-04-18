package com.org.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.utils.CommonLibrary;
import com.org.utils.ProjectConfiguration;

public class BaseTest {

	public static WebDriver driver;
	public static String basePath = System.getProperty("user.dir");
	public static ExtentHtmlReporter reportTemplate;
	public static ExtentReports reports;	

	@BeforeSuite
	public static void setUpReport() {
		reportTemplate = new ExtentHtmlReporter("C:\\Users\\thaku\\eclipse-workspace\\24thAutomationFrameworkDemo\\reports\\24thAutomationFrameworkDemo_" + CommonLibrary.getCurrentDate()  + ".html");
		reports = new ExtentReports();
		reports.attachReporter(reportTemplate);		
	}

	@AfterSuite
	public static void saveReport() {
		reports.flush();
	}

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", basePath + "\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(ProjectConfiguration.props.getProperty("appUrl"));
	}

	@AfterClass
	public static void closeBrowser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

}
