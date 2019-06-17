package com.YOU.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.YOU.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Object Repository
	@FindBy(id="zz6_Menu")
	private WebElement userName;
	
	@FindBy(xpath="//img[contains(@title, 'YASH Online Universe')]")
	private WebElement youLogo;
	
	@FindBy(xpath="//a[contains(@title, 'YASH Infogram')]")
	private WebElement infogramBtn;
	
	@FindBy(xpath="//div[@class='footright']//a//img")
	private WebElement yashLogo;
	
	private List<WebElement> sharedServicesList;
	
	//constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public boolean isYouLogoDisplayed() {
		return youLogo.isDisplayed();
	}
	
	public boolean isYashLogoDisplayed() {
		return yashLogo.isDisplayed();
	}
	
	public List<WebElement> getListOfSharedServices() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Shared Services')]"))));
		
		driver.findElement(By.xpath("//span[contains(text(),'Shared Services')]")).click();

		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//ul[@class='static']//li[1]//ul//a"))));
		
		sharedServicesList = driver.findElements(By.xpath("//ul[@class='static']//li[1]//ul//a"));
		return sharedServicesList;
	}
	
	public InfogramPage clickOnInfogramBtn() {
		infogramBtn.click();
		return new InfogramPage();
	}
}
