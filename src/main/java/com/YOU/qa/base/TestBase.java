package com.YOU.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.YOU.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public TestBase() {
		try {
			prop = new Properties();
			fis = new FileInputStream("G:\\Girish_Workspace\\AllureReportInPOM\\src\\main\\java\\com\\YOU\\qa\\config\\env.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Girish_Workspace\\AllureReportInPOM\\Allexe\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browser.equals("fireFox")){
			System.out.println("Write code to use GeckoDriver");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
	}
}
