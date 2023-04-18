package com.org.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.main.BaseTest;
import com.org.pages.LeftMenuPage;

public class LeftMenuTests  extends BaseTest{
	
	@BeforeMethod
	public static void switchToLeftmenuFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("LeftMenu");
	}
	
	@Test
	public static void validateSeleniumLink(){
		LeftMenuPage lmp = new LeftMenuPage();
		lmp.getSeleniumLink().click();		
	}

}
