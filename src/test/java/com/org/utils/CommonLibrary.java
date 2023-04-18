package com.org.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class CommonLibrary {
	
	public static String reportPath = "C:\\Users\\thaku\\eclipse-workspace\\24thAutomationFrameworkDemo\\reports\\screenshots\\";

	public static String getValueFromField(WebElement elem) {
		String enteredText = "";
		enteredText = elem.getAttribute("value");
		return enteredText;
	}

	public static String takeScreenshot(WebDriver driver, String imageName) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcFile = tss.getScreenshotAs(OutputType.FILE);
		File tarFile = new File(reportPath + imageName + ".png");
		try {
			Files.copy(srcFile, tarFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportPath + imageName + ".png";
	}

	public static String getCurrentDate() {
		Calendar.getInstance().getTime();
		String currDate = Calendar.getInstance().getTimeInMillis()+"";
		return currDate.replaceAll(" ", "_").replaceAll(",", "_").replaceAll(":", "_");
	}

	public static boolean compareText(String expText, String actText) {
		boolean result = true;
		if (!expText.equals(actText)) {
			result = false;
		}
		return result;
	}

	public static void main(String[] args) {

		CommonLibrary prs = new CommonLibrary();		
		System.out.println(getCurrentDate());

	}

}
