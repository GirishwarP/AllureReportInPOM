package com.YOU.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YOU.qa.base.TestBase;
import com.YOU.qa.pages.HomePage;
import com.YOU.qa.pages.InfogramPage;
import com.YOU.qa.util.TestUtil;

public class InfogramPageTest extends TestBase {

	HomePage homePage;
	InfogramPage infogramPage;
	
	@BeforeMethod
	public void preRequisites() {
		initialization();
		homePage = new HomePage(); 
		infogramPage = homePage.clickOnInfogramBtn(); 
		driver.switchTo().window(TestUtil.getWindowID());	//switching window(to infogram page)
		System.out.println("Switching to infogram page");
	}
	
	@Test
	public void userNameOnInfogramPageTest() {
		String userName = infogramPage.getUserName();
		System.out.println("User name on Infogram page : " + userName);
		Assert.assertEquals("Girishwar Patil", userName); // test case is written(User name assertion)
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
