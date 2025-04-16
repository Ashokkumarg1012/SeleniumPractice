package webAutomation.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base 
{
	public WebDriver driver;
	@BeforeClass
	public void initialise()
	{
		System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}

	public void isDisplayed(WebElement ele)
	{
		if(ele.isDisplayed())
		{
			System.out.println("Element is visible");
		}
		else
			System.out.println("Element is not visible");
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}

}
