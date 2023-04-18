package com.org.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.org.main.BaseTest;
import com.org.pages.UserRegistrationPage;
import com.org.utils.CommonLibrary;
import com.org.utils.ProjectConfiguration;

public class UserRegistrationTests extends BaseTest {	

	private static Logger logger = LogManager.getLogger(UserRegistrationTests.class);

	@Test
	public static void validateCompleteName() {	
		
		logger.info("validateCompleteName test Case started");
		
		ExtentTest testCase = reports.createTest("validateCompleteName");
		UserRegistrationPage urp = new UserRegistrationPage();
		try {
			urp.getFirstNameField().clear();
			urp.getFirstNameField().sendKeys(
					ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_firstName"));
		} catch (Exception e) {			
			logger.error("validateFirstName Test Case throw Exception.");
			testCase.info("validateFirstName Test Case throw Exception.");
		}
		String expValue = ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_firstName");
		String actValue = CommonLibrary.getValueFromField(urp.getFirstNameField());
		testCase.info("Validation of validateFirstName Test Case started.");
		if (!expValue.equals(actValue)) {
			testCase.fail("validateFirstName Test Case is Failed");
		} else {
			testCase.pass("validateFirstName Test Case is Passed");
			String imapPath = CommonLibrary.takeScreenshot(driver, "validateFirstName");
			try {
				testCase.addScreenCaptureFromPath(imapPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		urp.getMiddleNameField().clear();
		urp.getMiddleNameField()
				.sendKeys(ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_middleName"));
		String expMiddleValue = ProjectConfiguration.props
				.getProperty("UserRegistrationTests_validateFirstName_middleName");
		String actMiddleValue = CommonLibrary.getValueFromField(urp.getMiddleNameField());
		if (!expMiddleValue.equals(actMiddleValue)) {
			testCase.fail("validateMiddleName Test Case is Failed");
		} else {
			testCase.pass("validateMiddleName Test Case is Passed");
		}
		logger.info("validateCompleteName test Case Completed");
	}

	@Test
	public static void validateLastName() {
		logger.info("validateLastName test Case started");
		UserRegistrationPage urp = new UserRegistrationPage();
		urp.getLastNameField().clear();
		urp.getLastNameField()
				.sendKeys(ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_lastName"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("validateLastName test Case Completed");
	}

	@Test
	public static void validateAge() {
		logger.info("validateAge test Case started");
		UserRegistrationPage urp = new UserRegistrationPage();
		urp.getAgeField().clear();
		urp.getAgeField()
				.sendKeys(ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_age"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("validateAge test Case Completed");
	}


	@BeforeMethod
	public static void switchToUserRegistrationFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("UserRegistration");
	}

	@Test(enabled = false)
	public static void validateFirstName() {
		ExtentTest testCase = reports.createTest("validateFirstName");

		UserRegistrationPage urp = new UserRegistrationPage();

		try {
			urp.getFirstNameField().clear();
			urp.getFirstNameField().sendKeys(
					ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_firstName"));
		} catch (Exception e) {
			testCase.info("validateFirstName Test Case throw Exception.");
		}
		String expValue = ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_firstName");
		String actValue = CommonLibrary.getValueFromField(urp.getFirstNameField());

		testCase.info("Validation of validateFirstName Test Case started.");

		if (!expValue.equals(actValue)) {
			testCase.fail("validateFirstName Test Case is Failed");
		} else {
			testCase.pass("validateFirstName Test Case is Passed");
		}

		assertEquals(actValue, expValue);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled = false)
	public static void validateMiddleName() {
		ExtentTest testCase = reports.createTest("validateMiddleName");
		UserRegistrationPage urp = new UserRegistrationPage();
		urp.getMiddleNameField().clear();
		urp.getMiddleNameField()
				.sendKeys(ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_middleName"));

		String expValue = ProjectConfiguration.props.getProperty("UserRegistrationTests_validateFirstName_middleName");
		String actValue = CommonLibrary.getValueFromField(urp.getMiddleNameField());

		if (CommonLibrary.compareText(expValue, actValue)) {
			testCase.fail("validateMiddleName Test Case is Failed");
		} else {
			testCase.pass("validateMiddleName Test Case is Passed");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
