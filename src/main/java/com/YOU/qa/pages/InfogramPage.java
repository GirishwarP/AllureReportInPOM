package com.YOU.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.YOU.qa.base.TestBase;

public class InfogramPage extends TestBase {
	
	/*@BeforeClass
	public void switchWindow() {
		String windowId = Utility.getWindowID();
		driver.switchTo().window(windowId);
		System.out.println("Switched to : " + windowId);
	}*/
	
	//Object Repository
	@FindBy(xpath="//div[contains(text(),'Girishwar Patil')]")
	private WebElement userName;
	
	//Constructor
	public InfogramPage() {
		PageFactory.initElements(driver, this);
		System.out.println("in InfogramPage class");
	}
	
	public String getUserName() {
		return userName.getText();
	}
}
