package webAutomation.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Base 
{
	public WebDriver driver;
	@Parameters("browserName")
	@BeforeClass
	public void setup(String browserName)
	{
		System.out.println("Browser name is :"+browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.getProperty("webdriver.chrome.driver","C://geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
	}
	
	public void scrollTo(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
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
	public void takeScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//img.png");
		FileUtils.copyFile(src, dest);		
		
	}
	public void hover(WebElement ele)
	{
		Actions a=new Actions(driver);
		
		a.moveToElement(ele).perform();
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}

}
