package com.YOU.qa.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YOU.qa.base.TestBase;
import com.YOU.qa.pages.HomePage;
import com.YOU.qa.pages.InfogramPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	InfogramPage infogramPage;
	List<WebElement> sharedServices;
	
	@BeforeMethod
	public void preRequisites() {
		initialization();	//Base class method to initialize driver and hit URL
		homePage = new HomePage();	//HomePage object is created
	}

	@Test
	public void userNameOnHomePageTest() {
	    String userName = homePage.getUserName();
	    System.out.println("User name on Home page : " + userName);
	    Assert.assertEquals("Girishwar Jaykumar Patil", userName);   //test case is written(User name assertion)
	}

	@Test
	public void isYOULogoDisplayedTest() {
		System.out.println("Is YOU logo displayed : " + homePage.isYouLogoDisplayed());
	    Assert.assertTrue(homePage.isYouLogoDisplayed());	 		//test case is written(logo display verification)
	}

	@Test
	public void isYashLogoDisplayedTest() {
	    System.out.println("Is Yash logo displayed : " + homePage.isYashLogoDisplayed());
	    Assert.assertTrue(homePage.isYashLogoDisplayed());
	}
	
	@Test
	public void noOFSharedServicesTest() throws InterruptedException {
		sharedServices = homePage.getListOfSharedServices();
		System.out.println("No. of shared services are : " + sharedServices.size());
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for(WebElement element : sharedServices) {
			//wait.until(ExpectedConditions.visibilityOf(element));
			if(!element.getText().isEmpty()) {
				System.out.println(element.getText());
			}else
				System.out.println("it's blank");
		}
		Assert.assertEquals(sharedServices.size(), 5);
	}

	@Test
	public InfogramPage switchToInfogramPage() {
		infogramPage = homePage.clickOnInfogramBtn(); 
		return infogramPage;
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
